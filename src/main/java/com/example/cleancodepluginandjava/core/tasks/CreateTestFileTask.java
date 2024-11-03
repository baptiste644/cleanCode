package com.example.cleancodepluginandjava.core.tasks;

import com.example.cleancodepluginandjava.core.utils.EditFileUtils;

import java.io.File;
import java.util.List;

public class CreateTestFileTask {
    private final String path;

    public CreateTestFileTask(String path) {
        this.path = path;
    }

    public void execute() {
        EditFileUtils.setContents(path.concat("test.txt"), List.of("test1", "test2"));
    }
}