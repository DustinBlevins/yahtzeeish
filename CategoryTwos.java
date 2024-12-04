import java.util.List;

public class CategoryTwos extends Category{
   public CategoryTwos(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      return true;
   }
   
   public void setScore(List<Die> dice){
      int result = 0;
      for(Die d: dice){
         if(d.getFaceValue() == 2){
            result++;
         }
      }
      value = result*2;
   }
   
}