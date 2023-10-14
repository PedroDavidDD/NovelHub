package pe.edu.utp.sm2test


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager

import pe.edu.utp.sm2test.Adapters.TagsAdapter

import pe.edu.utp.sm2test.Providers.TagProvider
import pe.edu.utp.sm2test.databinding.ActivityTagsBinding

class TagsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTagsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTagsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }




}