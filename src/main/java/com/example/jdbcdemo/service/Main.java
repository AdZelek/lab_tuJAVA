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

import com.example.jdbcdemo.domain.Person;
import com.example.jdbcdemo.domain.Shoe;

public class Main {

	
	public static void main(String[] args) throws Exception {

	ShoeView view = new ShoeView();
	
	view.menu();
		
	}

}
