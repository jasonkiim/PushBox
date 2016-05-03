//Title: PushBox
//Name : Jason Kim
//Date : Tuesday, January 21st 2014
//Descrpition of the program: The objective of this game is to push all the boxes into the pink circles locations placed randomly within the map.
// The "PushBox" class.
import java.awt.*;
import hsa.Console;

public class PushBox
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console (30, 105);      //The size of the output screen adjusted

	//Colors used in main method
	Color DisplayBoard = new Color (255, 183, 111); //create Displayboard color
	Color BackGround = new Color (128, 64, 0); //create brown
	//Fonts in main method
	Font gameover = new Font ("Stencil", Font.PLAIN, 70);           //Font for the 'GAME OVER'
	Font tryagainfont = new Font ("Impact", Font.PLAIN, 30);        //Font for the tryagain phrases
	Font charget = new Font ("Impact", Font.PLAIN, 20);             //Font for press q or r to try again


	//Results when the user presses Enter or Space
	char letter = ' ';
	while (letter != ((char) 10))           //while char does not equal 'Enter'
	{
	    //Returning to mainscreen
	    letter = MainScreen ();

	    //Error trap to ensure that the user can only enter 'Enter' or 'Space' in the main screen
	    while (letter != ((char) 10) && letter != (char) 32)
	    {
		letter = c.getChar ();
	    }
	    if (letter == ((char) 10))
	    {
		c.clear ();
	    }
	    else if (letter == ((char) 32))     //Calls Rules screen when the user enters 'Space'
	    {
		c.clear ();
		letter = Rules ();
	    }
	}
	//x and y coordinates of initial position of the character for each level
	int xvalue1 = 280;
	int yvalue1 = 280;

	int xvalue2 = 240;
	int yvalue2 = 200;

	int xvalue3 = 120;
	int yvalue3 = 360;

	int xvalue4 = 520;
	int yvalue4 = 40;

	int xvalue5 = 400;
	int yvalue5 = 80;


	//Number of boxes needed to be filled in for each level
	int FirstMapWin = 4;
	int SecondMapWin = 3;
	int ThirdMapWin = 3;
	int FourthMapWin = 8;
	int FifthMapWin = 9;

	//Max number of movements for each level
	int FistMapCounter = 15;
	int SecondMapCounter = 35;
	int ThirdMapCounter = 100;
	int FourthMapCounter = 130;
	int FifthMapCounter = 160;

	//this char will determine whether if the player will quit or try again
	char tryagain = ' ';


	int winnum = 1;


	//this char will allow the user to redo the level again
	char redolevel = ' ';


	for (;;)    //Infinite loop so that the program is always running
	{


	    //FirstMap
	    if (winnum == 1)
	    {
		int[] [] Maps =
		    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 0, 2, 0, 3, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 3, 2, 0, 0, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 3, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		    };
		MapMaker (Maps);        //Makes the map
		CharcreateDown (Maps, xvalue1, yvalue1);        //Initial position of the character in the beginning of the game
		winnum = MoveMents (winnum, Maps, xvalue1, yvalue1, FistMapCounter, FirstMapWin, redolevel);
		if (winnum < 0 && winnum > -1000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //exceeding the max movements
		    c.clear ();
		    int x, y;
		    BackGroundRulesExit ();         //calls the background for this page

		    c.setFont (gameover);
		    c.setColor (Color.yellow);
		    c.drawString ("GAME OVER", 220, 200);
		    c.setFont (tryagainfont);
		    c.drawString ("You've exceeded the maximum number of steps", 130, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) twice to try again", 140, 350);
		    delay (1000);
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')    //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')         //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')            //Recalls the map again when the person presses T
			{
			    winnum = 1;
			    break;
			}
		    }
		}
		else if (winnum < 0 && winnum > -5000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //while playing
		    c.clear ();
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (tryagainfont);
		    c.setColor (Color.yellow);
		    c.drawString ("Are you sure you want to quit?", 150, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) to play again", 220, 350);
		    delay (1000);
		    
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 1;
			    break;
			}
		    }
		}
		else if (winnum > 100)  //When user types in 'r' or 'R', it will redo the level
		{
		    winnum = 1;
		}
	    }
	    else if (winnum == 2)   //Second Map
	    {
		int[] [] Maps =
		    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 0, 2, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0},
			{0, 0, 0, 0, 1, 3, 0, 0, 0, 1, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 3, 2, 0, 0, 0, 1, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 2, 3, 1, 0, 0},
			{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		    };
		MapMaker (Maps);
		CharcreateRight (Maps, xvalue2, yvalue2);
		winnum = MoveMents (winnum, Maps, xvalue2, yvalue2, SecondMapCounter, SecondMapWin, redolevel);
		if (winnum < 0 && winnum > -1000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //exceeding the max movements
		    c.clear ();
		    int x, y;
		    //Background of the rules screen
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (gameover);
		    c.setColor (Color.yellow);

		    c.drawString ("GAME OVER", 220, 200);
		    c.setFont (tryagainfont);
		    c.drawString ("You've exceeded the maximum number of steps", 130, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) twice to try again", 140, 350);
		    delay (1000);
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 2;             
			    break;
			}
		    }
		}
		else if (winnum < 0 && winnum > -5000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //while playing
		    c.clear ();
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (tryagainfont);
		    c.setColor (Color.yellow);
		    c.drawString ("Are you sure you want to quit?", 150, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) to play again", 220, 350);
		    delay (1000);

		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 2;
			    break;
			}
		    }
		}
		else if (winnum > 100)  //When user types in 'r' or 'R', it will redo the level
		{
		    winnum = 2;
		}
	    }

	    else if (winnum == 3)       //Third Map
	    {
		int[] [] Maps =
		    {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 1},
			{1, 0, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 2, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
			{1, 3, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
			{1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		    };
		MapMaker (Maps);
		CharcreateLeft (Maps, xvalue3, yvalue3);
		winnum = MoveMents (winnum, Maps, xvalue3, yvalue3, ThirdMapCounter, ThirdMapWin, redolevel);
		if (winnum < 0 && winnum > -1000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //exceeding the max movements
		    c.clear ();
		    int x, y;
		    //Background of the rules screen
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (gameover);
		    c.setColor (Color.yellow);

		    c.drawString ("GAME OVER", 220, 200);
		    c.setFont (tryagainfont);
		    c.drawString ("You've exceeded the maximum number of steps", 130, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) twice to try again", 140, 350);
		    delay (1000);
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{   
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 3;
			    break;
			}
		    }
		}
		else if (winnum < 0 && winnum > -5000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //while playing
		    c.clear ();
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (tryagainfont);
		    c.setColor (Color.yellow);
		    c.drawString ("Are you sure you want to quit?", 150, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) to play again", 220, 350);
		    delay (1000);
	 
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 3;
			    break;
			}
		    }
		}
		else if (winnum > 100)  //When user types in 'r' or 'R', it will redo the level
		{
		    winnum = 3;
		}
	    }
	    else if (winnum == 4)       //Fourth Map
	    {
		int[] [] Maps =


		    {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 1, 1, 1, 2, 2, 0, 0, 1, 0, 1, 2, 1},
			{1, 0, 0, 1, 3, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 1, 0, 1, 3, 3, 1, 0, 1, 3, 1, 0, 1},
			{1, 0, 0, 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
			{1, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 2, 0, 3, 1, 1, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 3, 1, 1, 0, 0, 3, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		    };
		MapMaker (Maps);
		CharcreateDown (Maps, xvalue4, yvalue4);
		winnum = MoveMents (winnum, Maps, xvalue4, yvalue4, FourthMapCounter, FourthMapWin, redolevel);
		if (winnum < 0 && winnum > -1000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //exceeding the max movements
		    c.clear ();
		    int x, y;
		    //Background of the rules screen
		    BackGroundRulesExit ();     //calls the background for this page

		    c.setFont (gameover);
		    c.setColor (Color.yellow);

		    c.drawString ("GAME OVER", 220, 200);
		    c.setFont (tryagainfont);
		    c.drawString ("You've exceeded the maximum number of steps", 130, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) twice to try again", 140, 350);
		    delay (1000);
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 4;
			    break;
			}
		    }
		}
		else if (winnum < 0 && winnum > -5000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //while playing
		    c.clear ();
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (tryagainfont);
		    c.setColor (Color.yellow);
		    c.drawString ("Are you sure you want to quit?", 150, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) to play again", 220, 350);
		    delay (1000);
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();
    
			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{       
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 4;
			    break;
			}
		    }
		}
		else if (winnum > 100)  //When user types in 'r' or 'R', it will redo the level
		{
		    winnum = 4;
		}
	    }
	    else if (winnum == 5)   //Fifth Map
	    {
		int[] [] Maps =

		    {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 3, 1, 0, 0, 0, 0, 0, 1, 0, 3, 1},
			{1, 1, 1, 1, 0, 2, 0, 1, 0, 0, 0, 1, 0, 0, 1},
			{1, 3, 1, 1, 0, 0, 2, 0, 0, 1, 0, 2, 2, 0, 1},
			{1, 0, 1, 1, 3, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 1, 1, 3, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1},
			{1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1},
			{1, 0, 0, 2, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 0, 0, 2, 1, 1, 1, 0, 2, 1, 1, 1, 0, 1},
			{1, 1, 3, 0, 3, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		    };
		MapMaker (Maps);
		CharcreateDown (Maps, xvalue5, yvalue5);
		winnum = MoveMents (winnum, Maps, xvalue5, yvalue5, FifthMapCounter, FifthMapWin, redolevel);
		if (winnum < 0 && winnum > -1000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //exceeding the max movements
		    c.clear ();
		    int x, y;
		    //Background of the rules screen
		    BackGroundRulesExit ();     //calls the background for this page

		    c.setFont (gameover);
		    c.setColor (Color.yellow);

		    c.drawString ("GAME OVER", 220, 200);
		    c.setFont (tryagainfont);
		    c.drawString ("You've exceeded the maximum number of steps", 130, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) twice to try again", 140, 350);
		    delay (1000);   
		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{   
			    winnum = 5;
			    break;
			}
		    }
		}
		else if (winnum < 0 && winnum > -5000)       //this page will ask whether if the player wants to play again or quit the game after
		{ //while playing
		    c.clear ();
		    BackGroundRulesExit ();     //calls the background for this page
		    c.setFont (tryagainfont);
		    c.setColor (Color.yellow);
		    c.drawString ("Are you sure you want to quit?", 150, 300);
		    c.setFont (charget);
		    c.drawString (" Press (q) to quit or Press (t) to play again", 220, 350);
		    delay (1000);

		    while (tryagain != 'q' || tryagain != 'Q' || tryagain != 't' || tryagain != 'T')        //the user must enter q, Q, t, or T
		    {
			tryagain = c.getChar ();

			if (tryagain == 'q' || tryagain == 'Q')     //Quits the game when the person presses q or Q
			{
			    break;
			}
			else if (tryagain == 't' || tryagain == 'T')        //Recalls the map again when the person presses T
			{
			    winnum = 5;
			    break;
			}
		    }
		}
		else if (winnum > 100)  //When user types in 'r' or 'R', it will redo the level
		{
		    winnum = 5;
		}
	    }
	    else if (winnum == 6)       //Breaks the game when the person completes all the levels
	    {
		c.clear ();
		ExitPageCompletion ();
		break;
	    }

	    if (tryagain == 'q' || tryagain == 'Q')         //Ends the program when the person wants to quit in the "try again page"
	    {
		c.clear ();
		ExitPage ();
		break;
	    }
	}
    }



    // main method


    public static void Boxes (int x, int y)     //method calling for boxes
    {
	Color boxes = new Color (94, 47, 0); //create color of boxes
	Color outline = new Color (255, 181, 106); //create color of outline
	c.setColor (outline);
	c.fillRect (x, y, 120, 120);
	c.setColor (boxes);
	c.fillRect (x, y, 20, 120);
	c.fillRect (x, y + 100, 120, 20);
	c.fillRect (x, y, 120, 20);
	c.fillRect (x + 100, y, 20, 120);
	c.setColor (Color.black);
	c.drawRect (x, y, 120, 120);
	c.drawLine (x, y, x + 120, y + 120);
	c.drawLine (x + 120, y, x, y + 120);
    }
    
    public static char Rules ()     //method calling for rules page
    {
	//Fonts used for Rules Screen
	Font showcard = new Font ("Showcard Gothic", Font.PLAIN, 50);
	Font berlin = new Font ("Berlin Sans FB", Font.PLAIN, 15);
	Font MovementsMade = new Font ("OCR A Std", Font.PLAIN, 18);
	Color BackGround = new Color (128, 64, 0);
	int x, y;
	//Background of the rules screen
	BackGroundRulesExit ();
	c.setColor (BackGround);
	c.fillRect (120, 120, 600, 360);

	//Title
	c.setColor (Color.yellow);
	c.setFont (showcard);
	c.drawString ("The Rules", 280, 170);

	//Boxes to show point form
	c.setColor (Color.lightGray);
	c.fillRect (135, 200, 15, 15);
	c.fillRect (135, 250, 15, 15);
	c.fillRect (135, 300, 15, 15);
	c.fillRect (135, 350, 15, 15);
	c.fillRect (135, 400, 15, 15);

	//The rules of this game
	c.setFont (berlin);
	c.setColor (Color.yellow);
	c.drawString ("The objective of PushBox is to move the boxes to designated pink circles by pushing them", 160, 210);

	c.drawString ("These boxes are located inside a room surrounded by walls. ", 160, 260);
	c.drawString ("You get to control the pusher within the room.", 160, 275);

	c.drawString ("Use 'W' to move the pusher up, 'S' to move the pusher down,", 160, 310);
	c.drawString ("'A' to move the pusher left, and 'D' to move the pusher right.", 160, 325);

	c.drawString ("The pusher cannot pass thorugh walls or boxes, nor pink circles", 160, 360);
	c.drawString ("and can only push one box at a time (NEVER PULL)", 160, 375);

	c.drawString ("You have limited moves for each level.", 160, 410);
	c.drawString ("If you exceed the limit, then you will LOSE THE GAME!", 160, 425);

	c.setColor (Color.black);
	c.drawString ("Press (q) to go back to main screen.", 250, 460);

	char escape = c.getChar ();
	while (escape != 'q' && escape != 'Q')  //When q is pressed, the user can go back to the main screen, the user can only press q to exit
	{
	    escape = c.getChar ();
	}


	return (escape);        //returns the char q or Q

    }


    public static char MainScreen ()            //mainscreen method
    {
	//Fonts used for mainscreen page
	Font bankgothic = new Font ("Berlin Sans FB Demi", Font.BOLD, 120);
	Font impact = new Font ("Impact", Font.PLAIN, 30);

	//Colors used for Mainscreen
	Color BackGround = new Color (128, 64, 0); //create brown

	//Introduction screen background
	c.setFont (bankgothic);
	c.setColor (BackGround);
	c.fillRect (0, 0, 1000, 1000);

	//Title of the game
	c.setFont (bankgothic);
	c.setColor (Color.black);
	c.drawString ("PushBox", 75, 180);
	c.setFont (bankgothic);
	c.setColor (Color.yellow);
	c.drawString ("PushBox", 90, 180);
	
	//Programmed by Jason Kim
	c.setFont (impact);
	c.drawString ("Programmed by Jason Kim", 90, 230);

	//Boxes on the main screen
	Boxes (650, 400);
	Boxes (650, 280);
	Boxes (650, 160);
	Boxes (530, 280);
	Boxes (530, 400);

	//Start and Procedure Button
	c.setColor (Color.black);
	c.fillRoundRect (15, 320, 500, 75, 40, 40);
	c.fillRoundRect (15, 440, 500, 75, 40, 40);
	c.setColor (Color.yellow);
	c.fillRoundRect (20, 325, 490, 65, 40, 40);
	c.fillRoundRect (20, 445, 490, 65, 40, 40);

	//Start and Procedure phrases
	c.setColor (Color.black);
	c.setFont (impact);
	c.drawString ("Press (Enter) to play the game!", 90, 368);
	c.drawString ("Press (Space) to view the rules!", 80, 488);

	//Char to go back to the main method
	char goback = c.getChar ();
	return (goback);

    }


    public static void ExitPage ()      //Exit Page appears after the person wants to quits the game
    {
	Color BackGround = new Color (128, 64, 0); //create brown
	Font bankgothic = new Font ("Berlin Sans FB Demi", Font.BOLD, 120);
	
	c.setColor (BackGround);
	c.fillRect (0, 0, 1000, 1000);
	//Shadow of the text
	c.setFont (bankgothic);
	c.setColor (Color.black);
	c.drawString ("Thanks For ", 65, 150);
	c.drawString ("Playing ", 65, 250);
	c.drawString ("Pushbox", 65, 370);
	//Writing of the text
	c.setFont (bankgothic);
	c.setColor (Color.yellow);
	c.drawString ("Thanks For ", 75, 150);
	c.drawString ("Playing ", 75, 250);
	c.drawString ("Pushbox", 75, 370);
	CharcreateExitPage (120, 400);
	//Creats boxes on the exit page
	Boxes (240, 400);
	Boxes (360, 400);
	Boxes (480, 400);
	Boxes (600, 400);
    }


    public static void ExitPageCompletion ()      //Exit Page After Completeing the game
    {
	Color BackGround = new Color (128, 64, 0); //create brown
	Font bankgothic = new Font ("Berlin Sans FB Demi", Font.BOLD, 95);
	Font bankgothicQ = new Font ("Berlin Sans FB Demi", Font.BOLD, 60);

	c.setColor (BackGround);
	c.fillRect (0, 0, 1000, 1000);
	
	c.setFont (bankgothicQ);
	c.setColor (Color.black);
	c.drawString ("You have beat all the levels!", 40, 165);
	c.setColor (Color.yellow);
	c.drawString ("You have beat all the levels!", 32, 165);
	
	c.setColor (Color.black);
	c.setFont (bankgothic);
	c.drawString ("Thanks for playing", 15, 270);
	c.drawString ("PushBox!", 200, 370);
	c.setColor (Color.yellow);
	c.setFont (bankgothic);
	c.drawString ("Thanks for playing", 5, 270);
	c.drawString ("PushBox!", 190, 370);
	CharcreateExitPage (120, 400);
	//Creates boxes on exitpagecompletion
	Boxes (240, 400);
	Boxes (360, 400);
	Boxes (480, 400);
	Boxes (600, 400);
    }


    public static void MapMaker (int Maps[] [])     //Structure of the map
    {
	Color DisplayBoard = new Color (255, 183, 111); //create Displayboard color
	Color BackGround = new Color (128, 64, 0); //create brown
	Color BoxesColor = new Color (255, 168, 81); //create Boxes color
	Color outline = new Color (94, 47, 0); //create color of outline of boxes

	Color LocationColor = new Color (255, 128, 128); //create Boxes color
	

	for (int y = 0 ; y <= 14 ; y++)     //Creates 15 Rows
	{
	    for (int x = 0 ; x <= 14 ; x++) //Creates 15 columns
	    {
		c.fillRect (x * 40, y * 40, 40, 40);        //Ground
		if (Maps [y] [x] == 0)
		{
		    c.setColor (BackGround);
		    c.fillRect (x * 40, y * 40, 40, 40);
		}
		
		else if (Maps [y] [x] == 1)                 //Walls
		{
		    c.setColor (Color.lightGray);       //Bricks
		    c.fillRect (x * 40, y * 40, 40, 40);
		    c.setColor (Color.black);
		    c.drawRect (x * 40, y * 40, 40, 40);
		    c.drawLine (x * 40, y * 40 + 10, x * 40 + 40, y * 40 + 10);
		    c.drawLine (x * 40, y * 40 + 20, x * 40 + 40, y * 40 + 20);
		    c.drawLine (x * 40, y * 40 + 30, x * 40 + 40, y * 40 + 30);
		    c.drawLine (x * 40, y * 40 + 40, x * 40 + 40, y * 40 + 40);

		    c.drawLine (x * 40 + 20, y * 40, x * 40 + 20, y * 40 + 10);
		    c.drawLine (x * 40 + 20, y * 40 + 20, x * 40 + 20, y * 40 + 30);

		    c.drawLine (x * 40 + 10, y * 40 + 10, x * 40 + 10, y * 40 + 20);
		    c.drawLine (x * 40 + 30, y * 40 + 10, x * 40 + 30, y * 40 + 20);


		    c.drawLine (x * 40 + 10, y * 40 + 30, x * 40 + 10, y * 40 + 40);
		    c.drawLine (x * 40 + 30, y * 40 + 30, x * 40 + 30, y * 40 + 40);
		}
		
		else if (Maps [y] [x] == 2)                 //Boxes
		{
		    c.setColor (outline);
		    c.fillRect (x * 40, y * 40, 40, 40);
		    c.setColor (BoxesColor);
		    c.fillRect (x * 40 + 5, y * 40 + 5, 30, 30);
		    c.setColor (Color.black);
		    c.drawLine (x * 40 + 5, y * 40 + 5, x * 40 + 35, y * 40 + 35);
		    c.drawLine (x * 40 + 5, y * 40 + 35, x * 40 + 35, y * 40 + 5);

		}
		
		else if (Maps [y] [x] == 3)                 //Locations where boxes are to be put in
		{
		    c.setColor (BackGround);
		    c.fillRect (x * 40, y * 40, 40, 40);
		    c.setColor (LocationColor);
		    c.fillOval (x * 40 + 10, y * 40 + 10, 20, 20);

		}
	    }
	}
    }


    public static void CharcreateUp (int Maps[] [], int x, int y)       //Cretes the character in up position
    {
	Color hands = new Color (239, 208, 207); //create skin color
	c.setColor (Color.magenta);
	//BODY
	c.fillRect (x + 5, y + 25, 30, 10);
	//ARMS
	c.fillRect (x + 5, y + 13, 7, 15);
	c.fillRect (x + 28, y + 13, 7, 15);
	//LEGS
	c.setColor (Color.blue);
	c.fillRect (x + 12, y + 20, 16, 5);
	//HEAD
	c.setColor (Color.black);
	c.fillOval (x + 12, y + 23, 17, 17);
	//Hands
	c.setColor (hands);
	c.fillOval (x + 3, y + 3, 10, 10);
	c.fillOval (x + 26, y + 3, 10, 10);
    }


    public static void CharcreateDown (int Maps[] [], int x, int y)  //Cretes the character in down position
    {
	Color hands = new Color (239, 208, 207); //create skin color
	c.setColor (Color.magenta);
	//BODY
	c.fillRect (x + 5, y + 10, 30, 10);
	//ARMS
	c.fillRect (x + 5, y + 14, 7, 15);
	c.fillRect (x + 28, y + 14, 7, 15);
	//LEGS
	c.setColor (Color.blue);
	c.fillRect (x + 12, y + 19, 16, 5);
	//HEAD
	c.setColor (Color.black);
	c.fillOval (x + 12, y + 2, 17, 17);
	//Hands
	c.setColor (hands);
	c.fillOval (x + 3, y + 29, 10, 10);
	c.fillOval (x + 26, y + 29, 10, 10);
    }


    public static void CharcreateLeft (int Maps[] [], int x, int y)  //Cretes the character in left position
    {
	Color hands = new Color (239, 208, 207); //create skin color
	c.setColor (Color.magenta);
	//BODY
	c.fillRect (x + 25, y + 5, 10, 30);
	//ARMS
	c.fillRect (x + 13, y + 5, 15, 7);
	c.fillRect (x + 13, y + 28, 15, 7);
	//LEGS
	c.setColor (Color.blue);
	c.fillRect (x + 20, y + 12, 5, 16);
	//HEAD
	c.setColor (Color.black);
	c.fillOval (x + 23, y + 12, 17, 17);
	//Hands
	c.setColor (hands);
	c.fillOval (x + 3, y + 3, 10, 10);
	c.fillOval (x + 3, y + 26, 10, 10);
    }


    public static void CharcreateRight (int Maps[] [], int x, int y)  //Cretes the character in right position
    {
	Color hands = new Color (239, 208, 207); //create skin color
	c.setColor (Color.magenta);
	//BODY
	c.fillRect (x + 11, y + 5, 10, 30);
	//ARMS
	c.fillRect (x + 15, y + 5, 15, 7);
	c.fillRect (x + 15, y + 28, 15, 7);
	//LEGS
	c.setColor (Color.blue);
	c.fillRect (x + 20, y + 12, 5, 16);
	//HEAD
	c.setColor (Color.black);
	c.fillOval (x + 3, y + 12, 17, 17);
	//Hands
	c.setColor (hands);
	c.fillOval (x + 30, y + 3, 10, 10);
	c.fillOval (x + 30, y + 26, 10, 10);
    }


    public static void CharcreateExitPage (int x, int y)  //Cretes the character in right position
    {
	Color hands = new Color (239, 208, 207); //create skin color
	c.setColor (Color.magenta);
	//BODY
	c.fillRect (x + 11, y + 30, 40, 70);
	//ARMS
	c.fillRect (x + 11, y + 10, 80, 20);
	c.fillRect (x + 11, y + 85, 80, 20);
	//LEGS
	c.setColor (Color.blue);
	c.fillRect (x + 50, y + 35, 20, 45);
	//HEAD
	c.setColor (Color.black);
	c.fillOval (x + 3, y + 28, 50, 50);
	//Hands
	c.setColor (hands);
	c.fillOval (x + 87, y + 6, 32, 32);
	c.fillOval (x + 87, y + 78, 32, 32);
    }


    public static void BackGroundRulesExit ()       //Creates background for rules page, exitpage, and try again page
    {
	Color BackGround = new Color (128, 64, 0);

	int x, y;
	//Fills the background with boxes
	for (y = 0 ; y < 1000 ; y = y + 120)
	{
	    for (x = 0 ; x < 1000 ; x = x + 120)
	    {
		Boxes (x, y);
	    }
	    Boxes (x, y);
	}


	c.setColor (BackGround);
	c.fillRect (120, 120, 600, 360);
    }


    //Core of the whole game, it creates movement and other essential actions needed for the game
    public static int MoveMents (int winnumber, int Maps[] [], int x, int y, int counter, int boxfill, char redolevel)
    {
	Color BackGround = new Color (128, 64, 0); //creates brown
	Color hands = new Color (239, 208, 207); //creates skin color
	Color Displayboard = new Color (255, 183, 111); //creates displayboard color
	Color BoxesColor = new Color (255, 168, 81); //creates Boxes color
	Color outline = new Color (94, 47, 0); //creates outline color of boxes

	Font MovementsMade = new Font ("Stencil", Font.PLAIN, 25);          //Font for movements made
	Font LevelCompleted = new Font ("Showcard Gothic", Font.BOLD, 60);  //Creats font for level completed
	Font Levels = new Font ("Stencil", Font.BOLD, 42);                  //Font for showing each level
	Font bankgothic = new Font ("Berlin Sans FB Demi", Font.BOLD, 30);  
	Font bankgothicR = new Font ("Berlin Sans FB Demi", Font.BOLD, 15);

	int a = 0;
	int n;
	char movement;
	for (n = 0 ; n < counter ; n++)     //This for loop determines the max number of movements for each level
	{
	    c.setColor (Color.darkGray);            //Creates outline of the display board
	    c.fillRect (600, 0, 300, 1000);
	    c.setColor (Displayboard);             //Creates the displayboard
	    c.fillRect (620, 20, 200, 560);

	    c.setColor (Color.black);
	    c.setFont (bankgothic);
	    c.drawString ("Pushbox", 655, 50);      //Title of the game on the displayboard (shadow)
	    c.setColor (Color.yellow);
	    c.drawString ("Pushbox", 659, 50);      //Title of the game on the displayboard (text)


	    c.setColor (Color.black);               //Showing what level the user is on
	    c.setFont (Levels);
	    c.drawString ("Level  " + winnumber, 630, 120);

	    c.setColor (Color.black);               //Showing how many steps the user has made
	    c.setFont (MovementsMade);
	    c.drawString ("Steps Made ", 645, 200);
	    c.drawString ("         " + n + "/" + counter, 635, 240);

	    c.setColor (Color.black);               //Showing the mission the user has to complete
	    c.setFont (MovementsMade);
	    c.drawString ("      Mission: ", 625, 360);
	    c.drawString ("Fill in " + boxfill + " boxes ", 625, 390);

	    c.setColor (Color.black);               //Showing press r to reset the map or presss e to quit the game
	    c.setFont (bankgothicR);
	    c.drawString ("Press (r) to reset the map!", 630, 470);
	    c.drawString ("Press (e) to quit the game!", 624, 490);
	    movement = c.getChar ();

	    while (movement != 'w' && movement != 'W' && movement != 's' && movement != 'S' && movement != 'a' && movement != 'A' && movement != 'd' && movement != 'D' && movement != 'r' && movement != 'R' && movement != 'E' && movement != 'e')
	    {
		movement = c.getChar ();            //error trap to make sure the user enters only specific characters
	    }
	    if (movement == 'w' || movement == 'W')         //Results when the user presses 'w' or 'W'
	    {
		if (Maps [(y - 40) / 40] [x / 40] == 0)         //When the space above is the ground
		{
		    c.setColor (BackGround);
		    c.fillRect (x, y, 40, 40);

		    Maps [y / 40] [x / 40] = 0;
		    y -= 40;
		    c.setColor (Color.magenta);
		    //BODY
		    c.fillRect (x + 5, y + 25, 30, 10);
		    //ARMS
		    c.fillRect (x + 5, y + 13, 7, 15);
		    c.fillRect (x + 28, y + 13, 7, 15);
		    //LEGS
		    c.setColor (Color.blue);
		    c.fillRect (x + 12, y + 20, 16, 5);
		    //HEAD
		    c.setColor (Color.black);
		    c.fillOval (x + 12, y + 23, 17, 17);
		    //Hands
		    c.setColor (hands);
		    c.fillOval (x + 3, y + 3, 10, 10);
		    c.fillOval (x + 26, y + 3, 10, 10);

		}
		else if (Maps [(y - 40) / 40] [x / 40] == 1 || Maps [(y - 40) / 40] [x / 40] == 3)
		{
		    n--;                    //If wall was detected in front of character, moves made do not increase
		}
		else if (Maps [(y - 40) / 40] [x / 40] == 2)        //When space above is a box
		{
		    if (Maps [(y - 40) / 40] [x / 40] == 2 && Maps [(y - 80) / 40] [x / 40] == 0)
		    { //When space above is a box and the following space from the box is the ground
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;

			Maps [(y - 40) / 40] [x / 40] = 2;

			c.setColor (outline);
			c.fillRect (x, y - 80, 40, 40);
			c.setColor (BoxesColor);
			c.fillRect (x + 5, y - 75, 30, 30);
			c.setColor (Color.black);

			c.drawLine (x + 5, y - 75, x + 35, y - 45);
			c.drawLine (x + 5, y - 45, x + 35, y - 75);

			Maps [(y - 80) / 40] [x / 40] = 2;
			y -= 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;
			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 5, y + 25, 30, 10);
			//ARMS
			c.fillRect (x + 5, y + 13, 7, 15);
			c.fillRect (x + 28, y + 13, 7, 15);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 12, y + 20, 16, 5);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 12, y + 23, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 3, 10, 10);
			c.fillOval (x + 26, y + 3, 10, 10);
		    }
		    else if (Maps [(y - 40) / 40] [x / 40] == 2 && Maps [(y - 80) / 40] [x / 40] == 3)
		    { //When space above is a box and space from the box is where boxes need to be located
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [(y - 80) / 40] [x / 40] = 2;
			c.setColor (Color.darkGray);
			c.fillRect (x, y - 80, 40, 40);
			c.setColor (Color.gray);
			c.fillRect (x + 5, y - 75, 30, 30);
			c.setColor (Color.black);
			c.drawLine (x + 5, y - 75, x + 35, y - 45);
			c.drawLine (x + 5, y - 45, x + 35, y - 75);


			if (Maps [(y - 40) / 40] [x / 40] == 2)
			{
			    a++;          //When the user properly puts the box into the pink circle it adds the number to the number of boxes needed to put in
			}                 
			y -= 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 5, y + 25, 30, 10);
			//ARMS
			c.fillRect (x + 5, y + 13, 7, 15);
			c.fillRect (x + 28, y + 13, 7, 15);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 12, y + 20, 16, 5);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 12, y + 23, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 3, 10, 10);
			c.fillOval (x + 26, y + 3, 10, 10);
		    }

		    else if (Maps [(y - 40) / 40] [x / 40] == 2 || Maps [(y - 40) / 40] [x / 40] == 3)
		    {
			n--;        //The steps do not increase when the character presses W,A,S,D in front of the wall or the box that has been placed in the pink circle
		    }
		}
	    }
	    if (movement == 's' || movement == 'S')     //Results when the user presses 's' or 'S'
	    {
		if (Maps [(y + 40) / 40] [x / 40] == 0)     //When the space below is the ground
		{
		    c.setColor (BackGround);
		    c.fillRect (x, y, 40, 40);

		    Maps [y / 40] [x / 40] = 0;
		    y += 40;
		    c.setColor (Color.magenta);
		    //BODY
		    c.fillRect (x + 5, y + 10, 30, 10);
		    //ARMS
		    c.fillRect (x + 5, y + 14, 7, 15);
		    c.fillRect (x + 28, y + 14, 7, 15);
		    //LEGS
		    c.setColor (Color.blue);
		    c.fillRect (x + 12, y + 19, 16, 5);
		    //HEAD
		    c.setColor (Color.black);
		    c.fillOval (x + 12, y + 2, 17, 17);
		    //Hands
		    c.setColor (hands);
		    c.fillOval (x + 3, y + 29, 10, 10);
		    c.fillOval (x + 26, y + 29, 10, 10);
		}
		else if (Maps [(y + 40) / 40] [x / 40] == 1 || Maps [(y + 40) / 40] [x / 40] == 3)
		{
		    n--;                    //If wall or pink circle was detected in front of character, moves made do not increase
		}
		else if (Maps [(y + 40) / 40] [x / 40] == 2)        //When space below is a box
		{
		    if (Maps [(y + 40) / 40] [x / 40] == 2 && Maps [(y + 80) / 40] [x / 40] == 0)
		    { //When space below is a box and the following space from the box is the ground
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;

			Maps [(y + 40) / 40] [x / 40] = 2;

			c.setColor (outline);
			c.fillRect (x, y + 80, 40, 40);
			c.setColor (BoxesColor);
			c.fillRect (x + 5, y + 85, 30, 30);
			c.setColor (Color.black);

			c.drawLine (x + 5, y + 85, x + 35, y + 115);
			c.drawLine (x + 5, y + 115, x + 35, y + 85);

			Maps [(y + 80) / 40] [x / 40] = 2;
			y += 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;
			//GOING DOWN
			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 5, y + 10, 30, 10);
			//ARMS
			c.fillRect (x + 5, y + 14, 7, 15);
			c.fillRect (x + 28, y + 14, 7, 15);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 12, y + 19, 16, 5);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 12, y + 2, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 29, 10, 10);
			c.fillOval (x + 26, y + 29, 10, 10);

		    }
		    else if (Maps [(y + 40) / 40] [x / 40] == 2 && Maps [(y + 80) / 40] [x / 40] == 3)
		    {
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [(y + 80) / 40] [x / 40] = 2;
			c.setColor (Color.darkGray);
			c.fillRect (x, y + 80, 40, 40);
			c.setColor (Color.gray);
			c.fillRect (x + 5, y + 85, 30, 30);
			c.setColor (Color.black);

			c.drawLine (x + 5, y + 85, x + 35, y + 115);
			c.drawLine (x + 5, y + 115, x + 35, y + 85);


			if (Maps [(y + 40) / 40] [x / 40] == 2)
			{
			    a++;    //When the user properly puts the box into the pink circle it adds the number to the number of boxes needed to put in
			}
			y += 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 5, y + 10, 30, 10);
			//ARMS
			c.fillRect (x + 5, y + 14, 7, 15);
			c.fillRect (x + 28, y + 14, 7, 15);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 12, y + 19, 16, 5);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 12, y + 2, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 29, 10, 10);
			c.fillOval (x + 26, y + 29, 10, 10);
		    }
		    else if (Maps [(y + 40) / 40] [x / 40] == 2)    //If wall was detected in front of character, moves made do not increase
		    {
			n--;
		    }
		}
	    }

	    if (movement == 'a' || movement == 'A')         //Results when the user presses 'a' or 'A'
	    {
		if (Maps [y / 40] [(x - 40) / 40] == 0)     //When the space to the left is the ground
		{
		    c.setColor (BackGround);
		    c.fillRect (x, y, 40, 40);

		    Maps [y / 40] [x / 40] = 0;
		    x -= 40;
		    c.setColor (Color.magenta);
		    //BODY
		    c.fillRect (x + 25, y + 5, 10, 30);
		    //ARMS
		    c.fillRect (x + 13, y + 5, 15, 7);
		    c.fillRect (x + 13, y + 28, 15, 7);
		    //LEGS
		    c.setColor (Color.blue);
		    c.fillRect (x + 20, y + 12, 5, 16);
		    //HEAD
		    c.setColor (Color.black);
		    c.fillOval (x + 23, y + 12, 17, 17);
		    //Hands
		    c.setColor (hands);
		    c.fillOval (x + 3, y + 3, 10, 10);
		    c.fillOval (x + 3, y + 26, 10, 10);
		}
		else if (Maps [y / 40] [(x - 40) / 40] == 1 || Maps [y / 40] [(x - 40) / 40] == 3)
		{
		    n--;                    //If wall or pink circle was detected in front of character, moves made do not increase
		}
		else if (Maps [y / 40] [(x - 40) / 40] == 2)            //When space to the left is a box
		{
		    if (Maps [y / 40] [(x - 40) / 40] == 2 && Maps [y / 40] [(x - 80) / 40] == 0)
		    { //When space to the left is a box the following space from the box is the ground
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;

			Maps [y / 40] [(x - 40) / 40] = 2;
			c.setColor (outline);
			c.fillRect (x - 80, y, 40, 40);
			c.setColor (BoxesColor);
			c.fillRect (x - 75, y + 5, 30, 30);
			c.setColor (Color.black);
			c.drawLine (x - 75, y + 5, x - 45, y + 35);
			c.drawLine (x - 45, y + 5, x - 75, y + 35);


			Maps [y / 40] [(x - 80) / 40] = 2;
			x -= 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;
			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 25, y + 5, 10, 30);
			//ARMS
			c.fillRect (x + 13, y + 5, 15, 7);
			c.fillRect (x + 13, y + 28, 15, 7);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 20, y + 12, 5, 16);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 23, y + 12, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 3, 10, 10);
			c.fillOval (x + 3, y + 26, 10, 10);
		    }
		    else if (Maps [y / 40] [(x - 40) / 40] == 2 && Maps [y / 40] [(x - 80) / 40] == 3)
		    {
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [(x - 80) / 40] = 2;
			c.setColor (Color.darkGray);
			c.fillRect (x - 80, y, 40, 40);
			c.setColor (Color.gray);
			c.fillRect (x - 75, y + 5, 30, 30);
			c.setColor (Color.black);

			c.drawLine (x - 75, y + 5, x - 45, y + 35);
			c.drawLine (x - 45, y + 5, x - 75, y + 35);

			if (Maps [y / 40] [(x - 40) / 40] == 2)
			{
			    a++;    //When the user properly puts the box into the pink circle it adds the number to the number of boxes needed to put in
			}
			x -= 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 25, y + 5, 10, 30);
			//ARMS
			c.fillRect (x + 13, y + 5, 15, 7);
			c.fillRect (x + 13, y + 28, 15, 7);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 20, y + 12, 5, 16);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 23, y + 12, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 3, y + 3, 10, 10);
			c.fillOval (x + 3, y + 26, 10, 10);

		    }
		    else if (Maps [y / 40] [(x - 40) / 40] == 2)    //If wall was detected in front of character, moves made do not increase
		    {
			n--;
		    }
		}
	    }

	    if (movement == 'd' || movement == 'D')             //Results when the user presses 'd' or 'D'
	    {
		if (Maps [y / 40] [(x + 40) / 40] == 0)         //When the space to the right is the ground
		{
		    c.setColor (BackGround);
		    c.fillRect (x, y, 40, 40);

		    Maps [y / 40] [x / 40] = 0;
		    x += 40;
		    c.setColor (Color.magenta);
		    //BODY
		    c.fillRect (x + 11, y + 5, 10, 30);
		    //ARMS
		    c.fillRect (x + 15, y + 5, 15, 7);
		    c.fillRect (x + 15, y + 28, 15, 7);
		    //LEGS
		    c.setColor (Color.blue);
		    c.fillRect (x + 20, y + 12, 5, 16);
		    //HEAD
		    c.setColor (Color.black);
		    c.fillOval (x + 3, y + 12, 17, 17);
		    //Hands
		    c.setColor (hands);
		    c.fillOval (x + 30, y + 3, 10, 10);
		    c.fillOval (x + 30, y + 26, 10, 10);
		}
		else if (Maps [y / 40] [(x + 40) / 40] == 1 || Maps [y / 40] [(x + 40) / 40] == 3)
		{
		    n--;                //If wall or pink circle was detected in front of character, moves made do not increase
		}
		else if (Maps [y / 40] [(x + 40) / 40] == 2)                //When space to the right is a box
		{
		    if (Maps [y / 40] [(x + 40) / 40] == 2 && Maps [y / 40] [(x + 80) / 40] == 0)
		    { //When space to the right is a box and the following space from the box is the ground
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [x / 40] = 0;
			Maps [y / 40] [(x + 40) / 40] = 2;
			c.setColor (outline);
			c.fillRect (x + 80, y, 40, 40);
			c.setColor (BoxesColor);
			c.fillRect (x + 85, y + 5, 30, 30);
			c.setColor (Color.black);

			c.drawLine (x + 85, y + 5, x + 115, y + 35);
			c.drawLine (x + 85, y + 35, x + 115, y + 5);



			Maps [y / 40] [(x + 80) / 40] = 2;
			x += 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);
			Maps [y / 40] [x / 40] = 0;
			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 11, y + 5, 10, 30);
			//ARMS
			c.fillRect (x + 15, y + 5, 15, 7);
			c.fillRect (x + 15, y + 28, 15, 7);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 20, y + 12, 5, 16);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 3, y + 12, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 30, y + 3, 10, 10);
			c.fillOval (x + 30, y + 26, 10, 10);
		    }
		    else if (Maps [y / 40] [(x + 40) / 40] == 2 && Maps [y / 40] [(x + 80) / 40] == 3)
		    {
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			Maps [y / 40] [(x + 80) / 40] = 2;
			c.setColor (Color.darkGray);
			c.fillRect (x + 80, y, 40, 40);
			c.setColor (Color.gray);
			c.fillRect (x + 85, y + 5, 30, 30);
			c.setColor (Color.black);
			c.drawLine (x + 85, y + 5, x + 115, y + 35);
			c.drawLine (x + 85, y + 35, x + 115, y + 5);

			if (Maps [y / 40] [(x + 40) / 40] == 2)
			{   
			    a++;    //When the user properly puts the box into the pink circle it adds the number to the number of boxes needed to put in
			}
			x += 40;
			c.setColor (BackGround);
			c.fillRect (x, y, 40, 40);

			c.setColor (Color.magenta);
			//BODY
			c.fillRect (x + 11, y + 5, 10, 30);
			//ARMS
			c.fillRect (x + 15, y + 5, 15, 7);
			c.fillRect (x + 15, y + 28, 15, 7);
			//LEGS
			c.setColor (Color.blue);
			c.fillRect (x + 20, y + 12, 5, 16);
			//HEAD
			c.setColor (Color.black);
			c.fillOval (x + 3, y + 12, 17, 17);
			//Hands
			c.setColor (hands);
			c.fillOval (x + 30, y + 3, 10, 10);
			c.fillOval (x + 30, y + 26, 10, 10);
		    }
		    else if (Maps [y / 40] [(x + 40) / 40] == 2)        //If wall was detected in front of character, moves made do not increase    
		    {
			n--;
		    }
		}
	    }

	    if (movement == 'r' || movement == 'R')     //if the person wants to quit, adds the winnumber by 100  and the actions occur in the main method
	    {
		winnumber = winnumber + 100;
		delay (300);
		break;
	    }
	    if (movement == 'e' || movement == 'E')     //if the person wants to quit, subtracts the winnumber by 5000 and the actions occur in the main method
	    {
		winnumber = winnumber - 5000;
		break;
	    }
	    if (a == boxfill)       //When all the boxes are filled in the pink circles, the level completed screen pops up
	    {
		delay (200);
		c.clear ();
		c.setColor (BackGround);
		c.fillRect (0, 0, 1000, 1000);
		c.setFont (LevelCompleted);
		c.setColor (Color.black);
		c.drawString ("LEVEL " + winnumber + " COMPLETED!!", 90, 100);
		c.setColor (Color.yellow);
		c.drawString ("LEVEL " + winnumber + " COMPLETED!!", 100, 100);
		//creates boxes
		Boxes (0, 480);
		Boxes (0, 360);
		Boxes (0, 240);
		Boxes (0, 120);

		Boxes (120, 480);
		Boxes (120, 360);
		Boxes (120, 240);

		Boxes (240, 480);
		Boxes (240, 360);

		Boxes (360, 480);
		Boxes (480, 480);

		Boxes (480, 360);
		Boxes (480, 480);

		Boxes (600, 240);
		Boxes (600, 360);
		Boxes (600, 480);

		Boxes (720, 480);
		Boxes (720, 360);
		Boxes (720, 240);
		Boxes (720, 120);

		winnumber++;
		delay (1000);
		break;
	    }
	}

	if (n == counter)       //if the person wants to quit, subtracts the winnumber by 1000 and the actions occur in the main method
	{
	    winnumber = winnumber - 1000;
	}

	return (winnumber);     //Returns the winnumber
    }


    public static void delay (int millisecs)  // Delay Method
    {
	try
	{
	    Thread.currentThread ().sleep (millisecs);
	}


	catch (InterruptedException e)
	{
	}
    }
} // PushBox class



