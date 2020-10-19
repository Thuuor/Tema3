package exercicis

import java.io.FileInputStream
import java.io.DataInputStream

fun main(){
	val f = DataInputStream(FileInputStream("Rutes.dat"))
	
	while (f.available() > 0) {
		System.out.println("Ruta: " + f.readUTF())
		System.out.println("Desnivell: " + f.readInt())
		System.out.println("Desnivell acumulat: " + f.readInt())
		val punts = f.readInt()
		System.out.println("Té: " + punts + " punts")
		for (i in 1..punts) {
			System.out.println("Punt $i: " + f.readUTF() + " (" + f.readDouble() + " , " + f.readDouble() + ")")
		}
		System.out.println()
	}
	f.close()
}