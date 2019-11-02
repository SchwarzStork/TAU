package Komis.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.sql.Date;
import java.time.LocalDate;

@RunWith(JUnit4.class)
public class CarBrandTest {

    TimeStamp date = new TimeStamp((LocalDate.now()));

    @Test
    public void emptyBrandIsImplementedTest() {
        assertNotNull(new CarBrand());
    }

    @Test
    public void brandIsImplementedTest(){
        assertNotNull(new CarBrand(1,"Volkswagen", 15));
    }

    @Test
    public void carTimestampTest(){
        assertNotNull(new CarBrand(1, "Volkswagen", 15, date, date, date));
    }

}
