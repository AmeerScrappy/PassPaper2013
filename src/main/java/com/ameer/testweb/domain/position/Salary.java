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
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal baseSalary;

    private Salary() {
    }

    private Salary(Builder build) {
        
        id = build.id;
        baseSalary = build.baseSalary;
    }
    
    public static class Builder{
        
        private Long id;
        private BigDecimal baseSalary;
        
        public Builder(BigDecimal bSal){
            this.baseSalary = bSal;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Salary build(){
            return new Salary(this);
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
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
        if (!(object instanceof Salary)) {
            return false;
        }
        Salary other = (Salary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.position.Salary[ id=" + id + " ]";
    }
    
}
