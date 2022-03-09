package org.d3if1053.hitungbmi

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if1053.hitungbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hitungBtn.setOnClickListener { hitungBMI() }
        binding.resetBtn.setOnClickListener { resetField() }
    }

    private fun resetField() {
        binding.bmiTextView.text = ""
        binding.kategoriTextView.text = ""
        binding.radioGroup.clearCheck()
        binding.tinggiField.text = null
        binding.bbField.text = null
        binding.tinggiField.clearFocus()
        binding.bbField.clearFocus()
    }

    private fun hitungBMI() {
        val berat = binding.bbField.text.toString()
        if (TextUtils.isEmpty(berat)) {
            Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val tinggi = binding.tinggiField.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val tinggiCm = tinggi.toFloat() / 100

        val selectedIdGender = binding.radioGroup.checkedRadioButtonId
        if (selectedIdGender == -1) {
            Toast.makeText(this, R.string.gender_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val isMale = selectedIdGender == R.id.maleRadio
        val bmi = berat.toFloat() / (tinggiCm * tinggiCm)
        val kategori = getKategory(bmi, isMale)

        binding.bmiTextView.text = getString(R.string.bmi_x, bmi)
        binding.kategoriTextView.text = getString(R.string.kategori_x, kategori)

    }

    private fun getKategory(bmi: Float, isMale: Boolean): String {
        val stringRes = if (isMale) {
            when {
                bmi < 20.5 -> R.string.kurus
                bmi < 27 -> R.string.ideal
                else -> R.string.gemuk
            }
        } else {
            when {
                bmi < 18.5 -> R.string.kurus
                bmi < 25 -> R.string.ideal
                else -> R.string.gemuk
            }
        }

        return getString(stringRes)
    }
}