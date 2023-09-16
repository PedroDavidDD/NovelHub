package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.utp.sm2test.Adapters.ListBooksAdapter
import pe.edu.utp.sm2test.Models.Books

class HomeActivity : AppCompatActivity() {
    private lateinit var btnBuscar: SearchView

    private lateinit var listBooks: RecyclerView
    private var listBook: ArrayList<Books> = arrayListOf<Books>()
    private lateinit var listBookAdapter: ListBooksAdapter
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

        listBooks.setLayoutManager(LinearLayoutManager(this))

        obtenerListaDeBooks() // Obtén la lista de Books
        listBookAdapter = ListBooksAdapter(this@HomeActivity, listBook, R.layout.activity_list_item_books)
        listBooks.adapter = listBookAdapter
        Toast.makeText(this, "Numero de libros: ${listBook.size}",Toast.LENGTH_LONG).show()

        // Configura un clic en el botón para abrir TagsActivity
        btnBuscar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent = Intent(this@HomeActivity, TagsActivity::class.java)
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Acciones cuando cambia el texto de búsqueda (si es necesario)
                return true
            }
        })
    }

    private fun initialComponents() {
        listBooks = findViewById(R.id.rv_listBooks)
        btnBuscar = findViewById(R.id.sv_buscar)

    }
    private fun obtenerListaDeBooks() {

        // Ejemplo de cómo agregar elementos a la lista
        listBook.add(Books("Título 1", "Día 1", "Capítulo 1", R.drawable.icono_etiqueta))
        listBook.add(Books("Título 2", "Día 2", "Capítulo 2", R.drawable.tbate))


    }
}
