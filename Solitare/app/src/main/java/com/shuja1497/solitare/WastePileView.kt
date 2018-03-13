package com.shuja1497.solitare

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by shuja1497 on 3/14/18.
 */
class WastePileView(ctx: Context) : ImageView(ctx) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onWasteTap()
        }
    }

    fun update(){
        // if there are cards in the waste card we need to show the top card else show the wmpty file.
        val cards = GameModel.wastePile
        imageResource = if (cards.size>0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) =
        ankoView({ WastePileView(it) }, 0, init)