package com.tjoeum.a20191107_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    abstract fun setupEvents()

    abstract fun setValues()
}