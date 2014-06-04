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
public class Names {
    
    private String firstName;
    private String lastName;

    private Names() {
    }

    private Names(Builder build) {
        
        firstName = build.firstName;
        lastName = build.lastName;
    }
    
    public static class Builder{
        
        private String firstName;
        private String lastName;
        
        public Builder(String name){
            this.firstName = name;
        }
        
        public Builder lastname(String surname){
            lastName = surname;
            return this;
        }
        
        public Names build(){
            return new Names(this);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
