package com.trs.trs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import it.sauronsoftware.ftp4j.FTPClient
import java.io.File

class MainActivity : AppCompatActivity() {
    val PORT = 21
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val mFtpClient = FTPClient()
            // Fase de conexión
            mFtpClient.connect("ftpupload.net", PORT)
            mFtpClient.login("epiz_24261351", "T8u7ypUuv8tZUP8")
            mFtpClient.type = FTPClient.TYPE_BINARY
            mFtpClient.changeDirectory("htdocs/trs-db")
            val file = File("therealshow.db")

            mFtpClient.upload(file)
            mFtpClient.disconnect(true)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val button = findViewById<Button>(R.id.button)
            button.setOnClickListener{
                val intent = Intent(this, Stats::class.java)
                startActivity(intent)
            }
    }
}