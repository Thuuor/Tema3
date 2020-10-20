package exercicis


import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory


class Finestra : JFrame() {
	
	init {
		var doc: Document
		
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutes.xml")
		val arrel = doc.getDocumentElement()
		val rutas = arrel.getElementsByTagName("ruta")
		
		
		defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		setTitle("Punts d'una ruta")
		setSize(400, 300)
		setLayout(BorderLayout())
		
		val panell1 = JPanel(FlowLayout())
		val panell2 = JPanel(BorderLayout())
		add(panell1,BorderLayout.NORTH)
		add(panell2,BorderLayout.CENTER)
		
		val llistaRutes = arrayListOf<String>()
		for (i in 0 until rutas.getLength()){
			
			val ruta = rutas.item(i) as Element
			llistaRutes.add(ruta.getElementsByTagName("nom").item(0).getTextContent())
			
		}
		
		val combo = JComboBox(llistaRutes.toArray())
		panell1.add(combo)
		
		panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
		val area = JTextArea()
		panell2.add(area)
		
		combo.addActionListener{
			// accions quan s'ha seleccionat un element del combobox,
			// i que han de consistir en omplir el JTextArea
			
		}
	}
}

fun main(args: Array<String>) {
	EventQueue.invokeLater {
		Finestra().isVisible = true
	}
}

