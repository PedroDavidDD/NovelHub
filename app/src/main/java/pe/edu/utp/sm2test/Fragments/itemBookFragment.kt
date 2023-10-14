package pe.edu.utp.sm2test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.utp.sm2test.Adapters.BooksAdapter
import pe.edu.utp.sm2test.R

class itemBookFragment : Fragment() {

    private var bookAdapter: BooksAdapter?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_item, container, false)
    }


}