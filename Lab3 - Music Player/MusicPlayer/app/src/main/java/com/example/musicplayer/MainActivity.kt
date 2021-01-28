package com.example.musicplayer

import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_button = findViewById<ImageView>(R.id.play_btn)
        val seekbar_sb = findViewById<SeekBar>(R.id.seekBar)
        val time_from_the_beginning = findViewById<TextView>(R.id.lefttime_TV)
        val total_time = findViewById<TextView>(R.id.righttime_TV)
        val rewind_button = findViewById<ImageView>(R.id.rewind_btn)
        val fast_forward_button = findViewById<ImageView>(R.id.fastforward_btn)


        val mediaplayer = MediaPlayer.create(this,R.raw.headandheart)
        seekbar_sb.progress = 0
        seekbar_sb.max = mediaplayer.duration
        total_time.text = mediaplayer.duration.toString()

        play_button.setOnClickListener {
            if(!mediaplayer.isPlaying){
                mediaplayer.start()
                play_button.setImageResource(R.drawable.pause)
            } else {
                mediaplayer.pause()
                play_button.setImageResource(R.drawable.play)
            }
        }

        fast_forward_button.setOnClickListener {
            val new_position = mediaplayer.currentPosition + 10000
            if(new_position < 0) {
                mediaplayer.seekTo(0)
            } else {
                mediaplayer.seekTo(new_position)
            }        }

        rewind_button.setOnClickListener {
            val new_position = mediaplayer.currentPosition - 10000
            if(new_position < mediaplayer.duration) {
                mediaplayer.seekTo(new_position)
            } else {
                mediaplayer.seekTo(mediaplayer.duration - 1)
            }
        }
        seekbar_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, postion: Int, changed: Boolean) {
                if(changed){
                    mediaplayer.seekTo(postion)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        runnable = Runnable {
            seekbar_sb.progress = mediaplayer.currentPosition
            var elapsedTime = createTimeLabel(mediaplayer.currentPosition)
            time_from_the_beginning.text = elapsedTime

            var remainingTime = createTimeLabel(mediaplayer.duration - mediaplayer.currentPosition)
            total_time.text = remainingTime

            handler.postDelayed(runnable, 50)
        }
        handler.postDelayed(runnable, 50)

        mediaplayer.setOnCompletionListener {
            play_button.setImageResource(R.drawable.play)
            seekbar_sb.progress = 0
        }

    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }
}