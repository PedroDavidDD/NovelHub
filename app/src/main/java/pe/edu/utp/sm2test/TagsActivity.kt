package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar // Asegúrate de importar la clase Toolbar correcta
import androidx.appcompat.app.ActionBarDrawerToggle

class TagsActivity : AppCompatActivity() {
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

    }

    private fun initialComponents() {
    }

}
