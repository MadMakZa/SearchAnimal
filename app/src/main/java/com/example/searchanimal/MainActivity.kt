package com.example.searchanimal

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.searchanimal.R
import com.example.searchanimal.MainActivity
import android.os.CountDownTimer
import android.content.Intent
import android.widget.ImageView
import com.example.searchanimal.ScoreActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private var searchingImage: ImageView? = null
    private var countDownTv: TextView? = null
    private var score = 0
    private val imagesArray = ArrayList<ImageView>()
    private val imageIdList: MutableList<Int?> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        clickToImage()
        startTimer()
    }

    private fun init() {
        countDownTv = findViewById(R.id.tv_countdown)
        searchingImage = findViewById(R.id.imageForSearch)
        imageIdList.add(R.drawable.animal1)
        imageIdList.add(R.drawable.animal2)
        imageIdList.add(R.drawable.animal3)
        imageIdList.add(R.drawable.animal4)
        imageIdList.add(R.drawable.animal5)
        imageIdList.add(R.drawable.animal6)
        imageIdList.add(R.drawable.animal7)
        imageIdList.add(R.drawable.animal8)
        imageIdList.add(R.drawable.animal9)
        imageIdList.add(R.drawable.animal10)
        imageIdList.add(R.drawable.animal11)
        imageIdList.add(R.drawable.animal12)
        imageIdList.add(R.drawable.animal13)
        imageIdList.add(R.drawable.animal14)
        imageIdList.add(R.drawable.animal15)
        imageIdList.add(R.drawable.animal16)
        imageIdList.add(R.drawable.animal17)
        imageIdList.add(R.drawable.animal18)
        imageIdList.add(R.drawable.animal19)
        imageIdList.add(R.drawable.animal20)
        imageIdList.add(R.drawable.animal21)
        imageIdList.add(R.drawable.animal22)
        imageIdList.add(R.drawable.animal23)
        imageIdList.add(R.drawable.animal24)
        imagesArray.add(findViewById(R.id.idImage1))
        imagesArray.add(findViewById(R.id.idImage2))
        imagesArray.add(findViewById(R.id.idImage3))
        imagesArray.add(findViewById(R.id.idImage4))
        imagesArray.add(findViewById(R.id.idImage5))
        imagesArray.add(findViewById(R.id.idImage6))
        imagesArray.add(findViewById(R.id.idImage7))
        imagesArray.add(findViewById(R.id.idImage8))
        imagesArray.add(findViewById(R.id.idImage9))
        imagesArray.add(findViewById(R.id.idImage10))
        imagesArray.add(findViewById(R.id.idImage11))
        imagesArray.add(findViewById(R.id.idImage12))
        imagesArray.add(findViewById(R.id.idImage13))
        imagesArray.add(findViewById(R.id.idImage14))
        imagesArray.add(findViewById(R.id.idImage15))
        imagesArray.add(findViewById(R.id.idImage16))
        imagesArray.add(findViewById(R.id.idImage17))
        imagesArray.add(findViewById(R.id.idImage18))
        imagesArray.add(findViewById(R.id.idImage19))
        imagesArray.add(findViewById(R.id.idImage20))
        imagesArray.add(findViewById(R.id.idImage21))
        imagesArray.add(findViewById(R.id.idImage22))
        imagesArray.add(findViewById(R.id.idImage23))
        imagesArray.add(findViewById(R.id.idImage24))
        makeImages()
    }

    private fun makeImages() {
        val randomImageId = Random().nextInt(imageIdList.size)
        searchingImage!!.setImageResource(imageIdList[randomImageId]!!)
        searchingImage!!.tag = imageIdList[randomImageId]
        val randomIndexImage = Random().nextInt(imagesArray.size)
        val randomImageView = imagesArray[randomIndexImage]
        randomImageView.tag = searchingImage!!.tag
        randomImageView.setImageDrawable(searchingImage!!.drawable)
        var index = 0
        for (image in imagesArray) {
            if (image.tag !== searchingImage!!.tag) {
                if (imageIdList[index] === randomImageView.tag) {
                    index++
                }
                image.setImageResource(imageIdList[index]!!)
                image.tag = imageIdList[index]
//                println(index)
                index++
            }
        }
        Collections.shuffle(imageIdList)
    }

    //клик на изображение в таблице
    private fun clickToImage() {
        for (img in imagesArray) {
            img.setOnClickListener { compareImages(img) }
        }
    }

    //сравнить картинки
    private fun compareImages(image: ImageView) {
        //если изображение совпадают
        if (searchingImage!!.tag == image.tag) {
            //добавить очко
            score++
            makeImages()
        }
    }

    fun startTimer() {
        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                openScoreActivity()
            }
        }.start()
    }

    fun pauseTimer() {
        countDownTimer!!.cancel()
    }

    fun resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS
        updateCountDownText()
    }

    //обновить текст в таймере
    fun updateCountDownText() {
        val seconds = (timeLeftInMillis / 1000).toInt() % 60
        val timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds)
        //поменять текст в мейн активити
        countDownTv!!.text = timeLeftFormatted
    }

    //переход на scoreActivity
    fun openScoreActivity() {
        val intent = Intent(this@MainActivity, ScoreActivity::class.java)
        intent.putExtra("SCORE_TAG", score)
        startActivity(intent)
        overridePendingTransition(R.anim.anim_slide, R.anim.anim_slide2)
        finish()
    }

    companion object {
        //переменные для таймера
        private const val START_TIME_IN_MILLIS: Long = 30000
        private var countDownTimer: CountDownTimer? = null
        private var timeLeftInMillis = START_TIME_IN_MILLIS
    }
}