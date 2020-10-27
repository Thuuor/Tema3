package exercicis

import java.io.ObjectInputStream
import java.io.FileInputStream
import com.squareup.moshi.*
import java.io.EOFException
import java.io.File

class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())

fun main() {
	
	val f_in = ObjectInputStream(FileInputStream("Rutes.obj"))
    val rutes = arrayListOf<Ruta>()

    try {
        while (true) {
            val r = f_in.readObject() as Ruta

            rutes.add(r)

        }

    } catch (e: EOFException) {
        f_in.close()

        val totalRutes = Rutes(rutes)
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val json = adapter.toJson(totalRutes)

        File("Rutes.json").writeText(json)
	}
}