package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Person;

public interface PersonManager {
	
	public int addPerson(Person person);
	public List<Person> getAllPersons();
    /*metoda transakcyjna - albo wszystkie albo zadna */ 
//	public void addAllPersons(List<Person> persons);

}
