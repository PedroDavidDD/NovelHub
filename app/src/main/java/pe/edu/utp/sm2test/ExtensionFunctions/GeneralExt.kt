package pe.edu.utp.sm2test.ExtensionFunctions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(containerId: Int, fragment: Fragment, addToBackStack: Boolean = false) {
    val transaction = beginTransaction()
    transaction.replace(containerId, fragment)
    if (addToBackStack) {
        transaction.addToBackStack(null)
    }
    transaction.commit()
}
//supportFragmentManager.replaceFragment(R.id.container, MyFragment())


//Extensión para crear y configurar un Intent:
inline fun <reified T : Activity> Context.buildIntent(
    extras: Bundle.() -> Unit = {}
): Intent {
    val intent = Intent(this, T::class.java)
    intent.putExtras(Bundle().apply(extras))
    return intent
}
/*
val intent = requireContext().buildIntent<SecondActivity> {
    putString("key", "value")
}
startActivity(intent)
*/
