// CAR MODEL RELATED THINGS TO BE FINISHED

package Komis.services;

import Komis.domain.CarModel;

import java.util.ArrayList;

public class CarModelServiceImpl {
    public static void main(String[] args){
        ArrayList<CarModel> carModels = new ArrayList<CarModel>();

        CarModelService modelRepo = new CarModelService(carModels);

        for (int i = 1; i<11 ; i++){
            Integer iString = new Integer(i);
            CarModel carModel = new CarModel(1, "A3", "1.8T", "Hatchback", "Gasoline" + iString.toString());
            modelRepo.create(carModel);
        }

        modelRepo.delete(3);
        modelRepo.update(5, new CarModel(5 ,"3", "2.0 SkyActiv", "Liftback", "Gasoline"));

        for (CarModel carModel:modelRepo.readAll()){
            System.out.print("Model id" +carModel.getId()
                    +", modelName:" +carModel.getModelName()
                    +", engineModel:" +carModel.getEngineModel()
                    +", bodyType:" +carModel.getBodyType()
                    +". fuelType:" +carModel.getFuelType());
        }

    }
}
