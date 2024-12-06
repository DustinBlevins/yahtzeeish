import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class CategorySmallStraight extends Category{
   public CategorySmallStraight(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      ArrayList<Integer> faceValues = new ArrayList<>();
      for(Die d : dice){
         if(!faceValues.contains(d.getFaceValue())){
            faceValues.add(d.getFaceValue());
         }
      }
      Collections.sort(faceValues);

         if (faceValues.containsAll(Arrays.asList(1, 2, 3, 4))) { 
         return true;         
         }
      return false;
   }
   
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         value = 30;
      } else {
         value = 0;
      }
   }
}
