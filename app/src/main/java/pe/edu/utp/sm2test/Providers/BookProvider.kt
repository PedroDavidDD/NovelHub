package pe.edu.utp.sm2test.Providers

import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R
import java.text.SimpleDateFormat
import java.util.Date

class BookProvider {
    companion object {
        val booksList = mutableListOf<Books>(
            Books(
                "The beginning after the end 1",
                "Día 5",
                "Capítulo 20",
                R.drawable.tbate,
                "Fantasia",
                "Nombredel libro",
                R.drawable.tbate,
                "Nombre del autor",
                3.5,
                "Synopsis del libro",
                parseDate("10/09/23")
            )


            )

        private fun parseDate(dateStr: String): Date? {
            val format = SimpleDateFormat("dd/MM/yy") // Define el formato de la cadena
            return try {
                format.parse(dateStr)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }

    }




}