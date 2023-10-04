package pe.edu.utp.sm2test.Providers

import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R

class BookProvider {
    companion object {
        val booksList = mutableListOf<Books>(
            Books(
                "Título 1",
                "Día 5",
                "Capítulo 20",
                R.drawable.tbate
            ),
            Books("Título 2", "Día 2", "Capítulo 2", R.drawable.tbate),
            Books("Título 3", "Día 3", "Capítulo 1000", R.drawable.icono_etiqueta),
            Books("Título 4", "Día 4", "Capítulo 110", R.drawable.tbate),
            Books("Título 5", "Día 5", "Capítulo 20", R.drawable.tbate)

            )
    }
}