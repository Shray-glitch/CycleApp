package com.example.cyrent;

public class CycleDetailUserData {
    String CycleBrandData;
    String CycleAgeData;
    boolean  GearData;
    boolean  BottleHolderData;
    boolean  HeadLightData;
    boolean  MudGuardData;
    boolean  BellData;
    boolean  CarrierData;



    public CycleDetailUserData(String cycleBrandData, String cycleAgeData, boolean gearData, boolean bottleHolderData, boolean headLightData, boolean mudGuardData, boolean bellData, boolean carrierData) {
        CycleBrandData = cycleBrandData;
        CycleAgeData = cycleAgeData;
        GearData = gearData;
        BottleHolderData = bottleHolderData;
        HeadLightData = headLightData;
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

    public String getCycleAgeData() {
        return CycleAgeData;
    }

    public void setCycleAgeData(String cycleAgeData) {
        CycleAgeData = cycleAgeData;
    }

    public boolean isGearData() {
        return GearData;
    }

    public void setGearData(boolean gearData) {
        GearData = gearData;
    }

    public boolean isBottleHolderData() {
        return BottleHolderData;
    }

    public void setBottleHolderData(boolean bottleHolderData) {
        BottleHolderData = bottleHolderData;
    }

    public boolean isHeadLightData() {
        return HeadLightData;
    }

    public void setHeadLightData(boolean headLightData) {
        HeadLightData = headLightData;
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
