import java.util.Random;

public class Die implements Comparable<Die>{
   private int faceValue;
   
   public Die(){
      roll();
   }

   public void roll(){
      Random r = new Random();
      faceValue = r.nextInt(6)+1;
   }
   
   public int getFaceValue(){
      return faceValue;
   }
   
   public String toString(){
      return ""+faceValue;
   }
   
   public int compareTo(Die other){
      return this.faceValue - other.getFaceValue();
   }
}