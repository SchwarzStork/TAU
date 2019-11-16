package Komis.cucumber;

import Komis.domain.CarBrand;
import org.junit.Before;
import org.junit.Test;
import Komis.services.CarBrandService;
import Komis.services.CarBrandServiceTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CucumberTest {

    private CarBrandService testRepo = new CarBrandService(new ArrayList<CarBrand>());
    private int brands_number = 12;

    @Before
    public void setTestRepo(){
        for(int i = 0; i < brands_number; i++ ) {
            CarBrand carBrand = new CarBrand(i, "Volkswagen",  100 + i);
            i++;
            CarBrand carBrand1 = new CarBrand(i, "Renault" , 100 + i);
            testRepo.toggleAddTimestamp();
            testRepo.carBrands.add(carBrand1);
            testRepo.carBrands.add(carBrand);
        }
    }

    @Test
    public void emptyCarBrandRepositoryIsImplementedTest() {
        assertNotNull(new CarBrandServiceTest());
    }

    @Test
    public void searchByRegularRegistrationExpressionMethodIsImplementedTest(){
        assertNotNull(testRepo.searchBrandByNameExpression("Volk"));
    }

    @Test
    public void searchByRegularRegistrationExpressionMethodInCarBrandRepositoryTest(){
        ArrayList<CarBrand> searchedBrands = testRepo.searchBrandByNameExpression("Au");
        assertEquals(brands_number/2, searchedBrands.size());
    }

    @Test
    public void removeBySystemListMethodIsImplementedTest(){
        ArrayList<Integer> brandSystemList = new ArrayList<>();
        brandSystemList.add(101);
        brandSystemList.add(105);
        ArrayList<CarBrand> removedBrands = testRepo.removeBySystemList(brandSystemList);
        assertEquals(brandSystemList.size(), removedBrands.size());
    }

}