package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.ReadBooksFragment

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

        // Cargar la imagen del libro utilizando Picasso
        val img = book.img
        holder.img.picassoLoadImageLocal(img!!, 352, 504)


        // Configurar el clic del botón para ver mas detalles
        holder.btnIr.setOnClickListener {
            (context as AppCompatActivity).supportFragmentManager.replaceFragment(R.id.frame_layout,  ReadBooksFragment(), true)
        }
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
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
