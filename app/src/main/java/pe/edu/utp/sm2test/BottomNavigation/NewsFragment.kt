package pe.edu.utp.sm2test.BottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.utp.sm2test.Adapters.ListNewsBooksAdapter
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class NewsFragment : Fragment() {

    private lateinit var listBooks: RecyclerView
    private  var listBookAdapter: ListNewsBooksAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño de la vista del fragmento
        val rootView = inflater.inflate(R.layout.fragment_news, container, false)

        // Inicializar componentes de la vista
        initialComponents(rootView)

        // Inicializar el adaptador y configurar el RecyclerView
        listBookAdapter = ListNewsBooksAdapter(requireContext(), BookProvider.booksList, R.layout.activity_list_news_item_books)
        listBooks.layoutManager = LinearLayoutManager(requireContext())
        listBooks.adapter = listBookAdapter

        return rootView
    }

    private fun initialComponents(rootView: View) {
        listBooks = rootView.findViewById(R.id.rv_news_listBooks)

    }
    // Método para establecer la lista de libros en HomeFragment
    fun setBookList(bookList: MutableList<Books>) {
        // Verificar si el adaptador no es nulo y notificar cambios en los datos
        listBookAdapter?.updateBookList(bookList)
    }
}