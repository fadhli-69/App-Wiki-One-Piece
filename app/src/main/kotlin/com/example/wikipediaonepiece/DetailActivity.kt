package com.example.wikipediaonepiece

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CHAR = "extra_char"
    }

    private var dataChar: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val tvDetailBounty: TextView = findViewById(R.id.tv_detail_bounty)
        val tvDetailAffiliation: TextView = findViewById(R.id.tv_detail_affiliation)
        val tvDetailDevilFruit: TextView = findViewById(R.id.tv_detail_devil_fruit)
        val tvDetailAbilities: TextView = findViewById(R.id.tv_detail_abilities)
        val tvDetailStatus: TextView = findViewById(R.id.tv_detail_status)
        val tvDetailOrigin: TextView = findViewById(R.id.tv_detail_origin)
        val tvDetailDream: TextView = findViewById(R.id.tv_detail_dream)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        // Menerima data dari Intent
        dataChar = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CHAR, Char::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Char>(EXTRA_CHAR)
        }

        // Menampilkan data pada view
        dataChar?.let {
            ivDetailPhoto.setImageResource(it.photo)
            tvDetailName.text = it.name
            tvDetailDescription.text = it.description
            tvDetailBounty.text = getString(R.string.bounty_format, it.bounty)
            tvDetailAffiliation.text = getString(R.string.affiliation_format, it.affiliation)
            tvDetailDevilFruit.text = getString(R.string.devil_fruit_format, it.devilFruit)
            tvDetailAbilities.text = getString(R.string.abilities_format, it.abilities)
            tvDetailStatus.text = getString(R.string.status_format, it.status)
            tvDetailOrigin.text = getString(R.string.origin_format, it.origin)
            tvDetailDream.text = getString(R.string.dream_format, it.dream)
        }

        // Menambahkan aksi pada tombol share
        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener {
            shareCharacterDetail()
        }
    }

    // Fungsi untuk membagikan detail karakter
    private fun shareCharacterDetail() {
        val shareText = """
            Nama: ${dataChar?.name}
            Deskripsi: ${dataChar?.description}
            Bounty: ${dataChar?.bounty}
            Afiliasi: ${dataChar?.affiliation}
            Buah Iblis: ${dataChar?.devilFruit}
            Kemampuan: ${dataChar?.abilities}
            Status: ${dataChar?.status}
            Asal: ${dataChar?.origin}
            Impian: ${dataChar?.dream}
        """.trimIndent()

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
