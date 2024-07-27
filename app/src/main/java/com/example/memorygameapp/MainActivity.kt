package com.example.memorygameapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygameapp.ui.theme.MemoryGameAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs =  findViewById(R.id.tvNumPairs)

        rvBoard = MemoryBoardApadter(this, 8)
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, 2)



    }
}
