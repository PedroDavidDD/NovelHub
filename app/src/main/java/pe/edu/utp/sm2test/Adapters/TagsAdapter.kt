package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarItemView
import pe.edu.utp.sm2test.BooksActivity
import pe.edu.utp.sm2test.Classes.Tag
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.TagsActivity
import pe.edu.utp.sm2test.ToolbarNav.TagsFragment

class TagsAdapter(private val tagsList: ArrayList<Tags>) : RecyclerView.Adapter<TagsAdapter.ViewHolder>(){


    lateinit var context: Context
//    var onItemClick: ((Tag) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_tag, parent, false)
        return ViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tag= tagsList[position]
        holder.nameTag.text= tag.nameTag
        holder.imageTag.setImageResource(tag.imageTag!!)

        holder.btnBook.setOnClickListener{

                val intent = Intent(holder.itemView.context, BooksActivity::class.java)
                holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return tagsList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameTag: TextView= itemView.findViewById(R.id.tvEtiqueta)
        var imageTag: ImageView= itemView.findViewById(R.id.ivEtiqueta)
        var btnBook: Button= itemView.findViewById(R.id.btnBooks)

    }



}