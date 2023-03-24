package com.wny2023.tp01parkappv2;

public class ItemRecycler {
    //공원명, 주요시설, 주요식물, 이미지, 공원주소, 사이트주소

    String parkName, addrPark, parkEquip, parkPlant;
    String imgPark;
    String urlSite;

    public ItemRecycler(String parkName, String addrPark, String parkEquip, String parkPlant, String imgPark, String urlSite) {
        this.parkName = parkName;
        this.addrPark = addrPark;
        this.parkEquip = parkEquip;
        this.parkPlant = parkPlant;
        this.imgPark = imgPark;
        this.urlSite = urlSite;
    }

    public ItemRecycler() {
    }
}
