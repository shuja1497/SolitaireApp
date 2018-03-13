package com.shuja1497.solitare

/**
 * Created by shuja1497 on 3/11/18.
 */
class FoundationPile(val suit: String){
    // contains cards
    val cards:MutableList<Card> = mutableListOf()

    fun reset(){
        cards.clear()
    }

    fun removeCards(card: Card){
        cards.remove(card)
    }

    fun addCard(card: Card): Boolean{
        // we need to check the card parameter is a match with the next card in the foundation
        var nextValue = 0
        if (cards.size > 0){
            nextValue = cards.last().value + 1
        }

        if (card.suit == suit && card.value == nextValue){
            cards.add(card)
            return true
        }
        return false
    }

}