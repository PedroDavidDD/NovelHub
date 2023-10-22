package pe.edu.utp.sm2test.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import pe.edu.utp.sm2test.ExtensionFunctions.picassoLoadImageLocal
import pe.edu.utp.sm2test.ExtensionFunctions.replaceFragment
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R
import pe.edu.utp.sm2test.ReadBooksFragment

class ListFilterBooksAdapter(val context: Context, var list: MutableList<Books>, val layout: Int) :
    RecyclerView.Adapter<ListFilterBooksAdapter.BookViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = list[position]
        // Aquí debes cargar la imagen desde la ruta o recurso correspondiente
        val img = book.img
        holder.img.picassoLoadImageLocal(img!!, 178, 220)

        holder.btnIr.text = book.title
         // Configurar el clic del botón para ver mas detalles
        holder.btnIr.setOnClickListener {
            (context as AppCompatActivity).supportFragmentManager.replaceFragment(R.id.frame_layout,  ReadBooksFragment(), true)
        }
    }
    inner class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.iv_filter_card_img)
        val btnIr: Button = view.findViewById(R.id.btn_filter_card_title)
    }
    fun updListFilterBooks(newList: MutableList<Books>) {
        this.list = newList
        notifyDataSetChanged()
    }
}