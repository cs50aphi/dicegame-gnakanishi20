
public class Die
{
    // Instance Variables
    int sides;
    
    // Constructor
    public Die()
    {
        sides = 6;
    }
    
    //constrution 
    public Die(int s)
    {
        sides = s;
    }
    
    // Methods
    public int roll()
    {
       int r = (int)(Math.random() * sides) + 1;
       return r;
    }
}