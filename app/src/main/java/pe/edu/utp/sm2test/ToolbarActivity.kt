package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar // Asegúrate de importar la clase Toolbar correcta
import androidx.appcompat.app.ActionBarDrawerToggle

class ToolbarActivity : AppCompatActivity() {
    private lateinit var btnInicio: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        /*
        // Inicializa los datos
        this.initialComponents()
        // Rellenar datos
        this.setData()
        // Acciones
        */
    }

    private fun setData() {
        // Configura un clic en el botón para abrir la SegundaActividad
        btnInicio.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initialComponents() {
        btnInicio = findViewById(R.id.btn_inicio)
    }
}
