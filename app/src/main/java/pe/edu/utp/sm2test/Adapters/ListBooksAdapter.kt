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
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R

class ListBooksAdapter(val context: Context, var list: MutableList<Books>, val layout: Int) :
    RecyclerView.Adapter<ListBooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = list[position]
        holder.title.text = book.title
        holder.day.text = book.day
        holder.chapter.text = book.chapter
        // Aquí debes cargar la imagen desde la ruta o recurso correspondiente
        holder.img.setImageResource(book.img!!)

        // Configurar el clic del botón para ver mas detalles
//        holder.btnIr.setOnClickListener {
//            val intent = Intent(holder.itemView.context, TagsActivity::class.java)
//            holder.itemView.context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_card_title)
        val day: TextView = view.findViewById(R.id.tv_card_day)
        val chapter: TextView = view.findViewById(R.id.tv_card_chapter)
        val img: ImageView = view.findViewById(R.id.iv_card_img)
        val btnIr: Button = view.findViewById(R.id.btn_card_title_go)
    }
    fun updateBookList(list: MutableList<Books>){
        //this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
