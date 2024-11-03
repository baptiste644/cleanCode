package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.Utils.Utils
import com.example.cleancodepluginandjava.core.tasks.CreateTestFileTask
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class CreateFilePluginAction : AnAction("Create File Plugin"){
    override fun actionPerformed(e: AnActionEvent) {
        // Chemin de destination pour le fichier "test.txt"
        val path = Utils.getPath(e)
        val action = CreateTestFileTask(path)
        action.execute()
    }
}