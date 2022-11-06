public class Room {

   public int maxCapacity;
   public String name;

   public Room(int maxNum, String n) {
      this.maxCapacity = maxNum;
      this.name = n;
   }

   public int getCapacity() {
      return maxCapacity;
   }

   @Override
   public String toString() {
      return name;
   }
}
