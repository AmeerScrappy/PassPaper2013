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
public class Deductions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String deductionType;
    private BigDecimal deductionValue;

    private Deductions() {
    }

    private Deductions(Builder build) {
        
        id = build.id;
        deductionType = build.deductionType;
        deductionValue = build.deductionValue;
    }

    public static class Builder{
        
        private Long id;
        private String deductionType;
        private BigDecimal deductionValue;
        
        public Builder(String dType){
            this.deductionType = dType;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder deductValue(BigDecimal dValue){
            deductionValue = dValue;
            return this;
        }
        
        public Deductions build(){
            return new Deductions(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getDeductionType() {
        return deductionType;
    }

    public BigDecimal getDeductionValue() {
        return deductionValue;
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
        if (!(object instanceof Deductions)) {
            return false;
        }
        Deductions other = (Deductions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.position.Deductions[ id=" + id + " ]";
    }
    
}
