package com.example.wikipediaonepiece

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Menghubungkan ImageView dari XML
        val splashImage = findViewById<ImageView>(R.id.imageViewSplash)

        // Memulai animasi fade in
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        splashImage.startAnimation(fadeIn)

        // Delay selama animasi fade out
        Handler(Looper.getMainLooper()).postDelayed({
            val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            splashImage.startAnimation(fadeOut)

            // Setelah animasi selesai, berpindah ke MainActivity
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 1500) // Durasi fade out

        }, 1500) // Durasi fade in
    }
}
