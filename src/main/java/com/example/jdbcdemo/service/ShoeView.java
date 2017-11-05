package com.example.jdbcdemo.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.example.jdbcdemo.domain.Shoe;

public class ShoeView {
	
	public void menu() {
		ShoeManagerJDBC conn = new ShoeManagerJDBC();
		conn.getConnection();
		System.out.println("Wybierz numer:");
		System.out.println("0 - jezeli chcesz wyswietlic wszystie produkty, ktore znajduja sie w bazie");
		System.out.println("1 - jezeli chcesz dodac produkt");
		System.out.println("2 - jezeli chcesz edytowac produkt");
		System.out.println("3 - jezeli chcesz usunac produkt");
		System.out.println("4 - jezeli chcesz usunac WSZYSTKIE produkty");
		System.out.println("5 - jezeli chcesz zakonczyc program");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		boolean blad = false;
		switch (number) {
		case 0:
			showAllShoes();
			menu(); 
		case 1:
			Shoe s = new Shoe();
			System.out.println("podaj nazwe");
			in.nextLine();
			s.setName(in.nextLine());
			System.out.println("podaj rozmiar");
			try {
				int size = in.nextInt();
				s.setSize(size);
			} catch (InputMismatchException n) {
				System.out.println("rozmiar musi byc liczba calkowita");
				menu();
			}

			System.out.println("podaj cene");
			String price = in.next();

			if (doubleValid(price) == true) {
				if (Double.parseDouble(price) > 0)
					s.setPrice(Double.parseDouble(price));
			} else {
				System.out.println("cena musi byc liczba rzeczywista");
				menu();
			}
			if (conn.addShoe(s) == 1)
				System.out.println("dodales produkt");
			else
				System.out.println("blad, sprobuj ponownie");
			menu();

		case 2:
			System.out.println("edycja");
			Shoe s2 = new Shoe();
			String name = null;
			int id;
			System.out.println("Podaj id produktu, ktory chcesz edytowac");
			id = in.nextInt();

			if (conn.findShoe(id) == null) {
				System.out.println("bledne id");
				menu();
			} else {
				s2 = conn.findShoe(id);
				System.out.println("edytujesz:");
				System.out.print("ID: " + s2.getID() + " name: " + s2.getName()
						+ " size:" + s2.getSize() + " price: " + s2.getPrice()
						+ "\n");
				System.out
						.println("Wprowadz nowa nazwe lub wpisz 0 jesli chcesz pozostawic nazwe bez zmian");
				in.nextLine();
				name = in.nextLine();
				if (!name.equals("0"))
					s2.setName(name);
				try {
					System.out
							.println("Wprowadz nowy rozmiar lub wpisz 0 jesli chcesz pozostawic rozmiar bez zmian");
					int size = in.nextInt();
					if (size != 0)
						s2.setSize(size);
				} catch (InputMismatchException n) {
					System.out.println("rozmiar musi byc liczba calkowita");
					menu();
				}

				System.out
						.println("Wprowadz nowa cene lub wpisz 0 jesli chcesz pozostawic cene bez zmian");

				String price2 = in.next();

				if (doubleValid(price2) == true) {
					if (Double.parseDouble(price2) > 0)
						s2.setPrice(Double.parseDouble(price2));
				} else {
					System.out.println("cena musi byc liczba rzeczywista");
					menu();
				}

				if (conn.updateShoe(s2) == 1)
					System.out.println("edytowales produkt");
				else
					System.out.println("blad, sprobuj ponownie");
				menu();
			}

		case 3:
			System.out.println("usun");
			int idD;
			System.out.println("Podaj id produktu, ktorego chcesz usunac");
			id = in.nextInt();
			if (conn.findShoe(id) == null) {
				System.out.println("bledne id");
				menu();
			} else {
			conn.deleteShoe(conn.findShoe(id));
			}
			menu();
		case 4:
			conn.clearShoes();
			System.out.println("usunieto wszystko");
			break;
		case 5:
			break;

		default:
			System.out.println("zla komenda");
			break;
		}
	}

	private boolean doubleValid(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;

		}

	}
	
	void showAllShoes() {
		List<Shoe> shoes = new ArrayList<>();
		ShoeManagerJDBC conn = new ShoeManagerJDBC();
		conn.getConnection();

		shoes.addAll(conn.getAllShoes());
		if (shoes.isEmpty())
			System.out.print("Brak butow w bazie danych. \n");
		else {
			System.out.print("Wszystkie buty w bazie danych: \n");
			for (Shoe shoetoList : conn.getAllShoes()) {
				System.out.print("ID: " + shoetoList.getID() + " name: "
						+ shoetoList.getName() + " size:"
						+ shoetoList.getSize() + " price: "
						+ shoetoList.getPrice() + "\n");
			}
		}

	}


}
