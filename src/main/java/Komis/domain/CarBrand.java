package Komis.domain;

import java.util.Date;

public class CarBrand {
    private int id;
    private String brandName;
    private int system_id;
    private TimeStamp addTimestamp;
    private TimeStamp updateTimestamp;
    private TimeStamp readTimestamps;

    public CarBrand(){

    }

    public CarBrand(int id, String brandName, int system_id){
        this.id = id;
        this.brandName = brandName;
        this.id = system_id;
    }

    public CarBrand(int id, String brandName, int system_id, TimeStamp addTimestamp, TimeStamp updateTimestamp, TimeStamp readTimestamps){
        this.id = id;
        this.brandName = brandName;
        this.id = system_id;
        this.addTimestamp = addTimestamp;
        this.updateTimestamp = updateTimestamp;
        this.readTimestamps = readTimestamps;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getSystem_id() {
        return system_id;
    }

    public void setSystem_id(int system_id) {
        this.system_id = system_id;
    }

    public TimeStamp getAddTimestamp() {
        return addTimestamp;
    }

    public void setAddTimestamp(TimeStamp addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public TimeStamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(TimeStamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public TimeStamp getReadTimestamps() {
        return readTimestamps;
    }

    public void setReadTimestamps(TimeStamp readTimestamps) {
        this.readTimestamps = readTimestamps;
    }



}
