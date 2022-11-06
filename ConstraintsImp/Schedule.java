import java.util.ArrayList;

/**
 * A class that creates a schedule which accounts
 * for the following constraints
 * overlapping timeSlots
 * students having more than five prefrences
 * professors teaching more or less than two classes
 * scheduling lab_courses
 * scheduling sections
 * scheduling classes in certain buildings
 */

public class Schedule {

   // a list of scheduled courses
   public Course[] classCounts;

   // list of students with there prefrences
   private Student[] student_prefs;

   // contains rooms ordered by capacity
   private Room[] rooms;

   // A list of timeslots
   private timeSlots[] times;

   // the total number of classes
   private int total_classes;

   // the total number of professors
   private int total_profs;

   /**
    * a constructor
    */
   public Schedule(String prefs, String conts) {
      fillData(prefs, conts);

   }

   private void fillData(String prefs, String conts) {

      extractData e = new extractData(prefs, conts);
      student_prefs = e.storePref();
      ArrayList<Integer> t = e.storeTime();
      rooms = e.storeRoom();
      String[] prof = e.storeProf();

      times = new timeSlots[t.size()];
      for (int i = 0; i < t.size(); i++) {
         times[i] = new timeSlots(t.get(i));
      }

      for (String s : prof) {
         System.out.println(s);
      }
      this.total_classes = e.classes;
      this.total_profs = e.profs;
   }

   public void makeSchedule() {

      for (int i = 0; i < rooms.length; i++) {
         for (int j = 0; j < times.length; j++) {
            // if (rooms[i] is assigned to overlapping timeslot) continue;
            // if (times[j] has no AvailableStudents or no class) continue;
            // do {
            // Find the next MostFamousClass
            // if (MostFamousClass can’t be schedule in room[i] OR Prof for MostFamousClass
            // is unavailable)
            // RemClass from preference list of AvailableStudents
            // else break;
            // } while (true)
            // MostFamousClass = this room, this timeslot
            // labs if mostFamousClass is lab, schedule lab in next overlapping timeslot
         }
      }

   }

   /**
    * 
    * @return
    */
   public void makeSections() {

   }

   /*
    * A fucntion which determines if there is
    * an overlap between two classes
    */
   public void classOverlap() {

   }

   /**
    * a function which checks if the room is okay for a course
    * 
    * @return
    */
   public boolean validRoom() { // joon
      return false;
   }

   public static void main(String[] args) {
      if (args.length != 2) {
         System.out.println("Usage: <prefences> <constraints>");
         return;
      }
      String prefrences = args[0];
      String constraints = args[1];
      Schedule s = new Schedule(prefrences, constraints);

   }

}