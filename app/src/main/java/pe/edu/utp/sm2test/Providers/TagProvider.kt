package pe.edu.utp.sm2test.Providers

import pe.edu.utp.sm2test.Models.Tags
import pe.edu.utp.sm2test.R

class TagProvider {
    companion object{
        val tagList= mutableListOf<Tags>(
            Tags(
                1,
                "Fantasía",
                R.drawable.fantasia
            ),
            Tags(
                2,
                "Terror",
                R.drawable.horror
            ),
            Tags(
                3,
                "Ciencia Ficción",
                R.drawable.ciencia_ficcion
            ),
            Tags(
                4,
                "Aventura",
                R.drawable.aventura
            ),
            Tags(
                5,
                "Humor",
                R.drawable.humor
            ),
            Tags(
                6,
                "Fan Ficción",
                R.drawable.fan_ficcion
            )



        )
    }
}