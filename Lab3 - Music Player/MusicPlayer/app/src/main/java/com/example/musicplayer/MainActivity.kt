package com.example.musicplayer

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RawRes
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var runnable: Runnable
    private var handler = Handler()
    val list_of_track = mapOf(0 to R.raw.headandheart,1 to R.raw.head_shoulders_hnees_and_toes,
            2 to R.raw.hollywood,3 to R.raw.lonely,4 to R.raw.lovefool, 5 to R.raw.whats_love_got_to_do_with_it)
    val details_of_track =
            mapOf("headandheart" to mapOf("title" to "Head & Heart","author" to "MNEK / Joel Corry","cover" to R.drawable.headandheart),
            "head_shoulders_hnees_and_toes" to mapOf("title" to "Head Shoulders Knees & Toes","author" to "Ofenbach / Quarterhead / Norma Jean Martine","cover" to R.drawable.head_shoulders_hnees_and_toes),
            "hollywood" to mapOf("title" to "Hollywood","author" to "LA Vision / Gigi D'Agostino","cover" to R.drawable.hollywood),
            "lovefool" to mapOf("title" to "Lovefool","author" to "twocolors","cover" to R.drawable.lovefool),
            "whats_love_got_to_do_with_it" to mapOf("title" to "What's Love Got to Do with It","author" to "Tina Turner / Kygo","cover" to R.drawable.whats_love_got_to_do_with_it))
    var actual_track = -1
    val max_track = list_of_track.size
    lateinit var mediaplayer: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_button = findViewById<ImageView>(R.id.play_btn)
        val seekbar_sb = findViewById<SeekBar>(R.id.seekBar)
        val time_from_the_beginning = findViewById<TextView>(R.id.lefttime_TV)
        val total_time = findViewById<TextView>(R.id.righttime_TV)
        val rewind_button = findViewById<ImageView>(R.id.rewind_btn)
        val fast_forward_button = findViewById<ImageView>(R.id.fastforward_btn)
        val next_track = findViewById<ImageView>(R.id.nexttrack_btn)
        val prevoius_track = findViewById<ImageView>(R.id.previoustrack_btn)



        newTrack(true)

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

        next_track.setOnClickListener {
            newTrack(true)
        }

        prevoius_track.setOnClickListener{
            newTrack(false)
        }


        seekbar_sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, postion: Int, changed: Boolean) {
                if (changed) {
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

            /*if(mediaplayer.currentPosition == mediaplayer.duration){
                newTrack()
            }*/

            handler.postDelayed(runnable, 50)
        }
        handler.postDelayed(runnable, 50)
    }

    fun newTrack(next: Boolean){
        val track_title = findViewById<TextView>(R.id.track_title_TV)
        val track_author = findViewById<TextView>(R.id.track_author_TV)
        val trakc_cover = findViewById<ImageView>(R.id.track_cover_IV)
        val seekbar_sb = findViewById<SeekBar>(R.id.seekBar)
        val total_time = findViewById<TextView>(R.id.righttime_TV)
        val play_button = findViewById<ImageView>(R.id.play_btn)

        if(next){
            actual_track += 1
        } else {
            actual_track -= 1
        }

        if(this::mediaplayer.isInitialized) {
            if(mediaplayer.isPlaying){
                mediaplayer.stop()
            }
        }
        val new_track = list_of_track[actual_track % list_of_track.size]!!
        val name_of_track = resources.getResourceEntryName(new_track)
        mediaplayer = MediaPlayer.create(this,new_track)
        mediaplayer.setOnCompletionListener {
            newTrack(true)
        }

        //mediaplayer.prepare()
        seekbar_sb.progress = 0
        seekbar_sb.max = mediaplayer.duration
        total_time.text = mediaplayer.duration.toString()
        if(details_of_track[name_of_track] != null){
            track_title.text = details_of_track[name_of_track]?.get("title").toString()
            track_author.text = details_of_track[name_of_track]?.get("author").toString()
            trakc_cover.setImageDrawable(resources.getDrawable(details_of_track[name_of_track]?.get("cover").toString().toInt()))
        }
        else {
            track_title.text = name_of_track
            track_author.text = ""
            trakc_cover.setImageDrawable(resources.getDrawable(R.drawable.default_cover))
        }

        mediaplayer.start()
        play_button.setImageResource(R.drawable.pause)
    }

    fun playSound(@RawRes rawResId: Int) {
        val assetFileDescriptor = this.resources.openRawResourceFd(rawResId) ?: return
        mediaplayer.run {
            reset()
            setDataSource(assetFileDescriptor.fileDescriptor, assetFileDescriptor.startOffset, assetFileDescriptor.declaredLength)
            prepareAsync()
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