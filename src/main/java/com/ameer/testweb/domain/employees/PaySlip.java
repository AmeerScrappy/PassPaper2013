/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.domain.employees;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Scrappy
 */
@Entity
public class PaySlip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal grossPay;
    private BigDecimal totalDeductions;
    private BigDecimal totalTax;
    private BigDecimal netPay;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date payDate;
    
    private PaySlip() {
    }

    private PaySlip(Builder build) {
        
        id = build.id;
        grossPay = build.grossPay;
        totalDeductions = build.totalDeductions;
        totalTax = build.totalTax;
        netPay = build.netPay;
        payDate = build.payDate;
    }
    
    public static class Builder{
        
        private Long id;
        private BigDecimal grossPay;
        private BigDecimal totalDeductions;
        private BigDecimal totalTax;
        private BigDecimal netPay;
        private Date payDate;
        
        public Builder (BigDecimal gPay){
            this.grossPay = gPay;
        }
        
        public Builder id (Long i){
            id = i;
            return this;                    
        }
        
        public Builder totalDeduction(BigDecimal tDeduct){
            totalDeductions = tDeduct;
            return this;
        }
        
        public Builder totalTax (BigDecimal tTax){
            totalTax = tTax;
            return this;
        }
        
        public Builder netPay(BigDecimal nPay){
            netPay = nPay;
            return this;
        }
        
        public Builder payDate(Date pDate){
            payDate = pDate;
            return this;
        }

        public PaySlip build(){
            return new PaySlip(this);
        }
    }
    

    
    public Long getId() {
        return id;
    }

    public BigDecimal getGrossPay() {
        return grossPay;
    }

    public BigDecimal getTotalDeductions() {
        return totalDeductions;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getNetPay() {
        return netPay;
    }

    public Date getPayDate() {
        return payDate;
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
        if (!(object instanceof PaySlip)) {
            return false;
        }
        PaySlip other = (PaySlip) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.domain.employees.PaySlip[ id=" + id + " ]";
    }
    
}
