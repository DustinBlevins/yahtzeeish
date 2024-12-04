import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CategoryFullHouse extends Category{
   public CategoryFullHouse(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      ArrayList<Die> tempDice = new ArrayList<Die>();
      tempDice.addAll(dice);
      Collections.sort(tempDice);
      int[] counts = new int[5];
      for(int i=0; i<tempDice.size(); i++){
         counts[i] = count(tempDice, tempDice.get(i).getFaceValue());
      }
      System.out.println("tempDice = "+tempDice);
      // if(findMin(counts) == 2 && findMax(counts) == 3){
      //    return true;
      // }
      return false;
   }
   
   public int count(List<Die> dice, int value){
      int result = 0;
      for(Die d: dice){
         if(d.getFaceValue() == value){
            result++;
         }
      }
      return result;
   }
   
   @Override
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         value = 25;
      }
      value = 0;
   }
   
}