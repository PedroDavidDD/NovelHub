package pe.edu.utp.sm2test.ToolbarNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_tags.view.rvTags
import pe.edu.utp.sm2test.Adapters.ListFilterBooksAdapter
import pe.edu.utp.sm2test.Adapters.TagsAdapter
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.Providers.BookProvider
import pe.edu.utp.sm2test.Providers.TagProvider
import pe.edu.utp.sm2test.R

class TagsFragment : Fragment() {

    private lateinit var adapterTags: TagsAdapter
    private lateinit var recyclerView: RecyclerView
    private var tagdapter: TagsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_tags, container, false)
        // Inflate the layout for this fragment
       tagdapter = TagsAdapter(
           requireContext(),
           TagProvider.tagList,
           R.layout.activity_item_tag
       )
        rootView.rvTags.layoutManager= GridLayoutManager(requireContext(),2)
        rootView.rvTags.adapter = tagdapter

        return rootView
    }


    private fun initialComponents(){
    }

}