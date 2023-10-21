package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_book_details.view.ivPortadaLibro
import kotlinx.android.synthetic.main.fragment_book_details.view.tvDescripcion
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreAutor
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreLibro
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class DetailsBookFragment : Fragment() {


    private var bookAdapter: BooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_book_details, container, false)


        val queryText = arguments?.getString("nombreLibro").toString().trim().lowercase()

        rootView.tvNombreLibro.text = queryText

        // Filtra la lista de libros por nombre Libro
        val filteredList = BookProvider.booksList.find { book ->
            book.nameBook.toString().lowercase().contains(queryText, ignoreCase = true)
        } ?: BookProvider.booksListNoData.first()

            bookAdapter = BooksAdapter(requireContext(), mutableListOf(filteredList))

            val img = filteredList.coverBook
            if (img != null) {
                val viewImg = rootView.ivPortadaLibro
                Picasso.get().load(img)
                    .resize(viewImg.width, 220)
                    .centerCrop()
                    .into(viewImg)
            }

            rootView.tvNombreAutor.text = filteredList.authorBook
            rootView.tvDescripcion.text = filteredList.synopsis

        return rootView
    }


}