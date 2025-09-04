package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;

public class AnalysisService {
    public static Analysis analysing (AnalysisType analysis) {
        if(analysis==AnalysisType.MEAN){
            return new Mean();
        }
        if(analysis==AnalysisType.MEDIAN){
            return new Median();
        }
        if(analysis==AnalysisType.STD_DEV){
            return new StandardDeviation();
        }
        if(analysis==AnalysisType.P90_NEAREST_RANK){
            return new P90_NEAREST_RANK();
        }
        if(analysis==AnalysisType.TOP3_FREQUENT_COUNT_SUM){
            return new TOP3_FREQUENT_COUNT_SUM();
        }
        throw new RuntimeException("AnalysisType not Available");
    }
}
