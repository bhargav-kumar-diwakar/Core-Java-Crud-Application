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
}