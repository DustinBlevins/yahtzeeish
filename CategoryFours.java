import java.util.List;

public class CategoryFours extends Category{
   public CategoryFours(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      return true;
   }
   
   public void setScore(List<Die> dice){
      int result = 0;
      for(Die d: dice){
         if(d.getFaceValue() == 4){
            result++;
         }
      }
      value = result;
   }
   
}