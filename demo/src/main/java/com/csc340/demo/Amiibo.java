package com.csc340.demo;

public class Amiibo {
    public String name;
    public String gameSeries;
    public String type;

    public Amiibo(String name, String gameSeries, String type) {
        this.name = name;
        this.gameSeries = gameSeries;
        this.type = type;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getGameSeries() {return gameSeries;}

    public void setGameSeries(String gameSeries) {this.gameSeries = gameSeries;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

}
