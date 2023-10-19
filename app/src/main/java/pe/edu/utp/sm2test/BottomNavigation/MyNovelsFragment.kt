package pe.edu.utp.sm2test.BottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.utp.sm2test.R

class MyNovelsFragment : Fragment() {

     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         // Inflar el diseño de la vista del fragmento
         val rootView = inflater.inflate(R.layout.fragment_my_novels, container, false)

         // Inicializar componentes de la vista
         initialComponents(rootView)



         return rootView
    }

    private fun initialComponents(rootView: View) {

    }
}