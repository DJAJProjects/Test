/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.jwieczorek.Services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakub Wieczorek
 * @version 1.0.1
 * 
 * Provides a basic IO contact with text files.
 */
public class FilesService {
    
     /**
     * Reads text lines from file.
     * @param fileName
     * Name of the file.
     * @return
     * Returns list of strings from given file
     * @throws IOException 
     * Throws an exception when there was an error while reading file.
     */
    public static List<String> readFromFile(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        return Files.readAllLines(path, ENCODING);
    }
    
    /**
     * Writes text lines to file.
     * @param lines
     * List of strings which should be saved in given file. 
     * @param fileName
     * Name of the file.
     * @throws IOException 
     * Throws an exception when there was an error while writing text into file.
     */
    public static void writeToFile(List<String> lines, String fileName) throws IOException{
        Path path = Paths.get(fileName);
        Files.write(path,lines, ENCODING, StandardOpenOption.APPEND);
    }
    
    /**
     * Deletes all the file content. File is not being deleted.
     * @param fileName
     * Name of the file.
     * @throws IOException 
     *  Throws an exception when there was an error while deleting file content.
     */
    public static void eraseFile(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        Files.write(path, new ArrayList<>(0), ENCODING);
    }
    
    /**
     * Specifies an encoding used by writing and reading functions.
     */
    final private static Charset ENCODING = StandardCharsets.UTF_8;
    
}
