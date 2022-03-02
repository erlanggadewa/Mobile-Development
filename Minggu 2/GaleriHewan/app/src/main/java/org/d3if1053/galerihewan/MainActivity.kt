package org.d3if1053.galerihewan

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val hewan = listOf("Ayam", "Bebek", "Domba", "Kambing", "Sapi")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener { showNext() }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener { showBack() }
    }

    private fun showNext() {
        index = if (index == hewan.size - 1) 0 else index + 1
        imageAndCaptionHandler(index)
    }

    private fun showBack() {
        index = if (index == 0) hewan.size - 1 else index - 1
        imageAndCaptionHandler(index)
    }

    private fun imageAndCaptionHandler(index: Int) {
        val textView: TextView = findViewById(R.id.nameTextView)
        textView.text = hewan[index]

        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setImageResource(
            when (index) {
                1 -> R.drawable.bebek
                2 -> R.drawable.domba
                3 -> R.drawable.kambing
                4 -> R.drawable.sapi
                else -> R.drawable.ayam
            }
        )
    }
}