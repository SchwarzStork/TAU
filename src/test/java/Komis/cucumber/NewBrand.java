package Komis.cucumber;

import Komis.domain.CarBrand;
import Komis.services.CarBrandService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NewBrand {

    private CarBrand carBrand;
    private CarBrandService repo = new CarBrandService(new ArrayList<>());

    @Given("Create New Brand")
    public void create_new_brand(){
        carBrand = new CarBrand(6, "Suzuki", 17);
    }

    @When("Brand has been created")
    public void brand_has_been_created(){
        repo.toggleAddTimestamp();
        repo.create(carBrand);
    }

    @Then("Brand has been added to database")
    public void brand_has_been_added_to_database(){
        repo.toggleReadTimestamp();
        assertEquals(carBrand, repo.read(6));
    }

}
