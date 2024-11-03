package com.example.cleancodepluginandjava.actions

import com.example.cleancodepluginandjava.ui.PopupDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ShowPopupAction : AnAction("Ouvrir le Popup") {
    override fun actionPerformed(e: AnActionEvent) {
        val dialog = PopupDialog(e)
        dialog.show()
    }
}