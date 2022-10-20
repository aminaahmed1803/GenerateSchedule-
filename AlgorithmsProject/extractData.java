import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.*;

public class extractData {

   Student[] studentPref;
   String[] timeSlots;
   String[] rooms;
   String[] professors;
   String contraints;
   String prefrence;
   BufferedReader br;

   public extractData(String prefs, String conts) {

      contraints = conts;
      prefrence = prefs;

   }

   public void storePref() {

      try {
         br = new BufferedReader(new FileReader(this.prefrence));
      } catch (IOException e) {
         System.out.println(e);
      }

      try {
         String line = br.readLine();

         String[] frag = line.split("\t");
         // System.out.println(frag[1]);
         int l = Integer.parseInt(frag[1]);
         studentPref = new Student[l];
         int idx = 0;

         while (idx < l) {
            line = br.readLine();
            frag = line.split("\t");
            // System.out.println(frag.length);
            studentPref[idx] = new Student(frag[0], frag[1]);
            idx++;
         }

      } catch (IOException ioe) {
         return;
      }

   }

   public void storeContraints() {
      try {
         br = new BufferedReader(new FileReader(this.contraints));
      } catch (IOException e) {
         System.out.println(e);
      }

   }

   /*
    * public void printPref() {
    * for (int i = 0; i < studentPref.length; i++) {
    * System.out.println(studentPref[i].toString());
    * }
    * }
    */

   public static void main(String[] args) {
      if (args.length != 2) {
         System.out.println("Usage: <prefences> <constraints>");
      }
      String prefrences = args[0];
      String constrains = args[1];
      extractData e = new extractData(prefrences, constrains);
      e.storePref();
      // e.printPref();

   }

}
