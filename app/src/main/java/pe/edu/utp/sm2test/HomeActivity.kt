package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar // Asegúrate de importar la clase Toolbar correcta
import androidx.appcompat.app.ActionBarDrawerToggle

class HomeActivity : AppCompatActivity() {
    private lateinit var btnIr: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        // Inicializa los datos
        this.initialComponents();
        // Rellenar datos
        this.setData()
        // Acciones
    }

    private fun setData() {
        // Configura un clic en el botón para abrir la SegundaActividad
        btnIr.setOnClickListener {
            val intent = Intent(this,TagsActivity::class.java )
            startActivity(intent)
        }
    }

    private fun initialComponents() {
        btnIr = findViewById(R.id.btn_card_title_go)
    }
}
