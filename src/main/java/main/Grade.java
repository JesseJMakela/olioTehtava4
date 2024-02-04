package main;

public class Grade implements Comparable<Grade>{
    private int numero;
    private String kurssi;

    public int getNumero()
    {
        return numero;
    }

    public String getKurssi()
    {
        return kurssi;
    }

    public Grade(int numero, String kurssi)
    {
        this.numero = numero;
        this.kurssi = kurssi;    
    }
    
    public void tulosta()
    {
        System.out.println(kurssi + ": " + numero);
    }
    public int compareTo(Grade grade) {
        return Integer.compare(this.numero, grade.getNumero());
    }
}   

