package main;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class University 
{
    public ArrayList<Student> students  = new ArrayList<>();
    private String FILENAME;

    public void FileName(){
        this.FILENAME = "students.txt";
    }


    public void newStudent(Student student) {
        students.add(student);
    }

    public void listStudents(){
        System.out.println("Opiskelijat:");
        for (Student student : students){
            student.tulostaTiedot();
        }
    }
    public void addGradetoStudent(int opId, String suorite, int numero) {
        Student student=students.get(opId);
        student.addGrade(numero, suorite);
    }

    public void listStudents2() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i++ + ": " + student.getName());
        }
    }
    public void saveStudentsToFile() 
    {
        try 
        {
            if (FILENAME == null) 
            {
                FileName();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.FILENAME));
            for (Student student : students) 
            {
                student.kirjoitaTiedot(writer);
            }
            writer.close();
        }
        catch (IOException e) 
        {
            System.out.println("Tiedostoon tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void loadStudentsFromFile() 
    {
       
        
        try 
        {
            students.clear();

            if (FILENAME == null) 
            {
                FileName();
            }

            BufferedReader reader = new BufferedReader(new FileReader(this.FILENAME));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(":");
                if (parts.length == 2) 
                {
                    int opNumero = Integer.parseInt(parts[0].trim());
                    String opNimi = parts[1].trim();
                    Student student = new Student(opNumero, opNimi);
                    students.add(student);
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Tiedoston lukeminen epäonnistui");
            e.printStackTrace();
        }
    }
}