package Komis.services;

import Komis.domain.CarBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CarBrandServiceTest {
    CarBrandService testRepo = new CarBrandService(new ArrayList<CarBrand>());
    private int brand_count = 10;

    @Before
    public void setTestRepo(){
        for (int i = 0; i < brand_count; i++){
            CarBrand carBrand = new CarBrand(i, "BMW" + Integer.toString(i), 7);
            testRepo.carBrands.add(carBrand);
        }
    }

    @Test
    public void emptyBrandRepositoryImplementationTest(){
        assertNotNull(new CarBrandServiceTest());
    }

    @Test
    public void brandRepositoryImplementationTest(){
        assertNotNull(testRepo);
    }

    @Test
    public void createMethodImplementationTest(){
        assertNotNull(testRepo.create(new CarBrand(1, "Volkswagen", 15)));
    }

    @Test
    public void readMethodImplementationTest(){
        CarBrand brand1 = new CarBrand(0, "Peugeot", 30);
        testRepo.carBrands.add(brand1);

        assertNotNull(testRepo.read(0));
    }

    @Test
    public void updateMethodImplementationTest(){
        CarBrand brand1 = new CarBrand(0, "Peugeot", 30);
        testRepo.carBrands.add(brand1);

        assertNotNull(testRepo.update(1, new CarBrand()));
    }

    @Test
    public void deleteMethodImplementationTest(){
        CarBrand brand1 = new CarBrand(0, "Peugeot", 30);
        testRepo.carBrands.add(brand1);

        assertNotNull(testRepo.delete(testRepo.carBrands.get(0)));
    }

    @Test
    public void readAllMethodTest(){
        assertEquals(brand_count, testRepo.carBrands.size());
    }

   /* @Test
    public void createMethodTest(){
        CarBrand BrandToVerify = testRepo.read(7);
        assertEquals(brand_count, testRepo.carBrands.size());
        assertEquals(testRepo.carBrands.get(7), BrandToVerify);
    }

    @Test
    public void readMethodTest(){
        CarBrand BrandToVerify = testRepo.read(5);
        assertEquals(testRepo.carBrands.get(5), BrandToVerify);
    }

    @Test
    public void updateMethodTest(){
        CarBrand newBrand = new CarBrand(9, "Test", 100);
        testRepo.update(9, newBrand);

        assertEquals(brand_count, testRepo.carBrands.size());
        assertEquals(testRepo.carBrands.get(9), newBrand);
    }

    @Test
    public void deleteMethodTest(){
        testRepo.delete(testRepo.carBrands.get(1));
        testRepo.delete(testRepo.carBrands.get(0));

        assertEquals(brand_count - 2, testRepo.carBrands.size());
    }

    @Rule
    public final ExpectedException except = ExpectedException.none();

    @Test
    public void createMethodExceptionTest(){
        except.expect(IllegalArgumentException.class);
        except.expectMessage("There is brand with this Id in database");

        assertNotNull(testRepo.create(new CarBrand(2, "Test", 100)));
    }

    @Test
    public void readMethodExceptionTest(){
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such brand id in database");

        assertNotNull(testRepo.read(100));
    }

    @Test
    public void updateMethodExceptionTest(){
        CarBrand newCar = new CarBrand(6, "Test", 100);

        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no brand with this Id in database");

        assertNotNull(testRepo.update(100, newCar));
    }

    @Test
    public void deleteMethodExceptionTest(){
        except.expect(NoSuchElementException.class);
        except.expectMessage("There is no such a car in database");

        CarBrand newBrand = new CarBrand(100, "Test", 100);

        assertNotNull(testRepo.delete(newBrand));
    }*/

}
