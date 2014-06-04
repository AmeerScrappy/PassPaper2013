/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.position;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Scrappy
 */
@Entity
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String positionCode;
    private String status;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "posistion_id")
    private List<Deductions> deductions;
    @OneToOne
    private Salary salary;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "posistion_id")
    private List<Benefits> benefits;

    private Position() {
    }

    private Position(Builder build) {
        
        id = build.id;
        positionCode = build.positionCode;
        status = build.status;
        deductions = build.deductions;
        salary = build.salary;
        benefits = build.benefits;
    }
    
    public static class Builder{
        
        private Long id;
        private String positionCode;
        private String status;
        private List<Deductions> deductions;
        private Salary salary;
        private List<Benefits> benefits;
        
        public Builder(String posCode){
            this.positionCode = posCode;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder status(String stat){
            status = stat;
            return this;
        }
        
        public Builder deduction(List<Deductions> d){
            deductions = d;
            return this;
        }
        
        public Builder salary(Salary s){
            salary = s;
            return this;
        }
        public Builder benefit(List<Benefits> b){
            benefits = b;
            return this;
        }
        
        public Position build(){
            return new Position(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getStatus() {
        return status;
    }

    public List<Deductions> getDeductions() {
        return deductions;
    }

    public Salary getSalary() {
        return salary;
    }

    public List<Benefits> getBenefits() {
        return benefits;
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.position.Position[ id=" + id + " ]";
    }
    
}
