package pe.edu.utp.sm2test.Fragments.ToolbarNav.Filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import pe.edu.utp.sm2test.Adapters.ListFilterBooksAdapter
import pe.edu.utp.sm2test.Enums.TypeFilterBook
import pe.edu.utp.sm2test.ExtensionFunctions.setTextColorRes
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R
import java.security.Provider

class FilterFragment : Fragment() {

    // Declaración de variables
    private lateinit var listFilterBooks: RecyclerView
    private lateinit var searchFilterBooks: EditText
    private var listFilterBookAdapter: ListFilterBooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño de la vista del fragmento
        val rootView = inflater.inflate(R.layout.fragment_filter, container, false)

        // Inicializar componentes de la vista
        initialComponents(rootView)

        // Inicializar el adaptador y configurar el RecyclerView
        listFilterBookAdapter = ListFilterBooksAdapter(
            requireContext(),
            BookProvider.booksList,
            R.layout.list_filter_item_books
        )
        listFilterBooks.layoutManager = GridLayoutManager(requireContext(), 2)
        listFilterBooks.adapter = listFilterBookAdapter

        // Iniciarlizar el Filtro
//        setSubFiltered()
        searchFilterBooks.setTextColorRes(R.color.black, R.color.white)

        return rootView
    }

    // Método para inicializar componentes de la vista
    private fun initialComponents(rootView: View) {
        listFilterBooks = rootView.findViewById(R.id.rv_filter_listBooks)
        searchFilterBooks = rootView.findViewById(R.id.et_filter_buscar)
    }

    fun setFilterBookList(bookList: MutableList<Books>) {
        // Actualizar el adaptador con la lista filtrada
        listFilterBookAdapter?.updListFilterBooks(bookList.toMutableList())
    }
    // SubFiltro
    private fun setSubFiltered(data: String? = null, typeFilterMain: String? = TypeFilterBook.title.toString()) {
        var queryText: String = ""

        searchFilterBooks.addTextChangedListener { query ->

            queryText = (data ?: query.toString()).trim().lowercase()

            // Filtrar la lista
            var booksFiltered: List<Books> = BookProvider.booksList.filter { book ->
                book.title.toString().lowercase().contains(queryText, ignoreCase = true)
            }

            when (typeFilterMain) {
                TypeFilterBook.title.toString() -> {
                    booksFiltered = BookProvider.booksList.filter { book ->
                        book.title.toString().lowercase().contains(queryText, ignoreCase = true)
                    }
                }
                TypeFilterBook.tag.toString() -> {
                    booksFiltered = BookProvider.booksList.filter { book ->
                        book.tagName.toString().lowercase().contains(queryText, ignoreCase = true)
                    }
                }
            }
            // Actualizar el adaptador con la lista filtrada
            listFilterBookAdapter?.updListFilterBooks(booksFiltered.toMutableList())
        }
        searchFilterBooks.setText(queryText)
    }

}