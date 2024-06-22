/**
 * Write a description of class old_version here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class old_version
{
    // instance variables - replace the example below with your own
    int Sentence;
    int Partners_sentence;
    int minQ = 2;//the min of number of questions
    int maxQ = 6;//the max of number of questions
    int minO = 0;//the min of number of Options of questions
    String[] questions = {"steal the dimond","rob that bank","break into that home","steal the phone","break into that building","steal the T.V"};//the diffrent questions that the system
    int maxO = questions.length -1;//the max of number of Options of questions
    int games = 0;// how many game,the player has played
    int[][] dilemmas = new int[13][maxQ];// every prison's dilemma

    public old_version()
    {
         int Counter = 0;// the amount of time being add to the player's sentence
        int Anti_counter = 0;// the amount of time being add to the player's sentence
        boolean cOntinue = true;// does the player what to continue
        String starter;
        String yes = "yes";
        String no = "no";
        System.out.println('\u000c');
        System.out.println("The Prisoner's Dilemma is a thought experment that challenges two players to a dilemma, ");
        System.out.println();
        System.out.println("where they can cooperate with their partner for mutual benefit only get a sentence of 1 year each or");
        System.out.println("betray their partner for their individual benefit with their partner geting punished with a sentence of 4 years");
        System.out.println();
        System.out.println("but if both partner deside to betray they're partner then then both players get punished with a sentence 2.");
        System.out.println();
        System.out.println("In this program you will be player in this dilemma, your will be given a random number of questions which you can answer with a yes or no,");
        System.out.print("do you wish to start?");
        Scanner start=new Scanner(System.in);
        starter= start.nextLine();
        while (cOntinue){
            int random_intq = (int)Math.floor(Math.random() * (maxQ - minQ + 1) +minQ); // the random number of question
            switch (starter.toLowerCase()){
                    case"y":
                    case"yes": starter="yes";
                    break;
                    case"n":
                    case"no": starter="no";
                    break;
                default: starter="wrong";
                    break;
            }
            if (starter.toLowerCase().equals(yes)){
                Sentence = 0;
                Partners_sentence = 0;
                for (int i=0;i<random_intq;i++){//this code allow the system to ask multible questions  
                    int random_into = (int)Math.floor(Math.random() * (maxO - minO) + 1) +minO;
                    Counter=The_Question(random_into,0,i);
                    Sentence=Sentence+Counter;
                    dilemmas[games][i]=Counter;
                    switch (Counter){
                        case 0:Anti_counter=+4;
                            break;
                        case 1:Anti_counter=+1;
                            break;
                        case 2:Anti_counter=+2;
                            break;
                        default:Anti_counter=+0;
                    }
                    Partners_sentence=Partners_sentence+Anti_counter;
                    System.out.println("your total sentence is "+Sentence);
                    System.out.println("your Partner's total sentence is "+Partners_sentence);
                }
                for(int i=0;i<maxQ-random_intq;i++){//this code filles in the dilemmas arrray
                    dilemmas[games][random_intq+i]=(int)Math.floor(Math.random() * (4 - 0) + 1) +0;
                }
                System.out.print('\u000c');
                System.out.println("your total sentence was "+Sentence);
                System.out.println("your Partner's total sentence was "+Partners_sentence);
                System.out.print("do you want to play again ");
                boolean proper=false;
                games++;
                String mutiple;
                if (games>1) mutiple= games+" games.";else mutiple="a game.";

                while(!proper){
                    starter= start.nextLine();
                    //System.out.println('\u000c');
                    if (games>13) starter="no";
                    switch (starter.toLowerCase()){

                            case"y":
                            case"yes":cOntinue=true;
                            proper=true;
                            break;
                            case"n":
                            case"no":cOntinue=false;
                            System.out.println("Thank you for playing " +mutiple);
                            proper=true;
                            break;
                        default:proper=false;System.out.println("Answer Properly.");
                            break;
                    }
                }//while
            }else{
                if (starter.toLowerCase().equals(no)){
                    cOntinue=false;
                }else{
                    cOntinue=true;
                    System.out.print("Please try again");
                    starter= start.nextLine();
                    starter= start.nextLine();
                }

            }

        }

    }

     /**
     *the method Your_Partner was made to deside if the player's partner betray them, if desided true then the partner betray
     */
    boolean Your_Partner(boolean choose,int based,int question)
    {
        int pmin = based;// has the player betrayed their partner
        int pmax = 20;
        int random_p = (int)Math.floor(Math.random() * (pmax - pmin + 1) +pmin);
        int pick =random_p%2;
        if (games>1){

            switch(dilemmas[games-1][question]){
                case 1:
                case 4:choose = false;
                    break;
                case 0:
                case 2:
                default:choose = true;
                    break;
            }
        }else{
            if (pick==1) choose= true;else choose= false;
        }
        return choose;
    }

    int The_Question (int random,int increase,int number)//this methods was made to ask a prisoner's dilemma question.
    {
        String Answer;
        String Your_Partner_Answer;
        System.out.print("did your partner "+questions[random]+":");
        Scanner statement=new Scanner(System.in);
        boolean proper=false;
        int friendship = 1;
        while (!proper){
            Answer= statement.nextLine();
            System.out.print('\u000c');
            switch (Answer.toLowerCase()){
                    case"y":
                    case"yes": friendship=1;
                    break;
                    case"n":
                    case"no": friendship=2;
                    break;
                default:proper=false;
                    break;
            }
            boolean Ratted_Out=Your_Partner(false,friendship,number);
            if (Ratted_Out==true){
                switch (Answer.toLowerCase()){
                        case"y":
                        case"yes": System.out.print("you have ratted out your partner, but sadly so did your partner. ");increase=+2;proper=true;
                        break;
                        case"n":
                        case"no": System.out.print("you haven't ratted out your partner, but your partner betrayed you. ");increase=+4;proper=true;
                        break;
                    default: System.out.println("Answer the Question");proper=false;
                        break;
                }
            }else{
                switch (Answer.toLowerCase()){
                        case"y":
                        case"yes": System.out.print("you lied about your partner, betraying them. ");proper=true;
                        break;
                        case"n":
                        case"no": System.out.print("you didn't lie about your partner, and your partner didn't lie about you. ");increase=+1;proper=true;
                        break;
                    default: System.out.println("Answer the Question");proper=false;
                        break;
                }  
            }
        }
        return increase;
    }
    
}
