import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class CategoryLargeStraight extends Category{
   public CategoryLargeStraight(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      ArrayList<Integer> faceValues = new ArrayList<>();
      for(Die d : dice){
         faceValues.add(d.getFaceValue());
      }
      Collections.sort(faceValues);

      // Check for sequences: 1-2-3-4-5 or 2-3-4-5-6
      if (faceValues.containsAll(Arrays.asList(1, 2, 3, 4, 5))){
    return true;
      }
      if (faceValues.containsAll(Arrays.asList(2, 3, 4, 5,6))){
    return true;
   }
      return false;
   }
   
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         value = 40;
      } else {
         value = 0;
      }
   }
}
