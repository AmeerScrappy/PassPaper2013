/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.services.Impl;

import com.ameer.testweb.domain.employees.Employee;
import com.ameer.testweb.repository.EmployeeRepository;
import com.ameer.testweb.services.Question5Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class Question5ServiceImpl implements Question5Service{

    @Autowired
    EmployeeRepository EmployeeRepo;
    
    @Override
    public Employee getName(Integer employeeNumber) {
        
        List<Employee> es = findAll();
        Employee empFound = null;
        for (Employee e : es) {
            if(e.getEmployeeNumber() == employeeNumber)
                empFound = e;
            
        }
        return empFound;
    }

    @Override
    public Employee getDemographic(Integer employeeNumber) {
        
        List<Employee> es = findAll();
        Employee empFound = null;
        for (Employee e : es) {
            if(e.getEmployeeNumber() == employeeNumber)
                empFound = e;
            
        }
        return empFound;
    }

    @Override
    public Employee getContact(Integer employeeNumber) {
        List<Employee> es = findAll();
        Employee empFound = null;
        for (Employee e : es) {
            if(e.getEmployeeNumber() == employeeNumber)
                empFound = e;
            
        }
        return empFound;
    }

    @Override
    public Employee getAddress(Integer employeeNumber) {
        List<Employee> es = findAll();
        Employee empFound = null;
        for (Employee e : es) {
            if(e.getEmployeeNumber() == employeeNumber)
                empFound = e;
            
        }
        return empFound;
    }

    @Override
    public Employee find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee persist(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee merge(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Employee entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeRepo.findAll();
    }
    
}
