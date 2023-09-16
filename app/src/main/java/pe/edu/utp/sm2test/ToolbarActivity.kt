package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar

class ToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        // Inicializa los datos
        initialComponents()

        // Configura un clic en el botón para abrir TagsActivity
        setData()
    }

    private fun setData() {
    }

    private fun initialComponents() {
    }
}
