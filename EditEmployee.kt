package com.example.nightworkerresultscommunitytire2022

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.*

class EditEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_employee)

        val fileData = findViewById<EditText>(R.id.LISTVIEW)
        val filename = "FILE.txt"
        var fileInputStream: FileInputStream? = null
        val fileOutputStream:FileOutputStream
        fileOutputStream = openFileOutput(filename, Context.MODE_APPEND)

        fileInputStream = openFileInput(filename)
            var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder: StringBuilder = StringBuilder()
            var text: String? = null
            while ({ text = bufferedReader.readLine(); text }() != null) {
                stringBuilder.append(text)
                stringBuilder.append("\n")
            }

            fileData.setText(stringBuilder.toString()).toString()

        val PName = findViewById<EditText>(R.id.LISTVIEW)
        val Save = findViewById<Button>(R.id.Deletebtn)
        Save.setOnClickListener {
            val fileOutputStream: FileOutputStream
            val Name:String = PName.text.toString()
            try {
                fileOutputStream = openFileOutput(filename, MODE_PRIVATE)
                fileOutputStream.write(Name.toByteArray())
                fileOutputStream.write("\n".toByteArray())
            } catch (e: FileNotFoundException){
                e.printStackTrace()
            }catch (e: NumberFormatException){
                e.printStackTrace()
            }catch (e: IOException){
                e.printStackTrace()
            }catch (e: Exception){
                e.printStackTrace()
            }
            Toast.makeText(applicationContext,"data save", Toast.LENGTH_LONG).show()

        }

        val Back = findViewById<Button>(R.id.Back)
        Back.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}