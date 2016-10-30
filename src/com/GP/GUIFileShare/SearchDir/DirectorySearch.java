package com.GP.GUIFileShare.SearchDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by user on 10/28/16.
 */
public class DirectorySearch implements IDirectorySearch {
    private static final String DIRECTORY = "/home/user/ClientFileShareGUI/downloads";

    public static void main(String[] args) {
        DirectorySearch dir = new DirectorySearch();
        dir.searchForFiles();
    }


    @Override
    public ArrayList<String> searchForFiles() {
        ArrayList<String> downloads = new ArrayList<>();
        try {
            try(Stream<Path> paths = Files.walk(Paths.get(DIRECTORY))) {
                paths.forEach(filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        System.out.println(filePath);
                        System.out.println(filePath.toString() + " + string");
                        String[] b = filePath.toString().split("\\/");
                        System.out.println(b[b.length-1]);
                        downloads.add(b[b.length-1]);

                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return downloads;
    }
}
