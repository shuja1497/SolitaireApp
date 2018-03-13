package com.shuja1497.solitare

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1
fun View.getResIdForCard(card: Card): Int {
    val resourceName  = "card${card.suit}${cardMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

// implementing game view and its method
class MainActivity : AppCompatActivity() , GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    val foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame() // setting up the game .

        // leaving 4dp on left and right and having 7 cards .
        val cardWidth = (displayMetrics.widthPixels - dip(8))/7
        val cardHeight = cardWidth * (190/140) // must be in same ratio as in the resource folder.

        //linear layout with vertical orientation
        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
//                imageView(imageResource=cardBackDrawable).lparams(cardWidth, cardHeight)// deck
                deckView = deckView ().lparams(cardWidth, cardHeight)
//                imageView(imageResource=emptyPileDrawable).lparams(cardWidth, cardHeight)// waste pile
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)
                view().lparams(cardWidth, 0) // for a space btwn waste pile and foundation pile
                for (i in 0..3){
//                    imageView(imageResource=emptyPileDrawable).lparams(cardWidth, cardHeight)// waste pile
                    foundationPileViews[i] = foundationPileView(i).lparams(cardWidth, cardHeight)
                }
            }
            linearLayout {
            }
        }
    }

    override fun update(model: GameModel) {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileViews.forEach {
            it!!.update()
        }
    }
}
