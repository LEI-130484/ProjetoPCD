package iscot.events;

import iscot.Area;

public class Event {

    private Area area;
    private String deviceId;
    private long timpestamp;
    
    public Area getArea(){
        return area;
    }

    public void setArea(Area area){
        this.area = area;
    }

    public String getDeviceId(){
        return deviceId;
    }

    public void setDevideId(String deviceId){
        this.deviceId=deviceId;
    }

    public long getTimpestamp(){
        return getTimpestamp();
    }

    public void setTimestamp(long timestamp){
        this.timpestamp=timestamp;
    }
    
}
