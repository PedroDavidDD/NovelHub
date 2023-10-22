package pe.edu.utp.sm2test.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.MainActivity

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val usuarioEt = findViewById<EditText>(R.id.etUsuario)
        val passwordEt = findViewById<EditText>(R.id.etPassword)
        val botonLogin = findViewById<Button>(R.id.buttonLogin)

        botonLogin.setOnClickListener{
            val user = usuarioEt.text.toString()
            val pw = passwordEt.text.toString()

            if (user == "" || pw == ""){
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, PerfilActivity::class.java)
                startActivity(intent)

            }
        }

        val botonRegresar = findViewById<Button>(R.id.buttonRegresar)
        botonRegresar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}
