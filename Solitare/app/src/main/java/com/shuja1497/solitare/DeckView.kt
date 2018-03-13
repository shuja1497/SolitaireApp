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
// custom view
class DeckView(context: Context) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update(){
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.size > 0) cardBackDrawable else emptyPileDrawable
    }
}
fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView({DeckView(it)}, 0, init)