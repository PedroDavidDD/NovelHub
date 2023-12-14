package pe.edu.utp.sm2test.Fragments.BottomNavigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import pe.edu.utp.sm2test.Adapters.ListBooksAdapter
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {

    // Declaración de variables
    private lateinit var listBooks: RecyclerView
    private  var listBookAdapter: ListBooksAdapter? = null
    private val db = FirebaseFirestore.getInstance()
    private val dateFormat = SimpleDateFormat("d 'de' MMMM 'de' yyyy, h:mm:ss a z", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño de la vista del fragmento
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Inicializar componentes de la vista
        initialComponents(rootView)


        // Inicializar el adaptador y configurar el RecyclerView
        listBookAdapter = ListBooksAdapter(requireContext(), mutableListOf(), R.layout.activity_list_item_books)
        listBooks.layoutManager = LinearLayoutManager(requireContext())
        listBooks.adapter = listBookAdapter

        // Obtener los datos de Firebase y luego configurar el adaptador
        fetchBooksFromFirestore()

        return rootView
    }

    // Método para inicializar componentes de la vista
    private fun initialComponents(rootView: View) {
        listBooks = rootView.findViewById(R.id.rv_listBooks)
    }

    // Método para establecer la lista de libros en HomeFragment
    fun setBookList(bookList: MutableList<Books>) {
        // Verificar si el adaptador no es nulo y notificar cambios en los datos
        listBookAdapter?.updateBookList(bookList)
    }

    private fun fetchBooksFromFirestore() {
        val booksCollection = db.collection("books")

        booksCollection.get()
            .addOnSuccessListener { result ->
                val booksList = mutableListOf<Books>()
                for (document in result) {
                    val book = document.toObject(Books::class.java)
                    // Obtener el campo fechaEstreno como un Timestamp
                    val timestamp = document.getTimestamp("fechaEstreno")
                    // Convertir a Date si el timestamp no es nulo
                    if (timestamp != null) {
                        val date = timestamp.toDate()
                        book.fechaEstreno = date
                    }
                    booksList.add(book)
                }
                listBookAdapter?.updateBookList(booksList)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error al obtener libros", e)
            }
    }

    private fun parseDate(dateString: String): Date? {
        return try {
            dateFormat.parse(dateString)
        } catch (e: ParseException) {
            Log.e("DateParsing", "Error al convertir la fecha", e)
            null
        }
    }
}
