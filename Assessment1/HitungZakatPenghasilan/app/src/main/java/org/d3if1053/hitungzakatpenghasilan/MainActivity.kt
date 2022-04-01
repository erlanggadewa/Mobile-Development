package org.d3if1053.hitungzakatpenghasilan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if1053.hitungzakatpenghasilan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hitung.setOnClickListener { hitungZakat() }
        binding.reset.setOnClickListener { resetField() }
    }


    private fun hitungZakat() {
        // Clear error text
        binding.hargaEmasHint.error = null
        binding.penghasilanHint.error = null
        binding.bonusHint.error = null

        val hargaEmas = binding.inputHargaEmas.text.toString()
        val penghasilan = binding.inputPenghasilan.text.toString()
        val bonus = binding.inputBonus.text.toString()
        if (!isNumeric(hargaEmas)) {
            // Set error text
            binding.hargaEmasHint.error = getString(R.string.error)
            return
        } else if (!isNumeric(penghasilan)) {
            binding.penghasilanHint.error = getString(R.string.error)
            return
        } else if (!isNumeric(bonus)) {
            binding.bonusHint.error = getString(R.string.error)
            return
        }

        val nisab = (hargaEmas.toFloat() * 85) / 12;
        if (penghasilan.toFloat() + bonus.toDouble() >= nisab) {
            val hasilZakat: Long =
                ((penghasilan.toDouble() + bonus.toDouble()) * 0.025).toLong()
            binding.outputZakat.text = getString(R.string.output, hasilZakat)
        } else {
            binding.outputZakat.text = "Tidak wajib membayar zakat"
        }

    }

    fun isNumeric(toCheck: String): Boolean {
        val regex = "[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }

    private fun resetField() {
        binding.hargaEmasHint.error = null
        binding.penghasilanHint.error = null
        binding.bonusHint.error = null
        binding.inputHargaEmas.text = null
        binding.inputPenghasilan.text = null
        binding.inputBonus.text = null
        binding.outputZakat.text = null
    }

}