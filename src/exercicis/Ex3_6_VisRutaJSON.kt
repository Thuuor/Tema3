package exercicis

import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import java.io.File
import org.json.JSONTokener
import org.json.JSONObject



class FinestraJSON : JFrame() {

	
	init {
		
		class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())

        val json = File("Rutes.json").readText()
        val llistaRutes = arrayListOf<String>()

        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(Rutes::class.java)
        val ruta = adapter.fromJson(json)

        val rutes = ruta.rutes
		
		defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		setTitle("JSON: Punts d'una ruta")
		setSize(400, 300)
		setLayout(BorderLayout())

		val panell1 = JPanel(FlowLayout())
		val panell2 = JPanel(BorderLayout())
		add(panell1, BorderLayout.NORTH)
		add(panell2, BorderLayout.CENTER)

		var nomsLlistaRutes = arrayListOf<String>()

		for(i in rutes){
			nomsLlistaRutes.add(i.nom)
		}
		
		val combo = JComboBox(nomsLlistaRutes.toArray())
		panell1.add(combo)

		panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
		val area = JTextArea()
		panell2.add(area)

		combo.addActionListener {
			
			var r = rutes.get(combo.getSelectedIndex())
			var result: String = ""
			for (i in r.llistaDePunts){
				result += "$i \n"
			}
			area.setText(result)
		}
	}
}

fun main(args: Array<String>) {
	EventQueue.invokeLater {
		FinestraJSON().isVisible = true
	}
}