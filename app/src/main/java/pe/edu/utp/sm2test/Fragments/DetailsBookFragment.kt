package pe.edu.utp.sm2test.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_book_details.view.elpRbCalificacion
import kotlinx.android.synthetic.main.fragment_book_details.view.ivPortadaLibro
import kotlinx.android.synthetic.main.fragment_book_details.view.tvDescripcion
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreAutor
import kotlinx.android.synthetic.main.fragment_book_details.view.tvNombreLibro
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.R

class DetailsBookFragment : Fragment() {


    private var bookAdapter: BooksAdapter? = null
    private lateinit var btnRead: Button
    private lateinit var ivShare: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_book_details, container, false)

        val queryText = arguments?.getInt("idBook")


        // Filtra la lista de libros por nombre Libro
        val filteredList = BookProvider.booksList.find { it.id == queryText }

        if ( filteredList != null ){
            bookAdapter = BooksAdapter(requireContext(), mutableListOf(filteredList))

            val img = filteredList.coverBook
            if (img != null) {
                rootView.ivPortadaLibro.picassoLoadImageLocal(img!!, 0, 220)
            }

            rootView.tvNombreLibro.text = filteredList.nameBook
            rootView.tvNombreAutor.text = filteredList.authorBook
            rootView.tvDescripcion.text = filteredList.synopsis
            rootView.elpRbCalificacion.rating= filteredList.qualification

        }

        btnRead= rootView.findViewById(R.id.btnLeer)
        btnRead.setOnClickListener {
            val readBooksFragment = ReadBooksFragment()
            val bundle = Bundle()
            if (queryText != null) {
                bundle.putInt("idBook", queryText)
            }
            readBooksFragment.arguments = bundle

            (context as AppCompatActivity).supportFragmentManager.replaceFragment(R.id.frame_layout,  readBooksFragment, true)
        }

        ivShare= rootView!!.findViewById(R.id.ivCompartir)
        ivShare.setOnClickListener {
            val bookId = filteredList?.id
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "http://www.NovelHUB.com/libros/$bookId")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
        return rootView
    }


}