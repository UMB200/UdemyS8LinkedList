package com.UmidJavaUdemy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//	    Customer customer = new Customer("Bob", 100.0);
//	    Customer anotherCustomer;
//	    anotherCustomer = customer;
//	    anotherCustomer.setBalance(10.0);
//        System.out.println("Balance for customer "+ customer.getName() + " balance " + customer.getBalance());
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
		integerArrayList.add(1);
		integerArrayList.add(2);
		integerArrayList.add(3);

		for(int i =0; i< integerArrayList.size(); i++){
			System.out.println(i + " original element is " + integerArrayList.get(i));

		}
		integerArrayList.add(1, 2);
		for(int i =0; i< integerArrayList.size(); i++) {
			System.out.println(i + " changed element is " + integerArrayList.get(i));
		}

    }
}
