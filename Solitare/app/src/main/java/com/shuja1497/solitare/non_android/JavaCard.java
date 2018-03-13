package com.shuja1497.solitare.non_android;

/**
 * Created by shuja1497 on 3/11/18.
 */
public class JavaCard {
    // Attributes > value(1 ,2 ,3 ..) ; suit : face(up or down)

    private int value ;// immutable . 2 will remain 2 always (so no need of a setter )
    private String suit ;
    private boolean faceUp; // mutable.. maybe changed from face up to face down( both getter and setter needed )

    public JavaCard(int value, String suit, boolean faceUp){
        this.value = value;
        this.suit = suit;
        this.faceUp = faceUp;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
}

// fields and properties
//fields >> value , suit , faceUp
// properties >> isFaceUp() .... can exist without a field also