package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R
import java.text.SimpleDateFormat

class ListNewsBooksAdapter(val context: Context, var list: MutableList<Books>, val layout: Int) :
    RecyclerView.Adapter<ListNewsBooksAdapter.BookViewHolder>() {

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
        holder.description.text = book.synopsis
        // Aquí debes cargar la imagen desde la ruta o recurso correspondiente
        val img = book.img
        holder.img.picassoLoadImageLocal(img!!, 0, 340)

        val outputFormat = SimpleDateFormat("dd MMM")
        val formattedDate = outputFormat.format(book.fechaEstreno)
        holder.date.text = formattedDate.uppercase()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_news_card_img)
        val title: TextView = view.findViewById(R.id.tv_news_card_title)
        val description: TextView = view.findViewById(R.id.tv_news_card_day)
        val date: TextView = view.findViewById(R.id.tv_news_card_title_go)
    }

    fun updateBookList(list: MutableList<Books>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
