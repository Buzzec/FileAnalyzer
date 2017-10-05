package com.buzzec;

import com.buzzec.loggger.*;

import java.util.*;

public class AnalyzedLine{
    private ArrayList<String> line;
    private Logger logger;
    
    public AnalyzedLine(ArrayList<String> line, Logger logger){
        this.line = line;
        this.logger = logger;
//        logger.log("AnalyzedLine(" + line + ", logger)", LogLevel.DEBUG);
    }
    
    public String get(int x){
//        logger.log("get(" + x + ")", LogLevel.DEBUG);
        return line.get(x);
    }
    
    public int size(){
//        logger.log("size()", LogLevel.DEBUG);
        return line.size();
    }
}
