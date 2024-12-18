import java.util.List;

public class CategoryFullHouse extends Category{
   public CategoryFullHouse(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      int[] counts = new int[7]; // Indices 1-6
      for(Die d : dice){
         counts[d.getFaceValue()]++;
      }
      boolean hasThreeOfAKind = false;
      boolean hasPair = false;
      for(int i = 1; i <= 6; i++){
         if(counts[i] == 3){
            hasThreeOfAKind = true;
         } else if(counts[i] == 2){
            hasPair = true;
         }
      }
      return hasThreeOfAKind && hasPair;
   }
   
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         value = 25;
      } else {
         value = 0;
      }
   }
}
