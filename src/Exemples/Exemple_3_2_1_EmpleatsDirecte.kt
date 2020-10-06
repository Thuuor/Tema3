package Exemples

import java.io.RandomAccessFile

fun main(args: Array<String>) {
	val f = RandomAccessFile("Empleats.dat", "r")
	f.seek(56)
	println("Núm.: " + f.readInt())
	println("Nom: " + f.readUTF())
	println("Depart: " + f.readInt())
	println("Edat: " + f.readInt())
	println("Sou: " + f.readDouble())
	println()
	f.seek(0)
	println("Núm.: " + f.readInt())
	println("Nom: " + f.readUTF())
	println("Depart: " + f.readInt())
	println("Edat: " + f.readInt())
	println("Sou: " + f.readDouble())
	println()
	f.close()

}

