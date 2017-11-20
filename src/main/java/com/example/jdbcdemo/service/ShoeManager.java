package com.example.jdbcdemo.service;

import java.util.List;

import com.example.jdbcdemo.domain.Person;
import com.example.jdbcdemo.domain.Shoe;

public interface ShoeManager {
	
	public int addShoe(Shoe shoe);
	public int updateShoe(Shoe shoe, String name,int size, double price);
	public int updateShoeName(Shoe shoe, String name);
	public int updateShoeSize(Shoe shoe, int size);
	public int updateShoePrice(Shoe shoe, double price);
	
	
	public int deleteShoe (Shoe shoe);
	public List<Shoe> getAllShoes();
	public Shoe findShoeId(int id); 
	public Shoe findShoeName(String name); 
	
	public void addAllShoes(List<Shoe> shoes);
	public int deleteAllSelectedShoes(List<Long> ids);
	public void deleteAllShoes();
	
	

}
