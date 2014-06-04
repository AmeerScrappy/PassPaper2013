/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.test.services;

import com.ameer.testweb.domain.employees.Address;
import com.ameer.testweb.domain.employees.Contact;
import com.ameer.testweb.domain.employees.Demographics;
import com.ameer.testweb.domain.employees.Employee;
import com.ameer.testweb.domain.employees.Names;
import com.ameer.testweb.repository.AddressRepository;
import com.ameer.testweb.repository.EmployeeRepository;
import com.ameer.testweb.services.Impl.Question5ServiceImpl;
import com.ameer.testweb.test.ConnectionConfigTest;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Scrappy
 */
public class Question5ServiceImplTest {
    
    private static ApplicationContext ctx;
    private Question5ServiceImpl serviceImpl;
    private EmployeeRepository EmpRepo;
    private AddressRepository AddressRepo;
    
    public Question5ServiceImplTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testName() {
         serviceImpl = ctx.getBean(Question5ServiceImpl.class);
         
         Names fullname = new Names.Builder("Ameer")
                 .lastname("Mallagie")
                 .build();
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(2)
                 .name(fullname)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         
         Employee employee = serviceImpl.getName(2);
         
         Assert.assertEquals("Ameer", employee.getName().getFirstName());
     }
     
     @Test
     public void testdemo() {
         serviceImpl = ctx.getBean(Question5ServiceImpl.class);
         
         Demographics demo = new Demographics.Builder("Male")
                 .race("Transparent")
                 .build();
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(2)
                 .demographics(demo)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         
         Employee employee = serviceImpl.getName(2);
         
         Assert.assertEquals("Transparent", employee.getDemographics().getRace());
     }
     
     @Test
     public void testContact() {
         serviceImpl = ctx.getBean(Question5ServiceImpl.class);
         
         Contact contact = new Contact.Builder("0769594969")
                 .homeNum("0219527100")
                 .build();
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(2)
                 .contact(contact)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         
         Employee employee = serviceImpl.getName(2);
         
         Assert.assertEquals("0769594969", employee.getContactInfo().getCellNumber());
     }
     
     @Test
     public void testAdress() {
         serviceImpl = ctx.getBean(Question5ServiceImpl.class);
         
         AddressRepo = ctx.getBean(AddressRepository.class);
         Address address = new Address.Builder("40 Someplace")
                 .postalCode(7650)
                 .build();
         AddressRepo.save(address);
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(2)
                 .address(address)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         
         Employee employee = serviceImpl.getName(2);
         
         Assert.assertEquals("40 Someplace", employee.getAddress().getPhysicalAddress());
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
