package pe.edu.utp.sm2test.ExtensionFunctions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.picassoLoadImageUrl(url: String) {
    if (url.isNotEmpty()){
        Picasso.get().load(url).into(this)
    }
}
fun ImageView.picassoLoadImageLocal( img: Int, targetWith: Int, targetHeight: Int) {
    Picasso.get().load(img)
        .resize(targetWith, targetHeight)
        .centerCrop()
        .into(this)
}
