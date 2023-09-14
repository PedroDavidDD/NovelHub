package pe.edu.utp.sm2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar // Asegúrate de importar la clase Toolbar correcta
import androidx.appcompat.app.ActionBarDrawerToggle

class HomeActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*
            toolbar = findViewById(R.id.toolbar) as Toolbar
            setSupportActionBar(toolbar)
        */
        // Inicializa los datos
        this.initialComponents();
        // Rellenar datos
        this.setData()
        // Acciones
    }

    private fun setData() {
        TODO("Not yet implemented")
    }

    private fun initialComponents() {
        TODO("Not yet implemented")
    }
}
