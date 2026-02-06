import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class User{
    int id;
    String name;
    int age;

    User(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class crud{
    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            try{
                System.out.println("-----CRUD Menu-----");
                System.out.println("1. Create User");
                System.out.println("2. Read Users");
                System.out.println("3. Updated User");
                System.out.println("4. Delete User");
                System.out.println("5.Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        createUser();
                        break;
                    case 2:
                        readUsers();
                        break;
                    case 3:
                        updateUser();
                        break;
                    case 4:
                        deleteUser();
                        break;
                    case 5:
                        System.out.println("Exiting......");
                        return;
                    default:
                        System.out.println("Invalid Choice! Please choose 1-5.");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); //clear buffer
            }catch (Exception e){
                System.out.println("Something went wrong: "+ e.getMessage());
                sc.nextLine();
            }
        }
    }
    //CREATE 
    static void createUser(){
    try{
        System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        if(age<=0){
            System.out.println("Age must be positive.");
            return;
        }
        users.add(new User(id,name,age));
        System.out.println("Users added successfully!");
        }catch(InputMismatchException e){
            System.out.println("Invalid input! ID and age must be numbers.");
            sc.nextLine();
        }
    }

    //READ
    static void readUsers(){
        if(users.isEmpty()){
            System.out.println("No users found.");
            return;
        }
        for(User u: users){
            System.out.println("Id: "+u.id+", Name: "+u.name+", Age: "+u.age);
        }
    }

    //UPDATE
    static void updateUser(){
        try{
            System.out.print("Enter the Id to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            for(User u: users){
                if(u.id == id){
                    System.out.print("Enter new name: ");
                    u.name = sc.nextLine();

                    System.out.print("Enter new age: ");
                    u.age = sc.nextInt();

                    System.out.println("User updated successfully!");
                    return;
                }
            }System.out.println("User not found!");
        }catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter correct values.");
            sc.nextLine();
        }
    }   

    //DELETE
    static void deleteUser(){
        try{
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            for(User u: users){
                if(u.id == id){
                    users.remove(u);
                    System.out.println("User Deleted successfully!");
                    return;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input! ID must be number.");
            sc.nextLine();
        }
    }
}

