package com.luxoft.springioc.lab3.model;

public interface Person {
    public void setName(String name);
    public String getName();
    public boolean isRegistered();
	public void setRegistered(boolean isRegistered);
    public void sayHello(Person person);
}