package com.aleite.utilities.fileSystem;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class fileSystemNavigator {
    private String rootDirectory;
    private String workingDirectory;
    private FileFilter fileFilter;
    private String[] list;

    public fileSystemNavigator(String rootDirectory) {
        this.rootDirectory = rootDirectory;
        this.workingDirectory = "/";

        this.fileFilter = new fileSystemNavigatorFilter();
    }

    public fileSystemNavigator(String rootDirectory, String filePrefix) {
        this.rootDirectory = rootDirectory;
        this.workingDirectory = "/";

        this.fileFilter = new fileSystemNavigatorFilter(filePrefix);
    }

    public boolean changeWorkingDirectory(String directory) {
        boolean status = false;
        if ((directory.indexOf("..") == -1) && (checkFileAvailable(directory))) {
            this.workingDirectory = (this.workingDirectory + directory + "/");
            status = true;
        }
        return status;
    }

    public boolean previousLevel() {
        boolean status = false;
        if (this.workingDirectory.lastIndexOf("/") > 0) {
            String[] structure = this.workingDirectory.split("/");
            int depth = structure.length - 1;

            String updatedWorkingDirectory = "/";
            if (depth > 1) {
                for (int i = 1; i < depth; i++) {
                    updatedWorkingDirectory = updatedWorkingDirectory + structure[i] + "/";
                }
            }
            this.workingDirectory = updatedWorkingDirectory;
            status = true;
        }
        return status;
    }

    public void resetWorkingDirectory() {

        this.workingDirectory = "/";
    }

    public String getWorkingDirectory() {
        return this.workingDirectory;
    }

    public String[] listFiles() {
        File f = new File(this.rootDirectory + this.workingDirectory);

        File[] files = f.listFiles(this.fileFilter);
        if (files != null) {
            Arrays.sort(files);
        }
        this.list = null;
        if (files != null) {
            this.list = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                this.list[i] = files[i].getName();
            }
        }
        return this.list;
    }

    private boolean checkFileAvailable(String filename) {
        boolean status = false;
        if (this.list != null) {
            for (int i = 0; i < this.list.length; i++) {
                if (this.list[i].equalsIgnoreCase(filename)) {
                    status = true;
                    break;
                }
            }
        }
        return status;
    }

    public void moveFile(String file, String newLocation) {
        File f = new File(this.rootDirectory + this.workingDirectory + file);

        f.renameTo(new File(this.rootDirectory + this.workingDirectory + newLocation + file));
    }
}
