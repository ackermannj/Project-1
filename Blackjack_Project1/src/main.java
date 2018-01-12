import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class main {
    public static void main(String args[]) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        int playerhand = 0;
        int dealerhand = 0;
        int cardvalue = 0;
        int userinput = 0;
        int drawn = 0;            //Setting variables
        int gamenum = 1;
        int userwin = 0;
        int dealwin = 0;
        int tie = 0;

        String cardname = " ";

        boolean blackjack = true;

        while (blackjack) {    //Outer loop - controls all games

            boolean newgame = true;
            System.out.println("START GAME #" + gamenum + "\n");

            drawn = rand.nextInt(13) + 1;
            dealerhand = 0; //Resetting the player hand and dealer hand every game
            playerhand = 0;

            switch (drawn) {   //First Card Dealt
                case 1:
                    cardvalue = 1;
                    cardname = "ACE";
                    break;


                case 2:
                    cardvalue = 2;
                    cardname = "TWO";
                    break;


                case 3:
                    cardvalue = 3;
                    cardname = "THREE";
                    break;


                case 4:
                    cardvalue = 4;
                    cardname = "FOUR";
                    break;


                case 5:
                    cardvalue = 5;
                    cardname = "FIVE";
                    break;


                case 6:
                    cardvalue = 6;
                    cardname = "SIX";
                    break;


                case 7:
                    cardvalue = 7;
                    cardname = "SEVEN";
                    break;


                case 8:
                    cardvalue = 8;
                    cardname = "EIGHT";
                    break;


                case 9:
                    cardvalue = 9;
                    cardname = "NINE";
                    break;


                case 10:
                    cardvalue = 10;
                    cardname = "TEN";
                    break;

                case 11:
                    cardvalue = 10;
                    cardname = "JACK";
                    break;


                case 12:
                    cardvalue = 10;
                    cardname = "QUEEN";
                    break;


                case 13:
                    cardvalue = 10;
                    cardname = "KING";
                    break;

            }
                playerhand += cardvalue;
                System.out.println("Your card is a " + cardname + "!");
                System.out.println("Your hand is: " + playerhand + "\n");

                while (newgame) {    //Inner loop - controls current game
                    try {

                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print Statistics");
                    System.out.println("4. Exit" + "\n");
                    System.out.println("Choose an option:");
                    userinput = scan.nextInt();


                    if (userinput == 1) {   //Draw Card

                        drawn = rand.nextInt(13) + 1;

                        switch (drawn) {
                            case 1:
                                cardvalue = 1;
                                cardname = "ACE";
                                break;


                            case 2:
                                cardvalue = 2;
                                cardname = "TWO";
                                break;


                            case 3:
                                cardvalue = 3;
                                cardname = "THREE";
                                break;


                            case 4:
                                cardvalue = 4;
                                cardname = "FOUR";
                                break;


                            case 5:
                                cardvalue = 5;
                                cardname = "FIVE";
                                break;


                            case 6:
                                cardvalue = 6;
                                cardname = "SIX";
                                break;


                            case 7:
                                cardvalue = 7;
                                cardname = "SEVEN";
                                break;


                            case 8:
                                cardvalue = 8;
                                cardname = "EIGHT";
                                break;


                            case 9:
                                cardvalue = 9;
                                cardname = "NINE";
                                break;


                            case 10:
                                cardvalue = 10;
                                cardname = "TEN";
                                break;

                            case 11:
                                cardvalue = 10;
                                cardname = "JACK";
                                break;


                            case 12:
                                cardvalue = 10;
                                cardname = "QUEEN";
                                break;


                            case 13:
                                cardvalue = 10;
                                cardname = "KING";
                                break;


                        }

                        playerhand += cardvalue;


                        System.out.println("Your card is a " + cardname + "!");
                        System.out.println("Your hand is: " + playerhand + "\n");

                    }

                    if (userinput == 2) {   //Hold Hand

                        dealerhand = rand.nextInt(9) + 15;
                        if (dealerhand > 21) {

                            System.out.println("You win!\n");
                            userwin += 1;
                            gamenum += 1;
                            newgame = false;
                            break;
                        }

                        if (dealerhand < playerhand) {

                            System.out.println("You win!\n");
                            userwin += 1;
                            gamenum += 1;
                            newgame = false;
                            break;

                        }

                        if (dealerhand > playerhand) {

                            System.out.println("You lose!\n");
                            dealwin += 1;
                            gamenum += 1;
                            newgame = false;
                            break;

                        }

                        if (dealerhand == playerhand) {

                            System.out.println("It's a tie!\n");
                            tie += 1;
                            gamenum += 1;
                            newgame = false;
                            break;

                        }

                        else if (dealerhand == 21) {

                            System.out.println("You lose!\n");
                            dealwin += 1;
                            gamenum +=1;
                            newgame = false;

                        }

                    }

                    if (userinput == 3) {   //Print Statistics

                        double percwin = 100*((double)userwin / (double)(gamenum -1));

                        System.out.println("Number of Player wins: " + userwin);
                        System.out.println("Number of Dealer wins: " + dealwin);
                        System.out.println("Number of tie games: " + tie);
                        System.out.println("Number of games played is: " + (gamenum -1));
                        System.out.println("Percentage of Player wins: " + percwin + "%" + "\n");

                    }

                    if (userinput == 4) {   //Exit

                        newgame = false;
                        blackjack = false;

                    }

                    if (userinput != 1 && userinput != 2 && userinput != 3 && userinput != 4) {

                        System.out.println("Invalid Input!\nPlease enter an integer value between 1 and 4.\n");

                        }



                    }



                catch(InputMismatchException e) {  // Catches if you type a letter into your input

                        System.out.println("Invalid Input!\nPlease enter an integer value between 1 and 4.\n");
                        scan.next();
                }


                    if (playerhand > 21) {

                        System.out.println("You lose!\n");
                        dealwin += 1;
                        gamenum +=1;
                        newgame = false;                    // These will end the game if the player gets 21 or goes over

                    } else if (playerhand == 21) {

                        System.out.println("You win!\n");
                        userwin += 1;
                        gamenum +=1;
                        newgame = false;


                    }

                    }
                }
            }
        }









