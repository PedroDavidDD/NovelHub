package pe.edu.utp.sm2test.Activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tag.rvEtiqueta
import pe.edu.utp.sm2test.Adapters.TagAdapter
import pe.edu.utp.sm2test.Classes.Tag
import pe.edu.utp.sm2test.R

class TagActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)

        rvEtiqueta.layoutManager = GridLayoutManager(this, 2)
        rvEtiqueta.adapter= TagAdapter(generarDatos(), this)
    }

    private fun generarDatos(): ArrayList<Tag> {
        var lista = ArrayList<Tag>()
        lista.add(Tag(R.drawable.fantasia, "Fantasia"))
        lista.add(Tag(R.drawable.fantasia, "Aventura"))
        lista.add(Tag(R.drawable.fantasia, "Ciencia Ficcion"))
        lista.add(Tag(R.drawable.fantasia, "Horror"))
        lista.add(Tag(R.drawable.fantasia, "Humor"))
        lista.add(Tag(R.drawable.fantasia, "Fan Ficcion"))

        return lista
    }
}