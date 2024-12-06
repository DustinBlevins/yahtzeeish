import java.util.List;

public class CategoryFives extends Category{
   public CategoryFives(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      return true;
   }
   
   public void setScore(List<Die> dice){
      int result = 0;
      for(Die d: dice){
         if(d.getFaceValue() == 5){
            result++;
         }
      }
      value = result;
   }
   
}