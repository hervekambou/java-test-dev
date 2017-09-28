package fr.poleemploi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.poleemploi.FrenchToJavanais;
import fr.poleemploi.FrenchToJavanaisImpl;

public class FrenchToJavanaisTest {
	private static final String AU_FRANCAIS = "au";
	private static final String AU_JAVANAIS = "avau";
	
	private static final String MOYEN_FRANCAIS = "moyen";
	private static final String MOYEN_JAVANAIS = "mavoyen";
	private static final String EXEMPLE_FRANCAIS = "exemple";
	private static final String EXEMPLE_JAVANAIS = "avexavemplave";
	
	private static final String PHRASE_FRANCAISE = "bonjour je chante au moyen";
	private static final String PHRASE_JAVANAIS = "bavonjavour jave chavantave avau mavoyen";
	
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
	public void testTransformFrenchToJavanais() {
		String result = frenchToJavanais.transformFrenchToJavanais(AU_FRANCAIS);
		assertTrue("Erreur de transformation du Francais en Javanais", AU_JAVANAIS.equals(result));
		
		result = frenchToJavanais.transformFrenchToJavanais(EXEMPLE_FRANCAIS);
		assertTrue("Erreur de transformation du Francais en Javanais", EXEMPLE_JAVANAIS.equals(result));
		
		result = frenchToJavanais.transformFrenchToJavanais(MOYEN_FRANCAIS);
		assertTrue("Erreur de transformation du Francais en Javanais", MOYEN_JAVANAIS.equals(result));
		
		result = frenchToJavanais.transformFrenchToJavanais(PHRASE_FRANCAISE);
		assertTrue("Erreur de transformation du Francais en Javanais", PHRASE_JAVANAIS.equals(result));
	}
	
	@Test
	public void testTransformJavanaisToFrench() {
		String result = frenchToJavanais.transformJavanaisToFrench(AU_JAVANAIS);
		assertTrue("Erreur de transformation du Javanais en Francais", AU_FRANCAIS.equals(result));
		
		result = frenchToJavanais.transformJavanaisToFrench(EXEMPLE_JAVANAIS);
		assertTrue("Erreur de transformation du Javanais en Francais", EXEMPLE_FRANCAIS.equals(result));
		
		result = frenchToJavanais.transformJavanaisToFrench(MOYEN_JAVANAIS);
		assertTrue("Erreur de transformation du Javanais en Francais", MOYEN_FRANCAIS.equals(result));
		
		result = frenchToJavanais.transformJavanaisToFrench(PHRASE_JAVANAIS);
		assertTrue("Erreur de transformation du Javanais en Francais", PHRASE_FRANCAISE.equals(result));
	}
	
}
