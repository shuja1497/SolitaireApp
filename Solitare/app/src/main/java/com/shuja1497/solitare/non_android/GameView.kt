package com.shuja1497.solitare

/**
 * Created by shuja1497 on 3/12/18.
 */
interface GameView {
    // any class that implements this interface will be notified when the model updates
    fun update(model: GameModel = GameModel)
}