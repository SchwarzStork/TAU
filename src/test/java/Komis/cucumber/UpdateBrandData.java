package Komis.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Komis.domain.CarBrand;
import Komis.services.CarBrandService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UpdateBrandData {
    private int brands_number = 10;
    private CarBrandService testRepo = new CarBrandService(new ArrayList<>());
    private ArrayList<CarBrand> brandsList = new ArrayList<>();
    private ArrayList<CarBrand> searchedBrands;
    private int id_to_update = 0;
    private String actualResponse = "";

    @Given("prepare brands list")
    public void prepare_brands_list() {
        for (int i = 1; i <= brands_number; i++) {
            CarBrand carBrand = new CarBrand(i, "Volkswagen"+ Integer.toString(i), 100 + i);
            i++;
            CarBrand carBrand1 = new CarBrand(i, "Audi" + Integer.toString(i),  100 + i);
            brandsList.add(carBrand);
            brandsList.add(carBrand1);
        }
    }

    @When("add brands to database")
    public void add_brands_to_database() {
        for(CarBrand carBrand : brandsList){
            testRepo.create(carBrand);
        }
    }

    @When("there is Audi")
    public void there_is_Audi() {
        searchedBrands = testRepo.searchBrandByNameExpression("Au");
    }

    @And("brand id is {string}")
    public void brand_id_is(String index) {
        int id = Integer.parseInt(index);
        for(CarBrand carBrand:searchedBrands){
            if(carBrand.getId()==id){
                actualResponse = "Updated";
                id_to_update = id;
                break;
            }
            actualResponse = "NotUpdates";
        }
    }

    @Then("update data of this Brand by new Brand {string}")
    public void update_data_of_this_Brand_by_new_Brand(String expectedResponse)
    {
        assertEquals(expectedResponse, actualResponse);
        CarBrand newCarBrand = new CarBrand(id_to_update, "Audi", 105);
        if(actualResponse.equals("Updated")){
            testRepo.toggleUpdateTimestamp();
            testRepo.update(id_to_update, newCarBrand);
            assertEquals(newCarBrand, testRepo.carBrands.get(id_to_update));
        }
    }

}
