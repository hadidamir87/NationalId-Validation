import org.example.NationalCode;
import org.example.ValidationNationalCode;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.Date;

public class NationalCodeTest {
    ValidationNationalCode validationNationalCode=new ValidationNationalCode();
    @Test
    public  void testValidNationalCode(){
        NationalCode nationalCode=new NationalCode("0083034544",new Date(),false);
        validationNationalCode.validateNationalCode(nationalCode);
        assertEquals(true,nationalCode.getValid());
    }

    @Test
    public  void testGetStateCode(){
        NationalCode nationalCode=new NationalCode("0480576531",new Date(),false);

        String testState= validationNationalCode.getStateCode(nationalCode);
        assertEquals("048",testState);
    }

    @Test
    public  void testGetUniqCode(){
        NationalCode nationalCode=new NationalCode("2130588263",new Date(),false);

        String testUniq= validationNationalCode.getPersonUniqueCode(nationalCode);
        assertEquals("058826",testUniq);
    }
}
