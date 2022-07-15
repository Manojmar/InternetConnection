package com.example.internetconnection

import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.internetconnection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val connectionManager:ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        binding.btn.setOnClickListener{
            val activeNetwork:NetworkInfo?=connectionManager.activeNetworkInfo
            val isConnected:Boolean=activeNetwork?.isConnectedOrConnecting==true

            if (isConnected){
                binding.text.text="You are Connected"
                binding.img.setBackgroundColor(Color.BLUE)
            }else{
                binding.text.text="You are Not Connected"
                binding.img.setBackgroundColor(Color.GREEN)
            }
        }
    }
}