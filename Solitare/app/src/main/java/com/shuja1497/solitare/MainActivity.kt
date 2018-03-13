package com.shuja1497.solitare

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // leaving 4dp on left and right and having 7 cards .
        val cardWidth = (displayMetrics.widthPixels - dip(8))/7
        val cardHeight = cardWidth * (190/140) // must be in same ratio as in the resource folder.

        verticalLayout {
            //linear layout with vertical orientation

            linearLayout {

            }

            linearLayout {

            }
        }


    }
}
