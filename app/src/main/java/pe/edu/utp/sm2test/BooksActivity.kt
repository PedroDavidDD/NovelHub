package pe.edu.utp.sm2test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.BottomNavigation.HomeFragment
import pe.edu.utp.sm2test.ToolbarNav.TagsFragment
import pe.edu.utp.sm2test.ToolbarNav.Filter.FilterFragment
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.Providers.TagProvider
import pe.edu.utp.sm2test.databinding.ActivityBooksBinding
import pe.edu.utp.sm2test.databinding.ActivityMainBinding
import pe.edu.utp.sm2test.databinding.ActivityTagBinding

class BooksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBooksBinding
    private lateinit var toolbar: Toolbar
//    private lateinit var genero: TextView

    // Crear HomeFragment y pasar la lista de libros
    private var homeFragment: HomeFragment = HomeFragment()
    private var filterFragment: FilterFragment = FilterFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvGenero.text= intent.getStringExtra("genero")
        initialComponents()

    }


    private fun getBtnListeners() {
//        // Configurar el listener para la navegación de la parte inferior
//        binding.bottomNavigationView.setOnItemReselectedListener { item ->
//            // Realizar acciones para el botón
//            when (item.itemId) {
//                R.id.btnInicio -> {
//                    replaceFragment(homeFragment)
//                }
//                R.id.btnExplorar -> {
//                    replaceFragment(NewsFragment())
//                }
//                R.id.btnMisSeries -> {
//                    replaceFragment(MyNovelsFragment())
//                }
//            }
//        }

    }

    private fun getSettingsToolbar(){
        // Configurar Toolbar
        setSupportActionBar(toolbar)
        // Cambiar el título del Toolbar
        supportActionBar?.title = "NovelHub"
    }

    // Método para obtener la lista de libros (simulación)
    private fun obtenerListaDeBooks() {
        // Ejemplo de cómo agregar elementos a la lista
        // BookProvider.booksList.add(Books("Título 6", "Día 1", "Capítulo 1", R.drawable.icono_etiqueta))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_nav_menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        // Configurar el Listener para el SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Aquí puedes realizar la búsqueda y aplicar el filtro a tu RecyclerView
                filterData(query)
                println("Selecciono")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Si deseas realizar la búsqueda en tiempo real, puedes aplicar el filtro aquí
                //filterData(newText)
                // Mientras escribes en el Buscador, aparecen los tags
                replaceFragment(TagsFragment())
                println("Escribo")

                if (newText.isNullOrEmpty()) {
                    // El texto está vacío o nulo, puedes realizar alguna acción aquí
                    replaceFragment(filterFragment)
                    // El texto está vacío, restaura la lista original en el fragmento HomeFragment
                    filterFragment.setFilterBookList(BookProvider.booksList)
                }

                return true
            }
        })

        return true
    }

    // Método para filtrar datos (a implementar)
    private fun filterData(query: String?) {

        // Verificar si el query es nulo o muy corto
        if (query.isNullOrEmpty() || query.length < 3) {
            // No se hace nada si el query es nulo o muy corto
            return
        }
        val queryText = query.toString().trim().lowercase()
        // Filtra la lista de libros por título
        val filteredList = BookProvider.booksList.filter { book ->
            book.title!!.lowercase().contains(queryText, ignoreCase = true)
        }
        //[Encontró algo?]
        replaceFragment(filterFragment)
        if (filteredList.isEmpty()) {
            // Si filteredList está vacío, restaura la lista original
            filterFragment.setFilterBookList( BookProvider.booksList )
            //Toast.makeText(this,"NO HA ENCONTRADO COINCIDENCIAS",Toast.LENGTH_SHORT).show()
        } else {
            // Si filteredList no está vacío, establece la lista filtrada
            // Establecer la lista con libros filtrados
            filterFragment.setFilterBookList(filteredList.toMutableList())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "action_settings ${ BookProvider.booksList.size }", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_account -> {
                Toast.makeText(this, "action_account", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Método para inicializar componentes
    private fun initialComponents() {
        toolbar = binding.toolbar1
        binding.rvLibros.layoutManager= GridLayoutManager(this,2)
        binding.rvLibros.adapter= BooksAdapter(BookProvider.booksList)


    }

    // Método para reemplazar fragmento en el contenedor
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
