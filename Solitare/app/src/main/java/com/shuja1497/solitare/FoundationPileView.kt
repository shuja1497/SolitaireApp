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
class FoundationPileView(context: Context,val index: Int) : ImageView(context) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onfoundationPileTap(index)
        }
    }

    fun update(){
        // if there are cards in the waste card we need to show the top card else show the wmpty file.
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.size>0) getResIdForCard(cards.last()) else emptyPileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) =
        ankoView({ FoundationPileView(it, index) }, 0, init)