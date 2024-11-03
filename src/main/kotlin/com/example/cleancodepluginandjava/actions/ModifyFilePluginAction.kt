package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.core.tasks.ModifyTestFileTask

class ModifyFilePluginAction{
    fun actionPerformed() {
        // Chemin de destination pour le fichier "test.txt"
        val path = "C:\\Users\\Public\\"  // Remplacez par le chemin voulu
        val action = ModifyTestFileTask(path)
        action.execute()
    }
}