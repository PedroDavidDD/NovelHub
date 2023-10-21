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
import com.squareup.picasso.Picasso
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
        holder.nameBook.text= book.nameBook
        holder.nameAuthor.text= book.authorBook

        val img = book.coverBook
        val viewImg = holder.coverBook
        Picasso.get().load(img!!)
            .resize(viewImg.width, 180)
            .centerCrop()
            .into(viewImg)

        holder.itemView.setOnClickListener {

            val bookFragment= DetailsBookFragment()
            val bundle= Bundle()

            bundle.putInt("idLibro", book.id)
            bookFragment.arguments = bundle

            val fragmentManager= (context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frame_layout, bookFragment).commit()



        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var coverBook: ImageView = itemView.findViewById(R.id.ivPortadaLibro)
        var nameBook: TextView= itemView.findViewById(R.id.tvNombreLibro)
        var nameAuthor: TextView= itemView.findViewById(R.id.tvNombreAutor)

    }
}