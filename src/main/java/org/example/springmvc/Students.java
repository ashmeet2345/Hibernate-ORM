package org.example.springmvc;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="STUDENTS")
public class Students {


    private int id;

    @Column(name="NAME")
    private String name;

    @Column(name="CITY")
    private String city;

    public Students(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Students(){
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public int getId() {
        return id;
    }
}
