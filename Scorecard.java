import java.util.ArrayList;
import java.util.List;

public class Scorecard{
   private List<Category> scoreList;
   private int overallScore;
   
   public Scorecard(){
      //TODO create all 13 categories for the scorecard
      scoreList = new ArrayList<Category>();
      scoreList.add(new CategoryOnes("ones"));                       //add all the ones together
      scoreList.add(new CategoryTwos("twos"));                       //add all the twos together
      // scoreList.add(new CategoryThrees("threes"));                //add all the threes together
      // scoreList.add(new CategoryFours("fours"));                  //add all the fours together 
      // scoreList.add(new CategoryFives("fives"));                  //add all the fives together
      // scoreList.add(new CategorySixes("sixes"));                  //add all the sixes together
      // scoreList.add(new CategorySmallStraight("small straight")); //must have four values in a row
      // scoreList.add(new CategoryLargeStraight("large straight")); //must have five values in a row
      scoreList.add(new CategoryFullHouse("full house"));            //must have three of one kind and two of another
      // scoreList.add(new CategoryThreeOfAKind("three of a kind")); //three dice must be the same but add all 5 dice values together
      // scoreList.add(new CategoryFourOfAKind("four of a kind"));   //four dice must be the same but add all 5 dice values together
      // scoreList.add(new CategoryYahtzee("yahtzee"));              //all 5 dice match -> scores 100 points
      // scoreList.add(new CategoryChance("chance"));                //add all the dice together
   }

   public int calculateScore(){
      //TODO Update to calculate score
      overallScore = 0;
      for(Category c: scoreList){
         if(!c.isAvailable()){
            overallScore += c.getValue();
         }
      }
      return overallScore;
   }

   public ArrayList<Category> availableCategories(){
      ArrayList<Category> result = new ArrayList<Category>();
      for(Category c: scoreList){
         if(c.isAvailable()){
            result.add(c);
         }
      }
      return result;
   }
   
   public int getOverallScore(){
      overallScore = calculateScore();
      return overallScore;
   }

  }