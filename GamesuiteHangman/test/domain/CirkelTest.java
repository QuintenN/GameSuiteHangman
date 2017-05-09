package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	
	@Before
	public void setUp(){
	}

	@Test
	public void constructorDoetZijnWerktest() {
		Punt punt = new Punt(200,200);
		Cirkel cirk = new Cirkel(punt, 20);
		assertEquals(cirk.getRadius(), 20);
		assertEquals(cirk.getMiddelpunt().equals(punt),true);
	}


}
