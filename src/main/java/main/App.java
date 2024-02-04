// Jesse Mäkelä
// Tehtävä 3 23.1
//olio ohjelmointi

package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);

        University university = new University();
        int opId;
        String a;

        boolean exit = false;
        while (!exit) {
            System.out.println( "1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma" );
            if (sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                    System.out.println("Anna opiskelijan nimi?");
                    String opNimi = sc.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    a = sc.nextLine();
                    int opNumero = Integer.parseInt(a);

                    Student uusiStudent = new Student(opNumero, opNimi);
                    university.newStudent(uusiStudent);
                    break;

                    case 2:
                    university.listStudents();
                    break;
                    
                    case 3:
                    university.listStudents2();
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    a = sc.nextLine();
                    opId = Integer.parseInt(a);
                    System.out.println("Mille kurssille suorite lisätään?");
                    String suorite = sc.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    a = sc.nextLine();
                    int numero = Integer.parseInt(a);
                    university.addGradetoStudent(opId, suorite, numero);

                    break;

                    case 4:
                    university.listStudents2();
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    a = sc.nextLine();
                    opId = Integer.parseInt(a);
                    university.students.get(opId).tulostaKurssit();
                    break;

                    case 5:
                    university.listStudents2();
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    a = sc.nextLine();
                    opId = Integer.parseInt(a);
                    System.out.println("Keskiarvo on " + university.students.get(opId).keskiarvo());
                    break;

                    case 6:
                    university.listStudents2();
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    a = sc.nextLine();
                    opId = Integer.parseInt(a);
                    System.out.println("Mediaani on " + university.students.get(opId).mediaani());
                    break;

                    case 7:
                    university.saveStudentsToFile();
                    break;

                    case 8:
                    university.loadStudentsFromFile();
                    break;

                    case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;

                    default: 
                    System.out.println("Syöte oli väärä");
                    break;
                }
            }
            else {
                System.out.println("Syöte on väärä");        
            }
        }
    }
}