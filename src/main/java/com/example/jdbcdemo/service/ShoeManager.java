package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Person;
import com.example.jdbcdemo.domain.Shoe;

public interface ShoeManager {
	
	public int addShoe(Shoe shoe);
	public List<Shoe> getAllShoes();
	

}
