package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.core.CreateTestFileAction
import com.example.cleancodepluginandjava.core.ModifyTestFileAction
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ModifyFilePluginAction{
    fun actionPerformed() {
        // Chemin de destination pour le fichier "test.txt"
        val path = "C:\\Users\\Public\\"  // Remplacez par le chemin voulu
        val action = ModifyTestFileAction(path)
        action.execute()
    }
}