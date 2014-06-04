/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.position;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Scrappy
 */
@Entity
public class Benefits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String benefitType;
    private BigDecimal benefitValue;

    private Benefits() {
    }

    private Benefits(Builder build) {
        
        id = build.id;
        benefitType = build.benefitType;
        benefitValue = build.benefitValue;
    }
    
    public static class Builder{
        
        private Long id;
        private String benefitType;
        private BigDecimal benefitValue;
        
        public Builder(String bType){
            this.benefitType = bType;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder benefitValue(BigDecimal bValue){
            benefitValue = bValue;
            return this;
        }
        
        public Benefits build(){
            return new Benefits(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public BigDecimal getBenefitValue() {
        return benefitValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benefits)) {
            return false;
        }
        Benefits other = (Benefits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.position.Benefits[ id=" + id + " ]";
    }
    
}
