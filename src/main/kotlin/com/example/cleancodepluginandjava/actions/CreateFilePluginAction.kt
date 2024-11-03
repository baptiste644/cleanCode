package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.core.CreateTestFileAction
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class CreateFilePluginAction{
    fun actionPerformed() {
        // Chemin de destination pour le fichier "test.txt"
        val path = "C:\\Users\\Public\\"  // Remplacez par le chemin voulu
        val action = CreateTestFileAction(path)
        action.execute()
    }
}