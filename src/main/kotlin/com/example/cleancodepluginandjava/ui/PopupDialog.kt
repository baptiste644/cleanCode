package com.example.cleancodepluginandjava.ui

import com.example.cleancodepluginandjava.actions.CreateFilePluginAction
import com.example.cleancodepluginandjava.actions.ImportViewCleanAction
import com.example.cleancodepluginandjava.actions.ModifyFilePluginAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JPanel

class PopupDialog(private val event: AnActionEvent) : DialogWrapper(true) {
    init {
        title = "Clean Code Plugin"
        init()
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel()

        // Bouton pour l'action 1
        val button1 = JButton("Créer Fichier Test")
        button1.addActionListener {
            CreateFilePluginAction().actionPerformed(event) // Exécute l'action de création de fichier
            println("Action 1")
        }

        // Bouton pour l'action 2
        val button2 = JButton("Modifier Test")
        button2.addActionListener {
            ModifyFilePluginAction().actionPerformed()
            println("Action 2")
            // MonAction2().execute() // Exécute l'action du module `core`
        }

        val button3 = JButton("Clean Import")
        button3.addActionListener {
            ImportViewCleanAction().actionPerformed(event)
            println("Clean Import")
        }

        // Ajouter les boutons au panel
        panel.add(button1)
        panel.add(button2)
        panel.add(button3)
        return panel
    }
}