package pe.edu.utp.sm2test.Providers

import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

class TagProvider {
    companion object{
        val tagList= mutableListOf<Tags>(
            Tags(
                1,
                "Fantasia",
                R.drawable.fantasia
            ),
            Tags(
                2,
                "Terror",
                R.drawable.fantasia
            ),
            Tags(
                3,
                "Romance",
                R.drawable.fantasia
            ),
            Tags(
                4,
                "Ciencia Ficcion",
                R.drawable.fantasia
            ),
            Tags(
                5,
                "Aventura",
                R.drawable.fantasia
            )



        )
    }
}