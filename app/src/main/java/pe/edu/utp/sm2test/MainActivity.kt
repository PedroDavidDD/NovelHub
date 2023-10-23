package pe.edu.utp.sm2test

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.textclassifier.SelectionEvent
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.setViewTreeOnBackPressedDispatcherOwner
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import pe.edu.utp.sm2test.Fragments.BottomNavigation.HomeFragment
import pe.edu.utp.sm2test.Fragments.BottomNavigation.MyNovelsFragment
import pe.edu.utp.sm2test.Fragments.BottomNavigation.NewsFragment
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.ExtensionFunctions.setAlertMessage
import pe.edu.utp.sm2test.ExtensionFunctions.setTextColorRes
import pe.edu.utp.sm2test.Fragments.DetailsBookFragment
import pe.edu.utp.sm2test.Fragments.ToolbarNav.Filter.FilterFragment
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.Fragments.ToolbarNav.Filter.TagsFragment
import pe.edu.utp.sm2test.databinding.ActivityMainBinding
import pe.edu.utp.sm2test.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    // Crear HomeFragment y pasar la lista de libros
    private var homeFragment: HomeFragment = HomeFragment()
    private var filterFragment: FilterFragment = FilterFragment()

    private lateinit var errorMessageTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Log.d("libro", BookProvider.booksList.toString())
        // Inicializa los datos y componentes
        initialComponents()

        // Reemplazar fragmento por defecto
        supportFragmentManager.replaceFragment(R.id.frame_layout,  homeFragment, true)
        // Establecer la lista de libros en el fragmento HomeFragment
        homeFragment.setBookList(BookProvider.booksList)

        // Acciones con los botones
        getBtnListeners()
    }

    private fun getBtnListeners() {
        // Configurar el listener para la navegación de la parte inferior
        binding.bottomNavigationView.setOnItemReselectedListener { item ->
            // Realizar acciones para el botón
            when (item.itemId) {
                R.id.btnInicio -> {
                    supportFragmentManager.replaceFragment(R.id.frame_layout,  homeFragment, true)
                }
                R.id.btnExplorar -> {
                    supportFragmentManager.replaceFragment(R.id.frame_layout,  NewsFragment(), true)
                }
                R.id.btnMisSeries -> {
                    supportFragmentManager.replaceFragment(R.id.frame_layout,  MyNovelsFragment(), true)
                }
            }

        }

    }

    private fun getSettingsToolbar(){
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "NovelHub"

        // Configurar la barra de acción y habilitar el botón de retroceso
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_ios_24)

        setColorBottomNavigationView()
    }

    private fun setColorBottomNavigationView() {
        var selectedColor = ContextCompat.getColor(this, R.color.md_theme_light_primary)
        var unselectedColor = ContextCompat.getColor(this, R.color.white)
        var colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked), // Estado seleccionado
                intArrayOf(-android.R.attr.state_checked)  // Estado no seleccionado
            ),
            intArrayOf( selectedColor, unselectedColor )
        )
        binding.bottomNavigationView.itemIconTintList = colorStateList
        binding.bottomNavigationView.itemTextColor = colorStateList
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_nav_menu, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        // Configurar el Listener para el SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Aquí puedes realizar la búsqueda y aplicar el filtro a tu RecyclerView
                filterDataMain(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Mientras escribes en el Buscador, aparecen los tags
                supportFragmentManager.replaceFragment(R.id.frame_layout,  TagsFragment(), true)
                return true
            }
        })

        return true
    }

    // Método para filtrar datos (a implementar)
    private fun filterDataMain(query: String?) {
        // Verificar si el query es nulo o muy corto
        if (query.isNullOrEmpty() || query.length < 3) {
            // errorMessageTextView
            errorMessageTextView.setTextColorRes(R.color.black, R.color.md_theme_light_primary)
            errorMessageTextView.setAlertMessage("Mínimo 3 caracteres", 3000)

            return
        }

        val queryText = query.toString().trim().lowercase()

        val filteredList = BookProvider.booksList.filter { book ->
            book.title.toString().lowercase().contains(queryText, ignoreCase = true)
        }

        val bundle = Bundle()
//        bundle.putString("filteredQueryText", queryText)

        if (filteredList.isEmpty()) {
            // Si filteredList está vacío, restaura la lista original

            bundle.putParcelableArrayList("filteredBookList", ArrayList(BookProvider.booksList.shuffled().take(4)))
            // errorMessageTextView
            errorMessageTextView.setTextColorRes(R.color.black, R.color.md_theme_light_primary)
            errorMessageTextView.setAlertMessage("Libro no encontrado, te recomendamos los siguientes", 4000)
        } else {
            // Si filteredList no está vacío, establece la lista filtrada
            bundle.putParcelableArrayList("filteredBookList", ArrayList(filteredList))
        }

        filterFragment.arguments = bundle
        supportFragmentManager.replaceFragment(R.id.frame_layout,  filterFragment, true)
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
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                true
            }
            android.R.id.home-> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Método para inicializar componentes
    private fun initialComponents() {
        toolbar = binding.toolbar1
        // Configurar Toolbar
        getSettingsToolbar()
        errorMessageTextView = binding.tvErrorMessage
        errorMessageTextView.bringToFront()

    }

}