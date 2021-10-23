package com.example.HomeDorkWebApp.service;

import com.example.HomeDorkWebApp.apiRepo.DevicesUserRepo;
import com.example.HomeDorkWebApp.model.Fan;
import com.example.HomeDorkWebApp.model.Lamp;
import com.example.HomeDorkWebApp.model.State;

import java.util.List;

public class DeviceService {

    private DevicesUserRepo devicesUserRepo ;

    public List<Lamp> listLamps(String Uuid){

        List<Lamp> lamps= devicesUserRepo.getLamb(Uuid);
return lamps;

    }
    public List<Fan> listFans(String Uuid){

        List<Fan> fans= devicesUserRepo.getFan(Uuid);
        return fans;

    }

    public double changeFanValue( String ID, double level){
        double fanLevel=devicesUserRepo.changeValueFan(ID,level);
        return fanLevel;
    }
    public double changeLampValue( String ID, double level){
        double lampLevel=devicesUserRepo.changeValueLamp(ID,level);
        return lampLevel;
    }

    public State lampON(String ID){
        State ON=devicesUserRepo.turnOnLamp(ID);
        return ON;
    }

    public State fanON(String ID){
        State onFan=devicesUserRepo.turnOnFan(ID);
        return onFan;
    }

    public State lampOF(String ID){
        State ofLamp=devicesUserRepo.turnOfLamp(ID);
        return ofLamp;
    }
    public State fanOF(String ID){
        State ofFan=devicesUserRepo.turnOfFan(ID);
        return ofFan;
    }





}
