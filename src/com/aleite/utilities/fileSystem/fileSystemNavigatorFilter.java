package com.aleite.utilities.fileSystem;

import java.io.File;
import java.io.FileFilter;

public class fileSystemNavigatorFilter implements FileFilter {
    String description;
    String prefix;

    public fileSystemNavigatorFilter() {}

    public fileSystemNavigatorFilter(String filePrefix) {
        this.prefix = filePrefix;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean accept(File file) {
        boolean show = true;
        if ((file.isHidden()) || (file.isDirectory())) {
            show = false;
        }
        if ((this.prefix != null) && (!file.getName().startsWith(this.prefix))) {
            show = false;
        }
        return show;
    }
}
