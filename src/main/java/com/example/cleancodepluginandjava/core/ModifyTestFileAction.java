package com.example.cleancodepluginandjava.core;

import com.example.cleancodepluginandjava.core.utils.EditFileUtils;

import java.io.File;
import java.util.List;

public class ModifyTestFileAction {
    private final String path;

    public ModifyTestFileAction(String path) {
        this.path = path.concat("test.txt");
    }

    public void execute() {
        EditFileUtils.removeLine(path, 0);
    }
}
