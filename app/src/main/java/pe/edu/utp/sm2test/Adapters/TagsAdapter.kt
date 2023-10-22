package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.Fragments.BookFragment
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

class TagsAdapter(val context: Context,private var tagList: MutableList<Tags>, val layout: Int) :
    RecyclerView.Adapter<TagsAdapter.TagsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return TagsViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        val tag = tagList[position]
        holder.nameTag.text = tag.nameTag

        val img = tag.imageTag
        val viewImg = holder.imageTag
        Picasso.get().load(img!!)
            .resize(50, 50)
            .centerCrop()
            .into(viewImg)

        holder.itemView.setOnClickListener {
            val bookFragment = BookFragment()
            val bundle = Bundle()
            bundle.putString("genero", tag.nameTag)
            bookFragment.arguments = bundle

            (context as AppCompatActivity).supportFragmentManager.replaceFragment(R.id.frame_layout,  bookFragment, true)
        }

    }


    override fun getItemCount(): Int {
        return tagList.size
    }

    class TagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTag: TextView = itemView.findViewById(R.id.tvEtiqueta)
        var imageTag: ImageView = itemView.findViewById(R.id.ivEtiqueta)

    }




}