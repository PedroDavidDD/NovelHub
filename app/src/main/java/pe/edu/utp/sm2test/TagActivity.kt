package pe.edu.utp.sm2test


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager

import pe.edu.utp.sm2test.Adapters.TagsAdapter

import pe.edu.utp.sm2test.Providers.TagProvider
import pe.edu.utp.sm2test.databinding.ActivityTagBinding


class TagActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTagBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initialComponents()

    }

    private fun initialComponents(){
        binding.rvTags.layoutManager= GridLayoutManager(this,2)
        binding.rvTags.adapter= TagsAdapter(TagProvider.tagList)

    }




}