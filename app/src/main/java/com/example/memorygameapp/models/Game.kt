package com.example.memorygameapp.models

import com.example.memorygameapp.utils.DEFAULT_ICONS

class Game(private val boardSize: BoardSize, customImages: List<String>?) {

    val cards: List<MemoryCard>
    var numPairsFound = 0

    private var numCardsFLips = 0
    private var indexOfSingleSelectCard: Int? = null

    init {
        if(customImages == null) {
            val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
            val randomizedImages = (chosenImages + chosenImages).shuffled()
            cards = randomizedImages.map{ MemoryCard(it) }
        } else {
             val randomizedImages = (customImages + customImages).shuffled()
            cards = randomizedImages.map{ MemoryCard(it.hashCode(), imageUrl = it)}
        }

    }

    fun flipCard(position: Int): Boolean {
        numCardsFLips++
    val card = cards[position]
        var foundMatch = false

        if(indexOfSingleSelectCard == null) {
            restoreCards()
            indexOfSingleSelectCard = position
        }
        else {
            foundMatch = checkForMatch(indexOfSingleSelectCard!!, position)
            indexOfSingleSelectCard = null
        }
       card.isFaceUp = !card.isFaceUp
        return foundMatch
    }

    private fun checkForMatch(position1: Int, position2: Int) : Boolean {
        if(cards[position1].identifier != cards[position2].identifier) {
            return false
        }
        cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairsFound++
        return true
    }

    private fun restoreCards() {
        for(card in cards) {
            if(!card.isMatched) {
                card.isFaceUp = false
            }
        }
    }
    fun haveWonGame(): Boolean {
        return  numPairsFound == boardSize.getNumPairs()
    }
    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp
    }
    fun getNumMoves() : Int {
        return numCardsFLips / 2
    }

}