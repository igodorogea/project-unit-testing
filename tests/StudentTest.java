import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StudentTest {
    private Student student;

    @Before
    public void setUp() throws Exception {
        student = new Student("John Doe");
    }

}