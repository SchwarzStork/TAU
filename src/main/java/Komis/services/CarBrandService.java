package Komis.services;

import Komis.domain.CarBrand;
import Komis.domain.TimeStamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarBrandService {
    ArrayList<CarBrand> carBrands;
    boolean addToggle = true;
    boolean readToggle = true;
    boolean updateToggle = true;

    public CarBrandService(){

    }

    public CarBrandService(ArrayList<CarBrand> carBrands){
        this.carBrands = carBrands;
    }

    ArrayList<CarBrand>readAll(){
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if (readToggle){
            for (CarBrand carBrand: carBrands){
                carBrand.setReadTimestamps(timeStamp);
            }
        }
        return carBrands;
    }

    ArrayList<CarBrand> create (CarBrand newBrand){
        for (CarBrand carBrand: carBrands){
            if(newBrand.getId()==carBrand.getId())
                throw  new IllegalArgumentException("There is no brand with this Id");
        }
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if (addToggle){
            newBrand.setAddTimestamp(timeStamp);
        }
        carBrands.add(newBrand);
        return carBrands;
    }

    CarBrand read(int id){
        TimeStamp timeStamp = new TimeStamp();
        for (CarBrand carBrand: carBrands){
            if (carBrand.getId()==id){
                timeStamp.setTimeStamp(LocalDate.now());
                if (readToggle){
                    carBrand.setReadTimestamps(timeStamp);
                }
            }
                return carBrand;
        }
        throw new  NoSuchElementException("No such brand Id in this database");
    }

     CarBrand update(int id, CarBrand carBrand) {
        TimeStamp timeStamp = new TimeStamp();
        if (carBrand.getId() == id) {
            carBrands.set(id, carBrand);
            timeStamp.setTimeStamp(LocalDate.now());
            if (updateToggle){
                carBrand.setUpdateTimestamp(timeStamp);
            }
            return carBrand;
        }
        throw new NoSuchElementException("There is no brand with this Id in the database");
    }

    CarBrand delete(CarBrand carBrand){
        if (carBrands.contains(carBrand)){
            carBrands.remove(carBrand);
            return carBrand;
        }
        throw new  NoSuchElementException("There is no such brand in database");
    }

    ArrayList<TimeStamp> getTimeStamps(int id){
        ArrayList<TimeStamp> timeStampsList = new ArrayList<>();
        for (CarBrand carBrand: carBrands){
            if (carBrand.getId()==id){
                timeStampsList.add(carBrand.getAddTimestamp());
                timeStampsList.add(carBrand.getReadTimestamps());
                timeStampsList.add(carBrand.getUpdateTimestamp());
            }
        }
        return  timeStampsList;
    }

    void toggleAddTimestamp(){
        addToggle = false;
    }

    void toggleReadTimestamp(){
        readToggle = false;
    }

    void toggleUpdateTimestamp(){
        updateToggle = false;
    }
}
