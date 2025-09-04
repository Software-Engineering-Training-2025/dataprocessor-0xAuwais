package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;

import java.util.List;

public class CleanService {
    public static Clean cleaning(CleaningType clean) {
        if(clean==CleaningType.REMOVE_NEGATIVES){
            return new Remove_z();
        }
        if(clean==CleaningType.REPLACE_NEGATIVES_WITH_ZERO){
            return new Replace_z();
        }
        else {
            throw new RuntimeException("CleaningType not Available");
        }
    }

}
