// CAR MODEL RELATED THINGS TO BE FINISHED

package Komis.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CarModelTest {

    @Test
    public void emptyModelIsImplementedTest() {
        assertNotNull(new CarModel() );
    }

    @Test
    public void modelIsImplementedTest() {
        assertNotNull(new CarModel(1, "Golf", "!.9 TDI", "Hatchback", "Diesel"));
    }

}
