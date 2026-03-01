package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(mappedBy="passport")
    private Person person;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, String number, Person person) {
		super();
		this.id = id;
		this.number = number;
		this.person = person;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", person=" + person + "]";
	}
    
}
