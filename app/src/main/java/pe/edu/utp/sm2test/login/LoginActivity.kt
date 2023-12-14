package pe.edu.utp.sm2test.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.GoogleAuthProvider
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.MainActivity
import pe.edu.utp.sm2test.ProviderType

class LoginActivity : AppCompatActivity(){
    private val GOOGLE_SIGN_IN = 100

    private lateinit var btnLogin: Button
    private lateinit var etCorreo: EditText
    private lateinit var etContraseña: EditText

    private lateinit var btnRegistrar: Button
    private lateinit var btnGoogle: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnGoogle = findViewById(R.id.btnGoogle)

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


        btnGoogle.setOnClickListener {
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id_2)).requestEmail().build()
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SIGN_IN)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==GOOGLE_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account= task.getResult(ApiException::class.java)

                if(account != null) {

                    val credential= GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener{
                        if(it.isSuccessful){
                            val profilePicUrl = account.photoUrl?.toString() ?: ""
                            showHome(account.email ?: "", account.displayName ?: "", ProviderType.GOOGLE, profilePicUrl)
                        }else{
                            showAlert("Error:","No se registró")
                        }
                    }
                }

            }catch (e: ApiException){
                showAlert("Error:","Se ha producido un error.")
            }

        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
