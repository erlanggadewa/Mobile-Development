package org.d3if1053.hitungbmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if1053.hitungbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}