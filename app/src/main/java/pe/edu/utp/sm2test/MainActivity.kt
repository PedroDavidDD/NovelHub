package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etNombreAlumno: EditText
    private lateinit var etCodigoAlumno: EditText
    private lateinit var btnMatricula: Button

    private lateinit var spCursos: Spinner
    private lateinit var rbHombre: RadioButton
    private lateinit var rbMujer: RadioButton
    private lateinit var rgSexo: RadioGroup
    private lateinit var etComentarios: EditText

    private lateinit var  nombre: String
    private lateinit var codigo: String
    private lateinit var sexo: String
    private lateinit var curso: String
    private lateinit var comentarios: String

    private var isSelectedSexo: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa los datos
        this.initialComponents();
        // Rellenar datos
        this.setData()
        // Acciones
        btnMatricula.setOnClickListener {
            this.getData()

            if (isSelectedSexo){
                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                intent.putExtra("nom", this.nombre)
                intent.putExtra("cod", this.codigo)
                intent.putExtra("cur", this.curso )
                intent.putExtra("sex", this.sexo )
                intent.putExtra("com", this.comentarios )
                startActivity(intent)
                Toast.makeText(this, "[ Correcto ]",Toast.LENGTH_SHORT).show()
            }
}
    }

    private fun setData() {
        etNombreAlumno.setText("Tessia")
        etCodigoAlumno.setText("U19207574")
        //Inicializa con IOS ?: con el primero
        val cursos = resources.getStringArray(R.array.arrCursos)
        val posicion = cursos.indexOf("Curso De Swift")
        spCursos.setSelection(posicion.takeIf { it != -1 } ?: 0)
    }

    private fun initialComponents(){

        etNombreAlumno = findViewById(R.id.etNombreAlumno)
        etCodigoAlumno = findViewById(R.id.etCodigoAlumno)
        btnMatricula = findViewById(R.id.btnMatricula)

        this.spCursos = findViewById(R.id.spCursos)
        this.rbHombre = findViewById(R.id.rbSexoH)
        rbMujer = findViewById(R.id.rbSexoM)
        etComentarios = findViewById(R.id.etComments)
        rgSexo = findViewById(R.id.rgSexo)
    }

    private fun getData(){
        this.nombre =    etNombreAlumno.text.toString()
        this.codigo =    etCodigoAlumno.text.toString()
        // obtener el id del curso seleccionado
        val idCurso = spCursos.selectedItemPosition
        when(idCurso){
            0 ->  { this.curso = "Curso De Android"}
            1 ->  { this.curso = "Curso De Swift"}
            2 ->  { this.curso = "Curso De IOS"}
            else ->  { this.curso = "Curso Random"}
        }
        // obtener el id del sexo seleccionado
        val checkedRadioButtonId = rgSexo.checkedRadioButtonId
        var msg = "[ Seleccione el sexo ]"
        if (checkedRadioButtonId != -1) {
            // Se ha seleccionado un RadioButton
            val radioButton = findViewById<RadioButton>(checkedRadioButtonId)
            val selectedText = radioButton.text.toString()
            // Hacer algo con el texto seleccionado
            msg = selectedText
            this.sexo = msg
            isSelectedSexo = true;
        } else {
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
            isSelectedSexo = false;
        }

        /*rgSexo.setOnCheckedChangeListener{
            group, checkedId ->
            // Cuando cambia la selección en el RadioGroup, este bloque de código se ejecutará
            if (checkedId != -1) {
                val radioButton: RadioButton = findViewById(checkedId)
                val selectedText = radioButton.text.toString()
            }
        }*/

        /*
          if (this.rbMujer.isChecked) { this.sexo = "mujer" }
          if (this.rbHombre.isChecked) { this.sexo = "hombre" }
        */
        this.comentarios = etComentarios.text.toString()
    }
}