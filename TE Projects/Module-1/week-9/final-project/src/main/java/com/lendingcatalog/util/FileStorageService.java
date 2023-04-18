package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {



    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {

        try(PrintWriter filePath = new PrintWriter(filename)) {
            filePath.println(contents);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        File dataFile =  new File(filename);

        List<String> outputFile = new ArrayList<>();
        try(Scanner inputFile = new Scanner(dataFile)) {
            do{
                String dataInput = inputFile.nextLine();
                outputFile.add(dataInput);
            }while (inputFile.hasNextLine());
        }
        catch(FileNotFoundException e){

        }



        return outputFile;
    }
}
