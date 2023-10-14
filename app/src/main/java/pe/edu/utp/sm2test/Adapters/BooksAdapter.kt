package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import pe.edu.utp.sm2test.Fragments.BookFragment
import pe.edu.utp.sm2test.Fragments.DetailsBookFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R

class BooksAdapter(val context: Context, var bookList: MutableList<Books>) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_books, parent, false)
        return BooksViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val book= bookList[position]
        holder.coverBook.setImageResource(book.coverBook!!)
        holder.nameBook.text= book.nameBook
        holder.nameAuthor.text= book.authorBook


        holder.itemView.setOnClickListener {

            val bookFragment= DetailsBookFragment()
            val bundle= Bundle()

            bundle.putString("nombreLibro", book.nameBook)
            bookFragment.arguments = bundle

            val fragmentManager= (context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frame_layout, bookFragment).commit()



        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var nameTag: TextView = itemView.findViewById(R.id.tvEtiqueta)
//        var calificacion: RatingBar= itemView.findViewById(R.id.elpRbCalificacion)
        var coverBook: ImageView = itemView.findViewById(R.id.ivPortadaLibro)
        var nameBook: TextView= itemView.findViewById(R.id.tvNombreLibro)
        var nameAuthor: TextView= itemView.findViewById(R.id.tvNombreAutor)

    }
}