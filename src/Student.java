import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
        if (nota > 10 || nota < 1) {
            throw new IllegalArgumentException("Nota trebuie sa fie intre 1 si 10");
        }

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
        // TreeMap is self sortable
        TreeMap<Integer, Integer> mapNote = new TreeMap<>();
        for (Integer n : note) {
            if (mapNote.containsKey(n)) {
                mapNote.put(n, mapNote.get(n) + 1);
            } else {
                mapNote.put(n, 1);
            }
        }

        int notaFrecventa = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> m : mapNote.entrySet()) {
            if (max <= m.getValue()) {
                max = m.getValue();
                notaFrecventa = m.getKey();
            }
        }

        return notaFrecventa;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(nume + " note: ");
        for (Integer n : note)
            output.append(n).append(" ");

        return output.toString();
    }
}
