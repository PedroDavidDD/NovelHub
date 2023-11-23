package pe.edu.utp.sm2test.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.conexionBD.DBHelper

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var dbhelper = DBHelper(this)

        val newUsuarioEt = findViewById<EditText>(R.id.etNuevoUsuario)
        val newPassEt = findViewById<EditText>(R.id.etNuevoPass)
        val btnRegistrar = findViewById<Button>(R.id.btnNuevoUsuario)

        btnRegistrar.setOnClickListener{
            val user = newUsuarioEt.text.toString().trim()
            val pass = newPassEt.text.toString().trim()

            if (user.isNotEmpty() && pass.isNotEmpty()){
                val insertado = dbhelper.addUser(user, pass)
                if (insertado != -1L){
                    Toast.makeText(this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

