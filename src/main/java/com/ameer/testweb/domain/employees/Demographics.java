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
public class Demographics {
    
    private String gender;
    private String race;

    private Demographics() {
    }

    private Demographics(Builder build) {
        
        gender = build.gender;
        race = build.race;
    }
    
    public static class Builder{
        
        private String gender;
        private String race;
        
        public Builder (String sex){
            this.gender = sex;
        }
        
        public Builder race(String ra){
            race = ra;
            return this;
        }
        
        public Demographics build(){
            return new Demographics(this);
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
