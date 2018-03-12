package com.shuja1497.solitare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter =0
        button_counter.setOnClickListener{
            counter++
            counterTextView.text = counter.toString()
        }
    }
}
