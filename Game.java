import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game{
   private List<Player> players;
   private Player currentPlayer;
   private List<Die> dice;
   private int round;
   private Scanner keyboard = new Scanner(System.in);
   
   public Game(List<Player> p){
      dice = new ArrayList<Die>();
      players = p;
      for(int i=0; i<5; i++){
         Die d = new Die();
         d.roll();
         dice.add(d);
      }
   }

   public void startGame(){
      currentPlayer = players.get(0);
      round = 1;
   }
   
   public void playersTurn(){
      for(Die d: dice){
         d.roll();
      }
      int count = 0;
      int[] intChoice = new int[0];
      do{
         System.out.println("Dice = "+dice);
         System.out.print("Enter index of dice to reroll or -1 to keep all: ");
         String[] strChoice = keyboard.nextLine().split(",");
         intChoice = new int[strChoice.length];
         
         for(int i=0; i < strChoice.length; i++){
            intChoice[i] = Integer.parseInt(strChoice[i].trim());
         }
         
         if(intChoice[0] == -1) {
            break;
         }
            
         //reroll
        
         for(int i : intChoice) {
            if(i >= 0 && i < dice.size()) {
               dice.get(i).roll();
            }
         }
         
         System.out.println("Dice after reroll = " + dice);
         count++;
      } while (count < 3 && intChoice[0] != -1);
      
      
      System.out.println("Available options are:");
      ArrayList<Category> availableCategories = currentPlayer.getScorecard().availableCategories();
      for(int i=0; i<availableCategories.size(); i++){
         System.out.println((i+1)+") "+availableCategories.get(i));
      }
      System.out.print(currentPlayer+" select an option: ");
      int selection = keyboard.nextInt();
      keyboard.nextLine();
      availableCategories.get(selection-1).setScore(dice);
   }

   public void nextTurn(){
      int nextPlayerIndex = (players.indexOf(currentPlayer)+1) % players.size();
      if(nextPlayerIndex == 0){
         round++;
      }
      currentPlayer = players.get(nextPlayerIndex);
   }

   public Boolean isGameOver(){
      for(Player p: players){
         if(p.getScorecard().availableCategories().size() > 0){
            return false;
         }
      }
      return true;
      // return round > 13;
   }

   
   public Player getCurrentPlayer(){
      return currentPlayer;
   }
   
   public int getRound(){
      return round;
   }
   
   public void declareWinner() {
      int highestScore = -1;
      List<Player> winners = new ArrayList<>();
      
      for (Player player : players) {
         int playerScore = player.getScorecard().getOverallScore();
         if (playerScore > highestScore) {
            highestScore = playerScore;
            winners.clear();
            winners.add(player);
         }
         else if (playerScore == highestScore) {
            winners.add(player);
         }
      }
      
     if (winners.size() == 1) {
        System.out.println("The winner is " + winners.get(0).getName() + " with a score of " + highestScore + "!");
    } else {
        System.out.println("It's a tie between:");
        for (Player winner : winners) {
            System.out.println("- " + winner.getName() + " with a score of " + highestScore);
        }
    }               
}
}