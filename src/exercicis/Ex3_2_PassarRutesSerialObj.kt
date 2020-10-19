package exercicis

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream


fun main(){
	
	val f_in = DataInputStream(FileInputStream("Rutes.dat"))
	val f_out = ObjectOutputStream(FileOutputStream("Rutes.obj"))
	
	while(f_in.available() > 0){
		
		val nom = f_in.readUTF()
		val desnivell = f_in.readInt()
		val desnivellAcum = f_in.readInt()
		val punts = f_in.readInt()

		
		val listaPuntos: MutableList<PuntGeo> = mutableListOf()

		
		for (i in 1..punts){
			val addPuntGeo = PuntGeo(f_in.readUTF(),Coordenades(f_in.readDouble(),f_in.readDouble()))
		
			listaPuntos.add(addPuntGeo)
		}
		
		val ruta = Ruta(nom,desnivell,desnivellAcum,listaPuntos)
		
		ruta.mostrarRuta()
		
		f_out.writeObject(ruta)
	}
	
	f_in.close()
	f_out.close()
}