package pe.edu.utp.sm2test.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.utp.sm2test.BooksActivity
import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

class TagsAdapter(private var tagList: MutableList<Tags>) :
    RecyclerView.Adapter<TagsAdapter.TagsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item_tag, parent, false)
        return TagsViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        val tag = tagList[position]
        holder.nameTag.text = tag.nameTag
        holder.imageTag.setImageResource(tag.imageTag!!)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, BooksActivity::class.java)
            intent.putExtra("genero", tag.nameTag)
            holder.itemView.context.startActivity(intent)

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