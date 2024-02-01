package com.example.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lid;

    private String brand;
    private String model;

    @ManyToOne
    private Student student;

    @ManyToMany
    @JoinTable(
            name = "laptop_feature",
            joinColumns = @JoinColumn(name = "laptop_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> features = new HashSet<>();
    
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

	public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
