package pe.edu.utp.sm2test.ToolbarNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tags.rvTags
import pe.edu.utp.sm2test.Adapters.TagsAdapter
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

class TagsFragment : Fragment() {

    private lateinit var adapterTags: TagsAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tags, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

//        val layoutManager= LinearLayoutManager(context)
//        recyclerView= view.findViewById(R.id.rvTags)
//        recyclerView.layoutManager= layoutManager
//        recyclerView.setHasFixedSize(true)
//        adapterTags= TagsAdapter(getTagsList())
//        recyclerView.adapter= adapterTags

    }

    fun getTagsList(): ArrayList<Tags>{
        var tagsList: ArrayList<Tags> = ArrayList()

        tagsList.add( Tags(3, "Fantasia", R.drawable.fantasia))
        tagsList.add( Tags(3, "Terror", R.drawable.fantasia))
        tagsList.add( Tags(3, "Ciencia ficcion", R.drawable.fantasia))


        return tagsList
    }


}