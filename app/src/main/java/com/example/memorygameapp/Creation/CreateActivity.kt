package com.example.memorygameapp.Creation

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import com.example.memorygameapp.R
import com.example.memorygameapp.models.BoardSize
import com.example.memorygameapp.utils.EXTRA_BOARD_SIZE

class CreateActivity : ComponentActivity() {

    private lateinit var boardSize: BoardSize
    private var numImagesRequired = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        boardSize = intent.getSerializableExtra(EXTRA_BOARD_SIZE)as BoardSize
        numImagesRequired = boardSize.getNumPairs()
        //supportActionBar?.title = "Choose pics (0 / $numImagesRequired)"
    }
}