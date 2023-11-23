package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class ReadBooksFragment : Fragment() {

    private lateinit var readingTitle: TextView
    private lateinit var readingContent: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_read_books, container, false)

        initialComponents(rootView)

        val queryInt = arguments?.getInt("idBook")
        // Filtra la lista de libros por título
        val filteredList = BookProvider.booksList.find { it.id == queryInt }
        readingTitle.text = filteredList?.title
        readingContent.text = filteredList?.readingContent;

        return rootView
    }

    private fun initialComponents(rootView : View) {
        readingTitle = rootView.findViewById(R.id.tvReadingTitle)
        readingContent = rootView.findViewById(R.id.tvReadingContent)

    }

}