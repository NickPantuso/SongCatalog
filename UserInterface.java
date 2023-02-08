package songCatalog;

import java.util.Scanner;

public class UserInterface {

   public static void main(String[] args) {
   
      Scanner scnr = new Scanner(System.in);
      
      Menu menu = new Menu();
      
      System.out.println("Please enter a number of songs, or 0 to quit:");
      int numSongs = scnr.nextInt();
      System.out.println();
      scnr.nextLine();
      
      if(numSongs != 0) {
         for(int i = 1; i <= numSongs; i++) {
            menu.addSong();
         }
      }else if(numSongs == 0) {
         menu.quit();
      }
      
      menu.displayCatalog();
      menu.displayMenu();
      String userInput = scnr.nextLine();
      System.out.println(); 
      menu.inputDetector(userInput);
      scnr.close();
   }
}