package com.example.android.quakereport;

/**
 * A custom class to represent earthquakes
 */

public class Earthquake {

    private String location;
    private long dateTime;
    private double magnitude;
    private String detailsURL;

    /**
     * Instantiates a new Earthquake.
     *
     * @param location  the location
     * @param dateTime  the date time
     * @param magnitude the magnitude
     */
    public Earthquake(String location, long dateTime, double magnitude, String detailsURL) {
        this.location = location;
        this.dateTime = dateTime;
        this.magnitude = magnitude;
        this.detailsURL = detailsURL;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public long getDateTime() {
        return dateTime;
    }

    /**
     * Sets date time.
     *
     * @param dateTime the date time
     */
    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets magnitude.
     *
     * @return the magnitude
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * Sets magnitude.
     *
     * @param magnitude the magnitude
     */
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Gets details url.
     *
     * @return the details url
     */
    public String getDetailsURL() {
        return detailsURL;
    }

    /**
     * Sets details url.
     *
     * @param detailsURL the details url
     */
    public void setDetailsURL(String detailsURL) {
        this.detailsURL = detailsURL;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "location='" + location + '\'' +
                ", dateTime=" + dateTime +
                ", magnitude=" + magnitude +
                ", detailsURL='" + detailsURL + '\'' +
                '}';
    }
}
