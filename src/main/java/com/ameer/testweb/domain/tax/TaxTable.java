/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.tax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Scrappy
 */
@Entity
public class TaxTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String years;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true) //AGGREGATION
    @JoinColumn(name = "taxtable_id")
    private List<Entries> entries;

    private TaxTable() {
    }

    private TaxTable(Builder build) {
        
        id = build.id;
        years = build.years;
    }
    
    public static class Builder{
        
        private Long id;
        private String years;
        private List<Entries> entries;
        
        public Builder(String yr){
            this.years = yr;
        }       
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder entities(List<Entries> entrieses){
            entries = entrieses;
            return this;
        }
        
        public TaxTable build(){
            return new TaxTable(this);
        }
    }

    public Long getId() {
        return id;
    }
    
    public String getYears() {
        return years;
    }

    public List<Entries> getEntries() {
        return entries;
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
        if (!(object instanceof TaxTable)) {
            return false;
        }
        TaxTable other = (TaxTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.tax.TaxTable[ id=" + id + " ]";
    }
    
}
