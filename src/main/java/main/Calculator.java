package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator 
{
    public double calculateKeskiarvo(ArrayList<Grade> grades) 
    {
        int sum = 0;
        for (Grade grade : grades) 
        {
            int numero = grade.getNumero();
            sum += numero;
        }
        return (double) sum / grades.size();
    }


    

    public double calculateMedian(ArrayList<Grade> grades) {
        Collections.sort(grades);
    
        int size = grades.size();
    
        if (size % 2 == 0) {
            int middleIndex1 = size / 2 - 1;
            int middleIndex2 = size / 2;
            int middleValue1 = grades.get(middleIndex1).getNumero();
            int middleValue2 = grades.get(middleIndex2).getNumero();
    
            return (middleValue1 + middleValue2) / 2.0;
        } else {
            int middleIndex = size / 2;
            return grades.get(middleIndex).getNumero();
        }
    }
}
