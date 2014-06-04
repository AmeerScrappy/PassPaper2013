/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.tax;

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
public class Entries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal lowerBand;
    private BigDecimal upperBand;
    private int taxPercentRate;

    private Entries() {
    }

    private Entries(Builder build) {
        
        id = build.id;
        lowerBand = build.lowerBand;
        upperBand = build.upperBand;
        taxPercentRate = build.taxPercentRate;
    }
    
    private static class Builder{
        
        private Long id;
        private BigDecimal lowerBand;
        private BigDecimal upperBand;
        private int taxPercentRate;
        
        public Builder(BigDecimal lowBand){
            this.lowerBand = lowBand;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder upperBand(BigDecimal uppBand){
            upperBand = uppBand;
            return this;
        }
        
        public Builder taxPercentaRate(int taxpertarte){
            taxPercentRate = taxpertarte;
            return this;
        }
        
        public Entries build(){
            return new Entries(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public BigDecimal getLowerBand() {
        return lowerBand;
    }

    public BigDecimal getUpperBand() {
        return upperBand;
    }

    public int getTaxPercentRate() {
        return taxPercentRate;
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
        if (!(object instanceof Entries)) {
            return false;
        }
        Entries other = (Entries) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.tax.Entries[ id=" + id + " ]";
    }
    
}
