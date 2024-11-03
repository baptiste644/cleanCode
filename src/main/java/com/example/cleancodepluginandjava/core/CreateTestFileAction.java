package com.example.cleancodepluginandjava.core;

import com.example.cleancodepluginandjava.core.utils.EditFileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateTestFileAction {
    private final String path;

    public CreateTestFileAction(String path) {
        this.path = path;
    }

    public void execute() {
        File file = new File(path, "test.txt");
        EditFileUtils.setContents(path.concat("test.txt"), List.of("test1", "test2"));
    }
}