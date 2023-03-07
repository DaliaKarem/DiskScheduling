package com.company;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Directory {
    private String directoryPath;
    private file[] files;
    private Directory[] subDirectories;
    private boolean deleted = false;
    File file;
    FileWriter write;
    public file[] getfiles()
    {
     return  this.files;
    }
    public Directory(file[] files,Directory[] subDirectories,String directoryPath) throws IOException {
        this.files=files;
        this.subDirectories=subDirectories;
        this.directoryPath=directoryPath;
        file= new File("DiskStructure.vfs.txt");
        write=null;
        write = new FileWriter(file);
    }
    public String getDirectoryPath(){
        return this.directoryPath;
    }
    public void createDir() throws IOException {
        if(file.equals(null)){
            write.write("<root>  "+directoryPath+"\n");
        }else{
            for (int i=0;i<subDirectories.length;i++) {
                write.write("<folder>" + i + 1 + "  " + subDirectories[i].getDirectoryPath() + "\n");
                write.write(subDirectories[i].getfiles().getFilePath()+"\n");
            }
        }
    }

    public void setSubDirectoriesAndFiles() throws IOException {
        for(int i=0;i<subDirectories.length;i++){
            subDirectories[i].createDir().mkdir();
        }
        for (int i=0;i<files.length;i++){
            files[i].createFile();
        }
    }
    public void deleteDir(String dirPath) throws IOException {
        Files.deleteIfExists(Paths.get(dirPath));
        deleted=true;
    }

    public void printDirectoryStructure(int level) {
	/*this method prints the directory name and its files
then makes recursion to loop on the subDirectories to print their structure too.

The level parameter can be used to print spaces before the directory name is printed to show its level in the structure */

    }
}

