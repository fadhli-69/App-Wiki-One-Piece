package com.example.wikipediaonepiece

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EasterEggActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easter_egg)

        // Menghubungkan view dengan kode menggunakan findViewById
        val tvName: TextView = findViewById(R.id.tv_easter_egg_name)
        val tvDescription: TextView = findViewById(R.id.tv_easter_egg_description)
        val ivPhoto: ImageView = findViewById(R.id.iv_easter_egg_photo)

        tvName.text = "Yanto"
        tvDescription.text = "Legenda mengatakan bahwa beliau adalah orang yang akan menjadi crew bajak laut Topi Jerami terakhir!"
        ivPhoto.setImageResource(R.drawable.yanto)
    }
}
