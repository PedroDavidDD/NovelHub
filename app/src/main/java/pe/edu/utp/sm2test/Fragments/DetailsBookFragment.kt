package pe.edu.utp.sm2test.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_book_details.view.elpRbCalificacion
import kotlinx.android.synthetic.main.fragment_book_details.view.ivPortadaLibro
import kotlinx.android.synthetic.main.fragment_book_details.view.tvDescripcion
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreAutor
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreLibro
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class DetailsBookFragment : Fragment() {


    private var bookAdapter: BooksAdapter? = null
    private lateinit var btnRead: Button
    private lateinit var ivShare: ImageView

    private val db = FirebaseFirestore.getInstance()
    private var booksListFromFirestore: MutableList<Books> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_book_details, container, false)

        val queryText = arguments?.getInt("idBook")

        // Llama a fetchBooksFromFirestore() cuando la vista se haya creado
        fetchBooksFromFirestore()

        // Obtener el libro específico por su ID desde Firebase
        val filteredBook = fetchBookByIdFromFirestore(queryText ?: 0)

        btnRead= rootView.findViewById(R.id.btnLeer)
        btnRead.setOnClickListener {
            val readBooksFragment = ReadBooksFragment()
            val bundle = Bundle()
            if (queryText != null) {
                bundle.putInt("idBook", queryText)
            }
            readBooksFragment.arguments = bundle

            (context as AppCompatActivity).supportFragmentManager.replaceFragment(R.id.frame_layout,  readBooksFragment, true)
        }

        ivShare= rootView!!.findViewById(R.id.ivCompartir)
        ivShare.setOnClickListener {
            val bookId = filteredBook?.id
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "http://www.NovelHUB.com/libros/$bookId")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        return rootView
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
    }// Método para actualizar la interfaz de usuario con los datos obtenidos
    private fun updateUIWithFetchedData(queryText: Int) {
        val filteredBook = fetchBookByIdFromFirestore(queryText)
        if (filteredBook != null) {
            bookAdapter = BooksAdapter(requireContext(), mutableListOf(filteredBook))
            val rootView = view // Obtener la vista raíz

            // Actualizar la vista con los datos del libro obtenidos de Firestore
            val img = filteredBook.coverBook
            if (img != null) {
                rootView?.ivPortadaLibro?.picassoLoadImageLocal(img, 0, 220)
            }

            rootView?.tvNombreLibro?.text = filteredBook.nameBook
            rootView?.tvNombreAutor?.text = filteredBook.authorBook
            rootView?.tvDescripcion?.text = filteredBook.synopsis
            rootView?.elpRbCalificacion?.rating = filteredBook.qualification
        }
    }

}