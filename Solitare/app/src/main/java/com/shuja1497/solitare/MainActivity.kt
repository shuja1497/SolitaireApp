package com.shuja1497.solitare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.button
import org.jetbrains.anko.onClick
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var count = 0
        relativeLayout {

            val counterTextView = textView {
                text = "0"
                textSize = 24f // in anko text size is given as float which is same as SP
            }

            button {
                onClick {
                    count++
                    counterTextView.text = count.toString()
                }
            }
        }
    }
}
