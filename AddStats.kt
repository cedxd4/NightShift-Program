package com.example.nightworkerresultscommunitytire2022

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class AddStats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_stats)

        val fileData = findViewById<TextView>(R.id.LISTVIEW)
        val filename = "FILE.txt"
        var fileInputStream: FileInputStream? = null

        fileInputStream = openFileInput(filename)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        var i = 1
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(i)
            stringBuilder.append(":\t\t")
            stringBuilder.append(text)
            stringBuilder.append("\n")
            i++
        }

        fileData.setText(stringBuilder.toString()).toString()

        val Back = findViewById<Button>(R.id.Back)
        Back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}