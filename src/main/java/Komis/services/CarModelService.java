package Komis.services;

import Komis.domain.CarModel;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CarModelService {
    private ArrayList<CarModel> carModels;

    public CarModelService(){

    }

    public CarModelService(ArrayList<CarModel> carModels){
        this.carModels = carModels;
        CarModel model1 = new CarModel(1, "Golf", "1.9 TDI", "Hatchback", "Diesel");
        carModels.add(model1);
    }

    public ArrayList<CarModel>readAll(){
        return carModels;
    }

    public ArrayList<CarModel> create (CarModel newModel){
        for(CarModel carModel: carModels){
            if (newModel.getId()==carModel.getId())
                throw new IllegalArgumentException("There is no model with this Id");
        }
        carModels.add(newModel);
        return carModels;
    }

    public CarModel read(int id){
        for (CarModel carModel: carModels){
            if (carModel.getId()==id)
                return carModel;
        }
        throw new NoSuchElementException("There is no such model Id in database");
    }

    public CarModel update(int id, CarModel carModel){
        if (carModel.getId()==id){
            carModels.set(id, carModel);
            return carModel;
        }
        throw new NoSuchElementException("There is no model with this Id in database");
    }

    public CarModel delete(int id){
        CarModel carModel = null;
        if ((carModel = read(id)) != null){
            carModels.remove(carModel);
            return carModel;
        }
        throw new NoSuchElementException("there is no such model in database");
    }
}
