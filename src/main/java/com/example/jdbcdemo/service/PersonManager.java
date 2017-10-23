package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Person;

public interface PersonManager {
	
	public int addPerson(Person person);
	//public void remove(long id); 
	public List<Person> getAllPersons();
	//public List<Person> findByName();

}
