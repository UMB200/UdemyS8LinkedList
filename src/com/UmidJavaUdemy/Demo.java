package com.UmidJavaUdemy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//12/15/2019
public class Demo {
    public static void main(String[] args) {
        LinkedList<String> statesUS = new LinkedList<String>();
        statesUS.add("New York");
        statesUS.add("Georgia");
        statesUS.add("Florida");
        statesUS.add("South Dakota");
        statesUS.add("Pennsylvania");
        statesUS.add("Virgina");
        addInOrder(statesUS, "New York");
        addInOrder(statesUS, "Georgia");
        addInOrder(statesUS, "Florida");
        addInOrder(statesUS, "South Dakota");
        addInOrder(statesUS, "Pennsylvania");
        addInOrder(statesUS, "Virginia");
        addInOrder(statesUS, "Virginia");
//
//        printStates(statesUS);
//        statesUS.add(1, "Maryland");
        printStates(statesUS);
//
//        statesUS.remove(4);
        visit(statesUS);

    }
    private static void printStates(LinkedList<String > list){
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            System.out.println("Going to: " + i.next());
        }
        System.out.println("=============");
    }
    private static boolean addInOrder(LinkedList<String> linkedList, String newState){
        ListIterator<String> listIterator = linkedList.listIterator();
        while ((listIterator.hasNext())){
              int comparison = listIterator.next().compareTo(newState);
              if(comparison == 0){
                  //equal do not add
                  System.out.println(newState + " already exists");
                  return false;
              }
              else if(comparison > 0){
                  // newState appears before this one
                  listIterator.previous();
                  listIterator.add(newState);
                  return true;
              }
              else if(comparison < 0){
                  //move to the next city
              }
        }listIterator.add(newState);
        return true;
    }
    private static void visit(LinkedList states){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean movingForward = true;
        ListIterator<String> listIterator = states.listIterator();
        if(states.isEmpty()){
            System.out.println("No states to visit");
        }
        else {
            System.out.println("Visiting " + listIterator.next());
            printInstruction();
        }
        while (!quit){
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Holidays are over");
                    quit = true;

                    break;
                case 1:
                    if(!movingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        movingForward= true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Visiting "+ listIterator.next());
                    } else {
                        System.out.println("End of the list");
                        movingForward = false;
                    }
                    break;
                case 2:
                    if(movingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        movingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Visiting "+ listIterator.previous());
                    }
                    else {
                        System.out.println("Start of the list");
                        movingForward = true;
                    }
                    break;
                default:
                    printInstruction();
            }
        }
    }
    private static void printInstruction(){
        System.out.println("Choose from actions:\npress");
        System.out.println("0 - quit\n" +
                            "1 - next state\n" +
                            "2 - previous state");
    }
}
