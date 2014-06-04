/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.employees;

import com.ameer.testweb.domain.position.Position;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer numberOfDependants;
    private Integer employeeNumber;
    @Embedded 
    private Names name;
    @Embedded
    private Demographics demographics;
    @Embedded
    private Contact contactInfo;
    @JoinColumn(name = "employee_id")
    @OneToMany
    private List<Identities> identities = new ArrayList<>();
    @OneToOne
    private Address address;
    @OneToMany//(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<PaySlip> paySlips = new ArrayList<>();
    @OneToOne
    private Position position;

    private Employee(){
        
    }
    private Employee(Builder build) {
        id = build.id;
        numberOfDependants = build.numberOfDependants;
        employeeNumber = build.employeeNumber;
        name = build.name;
        demographics = build.demographics;
        contactInfo = build.contactInfo;
        identities = build.identities;
        address = build.address;
        paySlips = build.paySlips;
        position = build.position;
    }
    
    public static class Builder{
        
        private Long id;
        private Integer numberOfDependants;
        private Integer employeeNumber;
        private Names name;
        private Demographics demographics;
        private Contact contactInfo;
        private List<Identities> identities;
        private Address address;
        private List<PaySlip> paySlips;
        private Position position;

        public Builder(Integer empnumber){
            this.employeeNumber = empnumber;
        }
        
        public Builder id(Long empID){
            id = empID;
            return this;
        }
        
        public Builder numOfDependants(Integer numDep){
            numberOfDependants = numDep;
            return this;
        }
        
        public Builder name(Names nm){
            name = nm;
            return this;
        }
        
        public Builder demographics(Demographics demo){
            demographics = demo;
            return this;
        }
        
        public Builder contact(Contact contact){
            contactInfo = contact;
            return this;
        }
        
        public Builder identity (List<Identities> identitys){
            identities = identitys;
            return this;
        }
        
        public Builder address(Address add){
            address = add;
            return this;
        }
        
        public Builder paySlips(List<PaySlip> slips){
            paySlips = slips;
            return this;
        }
        
        public Builder position(Position p){
            position = p;
            return this;
        }
        
        public Employee build(){
            return new Employee(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Integer getNumberOfDependants() {
        return numberOfDependants;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public Names getName() {
        return name;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public List<Identities> getIdentities() {
        return identities;
    }

    public List<PaySlip> getPaySlips() {
        return paySlips;
    }

    public Position getPosition() {
        return position;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    public Address getAddress() {
        return address;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.Employee[ id=" + id + " ]";
    }
    
}
