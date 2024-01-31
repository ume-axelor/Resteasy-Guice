package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lid;
    private String brand;
    private String model;

    @ManyToOne
    private Student student;

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

	public Object getSerialNumber() {
		return null;
	}

	public void setSerialNumber(Object serialNumber) {
		
	}
}
