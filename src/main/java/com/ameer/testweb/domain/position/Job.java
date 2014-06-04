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

/**
 *
 * @author Scrappy
 */
@Entity
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobTitle;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "job_id")
    private List<Position> positions;

    private  Job() {
    }

    private Job(Builder build) {
        
        id = build.id;
        jobTitle = build.jobTitle;
        positions =build.positions;
    }
    
    public static class Builder{
        
        private Long id;
        private String jobTitle;
        private List<Position> positions;
        
        public Builder(String jTitle){
            this.jobTitle = jTitle;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder positions(List<Position> ps){
            positions = ps;
            return this;
        }
        
        public Job build(){
            return new Job(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public List<Position> getPositions() {
        return positions;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ameer.testweb.position.Job[ id=" + id + " ]";
    }
    
}
