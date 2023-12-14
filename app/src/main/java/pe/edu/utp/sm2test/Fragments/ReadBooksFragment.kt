package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_book_details.view.elpRbCalificacion
import kotlinx.android.synthetic.main.fragment_book_details.view.ivPortadaLibro
import kotlinx.android.synthetic.main.fragment_book_details.view.tvDescripcion
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreAutor
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreLibro
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class ReadBooksFragment : Fragment() {

    private lateinit var readingTitle: TextView
    private lateinit var readingContent: TextView

    private val db = FirebaseFirestore.getInstance()
    private var booksListFromFirestore: MutableList<Books> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_read_books, container, false)

        initialComponents(rootView)

        // Llama a fetchBooksFromFirestore() cuando la vista se haya creado
        fetchBooksFromFirestore()

        return rootView
    }

    private fun initialComponents(rootView : View) {
        readingTitle = rootView.findViewById(R.id.tvReadingTitle)
        readingContent = rootView.findViewById(R.id.tvReadingContent)

    }

    // Método para obtener todos los libros de Firebase
    private fun fetchBooksFromFirestore() {
        val booksCollection = db.collection("books")

        booksCollection.get()
            .addOnSuccessListener { result ->
                val booksList = mutableListOf<Books>()
                for (document in result) {
                    val book = document.toObject(Books::class.java)
                    booksList.add(book)
                }
                // Actualiza la lista global con los libros obtenidos de Firebase
                booksListFromFirestore = booksList

                // Llama a la función para actualizar la interfaz de usuario con los datos obtenidos
                val queryText = arguments?.getInt("idBook")
                updateUIWithFetchedData(queryText ?: 0)
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error al obtener libros", e)
            }
    }

    // Método para obtener un libro específico por su ID desde la lista global de libros de Firebase
    private fun fetchBookByIdFromFirestore(bookId: Int): Books? {
        return booksListFromFirestore.find { it.id == bookId }
    }

    // Método para actualizar la interfaz de usuario con los datos obtenidos
    private fun updateUIWithFetchedData(queryText: Int) {
        // Obtener el libro específico por su ID desde Firebase
        val filteredBook = fetchBookByIdFromFirestore(queryText)
        if (filteredBook != null) {
            readingTitle.text = filteredBook.title
            readingContent.text = filteredBook.readingContent
        }
    }

}