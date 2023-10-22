package pe.edu.utp.sm2test.ExtensionFunctions

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun TextView.setTextColorRes(@ColorRes colorRes: Int, backgroundRes: Int) {
    setTextColor(ContextCompat.getColor(context, colorRes))
    setBackgroundColor(ContextCompat.getColor(context, backgroundRes))
}

fun TextView.setAlertMessage(message: String, durationMillis: Long) {
    text = message
    textAlignment = View.TEXT_ALIGNMENT_CENTER
    visibility = View.VISIBLE

    Handler(Looper.getMainLooper()).postDelayed({
        visibility = View.GONE
    }, durationMillis)
}