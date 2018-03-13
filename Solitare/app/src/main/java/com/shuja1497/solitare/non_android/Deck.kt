package com.shuja1497.solitare

import java.util.*

/**
 * Created by shuja1497 on 3/11/18.
 */
class Deck {
    val cards = Array(52, {Card(it % 13, getSuit(it))})
            // converting card to a list for shuffling and other functions

    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp = false }
        Collections.shuffle(cardsInDeck)// shuffle the deck
    }

    private fun getSuit(i: Int)= when(i/13){
            0 -> clubs
            1 -> diamonds
            2 -> hearts
            else ->  spades
        }
}