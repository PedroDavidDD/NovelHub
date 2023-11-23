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
                    2.5f,
                    "El Rey Grey tiene fuerza, riquezas y prestigio, es incomparable en un mundo gobernado por la habilidad marcial. Sin embargo, la soledad siempre está cerca de aquellos con gran poder. Bajo el atractivo exterior de un rey poderoso yace el caparazón de un hombre, desprovisto de propósitos y voluntad.",
                    parseDate("10/09/2023"),
                    "“El Continente Dicathen está compuesto por tres grandes reinos: el reino de Elenoir, ubicado en\n" +
                            "los bosques al Norte; el reino subterráneo de Darv, en las cercanías de la frontera del Sur; y el\n" +
                            "Reino de Sapin, ubicado en la frontera oriental del continente. También existen los Claros de las\n" +
                            "Bestias, de los cuales una gran parte permanece en misterio debido a que no han podido ser\n" +
                            "recorridos debido a la hostilidad de las bestias hacia los viajeros y entre ellas mismas. Sin embargo,\n" +
                            "cada año se realizan innumerables expediciones para obtener tentadoras riquezas.\n" +
                            "«Pasar página»\n" +
                            "“El Reino de Elenoir es la tierra natal de los elfos, ubicado en las profundidades del Bosque de\n" +
                            "Elshire, donde existe una niebla tan espesa que disuade a cualquiera de entrar, excepto a los elfos,\n" +
                            "los cuales pueden guiarse gracias a sus agudos sentidos...”."
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
                    5f,
                    "A young man chronicles his life as a renowned magician and musician.",
                    parseDate("10/09/2007"),
                    "Es noche de tala y dentro del Waystone Inn, Old Cob está contando la historia de Taborlin el Grande a Jake, Graham, Shep, Aaron, y el posadero. En él, se dice que Taborlin está encerrado dentro de una torre alta sin nada para escapar, mientras que los Chandrian están insinuados de estar cerca debido a la llama azul.\n" +
                            "\n" +
                            "La historia se detiene mientras los hombres comen su cena. Mientras termina de comer rápidamente, Old Cob reanuda la historia y menciona que Taborlin conocía el nombre de todas las cosas y utilizó esta capacidad para escapar de la celda invocando el nombre de piedra. Se encuentra con una gota que mataría a la mayoría, pero Taborlin también sabía el nombre del viento.\n" +
                            "\n" +
                            "Se explica que Taborlin aterriza de manera segura debido a un amuleto que le dio un tinker, momento en el que Graham menciona que \"un tinker paga por amabilidad dos veces\". Jake lo corrige diciendo \"el consejo de un tinker paga amabilidad dos veces\", momento en el que el posadero tranquilo habla por primera vez, corrigiendo ambos diciendo: \"Siempre se paga una deuda de tinkerra: Una vez para cualquier comercio simple. Dos veces por la ayuda libremente dada. Tres veces por cualquier insulto hecho.\""
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
                    5f,
                    "Bilbo Baggins embarks on a quest to reclaim a treasure from a dragon.",
                    parseDate("10/09/1937"),
                    "Cuando Bilbo se despierta a la mañana siguiente, sus huéspedes ya se han marchado. Piensa que ha logrado escaparle a la aventura, pero Gandalf entra en escena y le explica que los enanos han dejado una nota para Bilbo y que lo están esperando en la posada del Dragón Verde. Bilbo es forzado a apresurarse hacia allí y llega exactamente a las 11 de la mañana, la hora señalada. No ha tenido tiempo de juntar las cosas que quería llevar consigo, pero no es posible regresar. La compañía viaja a una región llamada las Tierras Salvajes y no pasa mucho tiempo antes de que Bilbo se encuentre más lejos de su casa de lo que nunca ha estado. Rápidamente comienza a desear estar en su hogar, cómodo al lado del fuego del hogar, tomando té.\n" +
                            "\n" +
                            "El grupo no es tan organizado como Bilbo hubiera esperado. Recién notan la desaparición de Gandalf bien entrado el día, y no pueden comenzar un fuego para cocinar la cena debido a la lluvia y la humedad. Los dos enanos más jóvenes, Fili y Kili, casi se ahogan cuando sus ponies, asustados, los arrojan al río."
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
                    3f,
                    "A young boy discovers he is a wizard and enrolls in a magical school.",
                    parseDate("10/09/1997"),
                    "Los Dursley son una familia acomodada y consciente del estatus que vive en Surrey, Inglaterra. Ansiosos por mantener las apariencias adecuadas, están avergonzados por la excéntrica hermana de la Sra Dursleyy, la Sra Potter, a quien durante años la Sra Dursley ha fingido no saber. En su camino al trabajo una mañana normal, el Sr. Dursley nota que un gato lee un mapa. Está inquieto, pero se dice a sí mismo que solo lo ha imaginado. Luego, mientras el Sr. Dursley espera en el tráfico, se da cuenta de personas vestidas con capas de colores brillantes. Pasando por una panadería más tarde ese día, escucha a la gente hablar de manera emocionada sobre su familia de cuñadas, los Potter y el hijo de un año de Potter’, Harry. Perturbado, pero aún no estoy seguro de que algo esté mal, el Sr. Dursley decide no decirle nada a su esposa. De camino a casa,se topa con un hombre extrañamente vestido que exclama alegremente que alguien llamado “You-Know-Who” finalmente se ha ido y que incluso un “Muggle” como el Sr. Dursley debería regocijarse. Mientras tanto, la noticia está llena de informes inusuales de estrellas fugaces y búhos volando durante el día.\n" +
                            "\n" +
                            "Esa noche, mientras los Dursley se duermen, Albus Dumbledore, un mago y jefe de la academia de magia de Hogwarts, aparece en su calle. Apaga todas las farolas y se acerca a un gato que pronto se revela como una mujer llamada Profesora McGonagall (que también enseña en Hogwarts) disfrazada. Discuten la desaparición de You-Know-Who, también conocido como Voldemort. Dumbledore le dice a McGonagall que Voldemort mató a los padres de Potter la noche anterior y trató de matar a su hijo, Harry, también, pero no pudo hacerlo. Dumbledore añade que el poder de Voldemorta aparentemente comenzó a disminuir después de su fallido intento de matar a Harry y que se retiró. Dumbledore agrega que el bebé Harry se puede dejar en la puerta de Dursleys’. McGonagall protesta que Harry no puede ser criado por los Dursley.Pero Dumbledore insiste en que no hay nadie más para cuidar al niño. Dice que cuando Harry tenga la edad suficiente, se le informará de su destino. Un gigante llamado Hagrid, que lleva un paquete de mantas con el bebé Harry dentro, luego cae del cielo en una motocicleta. Dumbledore toma a Harry y lo coloca en la puerta de los Dursleyley con una carta explicativa que ha escrito a los Dursley, y las tres partes."
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
                    3f,
                    "Nunca he podido creer en las historias sobre ‘la luz al final del túnel’ de las que tantos hablaban,\n" +
                            "donde después de vivir una experiencia cercana a la muerte, las personas despertaban asustadas,\n" +
                            "empapadas en un sudor frío, para luego exclamar: “¡He visto la luz!”.\n" +
                            "Pero aquí estoy, actualmente en eso que llaman ‘túnel’, frente a una luz deslumbrante, cuando la\n" +
                            "última cosa que recuerdo es que estaba durmiendo en mi habitación. Otros la llamaban la cámara\n" +
                            "real.\n" +
                            "¿He muerto? Si es así, ¿cómo? ¿Fui asesinado? No recuerdo haber perjudicado a nadie, pero el\n" +
                            "hecho de ser una poderosa figura pública podría darle todo tipo de razones a la gente para quererme\n" +
                            "muerto. De todos modos...\n" +
                            "Ya que no parecía que fuera a despertar pronto, lentamente me dirigí hacia esa brillante luz, ya que\n" +
                            "no tenía ninguna razón para negarme. El viaje me pareció durar una eternidad; incluso llegué a\n" +
                            "esperar que un coro de niños me iba a llamar con un himno angelical a lo que creía que era el cielo.\n" +
                            "Pero en cambio, la visión de todo mi alrededor se convirtió en algo borroso de un color rojizo\n" +
                            "brillante mientras que un sonido invadía mis oídos. Y cuando intenté decir algo, el único sonido\n" +
                            "que salía parecía ser un llanto. Y poco a poco las tenues voces se fueron haciendo cada vez más\n" +
                            "claras hasta que logré distinguir:\n" +
                            "“Felicidades, señor y señora, es un niño sano.”.\n" +
                            "Espera... Supongo que normalmente, después de oír esas palabras en lo único que podía pensar era:\n" +
                            "‘Mierda, ¿acabo de nacer? ¿Acaso soy un bebé ahora?’. Pero extrañamente, en lo único que podía\n" +
                            "pensar era: ‘Así que aquella brillante luz al final del túnel era solo la luz que entraba por...’.\n" +
                            "Ja, ja... No pensemos mucho más sobre ello. Al evaluar la situación racionalmente, como debía\n" +
                            "hacer todo rey, notaba que, estuviera donde estuviera, podía entender su idioma. Y eso siempre era\n" +
                            "una buena señal.",
                    parseDate("10/09/1996"),
                    "Bran pensó en ello."
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
                    3f,
                    "The protagonist continues his education at the magical university and faces various challenges.",
                    parseDate("10/09/2011"),
                    "Miré a mi alrededor y vi a la mujer que me había empujado fuera de su túnel. Supongo que lo justo\n" +
                            "sería llamarla ‘Mamá’. Me tomó un par de segundos reconocer cómo era, y debo admitir que se\n" +
                            "trataba de una belleza, pero eso podría deberse tal vez a mi vista algo borrosa. Sin embargo, en vez\n" +
                            "de una belleza glamurosa, sería mejor describirla como una encantadora, en el sentido que parecía\n" +
                            "amable y gentil, con un particular pelo castaño y ojos marrones. No pude evitar darme cuenta de\n" +
                            "sus largas pestañas y una nariz respingona que me daba ganas de aferrarme a ella. Estaba\n" +
                            "impregnada en un amor maternal. ¿Es por eso que los bebés se sienten atraídos hacia sus madres?\n" +
                            "Aparté mi rostro y miré hacia la derecha para apenas reconocer a la persona que asumí era mi padre,\n" +
                            "debido a su sonrisa idiota y unos ojos llorosos que me miraban. De inmediato, me dijo:\n" +
                            "“Hola, pequeño Art, soy tu papá. ¿Puedes decir ‘pa-pá’?”.\n" +
                            "Miré a mi alrededor para ver cómo mi madre y el doctor (a pesar de la dudosa cualificación que\n" +
                            "parecía tener), desviaban la mirada mientras que mi madre se burlaba:\n" +
                            "“Cariño, acaba de nacer.”."
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
                    2f,
                    "This story of a small town overrun by vampires is deliciously chilling. As residents experience a growing list of strange encounters and start putting the pieces together, you’ll feel yourself tensing up in anticipation of the final reveal and confrontation.",
                    parseDate("10/09/1975"),
                    "Cuando era un rey, con solo chasquear mis dedos era capaz de convocar al ejército de mi país. Y\n" +
                            "para mantener mi posición y resolver disputas y conflictos, me batía en duelo con luchadores de\n" +
                            "diferentes países e incluso con mi propia gente. En el ámbito del manejo de la espada y el control\n" +
                            "del ki no tenía rival, ya que poseer una gran fortaleza personal era lo esencial para llegar a ser un\n" +
                            "gobernante en mi antiguo mundo, porque los reyes no nacían, sino que se erigían. Sin embargo, no\n" +
                            "puedo recordar ningún momento en el que me sienta tan orgulloso como ahora. Ahora puedo gatear.\n" +
                            "¡Toma!\n" +
                            "Antes solo podía conformarme con las historias que me contaba Madre para intentar que me\n" +
                            "quedara dormido, pero en cuando se detenía me quejaba gruñendo como protesta. Mientras que\n" +
                            "Padre me sentaba sobre su regazo y, absorto, me hablaba de sus viejos tiempos, dándome pistas\n" +
                            "sobre qué tipo de mundo era este y de lo que podía encontrar en él.\n" +
                            "Reynolds Leywin había sido un aventurero y tenía bastante experiencia (aparentemente esta era\n" +
                            "una ocupación viable en este mundo). Y llegó a ser parte de diferentes grupos con los que, en\n" +
                            "diferentes expediciones, había ido en busca de tesoros y había completado misiones para el Gremio\n" +
                            "de Aventureros. Entonces había conocido a Madre en una ciudad llamada Valdan, en las fronteras\n" +
                            "del reino, y había decidido a sentar la cabeza. Orgulloso, me contaba cómo ella se había enamorado\n" +
                            "de él a primera vista, cuando había visitado el vestíbulo del Gremio de Aventureros en el que ella\n" +
                            "trabajaba en ese momento, pero por la forma en como Madre lo golpeó en la nuca y le dijo que\n" +
                            "parara de contarme mentiras, sospeché que era todo lo contrario."
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
                    4f,
                    "In 1935, a professor fleeing scandal moves with his wife to a family home in Georgia, located near the ruins of a plantation that his ancestors owned. Every month, in a strange, sacrificial ritual, the townspeople adorn two pigs with flower garlands and send them across the river. The animals never return.",
                    parseDate("10/09/1975"),
                    "Las armas podían ser usadas libremente y no estaban reguladas por los gobiernos, a menos que\n" +
                            "visitaras a la familia real o personas que tuvieran cierta autoridad. Pero por el amor de Dios, aún\n" +
                            "me sorprende cada vez que veo alguien portando sus armas mientras compra provisiones, ya que\n" +
                            "en mi antiguo mundo los únicos que tenían permitido portar armas eran los soldados y guardias.\n" +
                            "Por supuesto no las usaban con el propósito de matar, sino para disuadir el que ocurrieran crímenes.\n" +
                            "En cambio, aquí había visto cómo un gran mercenario calvo, que portaba un arma de asta, había\n" +
                            "acuchillado por la espalda a un ladrón que había robado un par de artículos de una armería; y cómo\n" +
                            "incluso los transeúntes lo felicitaban mientras que el ladrón yacía en el suelo, agonizando.\n" +
                            "Una similitud que compartía este con mi antiguo mundo era el sistema monárquico. El continente\n" +
                            "Dicathen tenía reinos, cada uno gobernado por un rey y su familia real. Sin embargo, a diferencia\n" +
                            "de la Tierra, el rey era elegido en base a su linaje; y el titulo pasaba de este a su hijo y así\n" +
                            "sucesivamente.\n" +
                            "Después de hojear por la enciclopedia, me pareció algo extraño que no existiera información sobre\n" +
                            "otros continentes aparte de este, ya que había barcos que transportaban mercancías y pasajeros por\n" +
                            "los ríos del continente, por lo que asumí que la tecnología no estaba lo suficientemente desarrollada\n" +
                            "para navegar por los océanos."
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
                    3f,
                    "Descriptions of the child’s erratic behavior, which includes spitting and screaming obscenities, build to a crescendo as her mother desperately hunts for an exorcist. If you’ve seen the classic movie adaptation, you have an idea of just how scary this situation gets … but the book is arguably even more terrifying.",
                    parseDate("10/09/2011"),
                    "En mi antiguo mundo, a pesar de que mi centro de ki no era tan grande, era considerado un prodigio\n" +
                            "por poder canalizar y usar mi ki de forma tan efectiva que lograba suplir el hecho de que mi núcleo\n" +
                            "no fuera tan grande. Gracias a la forma en cómo podía usarlo, logré convertirme en el duelista más\n" +
                            "fuerte de toda la división de élite, obteniendo el derecho de convertirme en el rey.\n" +
                            "Si ahora pudiera practicar de la misma forma que lo hacían los expertos en mi mundo, pero en vez\n" +
                            "de usar solo el maná que estaba dentro de mi núcleo, usara también el del entorno, ¿acaso no podría\n" +
                            "duplicar... No... Triplicar mi antigua fuerza?\n" +
                            "El siguiente libro lo encontré en el fondo de la estantería, y me aclaró las dudas que tenía.\n" +
                            "«Guía de principiantes para el Mago Privilegiado.»\n" +
                            "“Si bien el poder para controlar el maná es en gran medida genético, existen muchos casos donde\n" +
                            "los hijos de los magos son incapaces de sentir el maná en su entorno. Un censo reciente demostró\n" +
                            "que aproximadamente uno de cada cien niños es capaz de percibir el maná, pero esta medida solo\n" +
                            "puede ser demostrada una vez que sus núcleos de maná se desarrollan por completo, desde la\n" +
                            "adolescencia temprana hasta el inicio de la adolescencia tardía. Es bastante obvio cuando un mago\n" +
                            "se despierta por primera vez debido a que el maná que le rodea y el maná de su núcleo se repelen,\n" +
                            "logrando como resultado una barrera translúcida que se forma por un par de minutos después de\n" +
                            "despertar.”."
                ),
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
                    1f,
                    "Cavendish's utopian tale follows the adventures of a kidnapped woman, who travels to another world run by part-humans, part animals - fox men, fish men, geese men, the list goes on. As she is a very beautiful woman, she becomes their Empress, and organises an an almighty invasion of her own world, complete with literal fire(stones) raining from the sky.",
                    parseDate("10/09/1666"),
                    "“Para determinar la capacidad o habilidad de un Potenciador, se debe medir la capacidad de sus\n" +
                            "canales de maná, ya que estos determinan la velocidad y eficacia para distribuir el maná del núcleo\n" +
                            "a las distintas partes del cuerpo...”.\n" +
                            "“El poder y talento de un Conjurador, se determina por la fuerza de sus venas de maná, quienes\n" +
                            "indican la velocidad y efectividad al absorber el maná del exterior para poder lanzar un hechizo...”.\n" +
                            "«Pasar página»\n" +
                            "“Los Manipuladores de Maná, se clasifican normalmente en uno de estos dos tipos (Potenciadores\n" +
                            "o Conjuradores), ya que el intentar dominar ambas en una etapa temprana sería extremadamente\n" +
                            "lento e ineficiente. Como la mayoría de gente nace con cierta diferencia entre sus canales de maná\n" +
                            "y sus venas de maná...”."
                ),
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
                    3f,
                    "Mary Shelley started writing classic gothic thriller Frankenstein when she was 18 years old. Two centuries later, it is a major ancestor of both the science fiction and horror genres, tackling huge themes like the nature of life and death, immortality and genetic engineering. It is a pro-science novel that at its heart shows Dr Frankenstein as the callous fiend of the story, who created a being and was not willing to accept responsibility for his actions. In an age where the space between technical life and death is narrower than ever, and scientists are playing with the makeup of what makes us humans, Frankenstein can still teach an important lesson: just because you can, doesn't mean you should.",
                    parseDate("10/09/1818"),
                    "“Los principios fundamentales para la Potenciación. A diferencia de la conjuración, no se\n" +
                            "precisa tanto tiempo para reunir el maná del alrededor, ya que los Potenciadores usan el maná de\n" +
                            "sus propios núcleos en vez del de su alrededor, y el hacerlo requiere velocidad y precisión para\n" +
                            "hacerlo eficazmente...”.\n" +
                            "Aquí fue donde todo comenzó a tener sentido... La potenciación era muy similar al ki, excepto\n" +
                            "porque también podías absorber el maná del entorno. Y la razón por la que en mi antiguo mundo\n" +
                            "no había conjuradores era debido a que no existía ningún maná en el entorno para absorber y crear\n" +
                            "un fenómeno. Mi mirada se tensó mientras seguía leyendo.\n" +
                            "“La potenciación requiere una distribución apropiada del maná por las diferentes partes del cuerpo,\n" +
                            "dependiendo de lo que el usuario necesite. Si bien a simple vista, la potenciación requiere un gran\n" +
                            "entendimiento del cuerpo. Ser capaz de utilizar los canales de maná eficientemente requiere años\n" +
                            "de práctica física y mental...”.",
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
                    5f,
                    "This landmark novel begins with a simple proposition – what if humans could teleport? – and sprawls into a tale of rebirth and vengeance that winds across the Solar System: The Count of Monte Cristo for the interstellar age. First published as Tiger! Tiger! in the UK, named after the William Blake poem, it follows Gully Foyle – a violent, uneducated brute who spends six months marooned in deep space, and the rest of the book seeking retribution for it.",
                    parseDate("10/09/1957"),
                    "Punto de vista de Alice Leywin:\n" +
                            "Arthur debe de ser el bebé más adorable del mundo, pero no digo esto porque sea una madre\n" +
                            "condescendiente. No. Con su alborotado pelo castaño y sus ojos juguetones que irradian una luz\n" +
                            "azul en su mirada, lo hacen parecer a veces... Inteligente.\n" +
                            "No, no, ya te he dicho que no soy una madre condescendiente. Planeaba ser una madre estricta y\n" +
                            "justa. No podía confiar ni un poco en mi esposo para enseñarle a Art sentido común. ¡Por el amor\n" +
                            "de Dios, intentó enseñarle a pelear a mi bebé cuando apenas podía gatear!\n" +
                            "Y si no ponía atención en él, sabía que este pequeño pillo se volvería igualito a su padre. Tan pronto\n" +
                            "logró gatear, me sentí tan orgullosa que estaba a punto de llorar, pero lo que no sabía era lo\n" +
                            "problemático que se volvería tras empezar a moverse.\n" +
                            "Puedo jurar que en el momento en que apartaba mis ojos de él, aprovechaba para escabullirse en la\n" +
                            "biblioteca. Eso era raro, ya que incluso le habíamos comprado muchos animales de peluche y\n" +
                            "juguetes de madera para que jugara, pero siempre terminaba yendo a la biblioteca. Al menos, en\n" +
                            "eso era justo lo opuesto a su padre, ya que Reynolds siempre evitaba los libros tanto como el\n" +
                            "periódico.",

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
                    5f,
                    "Regarded as one of the greatest works in literature, Don Quixote recounts the adventures of Alonso Quixano: a middle-aged man so obsessed with chivalric books that he decides to imitate them and become a knight-errant. So begins his journey to find a faithful squire, save damsels in distress, and fight windmills.",
                    parseDate("10/09/1957"),
                    "Decidí ir de compras dos veces a la semana, al ver lo emocionado que se ponía cuando íbamos a la\n" +
                            "ciudad.\n" +
                            "No, no, te digo que no soy una madre condescendiente. Esto es solo para que aprenda del mundo\n" +
                            "exterior y para tener comida fresca. Sí ja,ja... Solo era eso. Parecía interesarse en un montón de\n" +
                            "cosas. Nunca podía cansarme de ver su cabecita, que no parecía apropiada para su pequeño cuerpo,\n" +
                            "girando de izquierda a derecha mientras intentaba tomar todas las cosas a su alrededor; y parecía\n" +
                            "particularmente interesado en las prácticas de su padre.\n" +
                            "Reynolds en su época había sido un aventurero bastante competente. Había alcanzado el rango B\n" +
                            "a la edad de veintiocho años lo cual era un ascenso realmente rápido. Para adquirir el rango E, el\n" +
                            "cual era el rango más bajo, requería que realizaras una prueba para evitar que los impacientes\n" +
                            "adolescentes fueran ignorantemente directo a su muerte. En cuanto a los rangos más altos, solo\n" +
                            "había visto un par de aventureros rango A cuando trabajaba en el gremio, y nunca había sido capaz\n" +
                            "de ver uno de rango S, asumiendo que realmente existen."
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
                    2f,
                    "In this classic by Dumas, a young man named d’Artagnan joins the Musketeers of the Guard. In doing so, he befriends Athos, Porthos, and Aramis — the King’s most celebrated musketeers — and embarks on a journey of his own.",
                    parseDate("10/09/1957"),
                    "En el Gremio de Aventureros, o como lo llamábamos el Salón del Gremio en Valden, pude ver a\n" +
                            "muchos de esos adolescentes impacientes. Y podría jurar que no me sorprendería si salieran\n" +
                            "volando si sus egos se le subían a la cabeza. Al menos eran ambiciosos.\n" +
                            "Una vez, me encargaron supervisar una prueba práctica básica, donde el examinado debía\n" +
                            "simplemente demostrar las capacidades básicas de la manipulación del maná, pero antes de que\n" +
                            "empezará la prueba, el chico se cayó de espaldas porque la espada que llevaba era demasiado\n" +
                            "pesada.\n" +
                            "Hablando de cabezas huecas, de seguro Reynolds debió ser igual que ellos. En el momento en el\n" +
                            "que me vio en el Salón del Gremio, quedó boquiabierto y se quedó embobado mirándome hasta\n" +
                            "que el tipo que tenía atrás le dio un codazo para que se apresurara. Rápidamente limpió su baba y\n" +
                            "murmuró:\n" +
                            "“H...Hola... ¿Podría cambiar es-estos objetos por una misión?”."
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
                    3f,
                    "Written by Scottish author Robert Louis Stevenson, this story of “buccaneers and buried gold” launched a million tropes of treasure maps, sea chests, Black Spots, and deserted islands.",
                    parseDate("10/09/1957"),
                    "Han pasado casi dos años desde que había hecho mi primer complicado viaje a la biblioteca. Había\n" +
                            "estado desde entonces intentando reunir los pequeños fragmentos de maná dispersos en mi cuerpo\n" +
                            "e intentado formar un núcleo de maná. Déjenme decirles que esto era una ardua y lenta tarea. Me\n" +
                            "sería mucho más fácil aprender a caminar con mis manos y comer con mis pies que intentar formar\n" +
                            "un núcleo de maná con este maldito cuerpo.\n" +
                            "Ya entendía por qué en el libro decía que tardaría al menos hasta la adolescencia para que una\n" +
                            "persona ‘despertara’. Si dejaba que las partículas de maná en mi cuerpo se movieran por si solas,\n" +
                            "les tardaría al menos una década para que se atrajeran entre sí para formar algo parecido a un núcleo\n" +
                            "de maná.\n" +
                            "En cambio... La ventaja de tener la mentalidad de un adulto implica que tengo la capacidad\n" +
                            "cognitiva de reunir las partículas de maná. Esto era algo que había hecho en mi antigua vida durante\n" +
                            "la escuela, donde te enseñaban durante la infancia cómo controlar el ki. Esencialmente, es poder\n" +
                            "sentir el ki, o maná ahora, dentro de tu cuerpo e intentar reunirlo cerca del plexo solar. Si las dejaba\n" +
                            "solas, las partículas eventualmente se atraerían por si solas de todos modos, pero hablando en\n" +
                            "sentido figurado solo estaba agarrando las plumas y juntándolas en un saco en vez de esperar a que\n" +
                            "cayeran solas."
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
                    3f,
                    "Ove is almost certainly the grumpiest man you will ever meet He thinks himself surrounded by idiots joggers neighbours who cant reverse a trailer properly and shop assistants who talk in code But isnt it rare these days to find such oldfashioned clarity of belief and deed Such unswerving conviction about what the world should be and a lifelong dedication to making it just so",
                    parseDate("10/09/1957"),
                    "¡Mi pequeño! Estoy muy feliz de haber tenido un hijo. Me pregunto: ¿cuándo pueden empezar a\n" +
                            "entrenar los bebés? ¿Cuándo podré volver a entrenar yo mismo? ¡No puedo esperar a enseñarle\n" +
                            "cosas sobre la magia! Espero que sea un Potenciador igual que su viejo padre. Ya que, aunque\n" +
                            "conozco los conceptos básicos sobre la conjuración, no puedo hacer nada útil excepto usarlos como\n" +
                            "ejercicio mental.\n" +
                            "En cambio, Alice es una de las personas más talentosas que he conocido. En su labor como\n" +
                            "Curandera es excepcional. Recuerdo aquel entonces, cuando aceptó salir conmigo, se unió a mi\n" +
                            "grupo y fuimos a misiones juntos. Sus habilidades curativas eran asombrosas por si solas, pero lo\n" +
                            "que más me sorprendió fue cuando usaba un hechizo de área, que curaba a todos los aliados que\n" +
                            "estuvieran en su interior. ¡Era única! ¡Y soy su marido!\n" +
                            "Je, je... Nunca me cansaré de decir eso.\n" +
                            "Antes de que nos asentáramos en aquellos viejos tiempos, íbamos a los Claros de la Bestias y\n" +
                            "cazábamos bestias de maná. Las bestias de maná son animales y criaturas únicas que han nacido\n" +
                            "con la capacidad de absorber el maná con el que pueden formar un núcleo de mana, al que llamamos\n" +
                            "núcleo de bestia."
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
                    4f,
                    "Augustus Everett is an acclaimed author of literary fiction. January Andrews writes bestselling romance. When she pens a happily ever after, he kills off his entire cast. They're polar opposites. In fact, the only thing they have in common is that for the next three months, they're living in neighboring beach houses, broke, and bogged down with writer's block. Until, one hazy evening, one thing leads to another and they strike a deal designed to force them out of their creative ruts: Augustus will spend the summer writing something happy, and January will pen the next Great American Novel. She'll take him on field trips worthy of any rom-com montage, and he'll take her to interview surviving members of a backwoods death cult (obviously). Everyone will finish a book and no one will fall in love. Really.\n",
                    parseDate("10/09/1957"),
                    "Han pasado un par de semanas desde mi despertar. Habíamos decidido mantenerlo en secreto por\n" +
                            "ahora. Padre se las arregló para contactar con unos compañeros de un antiguo grupo de aventureros\n" +
                            "para que nos ayudaran a reconstruir nuestra casa, y mientras nos quedamos en una posada cercana.\n" +
                            "Con la ayuda de los conjuradores levantando el suelo para los cimientos y los potenciadores\n" +
                            "realizando el trabajo duro, la casa no tardó en estar terminada. ¡Las ventajas de la magia!\n" +
                            "Sorprendentemente, ninguno de los antiguos compañeros de Padre preguntó por qué nuestra casa\n" +
                            "había explotado. Eso dice mucho del idiota de mi padre.\n" +
                            "En medio de la reconstrucción llegó mi cumpleaños (29 de mayo). Mis padres me despertaron esa\n" +
                            "mañana con un regalo, y con lo que parecía ser una rebanada de... ¿Pan...? En sus manos.\n" +
                            "¡Ahh! ¡Era un pastel...! Habría sido más fácil decirlo si no hubiese sido negro. Al abrir el regalo vi\n" +
                            "que era una espada cuidadosamente tallada. Abracé a mis padres y les di las gracias por el pastel y\n" +
                            "el regalo. Esto me sorprendió, ya que mis padres no se habían molestado en celebrar mis dos\n" +
                            "pasados cumpleaños, así que había asumido que en este mundo, simplemente, no se celebraban.\n" +
                            "Más tarde descubrí que los cumpleaños se celebraban a partir de los tres años; esto se debía a una\n" +
                            "antigua tradición, cuando los bebés eran más susceptibles a morir antes de los tres años.\n" +
                            "¡Qué medieval!"
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
                    4f,
                    "Charlie Mackesy offers inspiration and hope in uncertain times in this beautiful book, following the tale of a curious boy, a greedy mole, a wary fox and a wise horse who find themselves together in sometimes difficult terrain, sharing their greatest fears and biggest discoveries about vulnerability, kindness, hope, friendship and love. The shared adventures and important conversations between the four friends are full of life lessons that have connected with readers of all ages. ",
                    parseDate("10/09/1957"),
                    "Tan pronto cumplí tres años, Madre comenzó a darme lecciones a ciertas horas, enseñándome a\n" +
                            "leer y escribir. Haciendo el papel de un hijo genio, fingía que aprendía rápido para alegrarla, así\n" +
                            "podía leer libros más complejos en la biblioteca sin levantar sospechas.\n" +
                            "Esas últimas semanas pasaron en un suspiro. Después de despertar, Padre me enseñó lo mejor que\n" +
                            "pudo lo básico del maná y cómo podía empezar a entrenar. Trataba de simplificar lo más que podía\n" +
                            "para que lo entendiera un niño pequeño, pero supongo que, si no fuera porque tengo la capacidad\n" +
                            "de comprensión de un adulto, no creo que hubiera sido capaz de entenderlo.\n" +
                            "Los principios básicos son:\n" +
                            "Una forma fácil de saber cómo de fuerte es un núcleo de maná es según el color que tenga. Al\n" +
                            "principio el núcleo de maná es negro, debido a que se mezcla la sangre del cuerpo y otras impurezas\n" +
                            "en las partículas de maná para ser formado. Cuando el maná dentro del cuerpo de una persona se\n" +
                            "vuelve puro y las impurezas se filtran y cambia a un color rojo oscuro. Desde ahí, el color del\n" +
                            "núcleo de maná se aclara; de rojo oscuro a rojo, y luego a rojo claro. El orden es el siguiente: negro,\n" +
                            "rojo, naranja, amarillo, plateado y finalmente blanco. Tanto el núcleo de mana rojo como el núcleo\n" +
                            "de maná amarillo, se dividen en tres tipos de tonos (naranja oscuro, naranja, naranja claro). Por\n" +
                            "regla general, cuanto más claro sea el núcleo de maná, es más puro y tiene acceso a mayor poder."
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
                    3f,
                    "Regarded as one of the greatest works in literature, Don Quixote recounts the adventures of Alonso Quixano: a middle-aged man so obsessed with chivalric books that he decides to imitate them and become a knight-errant. So begins his journey to find a faithful squire, save damsels in distress, and fight windmills.",
                    parseDate("10/09/1957"),
                    "Mi vida diaria consistía en tomar lecciones de lectura y escritura con Madre y entrenamiento de\n" +
                            "potenciación con Padre. Después de terminar de explicarme la teoría básica y las aplicaciones de\n" +
                            "la potenciación, empezamos el entrenamiento físico. Ya que mi cuerpo era demasiado pequeño\n" +
                            "para entrenar en combate, optamos por correr y hacer ejercicio. Creo que ver a mi cuerpo de tres\n" +
                            "años intentar hacer una flexión es algo muy gracioso, pero Padre hacía un buen trabajo aguantando\n" +
                            "la risa.\n" +
                            "Cuando no estaba recibiendo lecciones, por lo general me quedaba dentro de la nueva e\n" +
                            "improvisada biblioteca, leyendo y meditando para condensar aún más mi núcleo de maná. Pasó un\n" +
                            "año sin muchos cambios dentro de mis planes, pero mientras cenábamos una noche Padre dijo.\n" +
                            "“Cariño, creo que es hora de que Art consiga un mentor apropiado.”."
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
                    3f,
                    "In this classic by Dumas, a young man named d’Artagnan joins the Musketeers of the Guard. In doing so, he befriends Athos, Porthos, and Aramis — the King’s most celebrated musketeers — and embarks on a journey of his own.",
                    parseDate("10/09/1957"),
                    "El sonido metálico del tenedor que Madre había dejado caer en su plato interrumpió el silencio.\n" +
                            "“¿Qué? ¡Reynolds! ¡Arthur todavía no ha cumplido ni cuatro años! ¡No! Además, dijiste que si\n" +
                            "nuestro hijo era un potenciador, ¡podrías enseñarle!” - Madre hablaba con una evidente\n" +
                            "desesperación.\n" +
                            "“Es que nunca habría podido creer que nuestro hijo fuera tan prodigioso en la manipulación del\n" +
                            "maná. ¿Acaso has escuchado de alguien que despierte a los tres años?” - Padre le respondió\n" +
                            "manteniendo la calma.\n" +
                            "“¡Pero eso significa que tendrá que irse de casa! ¡Solo tiene cuatros años, Reynolds! ¡No podemos\n" +
                            "permitir que nuestro bebé abandone su hogar tan pronto!”.\n" +
                            "“Es que no lo entiendes. Cuando lo veo meditar, no puedo evitar sentir que todo esto es natural\n" +
                            "para él. Alice, cariño, solo estoy frenando a mi hijo enseñándole algo que puede hacer incluso\n" +
                            "dormido.”."
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
                    3f,
                    "Written by Scottish author Robert Louis Stevenson, this story of “buccaneers and buried gold” launched a million tropes of treasure maps, sea chests, Black Spots, and deserted islands.",
                    parseDate("10/09/1957"),
                    "La batalla estaba llegando a su apogeo. El grupo de bandidos no había sospechado que en nuestro\n" +
                            "grupo habría magos capaces. Debido a ese error de cálculo, todos los luchadores de cuerpo a cuerpo\n" +
                            "habían muerto, y los únicos que seguían vivos eran cuatro magos y un par de arqueros que estaban\n" +
                            "dispersos y que habían logrado huir. Jasmine aún tenía problemas para tratar con el perverso\n" +
                            "usuario de la cadena, pero la arrogancia de su rostro había sido disipada de su cara, debido a los\n" +
                            "cortes y mellas en su cuerpo, de las cuales escurría sangre.\n" +
                            "Adam estaba ocupado lidiando con un potenciador de doble espada. Su estilo de lucha me\n" +
                            "recordaba a una serpiente, con sus flexibles maniobras y ataques repentinos. Podría ser considerado\n" +
                            "uno de los pocos potenciadores elementales con un atributo de agua. Potenciando la asta de su\n" +
                            "lanza para hacerla más flexible, sus ataques eran como un espejismo de rápidas estocadas y fluidos\n" +
                            "golpes. La batalla parecía estar a su favor; el usuario de dobles espadas tenía heridas con un\n" +
                            "abundante sangrado y desesperadamente intentaba detener la embestida de ataques.\n" +
                            "Un ruidoso estruendo desvió mi atención de la batalla de Adam. Padre había sido lanzado hacia los\n" +
                            "restos de lo que quedaba del hechizo de Muralla de Tierra y luchaba por intentar recuperar el\n" +
                            "sentido mientras que desde las comisuras de sus labios goteaba sangre."
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