package Komis.domain;

public class CarModel {

    private int id;
    private String modelName;
    private String engineModel;
    private String bodyType;
    private String fuelType;

    public CarModel(){

    }

    public CarModel(int id, String modelName, String engineModel, String bodyType, String fuelType){
        this.id = id;
        this.modelName = modelName;
        this.engineModel = engineModel;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

}
