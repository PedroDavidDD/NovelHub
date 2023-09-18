package pe.edu.utp.sm2test.ToolbarNav.Filter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import pe.edu.utp.sm2test.Adapters.ListFilterBooksAdapter
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R

class FilterFragment : Fragment() {

    // Declaración de variables
    private var listFilterBook: ArrayList<Books> = arrayListOf()
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
        listFilterBookAdapter = ListFilterBooksAdapter(requireContext(), listFilterBook, R.layout.list_filter_item_books)
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

    // Método para establecer la lista de libros en HomeFragment
    fun setFilterBookList(bookList: ArrayList<Books>) {
        // Limpiar la lista actual y agregar nuevos elementos
        listFilterBook.clear()
        listFilterBook.addAll(bookList)

        // Verificar si el adaptador no es nulo y notificar cambios en los datos
        listFilterBookAdapter?.notifyDataSetChanged()
    }

    fun setFiltered(data: String? = null) {
        var queryText: String = ""
        searchFilterBooks?.addTextChangedListener {query ->
            queryText = (data ?: query.toString()).trim().lowercase()
            val booksFiltered = listFilterBook.filter { book -> book.title!!.lowercase().contains(queryText) }
            listFilterBookAdapter!!.updListFilterBooks(ArrayList(booksFiltered))
        }
        searchFilterBooks?.setText(queryText)
    }

}