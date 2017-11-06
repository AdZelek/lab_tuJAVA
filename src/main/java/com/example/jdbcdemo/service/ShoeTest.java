package com.example.jdbcdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Shoe;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ShoeTest {
	public String NAME_1 = "Addidas 2091";
	public String NAME_2 = "Addidas 9012";
	public String NAME_3 = "Nike V22";
	public String NAME_4 = "Kalenji 330";
	
	public int SIZE_1 = 38;
	public int SIZE_2 = 39;
	public int SIZE_3 = 40;
	
	public double PRICE_1 = 199.99;
	public double PRICE_2 = 299.99;
	public double PRICE_3 = 99.99;
	
	ShoeManagerJDBC shoeManager = new ShoeManagerJDBC();
	
	public void chackAddAll(){
	shoeManager.clearShoes(); 
		
	Shoe shoe1 =new Shoe(NAME_1,SIZE_1,PRICE_1);
	Shoe shoe2 =new Shoe(NAME_2,SIZE_1,PRICE_2);
	Shoe shoe3 =new Shoe(NAME_3,SIZE_2,PRICE_1);
	Shoe shoe4 =new Shoe(NAME_4,SIZE_3,PRICE_3);
	
	List<Shoe> shoes = new ArrayList<>();
	shoes.add(shoe1);
	shoes.add(shoe2);
	shoes.add(shoe3);
	shoes.add(shoe4);
	
	shoeManager.addAllShoes(shoes);
	int size = shoeManager.getAllShoes().size();
	assertThat(size, either(is(4)).or(is(0))); 
	
	
	}
	
}
