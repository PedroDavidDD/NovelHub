package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_tag.view.ivEtiqueta
import kotlinx.android.synthetic.main.activity_item_tag.view.tvEtiqueta
import pe.edu.utp.sm2test.Classes.Tag
import pe.edu.utp.sm2test.R

class TagAdapter(private var lista: ArrayList<Tag>, private var context: Context) :
    RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    class ViewHolder(var vista: View, context: Context) : RecyclerView.ViewHolder(vista) {
        fun bind(tag: Tag) {
            vista.ivEtiqueta.setImageResource(tag.imagenEtiqueta)
            vista.tvEtiqueta.text= tag.nombreEtiqueta


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item_tag, parent, false), context )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }
}