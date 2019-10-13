package Komis.services;

import Komis.domain.CarBrand;
import java.util.ArrayList;

public class CarBrandServiceImpl {

    public static void main(String[] args ){
        ArrayList<CarBrand> carBrands = new ArrayList<CarBrand>();

        CarBrandService brandRepo = new CarBrandService(carBrands);

        for (int i = 1; i < 11; i++){
            Integer iString = new Integer(i);
            CarBrand carBrand = new CarBrand(i, "Audi" + iString.toString());
            brandRepo.create(carBrand);
        }

        brandRepo.delete(5);
        brandRepo.update(8, new CarBrand(8, "Mazda"));

        for (CarBrand carBrand:brandRepo.readAll()){
            System.out.println("Brand id" +carBrand.getId()
                    + ", brandName:" + carBrand.getBrandName());
        }
    }
}
