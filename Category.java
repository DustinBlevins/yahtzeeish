import java.util.List;

public abstract class Category {

   protected String name;
   protected int value = -1;
   
   public Category(String n){
      name = n;
   }
   
   public int getValue(){
      return value;
   }

   public boolean isAvailable(){
      return value == -1;
   }
   
   public String toString(){
      return name;
   }

   public abstract boolean isMatch(List<Die> dice);
   public abstract void setScore(List<Die> dice);
   

  }