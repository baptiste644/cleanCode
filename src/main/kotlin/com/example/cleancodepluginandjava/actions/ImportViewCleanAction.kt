package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.Utils.Utils
import com.example.cleancodepluginandjava.Utils.Utils.Companion.getContents
import com.example.cleancodepluginandjava.Utils.Utils.Companion.getPath
import com.example.cleancodepluginandjava.core.tasks.CreateTestFileTask
import com.example.cleancodepluginandjava.core.tasks.ImportViewCleanTask
import com.example.cleancodepluginandjava.core.utils.EditFileUtils
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class ImportViewCleanAction : AnAction("Import View Clean"){
    override fun actionPerformed(e: AnActionEvent) {
        var contents = getContents(e)
        Messages.showMessageDialog(getPath(e), "path", Messages.getInformationIcon())
        Messages.showMessageDialog(contents.toString(), "Avant Modif", Messages.getInformationIcon())
        contents = ImportViewCleanTask.importViewCleanTask(contents)
        Messages.showMessageDialog(contents.toString(), "Apres Modif", Messages.getInformationIcon())
        EditFileUtils.setContents(getPath(e), contents)

    }

}