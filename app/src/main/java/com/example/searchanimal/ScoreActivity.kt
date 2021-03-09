package com.example.searchanimal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.searchanimal.MainActivity
import com.example.searchanimal.ScoreActivity

class ScoreActivity : AppCompatActivity() {
    private var scoreTextView: TextView? = null
    private var btnNewGame: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        //widgets
        scoreTextView = findViewById(R.id.tvScore)
        btnNewGame = findViewById(R.id.btnStartGame)
        val score = intent.getIntExtra(SCORE_TAG, 0)
        scoreTextView?.setText(score.toString())
        btnNewGame?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ScoreActivity, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim_slide, R.anim.anim_slide2)
            finish()
        })
    }

    companion object {
        private const val SCORE_TAG = "SCORE_TAG"
    }
}