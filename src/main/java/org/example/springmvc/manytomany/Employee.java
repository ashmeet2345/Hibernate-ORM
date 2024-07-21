package org.example.springmvc.manytomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @Column(name="E_ID")

    private int eid;

    @Column(name="EMPLOYEE_NAME")
    private String employeeName;

    public Employee() {
        super();
    }

    @ManyToMany
    @JoinTable
            (name="EMP_PJ",joinColumns = {@JoinColumn(name="E_ID")},inverseJoinColumns = {@JoinColumn(name="P_ID")})
    private List<Project> projects;

    public Employee(int eid, String employeeName, List<Project> projects) {
        this.eid = eid;
        this.employeeName = employeeName;
        this.projects = projects;
    }



    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
