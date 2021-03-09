package com.example.searchanimal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.searchanimal.MainActivity

class StartActivity : AppCompatActivity() {
    private var btnStartGame: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        btnStartGame = findViewById(R.id.btnStartGame)

        btnStartGame!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@StartActivity, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim_slide, R.anim.anim_slide2)
            finish()
        })
    }
}