package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_book.view.tvGenero
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R


class BookFragment : Fragment() {

    private var bookAdapter: BooksAdapter? = null
    private lateinit var listFilterBook: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_book, container, false)

        initialComponents(rootView)

        rootView.tvGenero.text = arguments?.getString("genero")

        val queryText = arguments?.getString("genero").toString().trim().lowercase()
        // Filtra la lista de libros por título
        val filteredList = BookProvider.booksList.filter { book ->
            book.tagName!!.lowercase().contains(queryText, ignoreCase = true)
        }

        // Inflate the layout for this fragment
        bookAdapter = BooksAdapter(
            requireContext(),
            filteredList.toMutableList()
        )
        listFilterBook.layoutManager = GridLayoutManager(requireContext(), 2)


        listFilterBook.adapter = bookAdapter



        return rootView
    }

    private fun initialComponents(view: View) {
        listFilterBook = view.findViewById(R.id.rvLibros)


    }
}

