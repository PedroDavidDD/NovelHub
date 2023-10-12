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
                "Nombre del libro1",
                R.drawable.tbate,
                "Autor del autor",
                3.5,
                "Synopsis del libro",
                parseDate("10/09/23")
            ),
            Books(
                "Título 2",
                "Día 5",
                "Capítulo 20",
                R.drawable.icono_etiqueta,
                "Ciencia Ficcion",
                "Nombre del libro2",
                R.drawable.icono_etiqueta,
                "Autor del autor",
                3.5,
                "Synopsis del libro",
                parseDate("10/09/23")
            ),
            Books(
                "Título 3",
                "Día 5",
                "Capítulo 20",
                R.drawable.tbate,
                "Terror",
                "Nombre del libro3",
                R.drawable.tbate,
                "Autor del autor",
                3.5,
                "Synopsis del libro",
                parseDate("10/09/23")
            )



            )

        private fun parseDate(dateStr: String): Date? {
            val inputFormat  = SimpleDateFormat("dd/MM/yy") // Define el formato de la cadena
            return try {
                inputFormat.parse(dateStr)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }

    }




}