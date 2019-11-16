package Komis.services;

import Komis.domain.CarBrand;
import Komis.domain.TimeStamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarBrandService {
    public ArrayList<CarBrand> carBrands;
    boolean addToggle = true;
    boolean readToggle = true;
    boolean updateToggle = true;

    public CarBrandService() {

    }

    public CarBrandService(ArrayList<CarBrand> carBrands) {
        this.carBrands = carBrands;
    }

    ArrayList<CarBrand> readAll() {
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if (readToggle) {
            for (CarBrand carBrand : carBrands) {
                carBrand.setReadTimestamps(timeStamp);
            }
        }
        return carBrands;
    }

    public ArrayList<CarBrand> create(CarBrand newBrand) {
        for (CarBrand carBrand : carBrands) {
            if (newBrand.getId() == carBrand.getId())
                throw new IllegalArgumentException("There is no brand with this Id");
        }
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setTimeStamp(LocalDate.now());
        if (addToggle) {
            newBrand.setAddTimestamp(timeStamp);
        }
        carBrands.add(newBrand);
        return carBrands;
    }

    public CarBrand read(int id) {
        TimeStamp timeStamp = new TimeStamp();
        for (CarBrand carBrand : carBrands) {
            if (carBrand.getId() == id) {
                timeStamp.setTimeStamp(LocalDate.now());
                if (readToggle) {
                    carBrand.setReadTimestamps(timeStamp);
                }
            }
            return carBrand;
        }
        throw new NoSuchElementException("No such brand Id in this database");
    }

    public CarBrand update(int id, CarBrand carBrand) {
        TimeStamp timeStamp = new TimeStamp();
        if (carBrand.getId() == id) {
            carBrands.set(id, carBrand);
            timeStamp.setTimeStamp(LocalDate.now());
            if (updateToggle) {
                carBrand.setUpdateTimestamp(timeStamp);
            }
            return carBrand;
        }
        throw new NoSuchElementException("There is no brand with this Id in the database");
    }

    public CarBrand delete(CarBrand carBrand) {
        if (carBrands.contains(carBrand)) {
            carBrands.remove(carBrand);
            return carBrand;
        }
        throw new NoSuchElementException("There is no such brand in database");
    }

    ArrayList<TimeStamp> getTimeStamps(int id) {
        ArrayList<TimeStamp> timeStampsList = new ArrayList<>();
        for (CarBrand carBrand : carBrands) {
            if (carBrand.getId() == id) {
                timeStampsList.add(carBrand.getAddTimestamp());
                timeStampsList.add(carBrand.getReadTimestamps());
                timeStampsList.add(carBrand.getUpdateTimestamp());
            }
        }
        return timeStampsList;
    }

    public void toggleAddTimestamp() {
        addToggle = false;
    }

    public void toggleReadTimestamp() {
        readToggle = false;
    }

    public void toggleUpdateTimestamp() {
        updateToggle = false;
    }


    public ArrayList<CarBrand> searchBrandByNameExpression(String expression) {
        ArrayList<CarBrand> searchedBrands = new ArrayList<>();
        for (CarBrand carBrand:carBrands){
            if (carBrand.getBrandName().regionMatches(true, 0, expression, 0, expression.length()));
            searchedBrands.add(carBrand);
        }
        return searchedBrands;
    }

    public ArrayList<CarBrand> removeBySystemList(ArrayList<Integer> list){
        ArrayList<CarBrand> removedBrands = new ArrayList<>();
        for (CarBrand carBrand : carBrands){
            for (int id : list){
                if (carBrand.getSystem_id()==id){
                    removedBrands.add(carBrand);
                }
            }
        }

        for (CarBrand carBrand: removedBrands){
            carBrands.remove(carBrand);
        }
        return removedBrands;
    }


}