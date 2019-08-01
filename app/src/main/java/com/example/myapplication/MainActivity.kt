package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mp :MediaPlayer? = null
    var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.setOnClickListener {
            mp?.start()
        }
        pause.setOnClickListener {
            mp?.pause()
        }
    }

    fun clicked(v : View)
    {
        mp?.pause()
        when(v.id)
        {
            R.id.btn1 -> {
                mp = MediaPlayer.create(this, R.raw.demon_slayer)
                imageView.setImageResource(R.drawable.demon_slayer)
                flag = 1
            }
            R.id.btn2 -> {
                mp = MediaPlayer.create(this, R.raw.then)
                imageView.setImageResource(R.drawable.then)
                flag = 2
            }
            R.id.btn3 -> {
                mp = MediaPlayer.create(this, R.raw.old_town_road)
                imageView.setImageResource(R.drawable.old_town_road)
                flag = 3
            }
            R.id.btn4 -> {
                mp = MediaPlayer.create(this, R.raw.gasoline)
                imageView.setImageResource(R.drawable.gasoline)
                flag = 4
            }

        }
    }

    fun previous(vi : View)
    {
        when(flag)
        {
            2 -> vi.id = R.id.btn1
            3 -> vi.id = R.id.btn2
            4 -> vi.id = R.id.btn3
        }
        clicked(vi)
    }

    fun next(vi : View)
    {
        when(flag)
        {
            1 -> vi.id = R.id.btn2
            2 -> vi.id = R.id.btn3
            3 -> vi.id = R.id.btn4
        }
        clicked(vi)
    }

}
