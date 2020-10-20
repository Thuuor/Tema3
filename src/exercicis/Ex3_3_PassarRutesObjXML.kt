package exercicis


import javax.xml.parsers.DocumentBuilderFactory
import java.io.EOFException
import java.io.ObjectInputStream
import java.io.FileInputStream
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun main(){
	
	val f_in = ObjectInputStream(FileInputStream("Rutes.obj"))
	
	val doc = DocumentBuilderFactory.newInstance ().newDocumentBuilder().newDocument()
	val arrel = doc.createElement("rutes")
	doc.appendChild(arrel)
	
	try {
		while(true){
			val r = f_in.readObject() as Ruta
			val ruta = doc.createElement ("ruta")
			
			val nom = doc.createElement ("nom")
			nom.appendChild(doc.createTextNode(r.nom))
			ruta.appendChild(nom)
			
			val desnivell = doc.createElement ("desnivell")
			desnivell.appendChild(doc.createTextNode(r.desnivell.toString()))
			ruta.appendChild(desnivell)
			
			val desnivellAcum = doc.createElement("desnivellAcumulat")
			desnivellAcum.appendChild(doc.createTextNode(r.desnivellAcumulat.toString()))
			ruta.appendChild(desnivellAcum)
			
			val punts = doc.createElement("punts")
			ruta.appendChild(punts)
			
			for (i in 0..r.size()-1) {
				
				val punt = doc.createElement("punt")
				punt.setAttribute("num",Integer.toString((i+1)))
				punts.appendChild(punt)
				
				val nomPunt = doc.createElement("nom")
				nomPunt.appendChild(doc.createTextNode(r.getPuntNom(i)))
				punt.appendChild(nomPunt)
				
				val latitud = doc.createElement("latitud")
				latitud.appendChild(doc.createTextNode(r.getPuntLatitud(i).toString()))
				punt.appendChild(latitud)
				
				val longitud = doc.createElement("longitud")
				longitud.appendChild(doc.createTextNode(r.getPuntLongitud(i).toString()))
				punt.appendChild(longitud)
			}
			
			arrel.appendChild(ruta)
		}
	} catch (eof: EOFException){
		f_in.close()
	}
	
	val trans = TransformerFactory.newInstance().newTransformer()
	
	trans.transform(DOMSource(doc),StreamResult("Rutes.xml"))
}