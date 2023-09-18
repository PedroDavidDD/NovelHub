package pe.edu.utp.sm2test.BottomNavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.utp.sm2test.Adapters.ListBooksAdapter
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R

class HomeFragment : Fragment() {

    // Declaración de variables
    private var listBook: ArrayList<Books> = arrayListOf()
    private lateinit var listBooks: RecyclerView
    private  var listBookAdapter: ListBooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño de la vista del fragmento
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        // Inicializar componentes de la vista
        initialComponents(rootView)

        // Inicializar el adaptador y configurar el RecyclerView
        listBookAdapter = ListBooksAdapter(requireContext(), listBook, R.layout.activity_list_item_books)
        listBooks.layoutManager = LinearLayoutManager(requireContext())
        listBooks.adapter = listBookAdapter

        return rootView
    }

    // Método para inicializar componentes de la vista
    private fun initialComponents(rootView: View) {
        listBooks = rootView.findViewById(R.id.rv_listBooks)
    }

    // Método para establecer la lista de libros en HomeFragment
    fun setBookList(bookList: ArrayList<Books>) {
        // Limpiar la lista actual y agregar nuevos elementos
        listBook.clear()
        listBook.addAll(bookList)

        // Verificar si el adaptador no es nulo y notificar cambios en los datos
        listBookAdapter?.notifyDataSetChanged()
    }
}
