package org.example.util;

import java.io.File;
import java.io.IOException;

public class Action {
    public void init() {

        String absolutePath = new File(Prop.relativePath).getAbsolutePath();

        File file = new File(absolutePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
