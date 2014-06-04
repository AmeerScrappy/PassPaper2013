/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.employees;

import javax.persistence.Embeddable;

/**
 *
 * @author Scrappy
 */
@Embeddable
public class Contact {
    
    private String cellNumber;
    private String homeNumber;

    private Contact() {
    }

    private Contact(Builder build) {
        cellNumber = build.cellNumber;
        homeNumber = build.homeNumber;
    }
    
    public static class Builder{
        
        private String cellNumber;
        private String homeNumber;
        
        public Builder (String num){
            this.cellNumber = num;
        }
        
        public Builder homeNum(String home){
            homeNumber = home;
            return this;
        }
        
        public Contact build(){
            return new Contact(this);
        }
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
