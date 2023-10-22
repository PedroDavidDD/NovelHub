package pe.edu.utp.sm2test.ExtensionFunctions

import java.net.URL


// Validar correo electrónico:
fun String.isValidEmail(): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(this)
}
// Validar número de teléfono (formato: +51986657935):
fun String.isValidPhoneNumber(): Boolean {
    val phoneRegex = Regex("^\\+[0-9]{11,51}\$")
    return phoneRegex.matches(this)
}
//Validar URL:
fun String.isValidUrl(): Boolean {
    return try {
        URL(this).toURI()
        true
    } catch (e: Exception) {
        false
    }
}
// Validar contraseña fuerte (mínimo 8 caracteres, al menos una mayúscula, una minúscula y un número)
fun String.isStrongPassword(): Boolean {
    val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$")
    return passwordRegex.matches(this)
}
//Validar fecha en formato yyyy-MM-dd:
fun String.isValidDate(): Boolean {
    val dateRegex = Regex("^[0-9]{4}-[0-9]{2}-[0-9]{2}\$")
    return dateRegex.matches(this)
}
//Validar un nombre de usuario (solo letras y números, entre 4 y 20 caracteres):
fun String.isValidUsername(): Boolean {
    val usernameRegex = Regex("^[a-zA-Z0-9]{4,20}\$")
    return usernameRegex.matches(this)
}
