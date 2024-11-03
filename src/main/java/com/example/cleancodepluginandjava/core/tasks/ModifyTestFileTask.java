package com.example.cleancodepluginandjava.core.tasks;

import com.example.cleancodepluginandjava.core.utils.EditFileUtils;

public class ModifyTestFileTask {
    private final String path;

    public ModifyTestFileTask(String path) {
        this.path = path.concat("test.txt");
    }

    public void execute() {
        EditFileUtils.removeLine(path, 0);
    }
}
