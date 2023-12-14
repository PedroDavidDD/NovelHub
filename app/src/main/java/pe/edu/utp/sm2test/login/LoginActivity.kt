package pe.edu.utp.sm2test.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.MainActivity
import pe.edu.utp.sm2test.ProviderType

class LoginActivity : AppCompatActivity(){

    private lateinit var btnLogin: Button
    private lateinit var etCorreo: EditText
    private lateinit var etContraseña: EditText

    private lateinit var btnRegistrar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnLogin.setOnClickListener {
            if (etCorreo.text.isNotEmpty() && etContraseña.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    etCorreo.text.toString(),  etContraseña.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "" ,it.result?.user?.displayName ?: "" , ProviderType.BASIC, "")
                    } else {
                        // Mostrar un mensaje descriptivo del error
                        val errorMsg  = when (val ex = it.exception) {
                            is FirebaseAuthException -> ex.message
                            else -> "Se ha producido un error."
                        }
                        showAlert("Error",errorMsg ?: "Se ha producido un error.")

                    }

                }
            }
        }

        btnRegistrar.setOnClickListener {
            registerBasic()
        }

        val botonRegresar = findViewById<Button>(R.id.buttonRegresar)
        botonRegresar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun registerBasic() {
        if (etCorreo.text.isNotEmpty() && etContraseña.text.isNotEmpty()) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                etCorreo.text.toString(),  etContraseña.text.toString()).addOnCompleteListener {
                if (it.isSuccessful) {
                    showAlert("Excelente","¡Registrado!")
                } else {
                    // Mostrar un mensaje descriptivo del error
                    val errorMsg  = when (val ex = it.exception) {
                        is FirebaseAuthException -> ex.message
                        else -> "Se ha producido un error."
                    }
                    showAlert("Error",errorMsg ?: "Se ha producido un error.")
                }

            }
        }
    }

    private fun showHome( email: String, name: String, provider: ProviderType, profilePicUrl:String) {
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("name", name)
            putExtra("provider", provider.name)
            putExtra("picture", profilePicUrl)
        }
        startActivity(homeIntent)
    }
    private fun showAlert(title: String, errorMsg: String)  {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¡${title}!")
        builder.setMessage("${errorMsg}")
        builder.setPositiveButton("Accept", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
