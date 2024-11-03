package com.example.cleancodepluginandjava.Utils

import com.example.cleancodepluginandjava.core.utils.EditFileUtils
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.vfs.VirtualFile

class Utils {
    companion object {
        fun getPath(e: AnActionEvent): String {
            val project = e.project?: return ""

            // Récupère l'éditeur de fichiers actif
            val editorManager = FileEditorManager.getInstance(project)
            val virtualFile: VirtualFile? = editorManager.selectedFiles.firstOrNull()

            // Si un fichier est ouvert, on récupère le chemin
            if (virtualFile != null) {
                val filePath = virtualFile.path
                println("Chemin du fichier actuellement ouvert : $filePath")
                return filePath
                // Vous pouvez également passer `filePath` à une autre méthode ou le stocker
            } else {
                println("Aucun fichier ouvert actuellement.")
                return ""
            }
        }
        fun getContents(e: AnActionEvent): List<String> {
            return EditFileUtils.readFile(getPath(e))
        }

    }
}