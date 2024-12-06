/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
FILENAME    : App.java
DESCRIPTION : A product list application where the user could search for a specific product and the application would
              pass this query to the Product Class. From there, the class would look this query up in the web, return the 
              actual product name and price of the first result, and add this to the user's price list.

              Furthermore, the application also performs the following:
              (1) Display all the products according to its category— grocery, appliance, 
                  clothing, stationery, and medical,
              (2) Append more products according to category.
              (3) Delete a products by index,
              (4) Clear all the product list, and
              (5) Calculates the total minimum and maximum, and the total average price of
                  each category, and of all categories in total.
AUTHORS     : Justine Anne Loo, John Carlo Salinas, and Sharina Sodario
CREATED     : November 24, 2022
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;
import java.lang.NullPointerException;

public class App {
    public static void main(String[] args) {

        ArrayList<Product> grocery = new ArrayList<Product>();
        ArrayList<Product> appliance = new ArrayList<Product>();
        ArrayList<Product> clothing = new ArrayList<Product>();
        ArrayList<Product> stationery = new ArrayList<Product>();
        ArrayList<Product> medical = new ArrayList<Product>();

        Scanner input = new Scanner(System.in);

        String query = null;
        int category;
        int selection;
        Boolean loop = true;
        int val;
        int dChoice;

        while(loop){
            System.out.println("=================================================================================");
            System.out.println(" \t\t\t\t  GROBUDDY");
            System.out.println("=================================================================================");
            
            printProducts(grocery, appliance, clothing, stationery, medical);

            System.out.println(" [1]\t\tAppend Product");
            System.out.println(" [2]\t\tDelete Product");
            System.out.println(" [3]\t\tClear Product List");
            System.out.println(" [4]\t\tTerminate Program");
            System.out.println("=================================================================================");
            System.out.print("Input Selection: ");

            selection = errorHandling(input);

            switch(selection){
                case 1:
                    clear();
                    System.out.println("=================================================================================");
                    System.out.println(" \t\t\t\tADD A NEW PRODUCT");
                    System.out.println("=================================================================================");
                    printCategories();
                    System.out.print("Product Category (1-5): ");
                    category = errorHandling(input);
                    input.nextLine();
                    if(category>0 && category<6){
                        System.out.print("Product Name: ");
                        query = input.nextLine();
                    }

                    try{
                        switch(category){
                            case 1:
                                grocery.add(new Product(0, query));
                                System.out.println((grocery.get(grocery.size()-1)).getName() + " HAS BEEN ADDED!");
                                break;

                            case 2:
                                appliance.add(new Product(1, query));
                                System.out.println((appliance.get(appliance.size()-1)).getName() + " HAS BEEN ADDED!");
                                break;

                            case 3:
                                clothing.add(new Product(2, query));
                                System.out.println((clothing.get(clothing.size()-1)).getName() + " HAS BEEN ADDED!");
                                break;

                            case 4:
                                stationery.add(new Product(3, query));
                                System.out.println((stationery.get(stationery.size()-1)).getName() + " HAS BEEN ADDED!");
                                break;

                            case 5:
                                medical.add(new Product(4, query));
                                System.out.println((medical.get(medical.size()-1)).getName() + " HAS BEEN ADDED!");
                                break;

                            default:
                                System.out.println("Error: Invalid Input");
                                break;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Error: No Products Found!");
                    } 
                    break;
                
                case 2:
                    clear();
                    System.out.println("=================================================================================");
                    System.out.println(" \t\t\t\tDELETE A PRODUCT");
                    System.out.println("=================================================================================");
                    if (grocery.size() != 0 || appliance.size() != 0 || clothing.size() != 0 || stationery.size() != 0 || medical.size() != 0){
                        printCategories();
                        System.out.print("Product Category (1-5): ");
                        category = errorHandling(input);
                        switch(category){
                            case 1:
                                if (grocery.size() != 0){
                                    System.out.print("Index Number: ");
                                    val = errorHandling(input);

                                    if(val < grocery.size() && val >= 0){
                                        System.out.print("Are you sure to delete ");
                                        System.out.print((grocery.get(val)).getName() + "? [Yes:1 / No:2] ");
                                        dChoice = errorHandling(input);
                                        
                                        if (dChoice == 1){
                                            System.out.println((grocery.get(val)).getName() + " HAS BEEN DELETED!");
                                            grocery.remove(val);
                                        } else if (dChoice == 2){
                                            System.out.println("Returning To Main Menu");
                                        } else {
                                            System.out.println("Error: Invalid Input!");
                                        }
                                    } else {
                                        System.out.println("Error: Index Out Of Bounds!");
                                    }
                                } else {
                                    System.out.println("Error: No Products Found!");
                                }
                                break;
                            
                            case 2:
                                if (appliance.size() != 0){
                                    System.out.print("Index Number: ");
                                    val = errorHandling(input);

                                    if(val < appliance.size() && val >= 0){
                                        System.out.print("Are you sure to delete ");
                                        System.out.print((appliance.get(val)).getName() + "? [Yes:1 / No:2] ");
                                        dChoice = errorHandling(input);
                                        
                                        if (dChoice == 1){
                                            System.out.println((appliance.get(val)).getName() + " HAS BEEN DELETED!");
                                            appliance.remove(val);
                                        } else if (dChoice == 2){
                                            System.out.println("Returning To Main Menu");
                                        } else {
                                            System.out.println("Error: Invalid Input!");
                                        }
                                    } else {
                                        System.out.println("Error: Index Out Of Bounds!");
                                    }
                                } else {
                                    System.out.println("Error: No Products Found!");
                                }
                                break;

                            case 3:
                                if (clothing.size() != 0){
                                    System.out.print("Index Number: ");
                                    val = errorHandling(input);

                                    if(val < clothing.size() && val >= 0){
                                        System.out.print("Are you sure to delete ");
                                        System.out.print((clothing.get(val)).getName() + "? [Yes:1 / No:2] ");
                                        dChoice = errorHandling(input);
                                        
                                        if (dChoice == 1){
                                            System.out.println((clothing.get(val)).getName() + " HAS BEEN DELETED!");
                                            clothing.remove(val);
                                        } else if (dChoice == 2){
                                            System.out.println("Returning To Main Menu");
                                        } else {
                                            System.out.println("Error: Invalid Input!");
                                        }
                                    } else {
                                        System.out.println("Error: Index Out of Bounds!");
                                    }   
                                } else {
                                    System.out.println("Error: No Products Found!");
                                }
                                break;  

                            case 4:
                                if (stationery.size() != 0){
                                    System.out.print("Index Number: ");
                                    val = errorHandling(input);

                                    if(val < stationery.size() && val >= 0){
                                        System.out.print("Are you sure to delete ");
                                        System.out.print((stationery.get(val)).getName() + "? [Yes:1 / No:2] ");
                                        dChoice = errorHandling(input);
                                        
                                        if (dChoice == 1){
                                            System.out.println((stationery.get(val)).getName() + " HAS BEEN DELETED!");
                                            stationery.remove(val);
                                        } else if (dChoice == 2){
                                            System.out.println("Returning To Main Menu");
                                        } else {
                                            System.out.println("Error: Invalid Input!");
                                        }
                                    } else {
                                        System.out.println("Error: No Products Found!");
                                    }
                                } else {
                                    System.out.println("Error: No Products Found!");
                                }
                                break;

                            case 5:
                                if (medical.size() != 0){
                                    System.out.print("Index Number: ");
                                    val = errorHandling(input);

                                    if(val < medical.size() && val >= 0){
                                        System.out.print("Are you sure to delete ");
                                        System.out.print((medical.get(val)).getName() + "? [Yes:1 / No:2] ");
                                        dChoice = errorHandling(input);
                                        
                                        if (dChoice == 1){
                                            System.out.println((medical.get(val)).getName() + " HAS BEEN DELETED!");
                                            medical.remove(val);
                                        } else if (dChoice == 2){
                                            System.out.println("Returning To Main Menu");
                                        } else {
                                            System.out.println("Error: Invalid Input!");
                                        }
                                    } else {
                                        System.out.println("Error: No Products Found!");
                                    }
                                } else {
                                    System.out.println("Error: No Products Found!");
                                }
                                break;

                            default:
                                System.out.println("Error: Invalid Input!");
                                input.nextLine();
                                break;
                        }
                    } else {
                        System.out.println("Error: No Products Found!");
                    }
                    break;

                case 3:
                    clear();
                    System.out.println("=================================================================================");
                    System.out.println(" \t\t\t\tCLEAR PRODUCT LIST");
                    System.out.println("=================================================================================");    
                    grocery.clear();
                    appliance.clear();
                    clothing.clear();
                    stationery.clear();
                    medical.clear();
                    break;

                case 4:                    
                    clear();
                    System.out.println("Price Reference Credits: (c) 2022 iPrice Group Sdn Bhd (1113954 - D). All rights reserved");
                    System.out.println("GroBuddy thanks you for using our service!\n\n");
                    loop = false;
                    break;
                    
                default:
                    clear();
                    System.out.println("Error: Invalid Input!");
                    input.nextLine();
                    break;
            }
        }
        input.close();
    }

    public static void printProducts(ArrayList<Product> grocery, ArrayList<Product> appliance, ArrayList<Product> clothing, ArrayList<Product> stationery, ArrayList<Product> medical){
        double gMinPrice = 0, gMaxPrice = 0, gAvgPrice = 0;   //Grocery Array
        double aMinPrice = 0, aMaxPrice = 0, aAvgPrice = 0;   //Appliance Array
        double cMinPrice = 0, cMaxPrice = 0, cAvgPrice = 0;   //Clothing Array
        double sMinPrice = 0, sMaxPrice = 0, sAvgPrice = 0;   //Stationary Array
        double mMinPrice = 0, mMaxPrice = 0, mAvgPrice = 0;   //Medical Array
        int x = 0;
        
        if (grocery.size() != 0 || appliance.size() != 0 || clothing.size() != 0 || stationery.size() != 0 || medical.size() != 0 ){
            System.out.println(" Index\t\tGrocery Item = Price");
            System.out.println("=================================================================================");
            
            if (0 < grocery.size()){
                System.out.println(" Groceries");
                System.out.println("---------------------------------------------------------------------------------");
                
                for(x = 0; x < grocery.size(); x++){
                    System.out.println(" " + x + "\t\t" + (grocery.get(x)).getName() + " = " + (grocery.get(x)).getPrice());
                
                    gMinPrice += Double.parseDouble((grocery.get(x)).getMinPrice());
                    gMaxPrice += Double.parseDouble((grocery.get(x)).getMaxPrice());
                    
                }
                System.out.println("\nTotal Minimum Price of Groceries: " + gMinPrice);
                System.out.println("Total Maximum Price of Groceries: " + gMaxPrice);
                gAvgPrice = (gMinPrice+ gMinPrice)/2;
                System.out.println("Total Average Price of Groceries: " + gAvgPrice);
                System.out.println("=================================================================================");
            }

            if (0 < appliance.size()){
                System.out.println(" Electrical Appliances");
                System.out.println("---------------------------------------------------------------------------------");
                
                for(x = 0; x < appliance.size(); x++){
                    System.out.println(" " + x + "\t\t" + (appliance.get(x)).getName() + " = " + (appliance.get(x)).getPrice());
                    aMinPrice += Double.parseDouble((appliance.get(x)).getMinPrice());
                    aMaxPrice += Double.parseDouble((appliance.get(x)).getMaxPrice());
                }
                System.out.println("\nTotal Minimum Price of Electrical Appliances: " + aMinPrice);
                System.out.println("Total Maximum Price of Electrical Appliances: " + aMaxPrice);
                aAvgPrice = (aMinPrice+ aMinPrice)/2;
                System.out.println("Total Average Price of Electrical Appliances: " + aAvgPrice);
                System.out.println("=================================================================================");
            }

            if (0 < clothing.size()){
                System.out.println(" Clothing Fashion");
                System.out.println("---------------------------------------------------------------------------------");
                
                for(x = 0; x < clothing.size(); x++){
                    System.out.println(" " + x + "\t\t" + (clothing.get(x)).getName() + " = " + (clothing.get(x)).getPrice());
                    cMinPrice += Double.parseDouble((clothing.get(x)).getMinPrice());
                    cMaxPrice += Double.parseDouble((clothing.get(x)).getMaxPrice());
                }
                System.out.println("\nTotal Minimum Price of Clothing Fashion: " + cMinPrice);
                System.out.println("Total Maximum Price of Clothing Fashion: " + cMaxPrice);
                cAvgPrice = (cMinPrice+ cMinPrice)/2;
                System.out.println("Total Average Price of Clothing Fashion: " + cAvgPrice);
                System.out.println("=================================================================================");
            }

            if (0 < stationery.size()){
                System.out.println(" School Materials & Stationery");
                System.out.println("---------------------------------------------------------------------------------");
                
                for(x = 0; x < stationery.size(); x++){
                    System.out.println(" " + x + "\t\t" + (stationery.get(x)).getName() + " = " + (stationery.get(x)).getPrice());
                    sMinPrice += Double.parseDouble((stationery.get(x)).getMinPrice());
                    sMaxPrice += Double.parseDouble((stationery.get(x)).getMaxPrice());
                }
                System.out.println("\nTotal Minimum Price of School Materials & Stationeries: " + sMinPrice);
                System.out.println("Total Maximum Price of School Materials & Stationeries: " + sMaxPrice);
                sAvgPrice = (sMinPrice+ sMinPrice)/2;
                System.out.println("Total Average Price of School Materials & Stationeries: " + sAvgPrice);
                System.out.println("=================================================================================");
            }   
            
            if (0 < medical.size()){
                System.out.println(" Medicine & Medical Supplies");
                System.out.println("---------------------------------------------------------------------------------");
                
                for(x = 0; x < medical.size(); x++){
                    System.out.println(" " + x + "\t\t" + (medical.get(x)).getName() + " = " + (medical.get(x)).getPrice());
                    mMinPrice += Double.parseDouble((medical.get(x)).getMinPrice());
                    mMaxPrice += Double.parseDouble((medical.get(x)).getMaxPrice());
                }
                System.out.println("\nTotal Minimum Price of Medicine & Medical Supplies: " + mMinPrice);
                System.out.println("Total Maximum Price of Medicine & Medical Supplies: " + mMaxPrice);
                mAvgPrice = (mMinPrice+ mMinPrice)/2;
                System.out.println("Total Average Price of Medicine & Medical Supplies: " + mAvgPrice);
                System.out.println("=================================================================================");
            }

            System.out.println("\nTotal Minimum Price: " + (gMinPrice+aMinPrice+cMinPrice+sMinPrice+mMinPrice));
            System.out.println("Total Maximum Price: " + (gMaxPrice+aMaxPrice+cMaxPrice+sMaxPrice+mMaxPrice));
            System.out.println("Total Average Price: " + ((gMinPrice+aMinPrice+cMinPrice+sMinPrice+mMinPrice)+(gMaxPrice+aMaxPrice+cMaxPrice+sMaxPrice+mMaxPrice))/2);
            System.out.println("=================================================================================");
        }
    }

    public static void printCategories(){
        System.out.println("Product Category Specification");
        System.out.println("[1] Groceries");
        System.out.println("[2] Electrical Appliances");
        System.out.println("[3] Clothing Fashion");
        System.out.println("[4] School Materials & Stationeries");
        System.out.println("[5] Medicine & Medical Supplies");
        System.out.println("---------------------------------------------------------------------------------");
    }

    public static void clear(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static int errorHandling(Scanner input){
        int num = 0;
        try{
            num = input.nextInt();
        } catch(Exception e){
            num = 0;
        }

        return num;
    }
}