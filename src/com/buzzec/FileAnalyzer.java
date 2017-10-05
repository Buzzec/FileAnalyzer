package com.buzzec;

import com.buzzec.loggger.*;

import java.io.*;
import java.util.*;

public class FileAnalyzer{
    public static ArrayList<AnalyzedLine> analyzeFile(String filename, String splitString, Logger logger){
//        logger.log("analyzeFile(" + filename + ", " + splitString + ", logger)", LogLevel.DEBUG);
        logger.log("Beginning analysis of file: " + filename, LogLevel.INFO);
        
        ArrayList<AnalyzedLine> output = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine()) != null){
                ArrayList<String> arrayLine = new ArrayList<>();
                arrayLine.addAll(Arrays.asList(line.split(splitString)));
                output.add(new AnalyzedLine(arrayLine, logger));
            }
        }
        catch(Exception ex){
            logger.log("File error: " + ex, LogLevel.ERROR);
            ex.printStackTrace();
        }
        
        logger.log("File analysis completed.", LogLevel.INFO);
        return output;
    }
    
    public static ArrayList<AnalyzedLine> analyzeFile(String filename, Logger logger){
//        logger.log("analyzeFile(" + filename + ", logger)", LogLevel.DEBUG);
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            return analyzeFile(filename, br.readLine(), logger);
        }
        catch(Exception ex){
            logger.log("File error: " + ex, LogLevel.ERROR);
            ex.printStackTrace();
        }
        logger.log("analyseFile Returning null!", LogLevel.WARNING);
        return null;
    }
}
