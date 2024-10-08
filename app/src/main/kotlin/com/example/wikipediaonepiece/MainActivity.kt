package com.example.wikipediaonepiece

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvChar: RecyclerView
    private val list = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvChar = findViewById(R.id.rv_char)
        rvChar.setHasFixedSize(true)

        list.addAll(getListChar())
        showRecyclerList()
    }

    private fun getListChar(): ArrayList<Char> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataBounty = resources.getStringArray(R.array.data_bounty)
        val dataAffiliation = resources.getStringArray(R.array.data_affiliation)
        val dataDevilFruit = resources.getStringArray(R.array.data_devil_fruit)
        val dataAbilities = resources.getStringArray(R.array.data_abilities)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val dataOrigin = resources.getStringArray(R.array.data_origin)
        val dataDream = resources.getStringArray(R.array.data_dream)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listChar = ArrayList<Char>()
        for (i in dataName.indices) {
            val char = Char(
                name = dataName[i],
                description = dataDescription[i],
                photo = dataPhoto.getResourceId(i, -1),
                bounty = dataBounty[i],
                affiliation = dataAffiliation[i],
                devilFruit = dataDevilFruit[i],
                abilities = dataAbilities[i],
                status = dataStatus[i],
                origin = dataOrigin[i],
                dream = dataDream[i]
            )
            listChar.add(char)
        }
        return listChar
    }

    private fun showRecyclerList() {
        rvChar.layoutManager = LinearLayoutManager(this)
        val listCharAdapter = ListCharAdapter(list)
        rvChar.adapter = listCharAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Menghubungkan menu_main.xml ke activity
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }

            R.id.easter_egg -> {
                val intent = Intent(this, EasterEggActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
