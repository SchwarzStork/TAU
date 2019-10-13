package Komis.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarBrandTest {

    @Test
    public void emptyBrandIsImplementedTest() {
        assertNotNull(new CarBrand());
    }

    @Test
    public void brandIsImplementedTest(){
        assertNotNull(new CarBrand(1,"Volkswagen"));
    }

}
