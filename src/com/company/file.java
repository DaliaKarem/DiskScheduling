package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class file {
    private String filePath;
    private int[] allocatedBlocks;
    private boolean deleted = false;
    File file;
    FileWriter write;

    public file(String filePath, int[] allocatedBlocks) throws IOException {
        this.filePath = filePath;
        this.allocatedBlocks = allocatedBlocks;
        file = new File("DiskStructure.vfs.txt");
        write = null;
        write = new FileWriter(file);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int[] getAllocatedBlocks() {
        return this.allocatedBlocks;
    }

    public void createFile(int size) throws IOException {
        try {
            write.write(filePath);
        } catch () {

        }

    }

    public void deleteFile(String filePath) throws IOException {
        Files.delete(Paths.get(filePath));
        deleted = true;
    }
}














