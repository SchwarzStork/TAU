package Komis.cucumber;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Komis.domain.CarBrand;
import Komis.services.CarBrandService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RemoveBrand {

    private int brands_number = 10;
    private CarBrandService testRepo = new CarBrandService(new ArrayList<>());
    private ArrayList<CarBrand> carBrandsList = new ArrayList<>();
    private ArrayList<CarBrand> searchedBrands;
    private ArrayList<CarBrand> searchedBrandsNotAudi = new ArrayList<>();

    @Given("create brands list")
    public void create_brands_list() {
        for (int i = 0; i < brands_number; i++) {
            CarBrand carBrand = new CarBrand(i, "Volkswagen" + Integer.toString(i),  100 + i);
            i++;
            CarBrand carBrand1 = new CarBrand(i, "Audi" + Integer.toString(i),  100 + i);
            carBrandsList.add(carBrand);
            carBrandsList.add(carBrand1);
        }
    }

    @When("brands added to database")
    public void brands_added_to_database() {
        for(CarBrand carBrand : carBrandsList){
            testRepo.create(carBrand);
        }
    }

    @When("There is Volkswagen")
    public void there_is_Volkswagen() {
        searchedBrands = testRepo.searchBrandByNameExpression("Volk");
    }

    @But("car name is not Audi")
    public void car_name_is_not_Audi() {
        for(CarBrand carBrand:searchedBrands){
            if(carBrand.getBrandName().contains("Audi"))
                break;
            searchedBrandsNotAudi.add(carBrand);
        }
    }

    @Then("remove this brand")
    public void remove_this_brand()
    {
        for(CarBrand carBrand:searchedBrandsNotAudi){
            testRepo.delete(carBrand);

        }
        assertEquals(brands_number-searchedBrandsNotAudi.size(), testRepo.carBrands.size());
    }
}
