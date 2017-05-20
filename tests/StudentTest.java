import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student("John Doe");
    }

    @Test
    public void testAddNotaRight() throws Exception {
        int nota = 8;
        student.addNota(nota);
    }

    @Test
    public void testGetNotaRight() throws Exception {
        int nota = 8;
        student.addNota(nota);
        assertEquals(nota, student.getNota(0));
    }

    @Test
    public void testMedieAritmeticaRight() throws Exception {
        int firstNota = 8;
        int secondNota = 9;
        int thirdNota = 7;
        student.addNota(firstNota);
        student.addNota(secondNota);
        student.addNota(thirdNota);
        assertEquals(8, student.medieAritmetica(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNotaBoundaryLow() {
        student.addNota(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNotaBoundaryHigh() {
        student.addNota(12);
    }


    @Test
    public void testNotaFrecventaMaximaRight() throws Exception {
        student = new Student("John Doe", new ArrayList<>(Arrays.asList(5, 6, 7)));
        assertEquals(7, student.notaFrecventaMaxima());

        student = new Student("John Doe", new ArrayList<>(Arrays.asList(5, 5, 6, 7)));
        assertEquals(5, student.notaFrecventaMaxima());

        student = new Student("John Doe", new ArrayList<>(Arrays.asList(5, 5, 6, 6, 7)));
        assertEquals(6, student.notaFrecventaMaxima());
    }

    @Test
    public void testNotaFrecventaMaximaCrossCheck() throws Exception {
        ArrayList<Integer> note = new ArrayList<>(Arrays.asList(5, 5, 6, 7, 8, 4, 7, 9, 5, 7));
        student = new Student("John Doe", note);

        assertEquals(notaFrecventaMaximaAlt(note), student.notaFrecventaMaxima());
    }

    private int notaFrecventaMaximaAlt(ArrayList<Integer> note) {
        Collections.sort(note);

        int notaFrecventa = 0, max = 0, cnt = 0, prevNota = 0;
        for (int n : note) {
            if (n != prevNota) {
                cnt = 1;
                prevNota = n;
            } else {
                cnt++;
            }

            if (max <= cnt) {
                notaFrecventa = n;
                max = cnt;
            }
        }

        return notaFrecventa;
    }
}