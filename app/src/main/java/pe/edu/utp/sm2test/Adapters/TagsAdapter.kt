package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
        holder.imageTag.setImageResource(tag.imageTag!!)


        val bookFragment = BookFragment()
        val bundle = Bundle()
        bundle.putString("genero", tag.nameTag)  // Reemplaza con el valor que desees
        bookFragment.arguments = bundle



//        holder.itemView.setOnClickListener {
//
////            val intent = Intent(holder.itemView.context, BookFragment::class.java)
//////            //intent.putExtra("genero", tag.nameTag)
//////            //replaceFragment()
//////            Log.d("libro", "nombretag" )
////            holder.itemView.context.startActivity(intent)
//        }

//        holder.itemView.setOnClickListener {
//
//            // Reemplaza el fragmento actual con el nuevo fragmento
//            val newFragment = BookFragment()  // Reemplaza "YourNewFragment" con el nombre de tu fragmento
//            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
//            transaction.replace(R.id.framelibross, newFragment)  // R.id.fragmentContainer debe ser el ID de tu contenedor de fragmentos en tu diseño
//            transaction.addToBackStack(null)  // Opcional, para agregar a la pila de retroceso
//            transaction.commit()
//        }


    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    class TagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTag: TextView = itemView.findViewById(R.id.tvEtiqueta)
        var imageTag: ImageView = itemView.findViewById(R.id.ivEtiqueta)

    }




}