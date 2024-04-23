package miniproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class StudentsManagementSystem 

{
	 public static void main(String args[]) throws IOException 
	 
	 {
	        int choice;
	        Scanner sc = new Scanner(System.in);

	        do 
	        	
	        {
	            displayMenu();
	            choice = sc.nextInt();

	            switch (choice) 
	            
	            {
	                case 1:
	                    viewStudentList();
	                    break;
	                case 2:
	                    addNewStudent();
	                    break;
	                case 3:
	                    searchStudent();
	                    break;
	                case 4:
	                    removeStudent();
	                    break;
	                default:
	                    System.out.println("Invalid option. Please enter a valid choice.");
	            }
	            
	        } 
	        
	        while (choice <= 4);
	    }

	    private static void displayMenu() 
	    
	    {
	        System.out.println("=======Welcome To Management System======");
	        System.out.println("Enter 1: To View Student's List");
	        System.out.println("Enter 2: To Add New Student");
	        System.out.println("Enter 3: To Search Student");
	        System.out.println("Enter 4: To Remove Students");
	        System.out.println("Please Select An Above Option:");
	    }

	    private static void viewStudentList() throws IOException 
	    
	    {
	        try (BufferedReader reader = new BufferedReader(new FileReader("harish.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) 
	            {
	                System.out.println(line);
	            }
	        }
	    }

	    private static void addNewStudent() throws IOException 
	    
	    {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter student name: ");
	        String name = sc.next();
	        System.out.print("Enter roll number: ");
	        int rollNumber = sc.nextInt();
	        System.out.print("Enter marks: ");
	        double marks = sc.nextDouble();

	        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("harish.txt", true))))
	        
	        {
	            writer.println(name + "," + rollNumber + "," + marks);
	            System.out.println("Student added successfully.");
	        }
	    }

	    private static void searchStudent() throws IOException 
	    
	    {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the name to search: ");
	        String name = sc.next();

	        try (BufferedReader reader = new BufferedReader(new FileReader("harish.txt"))) 
	        
	        {
	            String line;
	            while ((line = reader.readLine()) != null) 
	            {
	                if (line.contains(name)) {
	                    System.out.println(line);
	                }
	            }
	        }
	    }

	    private static void removeStudent() throws IOException
	    
	    {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the name to remove: ");
	        String name = sc.next();

	        BufferedReader reader = new BufferedReader(new FileReader("harish.txt"));
	        String currentLine;
	        StringBuilder fileContent = new StringBuilder();

	        while ((currentLine = reader.readLine()) != null)
	        	
	         {
	            if (currentLine.contains(name)) 
	            {
	                continue;
	            }
	            
	            fileContent.append(currentLine).append("\n");
	        }
	  
	        reader.close();
	        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("harish.txt")));
	        writer.print(fileContent.toString());
	        writer.close();

	        System.out.println("Student removed successfully.");
	    }
	}