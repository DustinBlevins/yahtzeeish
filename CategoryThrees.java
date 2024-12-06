import java.util.List;

public class CategoryThrees extends Category{
   public CategoryThrees(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      return true;
   }
   
   public void setScore(List<Die> dice){
      int result = 0;
      for(Die d: dice){
         if(d.getFaceValue() == 3){
            result++;
         }
      }
      value = result;
   }
   
}