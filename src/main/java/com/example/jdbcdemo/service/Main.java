package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import org.hsqldb.Statement;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Person;
import com.example.jdbcdemo.domain.Shoe;

public class Main {
	
	public static void main(String[] args) throws Exception{
	
		Shoe shoe = new Shoe();
		shoe.name = "Nike 1210"; 
		shoe.price = 199.99;
		shoe.type = "running";
		
	
	ShoeManagerJDBC conn = new ShoeManagerJDBC(); 
	conn.getConnection(); 
	conn.addShoe(shoe);
	String allShoesQuery = "SELECT id, name, type, price FROM Shoe";
	
	List <Shoe> shoes = new ArrayList<>(); 
	conn.getAllShoes(); 
	//ResultSet allShoes = statement.executeQuery(allShoesQuery);
	
	
	//String allPersonQuery ="SELECT id, name, yob FROM Person";
	
	
	/*Person tola = new Person();
	tola.setName("Tola");
	tola.setYob(2222);
	
	// '"+ tola.getName() + "', " + tola.getYob()
	String addPersonQuery = "INSERT INTO Person(name,yob) values('Tola',1123)"; 
	//String addPersonQuery = "INSERT INTO Person(name,yob) values('Tola',1123)"; 
	//statement.executeUpdate(arg0); 
	
	List <Person> persons = new ArrayList<>(); 
	ResultSet allPersons = statement.executeQuery(allPersonQuery);
	
	statement.executeUpdate(addPersonQuery);
	
	
	/*while(allPersons.next()){
		Person person = new Person();
		person.setId(allPersons.getLong(1));
		person.setName(allPersons.getString(2));
		person.setYob(allPersons.getInt(3));
		
		/*System.out.println(allPersons.getLong(1));
		System.out.println(allPersons.getString(2));
		System.out.println(allPersons.getInt(3));
		System.out.println("-----------------------");*/ 
		
	
	
	
	}

}
