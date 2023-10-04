package pe.edu.utp.sm2test.ToolbarNav.Filter

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
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class FilterFragment : Fragment() {

    // Declaración de variables
    private lateinit var listFilterBooks: RecyclerView
    private var searchFilterBooks: EditText? = null
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
        listFilterBookAdapter = ListFilterBooksAdapter(requireContext(), BookProvider.booksList, R.layout.list_filter_item_books)
        listFilterBooks.layoutManager = GridLayoutManager(requireContext(),2)
        listFilterBooks.adapter = listFilterBookAdapter

        setFiltered()

        return rootView
    }

    // Método para inicializar componentes de la vista
    private fun initialComponents(rootView: View) {
        listFilterBooks = rootView.findViewById(R.id.rv_filter_listBooks)
        searchFilterBooks = rootView.findViewById(R.id.et_filter_buscar)
    }

    fun setFilterBookList(bookList: MutableList<Books>) {
        // Crear una copia de la lista original
        val copyOfOriginalList = ArrayList(BookProvider.booksList)

        // Limpiar la lista actual y agregar nuevos elementos
        copyOfOriginalList.clear()
        copyOfOriginalList.addAll(bookList)

        // Verificar si el adaptador no es nulo y notificar cambios en los datos
        listFilterBookAdapter?.notifyDataSetChanged()
    }

    fun setFiltered(data: String? = null) {
        var queryText: String = ""
        searchFilterBooks?.addTextChangedListener { query ->
            queryText = (data ?: query.toString()).trim().lowercase()

            // Crear una copia de la lista original
            val copyOfOriginalList = ArrayList(BookProvider.booksList)
            // Filtrar la copia de la lista
            val booksFiltered = copyOfOriginalList.filter { book -> book.title!!.lowercase().contains(queryText, ignoreCase = true) }

            // Actualizar el adaptador con la lista filtrada
            listFilterBookAdapter!!.updListFilterBooks(booksFiltered.toMutableList())

        }
        searchFilterBooks?.setText(queryText)
    }


}