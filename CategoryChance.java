import java.util.List;

public class CategoryChance extends Category{
   public CategoryChance(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      return true;
   }
   
   public void setScore(List<Die> dice){
      int total = 0;
      for(Die d : dice){
         total += d.getFaceValue();
      }
      value = total;
   }
}
