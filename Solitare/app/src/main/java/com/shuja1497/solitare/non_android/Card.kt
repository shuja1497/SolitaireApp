package com.shuja1497.solitare

/**
 * Created by shuja1497 on 3/11/18.
 */

// in kotlin we can only declare property .
// anytime we declare a variable in kotlin its a property
// val >> immutable
// var >> mutable
// constructor is made just after the class name

//Type 1 >>>
//class Card (value: Int, suit: String, faceUp: Boolean){
//    val value: Int = value
//    val suit: String = suit
//    var faceUp: Boolean = faceUp// each card should start face down
//}

// Type 2>>>
// if we add val and var then they will act as a property
val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"

val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(clubs, spades)

val cardMap = mapOf(0 to "A", 1 to "2", 2 to "3" , 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9",
        9 to "10", 10 to "J", 11 to "Q", 12 to "K")

// if class is just for holding a data it can be written as a data class
data class Card (val value: Int, val suit: String, var faceUp: Boolean=false){
    override fun toString(): String =
            if (faceUp) "${cardMap[value]}".padEnd(2) + "${getSuitChar(suit)}" else "XXX"

    // suits is included in Unicode
    private fun getSuitChar(suit: String): String = when(suit){
        diamonds -> "\u2666"
        clubs -> "\u2663"
        hearts -> "\u2665"
        spades -> "\u2660"
        else -> "incorrect suit"
    }
}

// init block can be created which will be called as soon as the
// constructor is called. >>> (for initialization purpose )