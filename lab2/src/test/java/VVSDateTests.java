package test.java;

import main.java.VVSDate;
import main.java.WrongDateException;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class VVSDateTests {
    static VVSDate vvsdate;

    @BeforeClass
            public static  void before() throws WrongDateException {
        try {
             vvsdate = new VVSDate ( 3 , 11 , 1989 );
        }catch ( WrongDateException w){
            System.out.println ("Wrong input" );
        }

    }
    @Test
    public void checkIfVVSDateNotNull(){
        assertNotNull (vvsdate);
    }
    @Test(expected=WrongDateException.class)
    public void testValidateWrongMonth() throws WrongDateException{

            vvsdate = new VVSDate ( 3 , 14 , 1989 );

    }
    @Test(expected=WrongDateException.class)
    public void testValidateFebruaryNotOk() throws WrongDateException {
        vvsdate = new VVSDate ( 29 , 2 , 1989 );
    }

    @Test
    public void testValidateFebruaryOk() throws WrongDateException {
        vvsdate = new VVSDate ( 29 , 2 , 2000 );
        assertNotNull ( vvsdate );
    }

    @Test(expected=WrongDateException.class)
    public void testValidateDayNot31Days() throws WrongDateException {
        vvsdate = new VVSDate ( 31 , 9 , 1989 );
    }

    @Test(expected=WrongDateException.class)
    public void testValidateTooLowDayNumber() throws WrongDateException {
        vvsdate = new VVSDate (-1, 2, 2000);
    }

    @Test(expected=WrongDateException.class)
    public void testValidateTooLowMonthNumber() throws WrongDateException {
        vvsdate = new VVSDate (1, 0, 1991);
    }

    @Test(expected=WrongDateException.class)
    public void testValidateTooLowYearNumber() throws WrongDateException {
        vvsdate = new VVSDate (1, 6, -2);
    }

    @Test
    public void testValidateGetDays() throws WrongDateException {
        vvsdate = new VVSDate (20, 2, 1);
        VVSDate vvsdate_second = new VVSDate (25, 2, 1);
        assertEquals ( 5, vvsdate_second.getDays ( vvsdate ) );
    }

}
