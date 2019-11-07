package com.tjoeum.a20191107_numberbaseballgame

import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : BaseActivity() {


    var questionNumArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion(){
        while (true) {
            val number = Random.nextInt(1, 9)
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
    }

    override fun setValues() {
    }


}
