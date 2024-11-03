package com.example.cleancodepluginandjava.ui

import com.example.cleancodepluginandjava.actions.CreateFilePluginAction
import com.example.cleancodepluginandjava.actions.ModifyFilePluginAction
import com.example.cleancodepluginandjava.core.ModifyTestFileAction
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel

class PopupDialog : DialogWrapper(true) {
    init {
        title = "Clean Code Plugin"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel()

        // Bouton pour l'action 1
        val button1 = JButton("Créer Fichier Test")
        button1.addActionListener {
            CreateFilePluginAction().actionPerformed() // Exécute l'action de création de fichier
            println("Action 1")
        }

        // Bouton pour l'action 2
        val button2 = JButton("Action 2")
        button2.addActionListener {
            ModifyFilePluginAction().actionPerformed()
            println("Action 2")
            // MonAction2().execute() // Exécute l'action du module `core`
        }

        // Ajouter les boutons au panel
        panel.add(button1)
        panel.add(button2)
        return panel
    }
}