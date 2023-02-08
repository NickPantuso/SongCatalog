package songCatalog;

public class Song {

   private String songName;
   private String artistName;
   private String songGenre;
   
   Song() {
      songName = "";
      artistName = "";
      songGenre = "";
   }
   
   Song(String songName, String artistName, String songGenre) {
      this.songName = songName;
      this.artistName = artistName;
      this.songGenre = songGenre;
   }
   
   public Song changeSong(String songName, String artistName, String songGenre) {
      return new Song(songName, artistName, songGenre);
   }
   
   public String getSong() {
      return songName;
   }
   
   public String getArtist() {
      return artistName;
   }
   
   public String getGenre() {
      return songGenre;
   }
   
   public void printInfo() {
      System.out.println(artistName + " - " + songName + " | " + songGenre);
   }
}