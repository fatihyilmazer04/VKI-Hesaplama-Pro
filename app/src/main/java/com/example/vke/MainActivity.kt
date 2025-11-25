package com.example.vke

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etBoy: EditText
    private lateinit var etKilo: EditText
    private lateinit var btnHesapla: Button
    private lateinit var btnTemizle: Button
    private lateinit var tvSonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etBoy = findViewById(R.id.etBoy)
        etKilo = findViewById(R.id.etKilo)
        btnHesapla = findViewById(R.id.btnHesapla)
        btnTemizle = findViewById(R.id.btnTemizle)
        tvSonuc = findViewById(R.id.tvSonuc)


        btnHesapla.setOnClickListener {
            hesaplaVeGoster()
        }


        btnTemizle.setOnClickListener {
            temizle()
        }
    }

    private fun temizle() {

        etBoy.text.clear()
        etKilo.text.clear()


        tvSonuc.text = "Sonuç Bekleniyor..."
        tvSonuc.setTextColor(android.graphics.Color.parseColor("#B39DDB"))


        etKilo.requestFocus()

        Toast.makeText(this, "Temizlendi!", Toast.LENGTH_SHORT).show()
    }

    private fun hesaplaVeGoster() {
        val boyText = etBoy.text.toString()
        val kiloText = etKilo.text.toString()

        if (boyText.isNotEmpty() && kiloText.isNotEmpty()) {
            val boy = boyText.toDouble()
            val kilo = kiloText.toDouble()

            val vki = kilo / (boy * boy)
            val durumMesaji: String
            val renkKodu: Int

            if (vki < 18.5) {
                durumMesaji = "Zayıf"
                renkKodu = android.graphics.Color.parseColor("#5E35B1")
            } else if (vki >= 18.5 && vki < 25) {
                durumMesaji = "Normal (İdeal)"
                renkKodu = android.graphics.Color.parseColor("#43A047") // Yeşil tonu
            } else if (vki >= 25 && vki < 30) {
                durumMesaji = "Fazla Kilolu"
                renkKodu = android.graphics.Color.parseColor("#FB8C00") // Turuncu tonu
            } else {
                durumMesaji = "Obez"
                renkKodu = android.graphics.Color.parseColor("#C2185B")
            }

            tvSonuc.setTextColor(renkKodu)
            tvSonuc.text = "VKİ: ${String.format("%.2f", vki)}\nDurum: $durumMesaji"

        } else {
            Toast.makeText(this, "Lütfen boy ve kilonuzu giriniz!", Toast.LENGTH_SHORT).show()
        }
    }
}