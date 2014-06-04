/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.test.services;

import com.ameer.testweb.domain.employees.Employee;
import com.ameer.testweb.domain.employees.Identities;
import com.ameer.testweb.repository.EmployeeRepository;
import com.ameer.testweb.repository.IdentitiesRepository;
import com.ameer.testweb.services.Impl.Question6ServiceImpl;
import com.ameer.testweb.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Scrappy
 */
public class Question6ServiceImplTest {
    
    private static ApplicationContext ctx;
    private Question6ServiceImpl serviceImpl;
    private EmployeeRepository EmpRepo;
    private IdentitiesRepository IdentityRepo;
    List<Identities> ids = new ArrayList<>();
    
    public Question6ServiceImplTest() {
    }
    
     @Test
     public void testIdentity() {
         serviceImpl = ctx.getBean(Question6ServiceImpl.class);
         IdentityRepo = ctx.getBean(IdentitiesRepository.class);
         Identities identity = new Identities.Builder("Captain")
                 .idValue("CAP213")
                 .build();
         IdentityRepo.save(identity);
         ids.add(identity);
              
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(2)
                 .identity(ids)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         
         Employee employee = serviceImpl.getIdentity(2);
         String sd = employee.getIdentities().get(0).getIdType();
         Assert.assertEquals("Captain", sd);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
