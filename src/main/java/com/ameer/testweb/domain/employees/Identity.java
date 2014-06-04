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
public class Identity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idType;
    private String idValue;

    private Identity(){

    }

    private Identity(Builder build) {
        
        id = build.id;
        idType = build.idType;
        idValue = build.idValue;
    }
    
    public static class Builder{
        
        private Long id;
        private String idType;
        private String idValue;
        
        public Builder(String idT){
            this.idType = idT;
        }
        
        public Builder id (Long idID){
            id = idID;
            return this;
        }
        
        public Builder idType(String idT){
            idType = idT;
            return this;
        }
        
        public Builder idValue(String idVal){
            idValue = idVal;
            return this;
        }
        
        public Identity build(){
            return new Identity(this);
        }
        
    }
    
    public Long getId() {
        return id;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdValue() {
        return idValue;
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
        if (!(object instanceof Identity)) {
            return false;
        }
        Identity other = (Identity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.employees.Identity[ id=" + id + " ]";
    }
    
}
