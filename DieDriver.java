import java.util.Scanner;

public class DieDriver
{
    public static void main(String[] args)
    {

        boolean gameOver = false;
        boolean tie = false;
        int goal = 100;
        int location1 = 0;
        int location2 = 0;
        //create players p1 and p2
        Scanner kb = new Scanner(System.in);
        System.out.println("how many sides does your die have?");
        int sides = kb.nextInt();
        Die p1 = new Die(sides);
        Die p2 = new Die(sides);
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
        //roll for player 1 and check to see if w
            int tempRoll = p1.roll();
            int secondRoll = p2.roll();
            int lastRoll1 = last1.roll();
            int lastRoll2 = last2.roll();
            //if p1 has won set hame over to true
            if(location1 + tempRoll == goal)
            {
                location1 += tempRoll;
                if(location2 >= (goal - sides))
                {
                    location2 += secondRoll;
                    if (location2 < 100)
                    {
                        System.out.println("Player 1 rolls a " + tempRoll);
                        System.out.println("player 1 wins!");
                        location1 += tempRoll;
                        gameOver = true;
                    }
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
            else if (location1 + tempRoll < goal)
            {
                System.out.println("Player 1 rolls a " + tempRoll);
                location1 += tempRoll;
            }
            else
            {
                 System.out.println("Player 1 rolled higher than the goal so the number doesn't count");
            }
            
            //p2 roll
            if(gameOver == false)
            {
                if(location2 + secondRoll == goal)
                {
                System.out.println("Player 2 rolls a " + secondRoll);
                System.out.println("player 2 wins!");
                location2 += secondRoll;
                gameOver = true;
                }
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