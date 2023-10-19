package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_book_details.view.tvDescripcion
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreAutor
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreLibro
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class DetailsBookFragment : Fragment() {


    private var bookAdapter: BooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_book_details, container, false)

        rootView.tvNombreLibro.text = arguments?.getString("nombreLibro")

        val queryText = arguments?.getString("nombreLibro").toString().trim().lowercase()
        // Filtra la lista de libros por nombre Libro
        val filteredList = BookProvider.booksList.filter { book ->
            book.nameBook!!.lowercase().contains(queryText, ignoreCase = true)
        }

        // Inflate the layout for this fragment
        bookAdapter = BooksAdapter(
            requireContext(),
            filteredList.toMutableList()
        )
        rootView.tvNombreAutor.text = filteredList[0].authorBook
        rootView.tvDescripcion.text = filteredList[0].synopsis


        // Inflate the layout for this fragment
        return rootView
    }


}