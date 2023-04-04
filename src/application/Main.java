package application;

import entities.Emplyoee;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		List <Emplyoee> list = new ArrayList<>(); 
		
		System.out.print("How many emplyooes will be registered? ");
		int numEmplyoee = sc.nextInt();
		
		for (int i = 0; i < numEmplyoee; i++) {
			
			System.out.println("Emplyoee #" + (i+1) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)){
				
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Emplyoee emp = new Emplyoee(id, name, salary);
			list.add(emp); 
			
		}
		
		System.out.println();
		System.out.print("Enter the ermplyoee id that will have salary increase: ");
		int idFinder = sc.nextInt();
		
		Emplyoee emp = list.stream().filter(x -> x.getId() == idFinder).findFirst().orElse(null);
		
		if (emp == null) {
			
		System.out.println("This id does not exist!");	
			
		}	else {
			
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			emp.setAumento(percent); 
			
		}
		System.out.println();
		
		System.out.println("List of emplyoess: ");
		
		for (Emplyoee x : list ) {
			
			System.out.println(x);
			
		}
		
		sc.close(); 
	}
	
	public static boolean hasId (List <Emplyoee> list, int id) {
		
		Emplyoee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		return emp != null; 
	}

}
