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
import com.ameer.testweb.domain.employees.Identities;
import com.ameer.testweb.domain.employees.Names;
import com.ameer.testweb.domain.employees.PaySlip;
import com.ameer.testweb.domain.position.Benefits;
import com.ameer.testweb.domain.position.Deductions;
import com.ameer.testweb.domain.position.Job;
import com.ameer.testweb.domain.position.Position;
import com.ameer.testweb.domain.position.Salary;
import com.ameer.testweb.repository.AddressRepository;
import com.ameer.testweb.repository.BenefitsRepository;
import com.ameer.testweb.repository.DeductionsRepository;
import com.ameer.testweb.repository.EmployeeRepository;
import com.ameer.testweb.repository.IdentitiesRepository;
import com.ameer.testweb.repository.JobRepository;
import com.ameer.testweb.repository.PaySlipRepository;
import com.ameer.testweb.repository.PositionRepository;
import com.ameer.testweb.repository.SalaryRepository;
import com.ameer.testweb.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
    private IdentitiesRepository IdentityRepo;
    private PaySlipRepository PaySlipRepo;
    private PositionRepository PositionRepo;
    private JobRepository JobRepo;
    private DeductionsRepository DeductionsRepo;
    private SalaryRepository SalaryRepo;
    private BenefitsRepository BenefitsRepo;
    
    public EmployeeRepositoryTest() {
    }
    
     @Test
     public void createEmployee() {
         
         List<Identities> ids = new ArrayList<>();
         List<PaySlip> slips = new ArrayList<>();
         List<Position> ps = new ArrayList<>();
         List<Deductions> ds = new ArrayList<>();
         List<Benefits> b = new ArrayList<>();
         
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
         
         IdentityRepo = ctx.getBean(IdentitiesRepository.class);
         Identities identity = new Identities.Builder("Captain")
                 .idValue("CAP213")
                 .build();
         Identities identities = new  Identities.Builder("Superhero")
                 .idValue("BAT312")
                 .build();
         ids.add(identity);
         ids.add(identities);
         IdentityRepo.save(identity);
         IdentityRepo.save(identities);
         
         PaySlipRepo = ctx.getBean(PaySlipRepository.class);
         PaySlip paySlip = new PaySlip.Builder(BigDecimal.valueOf(20000.00))
                 .netPay(BigDecimal.valueOf(15000.00))
                 .build();
         slips.add(paySlip);
         
//         Long idd = paySlip.getId();
//         
//         PaySlip obj = PaySlipRepo.findOne(idd);
//         PaySlipRepo.delete(obj);
         
         BenefitsRepo = ctx.getBean(BenefitsRepository.class);
         Benefits benefits = new Benefits.Builder("Lunch Money")
                 .benefitValue(BigDecimal.valueOf(250.00))
                 .build();
         BenefitsRepo.save(benefits);
         b.add(benefits);
         
         SalaryRepo = ctx.getBean(SalaryRepository.class);
         Salary salary = new Salary.Builder(BigDecimal.valueOf(15000.00))
                 .build();
         SalaryRepo.save(salary);
         
         DeductionsRepo = ctx.getBean(DeductionsRepository.class);
         Deductions deductions = new Deductions.Builder("Medical Aid")
                 .deductValue(BigDecimal.valueOf(350.00))
                 .build();
         DeductionsRepo.save(deductions);
         ds.add(deductions);
         
         PositionRepo = ctx.getBean(PositionRepository.class);
         Position position = new Position.Builder("PRM")
                 .status("Close")
                 .benefit(b)
                 .deduction(ds)
                 .salary(salary)
                 .build();
         PositionRepo.save(position);
         ps.add(position);
         
         JobRepo = ctx.getBean(JobRepository.class);
         Job job = new Job.Builder("Programmer")
                 .positions(ps)
                 .build();
         JobRepo.save(job);
         
         
         EmpRepo = ctx.getBean(EmployeeRepository.class);
         Employee emp = new Employee.Builder(1)
                 .name(fullname)
                 .demographics(demo)
                 .contact(contact)
                 .address(address)
                 .paySlips(slips)
                 .identity(ids)
                 .position(position)
                 .numOfDependants(2)
                 .build();
         EmpRepo.save(emp);
         id = emp.getId();
         
         PaySlipRepo = ctx.getBean(PaySlipRepository.class);
         PaySlip newpaySlip = new PaySlip.Builder(BigDecimal.valueOf(20000.00))
                 .netPay(BigDecimal.valueOf(15000.00))
                 .employee(emp)
                 .build();
         PaySlipRepo.save(newpaySlip);
     
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
