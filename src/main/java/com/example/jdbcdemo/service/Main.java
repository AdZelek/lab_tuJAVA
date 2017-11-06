package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import org.hsqldb.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import com.example.jdbcdemo.domain.Shoe;

public class Main {

	
	public static void main(String[] args) {

//	ShoeView view = new ShoeView();
	ShoeTest test = new ShoeTest(); 
	//view.menu();
	test.chackAddAll();
	
	
		
	}

}
