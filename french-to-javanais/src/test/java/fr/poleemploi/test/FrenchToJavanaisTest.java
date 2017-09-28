package fr.poleemploi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.FrenchToJavanaisImpl;
import fr.poleemploi.FrenchToJavanais;

public class FrenchToJavanaisTest {
	private static final String MOYEN_FRANCAIS = "moyen";
	private static final String MOYEN_JAVANAIS = "mavoyen";
	private static final String EXEMPLE_FRANCAIS = "exemple";
	private static final String EXEMPLE_JAVANAIS = "avexavemplave";
	
	private static FrenchToJavanais frenchToJavanais;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		frenchToJavanais = new FrenchToJavanaisImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTransformJavanaisToFrench() {
		String result = frenchToJavanais.transformJavanaisToFrench(EXEMPLE_JAVANAIS);
		assertTrue("", EXEMPLE_FRANCAIS.equals(result));
		
		result = frenchToJavanais.transformJavanaisToFrench(MOYEN_JAVANAIS);
		assertTrue("", MOYEN_FRANCAIS.equals(result));
	}
	
	@Test
	public void testTransformFrenchToJavanais() {
		String result = frenchToJavanais.transformFrenchToJavanais(EXEMPLE_FRANCAIS);
		assertTrue("", EXEMPLE_JAVANAIS.equals(result));
		
		result = frenchToJavanais.transformFrenchToJavanais(MOYEN_FRANCAIS);
		assertTrue("", MOYEN_JAVANAIS.equals(result));
	}
}
