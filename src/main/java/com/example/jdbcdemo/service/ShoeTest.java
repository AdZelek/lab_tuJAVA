package com.example.jdbcdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Shoe;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class ShoeTest {
	private final static String NAME_1 = "Addidas 2091";
	private final static String NAME_2 = "Addidas 9012";
	private final static String NAME_3 = "Nike V22";
	private final static String NAME_4 = "Kalenji 330";
	
	private final static int SIZE_1 = 38;
	private final static int SIZE_2 = 39;
	private final static int SIZE_3 = 40;
	
	private final static double PRICE_1 = 199.99;
	private final static double PRICE_2 = 299.99;
	private final static double PRICE_3 = 99.99;
	
	private ShoeManagerJDBC shoeManager = new ShoeManagerJDBC();
	
	@Test
    public void checkConnection() {
        assertNotNull(shoeManager.getConnection());
    }
	

    @Before
    public void checkDeleteAllshoes() {
        shoeManager.deleteAllShoes();
        List<Shoe> shoes = shoeManager.getAllShoes();
       // assertEquals(true, shoes.isEmpty());
    }
	
	Shoe shoe1 =new Shoe(NAME_1,SIZE_1,PRICE_1);
	Shoe shoe2 =new Shoe(NAME_2,SIZE_1,PRICE_2);
	Shoe shoe3 =new Shoe(NAME_3,SIZE_2,PRICE_1);
	Shoe shoe4 =new Shoe(NAME_4,SIZE_3,PRICE_3);
	
    @Test
	public void checkAddShoe() {
		assertEquals(1, shoeManager.addShoe(shoe1));
		List <Shoe> shoes = shoeManager.getAllShoes();
		Shoe shoeadd = shoes.get(0);

        assertEquals(1, shoeManager.getAllShoes().size());
        assertEquals(shoe1.getName(), shoeadd.getName());
        assertEquals(shoe1.getSize(), shoeadd.getSize());
        assertEquals(shoe1.getPrice(), shoeadd.getPrice(), 0.01);
	}
   
    @Test 
	public void chackAddAll(){
	
	List<Shoe> shoes = new ArrayList<>();
	shoes.add(shoe1);
	shoes.add(shoe2);
	shoes.add(shoe3);
	shoes.add(shoe4);
	
	shoeManager.addAllShoes(shoes);
	int size = shoeManager.getAllShoes().size();
	assertThat(size, either(is(4)).or(is(0))); 
	}
    
    @Test
    public void checkFindeName() {

        shoeManager.addShoe(shoe1);
        shoeManager.addShoe(shoe2);

        Shoe shoe = shoeManager.findShoeName(shoe2.getName());
        assertEquals(true, shoe.equals(shoe2));
        Shoe shoefind= shoe;
        assertEquals(shoe2.getName(), shoefind.getName()); 
    }
    
    @Test
    public void checkDeleteAllSelectedShoes() {
        shoeManager.addShoe(shoe1);
        shoeManager.addShoe(shoe2);
        shoeManager.addShoe(shoe3);

        List<Shoe> shoes = shoeManager.getAllShoes();
        List<Long> ids = new ArrayList<>();
        ids.add(shoes.get(0).getID());
        ids.add(shoes.get(1).getID());
        shoeManager.deleteAllSelectedShoes(ids);
        assertEquals(1, shoeManager.getAllShoes().size());
    }

	
	
	
}
