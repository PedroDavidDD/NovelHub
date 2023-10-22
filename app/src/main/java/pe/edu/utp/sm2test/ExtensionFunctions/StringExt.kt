package pe.edu.utp.sm2test.ExtensionFunctions

// 2. Verificar si una cadena es un número entero
fun String.isInt(): Boolean {
    return try {
        this.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

// 3. Verificar si una cadena es un número decimal
fun String.isDouble(): Boolean {
    return try {
        this.toDouble()
        true
    } catch (e: NumberFormatException) {
        false
    }
}

// 8. Enmascarar una cadena reemplazando todos los caracteres con asteriscos
fun String.mask(): String {
    return "*".repeat(length)
}

