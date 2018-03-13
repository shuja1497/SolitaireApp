package com.shuja1497.solitare

/**
 * Created by shuja1497 on 3/12/18.
 */
object GamePresenter {
    // if a variable may be null then we need to use "?"
    var view : GameView? = null

    fun setGameView(gameView: GameView){
         view = gameView
    }

    fun onDeckTap(){
        // we need to update the model
        GameModel.onDeckTap()
        // to call any variable that maybe null we have to use either "?" or"!!"
        view?.update() // if ? is present and null is given then this statement won't happen ever
    }

    fun onWasteTap(){
        GameModel.onWastePileTap()
        view?.update()
    }

    fun onfoundationPileTap(foundationIndex: Int){
        GameModel.onfoundationPileTap(foundationIndex)
        view?.update()
    }

    fun onTableauPileTap(tableauIndex: Int, cardIndex: Int){
        GameModel.onTableauPileTap(tableauIndex, cardIndex)
        view?.update()
    }
}