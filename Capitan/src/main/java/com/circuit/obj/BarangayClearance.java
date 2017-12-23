/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.obj;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marvin
 */
public class BarangayClearance {
    
    int id;
    String fullname;
    String surname;
    String firstName;
    String middleName;
    String gender;
    String birthDate;
    int control_no;
    String current_date;
    int age;
    String citizenship;
    String address;
    String barangay;
    String city;
    String remarks;
    int amountPaid;
    int amountChange;
    int regCost;
    int regVat;
    byte[] profileImage;
    
    
    private Map<String,Object> data = new HashMap<String,Object>();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.data.put("SURNAME", surname);
        this.surname = surname ;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.data.put("FIRSTNAME", firstName);
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.data.put("MIDDLENAME", middleName);
          this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.data.put("GENDER", gender);
        this.gender = gender;
    }

   

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.data.put("BIRTHDATE", birthDate);
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.data.put("AGE", age);
        this.age = age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.data.put("CITIZENSHIP", citizenship);
        this.citizenship = citizenship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.data.put("ADDRESS", address);
        this.address = address;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.data.put("BARANGAY", barangay);
        this.barangay = barangay;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.data.put("CITY", city);
        this.city = city;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.data.put("REMARKS", remarks);
        this.remarks = remarks;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.data.put("AMOUNT_PAID", amountPaid);
        this.amountPaid = amountPaid;
    }

    public int getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(int amountChange) {
        this.data.put("AMOUNT_CHANGE", amountChange);
        this.amountChange = amountChange;
    }

    public int getRegCost() {
        return regCost;
    }

    public void setRegCost(int regCost) {
        this.data.put("REG_COST",   regCost);
        this.regCost = regCost;
    }

    public int getRegVat() {
        return regVat;
    }

    public void setRegVat(int regVat) {
        this.data.put("REG_VAT", regVat);
        this.regVat = regVat;
    }

    public int getControl_no() {
        return control_no;
    }

    public void setControl_no(int control_no) {
          this.data.put("CONTROL_NO", control_no);
        this.control_no = control_no++;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
          this.data.put("CURRENT_DATE", current_date);
       this.current_date = current_date;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.data.put("PROFILE_IMAGE", profileImage);
        this.profileImage = profileImage;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    
    
    
    
    
     
    
     public Map<String,Object> getData()
    {
        
        return data;
    }
    
    
    
    
}
