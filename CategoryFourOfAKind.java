import java.util.List;

public class CategoryFourOfAKind extends Category{
   public CategoryFourOfAKind(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      int[] counts = new int[7];
      for(Die d : dice){
         counts[d.getFaceValue()]++;
      }
      for(int i = 1; i <= 6; i++){
         if(counts[i] >= 4){
            return true;
         }
      }
      return false;
   }
   
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         int total = 0;
         for(Die d : dice){
            total += d.getFaceValue();
         }
         value = total;
      } else {
         value = 0;
      }
   }
}
