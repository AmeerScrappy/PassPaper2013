/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.services;

import com.ameer.testweb.domain.employees.Employee;

/**
 *
 * @author Scrappy
 */
public interface Question6Service extends Services <Employee, Long>{
    
    public Employee getIdentity(Integer employeeNumber);
    
}
