import java.util.List;

public class CategoryYahtzee extends Category{
   public CategoryYahtzee(String n){
      super(n);
   }

   public boolean isMatch(List<Die> dice){
      int firstValue = dice.get(0).getFaceValue();
      for(Die d : dice){
         if(d.getFaceValue() != firstValue){
            return false;
         }
      }
      return true;
   }
   
   public void setScore(List<Die> dice){
      if(isMatch(dice)){
         value = 50;
      } else {
         value = 0;
      }
   }
}
