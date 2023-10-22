package pe.edu.utp.sm2test.Providers

import android.widget.ImageView
import com.squareup.picasso.Picasso
import pe.edu.utp.sm2test.Models.Books
import pe.edu.utp.sm2test.R
import java.text.SimpleDateFormat
import java.util.Date

class BookProvider {
    companion object {
        val booksList = mutableListOf<Books>(
            Books(
                0,
                "The beginning after the end 1",
                "Día 5",
                "Capítulo 20",
                R.drawable.tbate,
                "Fantasía",
                "The beginning after the end 1",
                R.drawable.tbate,
                "TurtleMe",
                3.5,
                "El Rey Gris posee una fuerza, una riqueza y un prestigio sin igual en un mundo gobernado por la habilidad marcial. Sin embargo, la soledad persigue de cerca a aquellos que poseen un gran poder. Bajo el glamuroso exterior de un poderoso rey se esconde la cáscara de un hombre, carent ",
                parseDate("10/09/2023")
            ),
            Books(
                1,
                "The Name of the Wind",
                "Día 5",
                "Capítulo 20",
                R.drawable.thenameofthewind,
                "Fantasía",
                "The Name of the Wind",
                R.drawable.thenameofthewind,
                "Patrick Rothfuss",
                3.5,
                "A young man chronicles his life as a renowned magician and musician.",
                parseDate("10/09/2007")
            ),
            Books(
                2,
                "The Hobbit",
                "Día 5",
                "Capítulo 20",
                R.drawable.thehobbit,
                "Fantasía",
                "The Hobbit",
                R.drawable.thehobbit,
                ".R.R. Tolkien",
                3.5,
                "Bilbo Baggins embarks on a quest to reclaim a treasure from a dragon.",
                parseDate("10/09/1937")
            ),
            Books(
                3,
                "Harry Potter and the Sorcerer's Stone",
                "Día 5",
                "Capítulo 20",
                R.drawable.harrypotter,
                "Fantasía",
                "Harry Potter and the Sorcerer's Stone",
                R.drawable.harrypotter,
                "J.K. Rowling",
                3.5,
                "A young boy discovers he is a wizard and enrolls in a magical school.",
                parseDate("10/09/1997")
            ),
            Books(
                4,
                "A Game of Thrones",
                "Día 5",
                "Capítulo 20",
                R.drawable.agameofthrones,
                "Fantasía",
                "A Game of Thrones",
                R.drawable.agameofthrones,
                "George R.R. Martin",
                3.5,
                "Noble families vie for control of the Iron Throne in a fantasy world.",
                parseDate("10/09/1996")
            ),
            Books(
                5,
                "The Wise Man's Fear",
                "Día 5",
                "Capítulo 20",
                R.drawable.thewisemanfear,
                "Fantasía",
                "The Wise Man's Fear",
                R.drawable.thewisemanfear,
                "Patrick Rothfuss",
                3.5,
                "The protagonist continues his education at the magical university and faces various challenges.",
                parseDate("10/09/2011")
            ),
            Books(
                6,
                "Salem’s Lot",
                "Día 5",
                "Capítulo 20",
                R.drawable.salemslot,
                "Terror",
                "Salem’s Lot",
                R.drawable.salemslot,
                "Stephen King",
                3.5,
                "This story of a small town overrun by vampires is deliciously chilling. As residents experience a growing list of strange encounters and start putting the pieces together, you’ll feel yourself tensing up in anticipation of the final reveal and confrontation.",
                parseDate("10/09/1975")
            ),
            Books(
                7,
                "Those Across the River",
                "Día 5",
                "Capítulo 20",
                R.drawable.thoseacrosstheriver,
                "Terror",
                "Those Across the River",
                R.drawable.thoseacrosstheriver,
                "Christopher Buehlman",
                3.5,
                "In 1935, a professor fleeing scandal moves with his wife to a family home in Georgia, located near the ruins of a plantation that his ancestors owned. Every month, in a strange, sacrificial ritual, the townspeople adorn two pigs with flower garlands and send them across the river. The animals never return.",
                parseDate("10/09/1975")
            ),
            Books(
                8,
                "The Exorcist",
                "Día 5",
                "Capítulo 20",
                R.drawable.thexorcist,
                "Terror",
                "The Exorcist",
                R.drawable.thexorcist,
                "William Peter Blatty",
                3.5,
                "Descriptions of the child’s erratic behavior, which includes spitting and screaming obscenities, build to a crescendo as her mother desperately hunts for an exorcist. If you’ve seen the classic movie adaptation, you have an idea of just how scary this situation gets … but the book is arguably even more terrifying.",
                parseDate("10/09/2011")
            )
            ,
            Books(
                9,
                "The Blazing World",
                "Día 5",
                "Capítulo 20",
                R.drawable.theblazingworld,
                "Ciencia Ficción",
                "The Blazing World",
                R.drawable.theblazingworld,
                "Margaret Cavendish",
                3.5,
                "Cavendish's utopian tale follows the adventures of a kidnapped woman, who travels to another world run by part-humans, part animals - fox men, fish men, geese men, the list goes on. As she is a very beautiful woman, she becomes their Empress, and organises an an almighty invasion of her own world, complete with literal fire(stones) raining from the sky.",
                parseDate("10/09/1666")
            )
            ,
            Books(
                10,
                "Frankenstein",
                "Día 5",
                "Capítulo 20",
                R.drawable.thefrankenstein,
                "Ciencia Ficción",
                "Frankenstein",
                R.drawable.thefrankenstein,
                "Mary Shelley",
                3.5,
                "Mary Shelley started writing classic gothic thriller Frankenstein when she was 18 years old. Two centuries later, it is a major ancestor of both the science fiction and horror genres, tackling huge themes like the nature of life and death, immortality and genetic engineering. It is a pro-science novel that at its heart shows Dr Frankenstein as the callous fiend of the story, who created a being and was not willing to accept responsibility for his actions. In an age where the space between technical life and death is narrower than ever, and scientists are playing with the makeup of what makes us humans, Frankenstein can still teach an important lesson: just because you can, doesn't mean you should.",
                parseDate("10/09/1818")
            ),
            Books(
                11,
                "The Stars My Destination",
                "Día 5",
                "Capítulo 20",
                R.drawable.thestarsmydestination,
                "Ciencia Ficción",
                "The Stars My Destination",
                R.drawable.thestarsmydestination,
                "Alfred Bester",
                3.5,
                "This landmark novel begins with a simple proposition – what if humans could teleport? – and sprawls into a tale of rebirth and vengeance that winds across the Solar System: The Count of Monte Cristo for the interstellar age. First published as Tiger! Tiger! in the UK, named after the William Blake poem, it follows Gully Foyle – a violent, uneducated brute who spends six months marooned in deep space, and the rest of the book seeking retribution for it.",
                parseDate("10/09/1957")
            ),
            Books(
                12,
                "Don Quixote",
                "Día 5",
                "Capítulo 20",
                R.drawable.donquixote,
                "Aventura",
                "Don Quixote",
                R.drawable.donquixote,
                "Miguel de Cervantes",
                3.5,
                "Regarded as one of the greatest works in literature, Don Quixote recounts the adventures of Alonso Quixano: a middle-aged man so obsessed with chivalric books that he decides to imitate them and become a knight-errant. So begins his journey to find a faithful squire, save damsels in distress, and fight windmills.",
                parseDate("10/09/1957")
            ),
            Books(
                13,
                "The Three Musketeers",
                "Día 5",
                "Capítulo 20",
                R.drawable.thethreemusketeers,
                "Aventura",
                "The Three Musketeers",
                R.drawable.thethreemusketeers,
                "Alexandre Dumas",
                3.5,
                "In this classic by Dumas, a young man named d’Artagnan joins the Musketeers of the Guard. In doing so, he befriends Athos, Porthos, and Aramis — the King’s most celebrated musketeers — and embarks on a journey of his own.",
                parseDate("10/09/1957")
            ),
            Books(
                14,
                "Treasure Island",
                "Día 5",
                "Capítulo 20",
                R.drawable.treasureisland,
                "Aventura",
                "Treasure Island",
                R.drawable.treasureisland,
                "Robert Louis Stevenson",
                3.5,
                "Written by Scottish author Robert Louis Stevenson, this story of “buccaneers and buried gold” launched a million tropes of treasure maps, sea chests, Black Spots, and deserted islands.",
                parseDate("10/09/1957")
            ),
            Books( 15,
                "A Man Called Ove",
                "Día 5",
                "Capítulo 20",
                R.drawable.amancalledove,
                "Humor",
                "A Man Called Ove",
                R.drawable.amancalledove,
                "Fredrik Backman",
                3.5,
                "Ove is almost certainly the grumpiest man you will ever meet He thinks himself surrounded by idiots joggers neighbours who cant reverse a trailer properly and shop assistants who talk in code But isnt it rare these days to find such oldfashioned clarity of belief and deed Such unswerving conviction about what the world should be and a lifelong dedication to making it just so",
                parseDate("10/09/1957")
            ),
            Books( 16,
                "Beach Read",
                "Día 5",
                "Capítulo 20",
                R.drawable.beachread,
                "Humor",
                "Beach Read",
                R.drawable.beachread,
                "Emily Henry",
                3.5,
                "Augustus Everett is an acclaimed author of literary fiction. January Andrews writes bestselling romance. When she pens a happily ever after, he kills off his entire cast. They're polar opposites. In fact, the only thing they have in common is that for the next three months, they're living in neighboring beach houses, broke, and bogged down with writer's block. Until, one hazy evening, one thing leads to another and they strike a deal designed to force them out of their creative ruts: Augustus will spend the summer writing something happy, and January will pen the next Great American Novel. She'll take him on field trips worthy of any rom-com montage, and he'll take her to interview surviving members of a backwoods death cult (obviously). Everyone will finish a book and no one will fall in love. Really.\n",
                parseDate("10/09/1957")
            ),
            Books( 17,
                "The Boy, the Mole, the Fox and the Horse",
                "Día 5",
                "Capítulo 20",
                R.drawable.theboythemolethefox,
                "Humor",
                "The Boy, the Mole, the Fox and the Horse",
                R.drawable.theboythemolethefox,
                "Charlie Mackesy",
                3.5,
                "Charlie Mackesy offers inspiration and hope in uncertain times in this beautiful book, following the tale of a curious boy, a greedy mole, a wary fox and a wise horse who find themselves together in sometimes difficult terrain, sharing their greatest fears and biggest discoveries about vulnerability, kindness, hope, friendship and love. The shared adventures and important conversations between the four friends are full of life lessons that have connected with readers of all ages. ",
                parseDate("10/09/1957")
            ),
            Books( 18,
                "Don Quixote",
                "Día 5",
                "Capítulo 20",
                R.drawable.donquixote,
                "Fan Ficción",
                "Don Quixote",
                R.drawable.donquixote,
                "Miguel de Cervantes",
                3.5,
                "Regarded as one of the greatest works in literature, Don Quixote recounts the adventures of Alonso Quixano: a middle-aged man so obsessed with chivalric books that he decides to imitate them and become a knight-errant. So begins his journey to find a faithful squire, save damsels in distress, and fight windmills.",
                parseDate("10/09/1957")
            ),
            Books( 19,
                "The Three Musketeers",
                "Día 5",
                "Capítulo 20",
                R.drawable.thethreemusketeers,
                "Fan Ficción",
                "The Three Musketeers",
                R.drawable.thethreemusketeers,
                "Alexandre Dumas",
                3.5,
                "In this classic by Dumas, a young man named d’Artagnan joins the Musketeers of the Guard. In doing so, he befriends Athos, Porthos, and Aramis — the King’s most celebrated musketeers — and embarks on a journey of his own.",
                parseDate("10/09/1957")
            ),
            Books( 20,
                "Treasure Island",
                "Día 5",
                "Capítulo 20",
                R.drawable.treasureisland,
                "Fan Ficción",
                "Treasure Island",
                R.drawable.treasureisland,
                "Robert Louis Stevenson",
                3.5,
                "Written by Scottish author Robert Louis Stevenson, this story of “buccaneers and buried gold” launched a million tropes of treasure maps, sea chests, Black Spots, and deserted islands.",
                parseDate("10/09/1957")
            )




            )

        private fun parseDate(dateStr: String): Date? {
            val inputFormat  = SimpleDateFormat("dd/MM/yyyy") // Define el formato de la cadena
            return try {
                inputFormat.parse(dateStr)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }

        }

    }




}