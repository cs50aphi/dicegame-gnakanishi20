import java.util.Scanner;

public class DieDriver
{
    public static void main(String[] args)
    {

        boolean gameOver = false;
        boolean tie = false;
        int goal = 100;
        //initialises start locations
        int location1 = 0;
        int location2 = 0;
        
        //creates scanner
        Scanner kb = new Scanner(System.in);
        
        //initializing how many sides of the dice there are
        System.out.println("how many sides does your die have?");
        int sides = kb.nextInt();
        
        //dice rolls for players
        Die p1 = new Die(sides);
        Die p2 = new Die(sides);
        
        //Dice rolls for rebuttle
        Die last1 = new Die(sides);
        Die last2 = new Die(sides);
        
        // while game over is false
        while (!gameOver)
        {
            // report player location
        System.out.println("player 1 is at " + location1);
        System.out.println("player 2 is at " + location2);
        pause();
            //roll for p1
            int tempRoll = p1.roll();
            //roll for p2
            int secondRoll = p2.roll();
            //roll for p1 rebuttle
            int lastRoll1 = last1.roll();
             //roll for p2 rebuttle
            int lastRoll2 = last2.roll();
            
            //if p1 has won set hame over to true
            if(location1 + tempRoll == goal)
            {
                location1 += tempRoll;
                //checks to see if p2 can roll to tie the game
                if(location2 >= (goal - sides))
                {
                    //rolled for tie
                    location2 += secondRoll;
                    //action if the last roll did not reach the goal
                    if (location2 < 100)
                    {
                        System.out.println("Player 1 rolls a " + tempRoll);
                        System.out.println("player 1 wins!");
                        location1 += tempRoll;
                        gameOver = true;
                    }
                    //action if the last roll reaches the goal and p2 is now tied with p1
                    else if (location2 == 100)
                    {
                        System.out.println("it's a tie! Roll for rebuttle!");
                        
                        if(lastRoll1 == lastRoll2)
                        {
                            System.out.println("Its a TIE!");
                            gameOver = true;
                        }
                        else if(lastRoll1 > lastRoll2)
                        {
                            System.out.println("player 1 wins!");
                            gameOver = true;
                        }
                        else if (lastRoll1 < lastRoll2)
                        {
                            System.out.println("player 2 wins!");
                            gameOver = true;
                        }
                    }
                    else 
                    {
                        System.out.println("player 1 wins!");
                        gameOver = true;
                    }
                }
                else
                {
                    System.out.println("Player 1 rolls a " + tempRoll);
                    System.out.println("player 1 wins!");
                    gameOver = true;
                }
            }
            //action when p1 roll if he doesn't win on it
            else if (location1 + tempRoll < goal)
            {
                System.out.println("Player 1 rolls a " + tempRoll);
                location1 += tempRoll;
            }
            // what to do when the roll exceeds the goal
            else
            {
                 System.out.println("Player 1 rolled higher than the goal so the number doesn't count");
            }
            
            //p2 roll
            if(gameOver == false)
            {
                //all of p2 rolls and wins
                if(location2 + secondRoll == goal)
                {
                System.out.println("Player 2 rolls a " + secondRoll);
                System.out.println("player 2 wins!");
                location2 += secondRoll;
                gameOver = true;
                }
                 //action if p2 roll if he doesn't win on it
                else if (location2 + secondRoll < goal)
                {
                System.out.println("Player 2 rolls a " + secondRoll);
                location2 += secondRoll;
                }
                else
                {
                 System.out.println("Player 2 rolled higher than the goal so the number doesn't count");
                }
            }
        }
    }


        //if not gone over add to p1 location

        //add roll to location 1
        //do same for player 2

        // Scanner kb = new Scanner(System.in);
        // System.out.println("How many sides does your dice have?");
        // int s = kb.nextInt();

        // Die d = new Die();
        // Die c = new Die(s);
        // int roll = c.roll();
        // System.out.println("You rolled a " + roll);
    
    public static void pause()
        {
            Scanner kb = new Scanner(System.in);
            System.out.println("Press any key to continue");
            kb.nextLine();
        }
}