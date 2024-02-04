package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Student {
    private int opNumero;
    private String opNimi;
    public ArrayList<Grade> kurssit  = new ArrayList<>();
    Calculator calculator = new Calculator();

    public Student(int opNumero, String opNimi){
        this.opNumero=opNumero;
        this.opNimi=opNimi;
        
    }
    
    public void addGrade(int numero, String kurssi){
        Grade grade = new Grade(numero, kurssi);
        kurssit.add(grade);
    }

    public String getName() {
        return opNimi;
    }

    public void tulostaTiedot(){
        System.out.println(opNumero+": "+opNimi);
    }

    public void kirjoitaTiedot(BufferedWriter writer) throws IOException
    {
        writer.write(opNumero+": " + opNimi + "\n");
    }

    public void tulostaKurssit(){
        if (kurssit.isEmpty()){
            System.out.println("Opiskelijalla ei ole suoritteita");
        }
        for (Grade grade : kurssit){
            grade.tulosta();
            }
    }
    


    public double keskiarvo(){
        return calculator.calculateKeskiarvo(kurssit);
        
    }
    public double mediaani(){
        return calculator.calculateMedian(kurssit);
    }
}
