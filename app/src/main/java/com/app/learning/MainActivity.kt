package com.app.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.learning.animation.AnimationMainActivity
import com.app.learning.complex_ui_practice.ComplexUIMainActivity
import com.app.learning.custom_views.CustomViewMainActivity
import com.app.learning.databinding.ActivityMainBinding
import com.app.learning.navigation.NavigationMainActivity
import com.app.learning.touch_input.TouchInputMainActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.animationBT.setOnClickListener {
            startActivity(Intent(this,AnimationMainActivity::class.java))
        }

        binding.complexUIBT.setOnClickListener {
            startActivity(Intent(this,ComplexUIMainActivity::class.java))
        }

        binding.customViewBT.setOnClickListener {
            startActivity(Intent(this,CustomViewMainActivity::class.java))
        }

        binding.navigationBT.setOnClickListener {
            startActivity(Intent(this,NavigationMainActivity::class.java))
        }

        binding.touchNInputBT.setOnClickListener {
            startActivity(Intent(this,TouchInputMainActivity::class.java))
        }

    }
}