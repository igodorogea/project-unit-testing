import org.junit.Before;
import org.junit.Test;
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

}