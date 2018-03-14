package com.shuja1497.solitare

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1
fun View.getResIdForCard(card: Card): Int {
    val resourceName  = "card${card.suit}${cardMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

//making card width and height . an extension func of Context class
// leaving 4dp on left and right and having 7 cards .
val Context.cardWidth : Int get() = (displayMetrics.widthPixels - dip(8))/7
val Context.cardHeight get()= cardWidth * (190/140) // must be in same ratio as in the resource folder.


// implementing game view and its method
class MainActivity : AppCompatActivity() , GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    val foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)
    val tableauPileViews: Array<TableauPileView?> = arrayOfNulls(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.setGameView(this)
        GameModel.resetGame() // setting up the game .

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
                for (i in 0..6){
                    tableauPileViews[i] = tableauPileView(i).lparams(cardWidth, matchParent)
                }
            }.lparams{
                height = matchParent
                topMargin = cardHeight/2
            }
        }
    }

    override fun update() {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileViews.forEach {
            it!!.update()
        }
        tableauPileViews.forEach {
            it!!.update()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Start Over")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        GameModel.resetGame()
        update()
        return true
    }
}
