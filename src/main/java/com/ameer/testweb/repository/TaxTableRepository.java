/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.testweb.repository;

import com.ameer.testweb.domain.tax.TaxTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Scrappy
 */
@Repository
public interface TaxTableRepository extends JpaRepository<TaxTable, Long>{
    
}
