package com.shuja1497.solitare

/**
 * Created by shuja1497 on 3/11/18.
 */
// we need to create properties for each of our game objects.
// there is only one game of solitare . we will model only one game at a time . so we can declare this game model as
// a singleton . replace class with object
// now instance of taking its instance to different classes we can access it directly .

object GameModel {
    val deck = Deck()
    val wastePile:MutableList<Card> = mutableListOf()
    val foundationPiles = arrayOf(FoundationPile(clubs), FoundationPile(diamonds),
            FoundationPile(hearts), FoundationPile(spades))
    val tableauPiles = Array(7, { TableauPile()})

    fun resetGame(){
        wastePile.clear()
        foundationPiles.forEach { it.reset() }
        deck.reset() // reset the deck to have all 52 cards and shuffle them.
        // setting up the tableau pile >> 1st pile contains 1, 2nd pile contains 2 .............. 7th pile contains 7

        // forEachIndexed takes both index and what is in that index .. two parameters therefore "it" cannot be used
        tableauPiles.forEachIndexed { index, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(index+1, { deck.drawCard()}).toMutableList()
            tableauPiles[index] = TableauPile(cardsInPile)
        }
    }

    fun onDeckTap(){
        if (deck.cardsInDeck.size>0) {
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        }else{
            // if deck is empty copy all the cards from the waste pile into the deck
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onWastePileTap(){
        if (wastePile.size>0){
            val card = wastePile.last() // top card in the waste pile
            if (playCard(card)){
                wastePile.remove(card)
            }
        }
    }

    fun onfoundationPileTap(foundationIndex: Int){
        val foundationPile = foundationPiles[foundationIndex]
        if (foundationPile.cards.size>0){
            val card = foundationPile.cards.last() // top card in the waste pile
            if (playCard(card)){
                foundationPile.removeCards(card)
            }
        }
    }

    fun onTableauPileTap(tableauIndex: Int, cardIndex: Int){
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.cards.size>0){
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex+1)
            if (playCardsOnTableau(cards)){
                tableauPile.removeCards(cardIndex)
            }
        }
    }

    private fun playCardsOnTableau(cards: MutableList<Card>): Boolean {
        // moving only single card
        if (cards.size == 1){
            return playCard(cards.first())
        }// moving multiple cards
        else{
            tableauPiles.forEach {
                if (it.addCards(cards)){
                    return true
                }
            }
        }
        return false
    }

    private fun playCard(card: Card): Boolean {
        foundationPiles.forEach {
            if (it.addCard(card)){ // it represents a foundation Pile
                return true
            }
        }
        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))){
                return true
            }
        }
        return false
    }

    fun debugPrint(){
//        println(deck.cardsInDeck.last())// top card in the deck
        //printing the first line .. first thing is top waste pile card
        var firstLine = if (wastePile.size>0) "${wastePile.last()}" else "___"

        // adding padding before the start of foundation Pile(starts on the 4th cell) .. 3*6 = 18 char
        firstLine = firstLine.padEnd(18)

        //adding foundPile ..
        foundationPiles.forEach {
            firstLine += if (it.cards.size>0) "${it.cards.last()}" else "___"
            firstLine += "   "
        }
        println(firstLine)
        println()
        for (i in 0..12){
            var row = ""
            tableauPiles.forEach {
                row += if (it.cards.size>i) "${it.cards[i]}" else "   "
                row += "   "
            }
            println(row)
        }
    }
}
