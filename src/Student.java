import java.util.ArrayList;

public class Student {
    private String nume;
    private ArrayList<Integer> note;

    public Student(String nume) {
        this.nume = nume;
        note = new ArrayList<>();
    }

    public Student(String nume, ArrayList<Integer> note) {
        this.nume = nume;
        this.note = note;
    }

    public String getNume() {
        return nume;
    }

    public void addNota(int nota) {
        note.add(nota);
    }

    public int getNota(int i) {
        return note.get(i);
    }

    public int nrDisciplinePromovate() {
        int nrDiscipline = 0;
        for (Integer n : note)
            if (n >= 5)
                nrDiscipline++;

        return nrDiscipline;
    }

    public float medieAritmetica() {
        int m = 0;
        for (Integer n : note)
            if (n >= 5)
                m += n;

        return m / this.nrDisciplinePromovate();
    }

    public int notaFrecventaMaxima() {
        int nota = 0;
        //corpul metodei pentru returnarea notei de frecventa maxima
        return nota;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(nume + " note: ");
        for (Integer n : note)
            output.append(n).append(" ");

        return output.toString();
    }
}
