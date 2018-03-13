package com.shuja1497.solitare

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var count = 0
        relativeLayout {

            val counterTextView = textView {
                id = 11
                text = "0"
                textSize = 24f // in anko text size is given as float which is same as SP
            }

            button {
                onClick {
                    count++
                    counterTextView.text = count.toString()
                }
            }.lparams {
                below(counterTextView)
            }
        }
    }
}
