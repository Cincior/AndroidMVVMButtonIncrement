package com.example.mvvmbuttonexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmbuttonexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
//        val controller = WindowInsetsControllerCompat(window, window.decorView)
//
//        controller.hide(WindowInsetsCompat.Type.systemBars())
//        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = counterViewModel
        binding.lifecycleOwner = this

        binding.btnZero.setOnClickListener{
            counterViewModel.zero()
        }
//        binding.btnAdd.setOnClickListener{
//            counterViewModel.increment()
//        }

        counterViewModel.counter.observe(this, Observer {
            counterProg -> binding.counterResultProg.text = counterProg.count.toString()
        })


    }
}