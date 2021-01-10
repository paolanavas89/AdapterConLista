package com.example.adapterconlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapterconlista.databinding.ActivityMainBinding
import com.example.adapterconlista.databinding.ActivityMainBinding.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        val mutableList : MutableList<String> = mutableListOf ()
        var n = Random.nextInt(5,10 )
        for (i in 0..n){
            mutableList.add("PC-$i")
        }
        adapter = StringAdapter(mutableList.toMutableList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


    }

}

