package com.tjoeum.a20191107_numberbaseballgame

import android.os.Bundle
import android.util.Log
import com.tjoeum.a20191107_numberbaseballgame.adapters.ChatAdapter
import com.tjoeum.a20191107_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {


    var questionNumArray = ArrayList<Int>()
    var chatLists = ArrayList<ChatData>()
    var chatAdapter: ChatAdapter? = null

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

    override fun setupEvents() {

        inputBtn.setOnClickListener {

            var inputNum = inputEdt.text.toString()
            chatLists.add(ChatData(inputNum,"ME"))

            chatAdapter?.notifyDataSetChanged()

            chatListView.smoothScrollByOffset(chatLists.size)
        }

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this,chatLists)
        chatListView.adapter = chatAdapter

    }


}
