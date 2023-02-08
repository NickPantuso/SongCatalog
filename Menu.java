package songCatalog;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

   private ArrayList<Song> songList;
   private Scanner scnr;
   
   Menu() {
      songList = new ArrayList<Song>();
      scnr = new Scanner(System.in);
   }
   
   public void displayMenu() {
      System.out.println("Menu:");
      System.out.println("a - Add song to catalog");
      System.out.println("r - Replace song");
      System.out.println("d - Delete song");
      System.out.println("dc - Display catalog");
      System.out.println("dsg - Display all songs within a genre");
      System.out.println("q - quit");
      System.out.println();
      System.out.println("Enter a command:");
   }
   
   public void inputDetector(String userInput) {
      String input = userInput;
      if(input.equals("a")) {
         addSong();
         displayMenu();
         input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
      if(input.equals("r")) {
         replaceSong();
         displayMenu();
         input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
      if(input.equals("d")) {
         deleteSong();
         displayMenu();
         input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
      if(input.equals("dc")) {
         displayCatalog();
         displayMenu();
         input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
      if(input.equals("dsg")) {
         displaySongsInGenre();
         displayMenu();
         input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
      if(input.equals("q")) {
         quit();
      }
   }

   public void addSong() {
      String userSong, userArtist, userGenre = "";
      System.out.println("Enter the song's title:");
      userSong = scnr.nextLine();
      System.out.println("Enter the artist's name:");
      userArtist = scnr.nextLine();
      System.out.println("Enter the song's genre:");
      userGenre = scnr.nextLine();
      System.out.println();
      System.out.println("Your song has been added!");
      System.out.println();
      addToList(new Song(userSong, userArtist, userGenre));
   }
   
   public void addToList(Song s) {
      songList.add(s);
   }


   public void replaceSong() {
      String userSong, userArtist, userGenre = "";
      int exist = 0;
      System.out.println("Please enter the title of the song you'd like to replace (capitalization matters!):");
      String replaceSong = scnr.nextLine();
      System.out.println("Please enter the artist of the song (capitalization matters!):");
      String replaceArtist = scnr.nextLine();
      System.out.println();
      for(int i = 0; i < songList.size(); i++) {
          if(replaceSong.equals(songList.get(i).getSong()) && replaceArtist.equals(songList.get(i).getArtist())) {
             exist = 1;
             System.out.println("Enter the new song's title:");
             userSong = scnr.nextLine();
             System.out.println("Enter the new artist's name:");
             userArtist = scnr.nextLine();
             System.out.println("Enter the new song's genre:");
             userGenre = scnr.nextLine();
             System.out.println();
             songList.set(i, songList.get(i).changeSong(userSong, userArtist, userGenre));
             System.out.println("Your song has been replaced!");
             System.out.println();
          }
      }
      if (exist == 0) {
         System.out.println("Sorry, that song and artist combination doesn't exist in your catalog.");
         System.out.println();
         displayMenu();
         String input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
   }
   
   public void deleteSong() {
      int exist = 0;
      System.out.println("Please enter the title of the song you'd like to delete (capitalization matters!):");
      String deleteSong = scnr.nextLine();
      System.out.println("Please enter the artist of the song (capitalization matters!):");
      String deleteArtist = scnr.nextLine();
      System.out.println();
      for(int i = 0; i < songList.size(); i++) {
          if(deleteSong.equals(songList.get(i).getSong()) && deleteArtist.equals(songList.get(i).getArtist())) {
             exist = 1;
             songList.remove(i);
             System.out.println("Your song has been deleted!");
             System.out.println();
          }
      }
      if (exist == 0) {
         System.out.println("Sorry, that song and artist combination doesn't exist in your catalog.");
         System.out.println();
         displayMenu();
         String input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      }
   }
   
   public void displayCatalog() {
      System.out.println("Your Music Catalog:");
      for(int i = 0; i < songList.size(); i++) {
      songList.get(i).printInfo();
      }
      System.out.println();
   }
      
   public void displaySongsInGenre() {
      int exist = 0;
      System.out.println("Please enter a genre to display songs (capitalization matters!):");
      String genreSort = scnr.nextLine();
      System.out.println();
      for(int i = 0; i < songList.size(); i++) {
         if(genreSort.equals(songList.get(i).getGenre())) {
            exist = 1;
            songList.get(i).printInfo();
         }
      }
      if (exist == 0) {
         System.out.println("Sorry, that genre doesn't exist in your catalog.");
         System.out.println();
         displayMenu();
         String input = scnr.nextLine();
         System.out.println();
         inputDetector(input);
      } else {System.out.println();}
   }
   
   public void quit() {
      System.out.println("CREDITS:");
      System.out.println("Benjamin Blake");
      System.out.println("Nicholas Pantuso");
      System.out.println("Jayson Paul");
      System.exit(0);
   }
}
