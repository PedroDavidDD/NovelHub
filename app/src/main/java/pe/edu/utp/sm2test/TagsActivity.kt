package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar // Asegúrate de importar la clase Toolbar correcta
import androidx.appcompat.app.ActionBarDrawerToggle

class TagsActivity : AppCompatActivity() , SearchView.OnQueryTextListener {
    private lateinit var svBuscar: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tags)
        // Inicializa los datos
        this.initialComponents()
        // Rellenar datos
        this.setData()
        // Acciones
    }

    private fun setData() {
        // Inicie de 0
        svBuscar.setOnQueryTextListener(this)

    }

    private fun initialComponents() {
        svBuscar = findViewById(R.id.sv_buscar)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        TODO("Not yet implemented")
    }
}
