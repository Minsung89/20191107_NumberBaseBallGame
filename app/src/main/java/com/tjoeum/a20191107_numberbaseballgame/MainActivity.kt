package com.tjoeum.a20191107_numberbaseballgame

import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.tjoeum.a20191107_numberbaseballgame.adapters.ChatAdapter
import com.tjoeum.a20191107_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {


    var questionNumArray = ArrayList<Int>()
    var chatLists = ArrayList<ChatData>()
    var chatAdapter: ChatAdapter? = null
    var userInputNumArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion(){
        while (true) {
            val number = Random.nextInt(1, 10)
            if(!questionNumArray.contains(number))
                questionNumArray.add(number)
            if(questionNumArray.size == 3)
                break

        }

        for (num in questionNumArray){
            Log.i("번호",num.toString())
        }


    }


    fun checkAnswer(){

        var strikeCount = 0
        var ballCount = 0

        for (i in 0..2){
            for(j in 0..2){
                if(userInputNumArray[i] == questionNumArray[j]){
                    if(i==j){
                        //strike 증가
                        strikeCount ++
                    } else {
                        //ball 증가
                        ballCount ++
                    }
                }
            }
        }


        Handler().postDelayed({
            chatLists.add(ChatData("${strikeCount}S ${ballCount}B 입니다.", "CPU"))

            if(strikeCount ==3){
                chatLists.add(ChatData("축하합니다! 정답입니다","CPU"))
            }
            chatAdapter?.notifyDataSetChanged()

            chatListView.smoothScrollToPosition(chatLists.size-1)
        },500)



    }


    override fun setupEvents() {

        inputBtn.setOnClickListener {

            var inputNum = inputEdt.text.toString()
            chatLists.add(ChatData(inputNum,"ME"))

            chatAdapter?.notifyDataSetChanged()

            userInputNumArray.clear()

            userInputNumArray.add(inputNum.toInt() / 100)
            userInputNumArray.add(inputNum.toInt() / 10 % 10 )
            userInputNumArray.add(inputNum.toInt() % 10)

            Log.i("userInputNumArray", userInputNumArray.toString())
            chatListView.smoothScrollByOffset(chatLists.size)

            checkAnswer()
        }

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this,chatLists)
        chatListView.adapter = chatAdapter

    }


}
