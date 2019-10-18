package com.luxoft.springioc.lab3.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;


public class RegistrationTest {

	private AbstractApplicationContext context;

	@Before
	public void setUp() {
		context = new AnnotationConfigApplicationContext(RegistrationTest.class);
	}

	@Test
	public void testPersonCreated() {
		assertEquals(1, UsualPerson.createdPersons);
	}

	@Test
	public void testPersonRegistration() {
		UsualPerson person = (UsualPerson) context.getBean("person");

		RegistrationManager registrationManager = (RegistrationManager) context.getBean("registrationManager");

		registrationManager.getApplicationContext().publishEvent(new PersonRegistrationEvent(person));
		System.out.println("After registering:");
		System.out.println(person);
		assertTrue(person.isRegistered());
	}

	@After
	public void tearDown() {
		context.close();
		assertEquals(0, UsualPerson.createdPersons);
	}

}
