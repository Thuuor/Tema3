package exercicis

import java.io.ObjectInputStream
import java.io.FileInputStream
import java.io.EOFException

fun main(){
	
	val f = ObjectInputStream(FileInputStream("Rutes.obj"))
	
	try {
		while (true){
		val r = f.readObject() as Ruta
		r.mostrarRuta()
		}
	} catch (e: EOFException) {
		f.close()
	}
	
}