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
	
	public static void menu ()
	{
		ShoeManagerJDBC conn = new ShoeManagerJDBC(); 
		conn.getConnection(); 
		System.out.println("Wybierz numer:");
		System.out.println("1 - jezeli chcesz dodac produkt");
		System.out.println("2 - jezeli chcesz edytowac produkt");
		System.out.println("3 - jezeli chcesz usunac produkt");
		System.out.println("4 - jezeli chcesz usunac WSZYSTKIE produkty");
		Scanner in= new Scanner(System.in);
		int number = in.nextInt();
		boolean blad = false; 
		 switch(number){
	      case 1:
	    	  Shoe s = new Shoe(); 
	          System.out.println("podaj nazwe");
	          s.setName(in.next());
	          System.out.println("podaj rozmiar");
	          try{ 
	        	 int size = in.nextInt();
	        	 s.setSize(size); 
	        	 }
	         catch (InputMismatchException n){
	        	 System.out.println("rozmiar musi byc liczba calkowita");
	        	 menu(); 
	         	}
	          
	          System.out.println("podaj cene");
	          String price = in.next(); 
	         if (in.hasNextDouble()) {
	         
	          s.setPrice( Double.parseDouble(price));
	          }
	         else System.out.println("blad, sprobuj ponownie"); 
	         
	    
	          
	          if(conn.addShoe(s)==1)
	        	  System.out.println("dodales produkt");
	          else System.out.println("blad, sprobuj ponownie"); 
	          menu();
	        
	      case 2:
	          System.out.println("edycja");
	          Shoe s2 = new Shoe();
	          String name = null ;
	          int id ; 
	          System.out.println("Podaj id produktu, ktory chcesz edytowac");
	          id = in.nextInt();
	         
	          if (conn.findShoe(id)==null){
	        	  System.out.println("bledne id");
	        	  menu();
	          }
	          else{
	        		  s2 = conn.findShoe(id); 
	        		  System.out.println("edytujesz:");
	        		  System.out.print("ID: "+s2.getID()+" name: " + s2.getName()+ " size:" + s2.getSize()
								 + " price: " + s2.getPrice() + "\n");
	        				  
	         // s2.setID(id); 
	          System.out.println("Wprowadz nowa nazwe albo wcsnij enter jezeli chcesz pozostawic stara nazwe");
	          name=in.next(); 
	         
	          if(name != null)s2.setName(name);
	            try{ 
	            	 System.out.println("Wprowadz nowy rozmiar albo wcsnij enter jezeli chcesz pozostawic rozmiar bez zmian");
		        	 int size = in.nextInt();
		        	 s2.setSize(size); 
		        	 }
		         catch (InputMismatchException n){
		        	 System.out.println("rozmiar musi byc liczba calkowita");
		        	 menu(); 
		       	 }
	          
	          
		          System.out.println("Wprowadz nowa cene albo wcsnij enter jezeli chcesz pozostawic cene bez zmian");
		         String price2 = in.next();
		         if(doubleValid(price2)==true)
		         s2.setPrice(Double.parseDouble(price2));
		         else {
			        	 System.out.println("cena musi byc liczba rzeczywista");
			        	 menu(); 
			         	}
		         
	          if(conn.updateShoe(s2)==1)
	        	  System.out.println("edytowales produkt");
	          else System.out.println("blad, sprobuj ponownie"); 
	          menu();
	          }
	          
	      case 3:
	          System.out.println("usun");
	          break;
	      case 4:
	          System.out.println("usun wszystko");
	          break;
	      case 5:
	          System.out.println("usunieto wszystko");
	          break;
	          
	      default:
	          System.out.println("zla komenda");
	          break;
	      }
	}
	
	 private static boolean doubleValid(String text) { 
         try {
               //String wzor=pesel; 
             Double.parseDouble(text); 
               return true;
           } catch (NumberFormatException e) {
            return false;
        
           }
   
   }
	
	public static void main(String[] args) throws Exception{
	
		List <Shoe> shoes = new ArrayList<>(); 

		Shoe shoe = new Shoe("Addidas 3030",38,399.99);

		ShoeManagerJDBC conn = new ShoeManagerJDBC(); 
		conn.getConnection(); 
	
	    //conn.addShoe(shoe);
	
		shoes.addAll(conn.getAllShoes()); 
		
		System.out.print("Wszystkie buty w bazie danych: \n");
		for (Shoe shoetoList : conn.getAllShoes()) 
		{	
			System.out.print("ID: "+shoetoList.getID()+" name: " + shoetoList.getName()+ " size:" + shoetoList.getSize()
							 + " price: " + shoetoList.getPrice() + "\n");
		}
		
		menu(); 
		
	
		
	
	
	
	}

}
