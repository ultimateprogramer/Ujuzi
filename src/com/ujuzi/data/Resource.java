/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ujuzi.data;

import java.util.Vector;

/**
 *
 * @author Ahmed Maawy
 */
public class Resource {
    private String address;
    private String areaServed;
    private String contentID;
    private String city;
    private String cost;
    private String description;
    private String email;
    private String foundIn;
    private String isDropInCenter;
    private String isNational;
    private String languages;
    private String phoneLocal;
    private String phoneTollFree;
    private String populationServed;
    private String hours;
    private String state;
    private String title;
    private String website;
    private String zip;

    private String matchType;
    private String dist;
    private String webCode;
    private String dcAlliance;
    private String medicaID;
    private String medicare;
    private String privateInsurance;
    private String noInsurance;

    private Vector childResources;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaServed() {
        return areaServed;
    }

    public void setAreaServed(String areaServed) {
        this.areaServed = areaServed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoundIn() {
        return foundIn;
    }

    public void setFoundIn(String foundIn) {
        this.foundIn = foundIn;
    }

    public String getIsDropInCenter() {
        return isDropInCenter;
    }

    public void setIsDropInCenter(String isDropInCenter) {
        this.isDropInCenter = isDropInCenter;
    }

    public String getIsNational() {
        return isNational;
    }

    public void setIsNational(String isNational) {
        this.isNational = isNational;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getPhoneLocal() {
        return phoneLocal;
    }

    public void setPhoneLocal(String phoneLocal) {
        this.phoneLocal = phoneLocal;
    }

    public String getPhoneTollFree() {
        return phoneTollFree;
    }

    public void setPhoneTollFree(String phoneTollFree) {
        this.phoneTollFree = phoneTollFree;
    }

    public String getPopulationServed() {
        return populationServed;
    }

    public void setPopulationServed(String populationServed) {
        this.populationServed = populationServed;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDcAlliance() {
        return dcAlliance;
    }

    public void setDcAlliance(String dcAlliance) {
        this.dcAlliance = dcAlliance;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getMedicaID() {
        return medicaID;
    }

    public void setMedicaID(String medicaID) {
        this.medicaID = medicaID;
    }

    public String getMedicare() {
        return medicare;
    }

    public void setMedicare(String medicare) {
        this.medicare = medicare;
    }

    public String getNoInsurance() {
        return noInsurance;
    }

    public void setNoInsurance(String noInsurance) {
        this.noInsurance = noInsurance;
    }

    public String getPrivateInsurance() {
        return privateInsurance;
    }

    public void setPrivateInsurance(String privateInsurance) {
        this.privateInsurance = privateInsurance;
    }

    public String getWebCode() {
        return webCode;
    }

    public void setWebCode(String webCode) {
        this.webCode = webCode;
    }

    public Vector getChildResources() {
        return childResources;
    }

    public void setChildResources(Vector childCategories) {
        this.childResources = childCategories;
    }
}