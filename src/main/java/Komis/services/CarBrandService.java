package Komis.services;

import Komis.domain.CarBrand;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarBrandService {
    private ArrayList<CarBrand> carBrands;


    public CarBrandService(){

    }

    public CarBrandService(ArrayList<CarBrand> carBrands){
        this.carBrands = carBrands;
        CarBrand brand1 = new CarBrand(0, "Volkswagen");
        carBrands.add(brand1);
    }

    public ArrayList<CarBrand>readAll(){
        return carBrands;
    }

    public ArrayList<CarBrand> create (CarBrand newBrand){
        for (CarBrand carBrand: carBrands){
            if(newBrand.getId()==carBrand.getId())
                throw  new IllegalArgumentException("There is no brand with this Id");
        }
        carBrands.add(newBrand);
        return carBrands;
    }

    public CarBrand read(int id){
        for (CarBrand carBrand: carBrands){
            if (carBrand.getId()==id)
                return carBrand;
        }
        throw new  NoSuchElementException("No such brand Id in this database");
    }

    public CarBrand update(int id, CarBrand carBrand) {
        if (carBrand.getId() == id) {
            carBrands.set(id, carBrand);
            return carBrand;
        }
        throw new NoSuchElementException("There is no brand with this Id in the database");
    }

    public CarBrand delete(int id){
        CarBrand carBrand = null;
        if((carBrand = read(id)) !=null){
            carBrands.remove(carBrand);
            return carBrand;
        }
        throw new  NoSuchElementException("There is no such brand in database");
    }
}
