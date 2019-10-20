package Komis.services;

import Komis.domain.CarBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class CarBrandServiceTest {
    CarBrandService carBrands = new CarBrandService(new ArrayList<CarBrand>());

    @Test
    public void emptyBrandRepositoryImplementationTest(){
        assertNotNull(new CarBrandServiceTest());
    }

    @Test
    public void brandRepositoryImplementationTest(){
        assertNotNull(carBrands);
    }

    @Test
    public void createMethodImplementationTest(){
        assertNotNull(carBrands.create(new CarBrand(1, "Volkswagen")));
    }

    @Test
    public void readMethodImplementationTest(){
        assertNotNull(carBrands.read(0));
    }

   /*  @Test
    public void updateMethodImplementationTest(){
        assertNotNull(carBrands.update(1, new CarBrand()));
    } */
}
