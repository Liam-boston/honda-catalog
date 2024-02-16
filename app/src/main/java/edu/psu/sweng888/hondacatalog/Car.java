package edu.psu.sweng888.hondacatalog;

import java.io.Serializable;

public class Car implements Serializable {
    public String make;
    public String model;
    public Integer year;
    public Integer mileage;
    public Integer valuation;
    public Integer numPrevOwners;

    public Car(String make, String model, Integer year, Integer mileage, Integer valuation, Integer numPrevOwners) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.valuation = valuation;
        this.numPrevOwners = numPrevOwners;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getValuation() {
        return valuation;
    }

    public void setValuation(Integer valuation) {
        this.valuation = valuation;
    }

    public Integer getNumPrevOwners() {
        return numPrevOwners;
    }

    public void setNumPrevOwners(Integer numPrevOwners) {
        this.numPrevOwners = numPrevOwners;
    }

    @Override
    public String toString() {
        return (this.year + " " + this.make + " " + this.model);
    }
}
