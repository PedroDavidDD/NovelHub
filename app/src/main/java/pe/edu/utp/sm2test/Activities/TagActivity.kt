package pe.edu.utp.sm2test.Activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
//import kotlinx.android.synthetic.main.activity_tag.rvEtiqueta
import pe.edu.utp.sm2test.Adapters.TagsAdapter

import pe.edu.utp.sm2test.R

class TagActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

//        rvEtiqueta.layoutManager = GridLayoutManager(this, 2)
//        rvEtiqueta.adapter= TagsAdapter(generarDatos(), this)
    }


}