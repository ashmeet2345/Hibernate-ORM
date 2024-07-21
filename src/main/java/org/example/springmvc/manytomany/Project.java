package org.example.springmvc.manytomany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="PROJECT")
public class Project {
    @Id
    @Column(name="P_ID")
    private int pid;

    @Column(name="PROJECT_NAME")
    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public Project() {
        super();
    }

    public Project(int pid, String projectName, List<Employee> employees) {
        this.pid = pid;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
