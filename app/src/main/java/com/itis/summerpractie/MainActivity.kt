package com.itis.summerpractie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener
import com.itis.summerpractie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)

        val pref = getSharedPreferences("Default", MODE_PRIVATE)
        pref.getInt(ARG_COUNT, -1).takeIf { it > -1 }?.let {
            count = it
        }

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("ARG_COUNT")
        }

        binding.button.setOnClickListener {
            count++
            pref.edit {
                putInt(ARG_COUNT, count)
            }
            binding.tvHelloWorld.text = "Our counter: $count"
        }

        binding.etLogin.addTextChangedListener {
            binding.tiLogin.error = null
        }
        binding.tiLogin.error = "ERROR"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_COUNT", count)
    }

    companion object {
        private const val ARG_COUNT = "ARG_COUNT"
    }
}