/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.employees;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Scrappy
 */
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String physicalAddress;
    private Integer postalAddress;
    private Integer postalCode;

    private Address() {
    }

    private Address(Builder build) {
        
        id = build.id;
        physicalAddress = build.physicalAddress;
        postalAddress = build.postalAddress;
        postalCode = build.postalCode;
    }
    
    public static class Builder{
        
        private Long id;
        private String physicalAddress;
        private Integer postalAddress;
        private Integer postalCode;
        
        public Builder(String phyAdd){
            this.physicalAddress = phyAdd;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder postalAddress(Integer postadd){
            postalAddress = postadd;
            return this;
        }
        
        public Builder postalCode(Integer postCode){
            postalCode = postCode;
            return this;
        }
        
        public Address build(){
            return new Address(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public Integer getPostalAddress() {
        return postalAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.employees.Address[ id=" + id + " ]";
    }
    
}
