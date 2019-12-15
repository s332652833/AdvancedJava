//Program that uses file IO and search to find/create usernames

package advanced.java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arup
 */
public class FileIOandSearch {
    
    //method to easily sort and check through file
    private static boolean Find(ArrayList<String> userlist, String word) {
        for (String i : userlist) {
            if (i.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        File file = new File("newfile.txt");
        
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter print = new PrintWriter(file);
        print.write("akar1");
        print.close();
        
        ArrayList<String> Userlist;
        try (Scanner f = new Scanner(file)) {
            Userlist = new ArrayList<>();
            while (f.hasNext()) {
                Userlist.add(f.next());
            }
        }

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("If you already have a username type 'login', to create new username type 'new', to quit type 'exit'.");

                String option = input.nextLine();
                switch(option){
                    case ("login"):
                    System.out.println("Type in username(this is case sensitive): ");
                    String name = input.nextLine();
                    if (Find(Userlist, name)) {
                        System.out.printf("Hello User %s\n", name);
                    } else {
                        System.out.println("Not a listed username");
                    }
                    break;
                    
                    case ("new"):
                    System.out.println("What is the new username you would like to create?");
                    String newuser = input.nextLine();  
                    if (!Find(Userlist, newuser)) {
                        Userlist.add(newuser);
                        print.write(newuser);
                        System.out.printf("Username %s has been created\n", newuser);
                    } else {
                        System.out.println("Username already exists");
                    }
                    break;
                    case ("exit"): 
                    System.exit(0);
                    
                    default:
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Not a proper response");
            }
    }
        }
    }

