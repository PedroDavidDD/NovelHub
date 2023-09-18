package pe.edu.utp.sm2test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import pe.edu.utp.sm2test.BottomNavigation.HomeFragment
import pe.edu.utp.sm2test.BottomNavigation.MyNovelsFragment
import pe.edu.utp.sm2test.BottomNavigation.NewsFragment
import pe.edu.utp.sm2test.BottomNavigation.TagsFragment
import pe.edu.utp.sm2test.Filter.FilterFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var listBook: ArrayList<Books> = arrayListOf()

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    // Crear HomeFragment y pasar la lista de libros
    private var homeFragment: HomeFragment = HomeFragment()
    private var filterFragment: FilterFragment = FilterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa los datos y componentes
        initialComponents()
        // Datos del Toolbar
        getSettingsToolbar()

        // Reemplazar fragmento por defecto
        replaceFragment(homeFragment)
        // Obtener lista de libros
        obtenerListaDeBooks()
        // Establecer la lista de libros en el fragmento HomeFragment
        homeFragment.setBookList(listBook)

        // Acciones con los botones
        getBtnListeners()
    }

    private fun getBtnListeners() {
        // Configurar el listener para la navegación de la parte inferior
        binding.bottomNavigationView.setOnItemReselectedListener { item ->
            // Realizar acciones para el botón
            when (item.itemId) {
                R.id.btnInicio -> {
                    replaceFragment(homeFragment)
                }
                R.id.btnExplorar -> {
                    replaceFragment(NewsFragment())
                }
                R.id.btnMisSeries -> {
                    replaceFragment(MyNovelsFragment())
                }
            }
        }

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
        listBook.add(Books("Título 1", "Día 1", "Capítulo 1", R.drawable.icono_etiqueta))
        listBook.add(Books("Título 2", "Día 2", "Capítulo 2", R.drawable.tbate))

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
                    filterFragment.setFilterBookList(listBook)
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

        // Filtra la lista de libros por título
        val filteredList = listBook.filter { book ->
            book.title!!.contains(query, ignoreCase = true)
        }
        //[Encontró algo?]
        replaceFragment(filterFragment)
        if (filteredList.isEmpty()) {
            // Si filteredList está vacío, restaura la lista original
            filterFragment.setFilterBookList(listBook)
        } else {
            // Si filteredList no está vacío, establece la lista filtrada
            // Establecer la lista con libros filtrados
            filterFragment.setFilterBookList(ArrayList(filteredList))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "action_settings ${listBook.size}", Toast.LENGTH_SHORT).show()
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
    }

    // Método para reemplazar fragmento en el contenedor
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}
