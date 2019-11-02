package Komis.services;

import Komis.domain.CarBrand;
import Komis.domain.TimeStamp;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.internal.matchers.Null;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class CarBrandServiceTimestampTest {


    @Mock
    TimeStamp addTimestamp;

    @Mock
    TimeStamp updateTimestamp;

    @Mock
    TimeStamp readTimestamps;

    @Mock
    CarBrandService mockRepo = new CarBrandService(new ArrayList<>());

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
    private CarBrandService testRepo = new CarBrandService(new ArrayList<>());

    @Test
    public void testAddTimestampNotNull(){
        assertNotNull(addTimestamp);
    }

    @Test
    public void testUpdateTimestampNotNull(){
        assertNotNull(updateTimestamp);
    }

    @Test
    public void testReadTimestampsNotNull(){
        assertNotNull(readTimestamps);
    }

    @Test
    public void testCreateMethodOnMockedRepo(){
        CarBrand brand = new CarBrand();
        mockRepo.create(brand);
        verify(mockRepo).create(brand);
    }

    @Test
    public void testReadMethodOnMockedRepo(){
        CarBrand car = new CarBrand(0, "Volkswagen", 11);
        mockRepo.create(car);
        mockRepo.read(0);
        verify(mockRepo, times(1)).read(0);
    }

    @Test
    public void testReadAllMethodOnMockedRepo(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        CarBrand brand1 = new CarBrand(1, "Audi", 22);
        mockRepo.create(brand);
        mockRepo.create(brand1);
        mockRepo.readAll();
        verify(mockRepo, times(1)).readAll();
    }

    @Test
    public void testUpdateMethodOnMockedRepo(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        CarBrand newBrand = new CarBrand(1, "Audi", 22);
        mockRepo.create(brand);
        mockRepo.update(0, newBrand);
        verify(mockRepo, times(1)).update(0, newBrand);
    }

    // simple tests for addTimestamp equal to date now()
    @Test
    public void testAddTimestampOnCreateMethod(){
        CarBrand carBrand = new CarBrand();
        testRepo.create(carBrand);
        when(addTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        Mockito.mockingDetails(addTimestamp).isMock();
        assertEquals(testRepo.carBrands.get(0).getAddTimestamp().getTimeStamp(), addTimestamp.getTimeStamp());
    }

    // simple test for readTimestamps equal to date now()
    @Test
    public void testReadTimestampOnReadMethod(){
        CarBrand carBrand = new CarBrand(0, "Volkswagen", 11);
        testRepo.carBrands.add(carBrand);
        testRepo.read(0);
        when(readTimestamps.getTimeStamp()).thenReturn(LocalDate.now());
        Mockito.mockingDetails(readTimestamps).isMock();
        assertEquals(testRepo.carBrands.get(0).getReadTimestamps().getTimeStamp(), readTimestamps.getTimeStamp());
    }

    // simple test for updateTimestamp equal to date now()
    @Test
    public void testUpdateTimestampOnUpdateMethod(){
        CarBrand carBrand = new CarBrand(0, "Volkswagen", 11);
        CarBrand newBrand = new CarBrand(1, "Audi", 22);
        testRepo.carBrands.add(carBrand);
        testRepo.update(0, newBrand);
        when(updateTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        Mockito.mockingDetails(updateTimestamp).isMock();
        assertEquals(testRepo.carBrands.get(0).getUpdateTimestamp().getTimeStamp(), updateTimestamp.getTimeStamp());
    }

    // simple test for readTimestamps equal to date now()
    @Test
    public void testReadTimestampOnReadAllMethod() {
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        CarBrand brand1 = new CarBrand(1, "Audi", 22);
        testRepo.carBrands.add(brand);
        testRepo.carBrands.add(brand1);
        testRepo.readAll();
        when(readTimestamps.getTimeStamp()).thenReturn(LocalDate.now());
        Mockito.mockingDetails(readTimestamps).isMock();
        assertEquals(testRepo.carBrands.get(0).getReadTimestamps().getTimeStamp(), readTimestamps.getTimeStamp());
        assertEquals(testRepo.carBrands.get(1).getReadTimestamps().getTimeStamp(), readTimestamps.getTimeStamp());
    }

    // test for timestamps method
    @Test
    public void testForGetTimestampsMethod(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        CarBrand newBrand = new CarBrand(1, "Audi", 22);
        testRepo.create(brand);
        testRepo.read(0);
        when(addTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        when(readTimestamps.getTimeStamp()).thenReturn(LocalDate.now());
        when(updateTimestamp.getTimeStamp()).thenReturn(LocalDate.now());
        mockingDetails(addTimestamp).isMock();
        mockingDetails(readTimestamps).isMock();
        mockingDetails(updateTimestamp).isMock();
        assertEquals(testRepo.getTimeStamps(0).get(0).getTimeStamp(), addTimestamp.getTimeStamp());
        assertEquals(testRepo.getTimeStamps(0).get(1).getTimeStamp(), readTimestamps.getTimeStamp());
        testRepo.update(0, newBrand);
        assertEquals(testRepo.getTimeStamps(0).get(2).getTimeStamp(), updateTimestamp.getTimeStamp());
    }

    @Rule
    public final ExpectedException except = ExpectedException.none();

    // test for timestamps toggle methods
    @Test
    public void testForToggleAddTimestampMethod(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        testRepo.toggleAddTimestamp();
        testRepo.create(brand);
        assertNull(testRepo.carBrands.get(0).getAddTimestamp());
    }

    @Test
    public void testForToggleReadTimestampMethod(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        testRepo.carBrands.add(brand);
        testRepo.toggleReadTimestamp();
        testRepo.read(0);
        testRepo.readAll();
        assertNull(testRepo.carBrands.get(0).getReadTimestamps());
    }
    @Test
    public void testForToggleUpdateTimestampMethod(){
        CarBrand brand = new CarBrand(0, "Volkswagen", 11);
        CarBrand newBrand = new CarBrand(1, "Audi", 22);
        testRepo.carBrands.add(brand);
        testRepo.toggleUpdateTimestamp();
        testRepo.update(0, newBrand);
        assertNull(testRepo.carBrands.get(0).getUpdateTimestamp());
    }
}

