package pe.edu.utp.sm2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ResultadoActivity : AppCompatActivity() {

    private lateinit var nombreA: TextView
    private lateinit var codigoA: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        nombreA = findViewById(R.id.tv_ca)
        codigoA = findViewById(R.id.et_np)

        var bundle = intent.extras;

        nombreA.setText(bundle?.getString("nom"))
        codigoA.setText(bundle!!.getString("cod"))

        codigoA.setText(bundle!!.getString("nom")+bundle!!.getString("cod")+bundle!!.getString("cur")+bundle!!.getString("sex")+bundle!!.getString("com"))

    }
}