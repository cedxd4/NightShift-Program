package com.example.nightworkerresultscommunitytire2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.io.File

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val change = findViewById<Button>(R.id.EditEmployee)
        change.setOnClickListener {
            val intent = Intent(this,EditEmployee::class.java)
            startActivity(intent)
            finish()
        }

        val stats = findViewById<Button>(R.id.AddStats)
        stats.setOnClickListener {
            val intent = Intent(this,AddStats::class.java)
            startActivity(intent)
            finish()
        }

        val exit = findViewById<Button>(R.id.EXIT)
        exit.setOnClickListener {
            this@MainActivity.finish()
        }
    }
}