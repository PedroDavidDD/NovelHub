package pe.edu.utp.sm2test.ToolbarNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tag.rvTags
import pe.edu.utp.sm2test.Adapters.TagsAdapter
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TagsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TagsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapterTags: TagsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tag, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val layoutManager= LinearLayoutManager(context)
        recyclerView= view.findViewById(R.id.rvTags)
        recyclerView.layoutManager= layoutManager
        recyclerView.setHasFixedSize(true)
        adapterTags= TagsAdapter(getTagsList())
        recyclerView.adapter= adapterTags

    }

    fun getTagsList(): ArrayList<Tags>{
        var tagsList: ArrayList<Tags> = ArrayList()

        tagsList.add( Tags(3, "Fantasia", R.drawable.fantasia))
        tagsList.add( Tags(3, "Terror", R.drawable.fantasia))
        tagsList.add( Tags(3, "Ciencia ficcion", R.drawable.fantasia))


        return tagsList
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TagsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TagsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}