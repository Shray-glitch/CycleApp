package com.example.cyrent.Model;

public class CycleDetailUserData {
    String CycleBrandData;
    boolean  GearData;
    boolean  MudGuardData;
    boolean  BellData;
    boolean  CarrierData;



    public CycleDetailUserData(String cycleBrandData, boolean gearData,  boolean mudGuardData, boolean bellData, boolean carrierData) {
        CycleBrandData = cycleBrandData;
        GearData = gearData;
        MudGuardData = mudGuardData;
        BellData = bellData;
        CarrierData = carrierData;
    }

    public String getCycleBrandData() {
        return CycleBrandData;
    }

    public void setCycleBrandData(String cycleBrandData) {
        CycleBrandData = cycleBrandData;
    }



    public boolean isGearData() {
        return GearData;
    }

    public void setGearData(boolean gearData) {
        GearData = gearData;
    }





    public boolean isMudGuardData() {
        return MudGuardData;
    }

    public void setMudGuardData(boolean mudGuardData) {
        MudGuardData = mudGuardData;
    }

    public boolean isBellData() {
        return BellData;
    }

    public void setBellData(boolean bellData) {
        BellData = bellData;
    }

    public boolean isCarrierData() {
        return CarrierData;
    }

    public void setCarrierData(boolean carrierData) {
        CarrierData = carrierData;
    }
}
