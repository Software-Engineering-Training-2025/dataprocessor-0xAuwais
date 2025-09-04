package org.example.dataprocessor;

import org.example.dataprocessor.enums.OutputType;

import java.io.Console;

public class OutputService {
    public static Output printing (OutputType output){
        if(output==OutputType.CONSOLE){
            return new output_console();
        }
        if(output==OutputType.TEXT_FILE){
            return new output_txt();
        }
        else {
            throw new RuntimeException("There is no such OutputType");
        }
    }
}
