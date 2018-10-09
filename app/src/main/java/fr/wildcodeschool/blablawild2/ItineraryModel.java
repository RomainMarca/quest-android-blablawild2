package fr.wildcodeschool.blablawild2;

import java.util.Date;

/**
 * Created by bastienwcs on 15/04/18.
 */

public class ItineraryModel {

    private String departure;
    private String destination;
    private String driver;
    private Date date;
    private int price;

    public ItineraryModel(String departure, String destination, String driver, Date date, int price) {
        this.departure = departure;
        this.destination = destination;
        this.driver = driver;
        this.date = date;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDriver() {
        return driver;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public ItineraryModel() {}


}
