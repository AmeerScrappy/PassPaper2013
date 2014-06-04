/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.test.repository;

import com.ameer.testweb.domain.employees.Address;
import com.ameer.testweb.domain.employees.Contact;
import com.ameer.testweb.domain.employees.Demographics;
import com.ameer.testweb.domain.employees.Employee;
import com.ameer.testweb.domain.employees.Identity;
import com.ameer.testweb.domain.employees.Names;
import com.ameer.testweb.repository.AddressRepository;
import com.ameer.testweb.repository.EmployeeRepository;
import com.ameer.testweb.repository.IdentityRepository;
import com.ameer.testweb.test.ConnectionConfigTest;
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
public class EmployeeRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private EmployeeRepository EmpRepo;
    private AddressRepository AddressRepo;
    private IdentityRepository IdentityRepo;
    
    public EmployeeRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createEmployee() {
         
         Names fullname = new Names.Builder("Ameer")
                 .lastname("Mallagie")
                 .build();
         Demographics demo = new Demographics.Builder("Male")
                 .race("Transparent")
                 .build();
         Contact contact = new Contact.Builder("0769594969")
                 .homeNum("0219527100")
                 .build();
         AddressRepo = ctx.getBean(AddressRepository.class);
         Address address = new Address.Builder("40 Someplace")
                 .postalCode(7650)
                 .build();
         AddressRepo.save(address);
//         IdentityRepo = ctx.getBean(IdentityRepository.class);
//         Identity identity = new Identity.Builder("Captain")
//                 .idValue("CAP213")
//                 .build();
//         IdentityRepo.save(identity);
//         identity doesnt seem to wanna work
         
         
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(1)
                 .name(fullname)
                 .demographics(demo)
                 .contact(contact)
                 .address(address)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         id = emp.getId();
     
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