package com.shuja1497.solitare

import android.content.Context
import android.view.ViewManager
import android.widget.RelativeLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

/**
 * Created by shuja1497 on 3/14/18.
 */
// responsible for all the cards in a certain tableau pile
class TableauPileView(context: Context,val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update(){
        // instead of updating the views we will remove all the views and build the tableau from scratch.
        removeAllViews()
        addViews()
    }

    private fun addViews() {

        val cards = GameModel.tableauPiles[index].cards
        //add image view to the screen for each card in the card list
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat() // top margin sort of
                imageResource = if (card.faceUp) getResIdForCard(card) else cardBackDrawable
                onClick {
                    GamePresenter.onTableauPileTap(index, i) // index for tableaupile and card resp.
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}


fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {}) =
        ankoView({ TableauPileView(it, index) }, 0, init)

