package Assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = null;
        System.out.println("you have a random word , you have 6 lives(wrong guess) to guess the word , letters only are allowed, symboles and numbers are not allowed ");
        String fileName = "C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\Assignment\\src\\Assignment\\words";
        try
        {
            BufferedReader br;
            FileReader fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            
            List<String> lines = new ArrayList<String>();
            String line = br.readLine();
            
            while( line != null ) {
                lines.add(line);
                line = br.readLine();
            }
            
            Random r = new Random();
            word = lines.get(r.nextInt(lines.size()));
            
            //ArrayList<String> words=new ArrayList<String>();
            //words.add(word);
            fr.close();
            br.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        int wordLength= word.length();
        System.out.println(wordLength);
        
        int spaces;
        char [] words = new char[word.length()];
        for(int i = 0 ; i < wordLength ; i++)
        {
            System.out.print(" _ ");
        }
        for(spaces = 0 ; spaces < wordLength ; spaces++)
        {
            
            words[spaces]='*';
        }
        System.out.println();
        
        int lettersRemaining = wordLength;
        int numberOfGuesses = 6;
        int wrong = 0;
        char letterGuess;
        boolean checkGuess;
        char PreviousLetter = 0;
        String pattern = "[a-zA-Z]{1}";
        //char [] PreviousAll = new char[wordLength]; 
        //char [] wordArr = new char[wordLength];
        //word.getChars(0 , wordLength , wordArr , 0);
        while (lettersRemaining > 0 && wrong < 6){
            
            System.out.print("Guess a letter : ");
            letterGuess = input.next().charAt(0);
            checkGuess = (word.indexOf(letterGuess)) != -1;
            String s = String.valueOf(letterGuess);
            
            if(s.matches(pattern)){
            /*for(int k = 0;k != wordLength ;k++)
                    {
                        if(wordArr[k] == letterGuess){
                            System.out.println("You enter this character previously");
                        }                       
                    }*/
            if(PreviousLetter == letterGuess){
                System.out.println("You enter this character previously");
            }
            else
            {
            if(checkGuess == false)
            {
                wrong++;
                System.out.print("Your Guess is wrong , you still have ");
                System.out.print(numberOfGuesses-wrong);
                System.out.println(" chance ,keep trying.");
            }
            else
            {   
                for (spaces = 0; spaces < wordLength; spaces++)
                {   
                    
                    if (word.charAt(spaces) == letterGuess) 
                    {
                        //wordArr[spaces] = letterGuess;
                        if(letterGuess == words[spaces])
                        {
                            System.out.println("You enter this character previously");
                            break;
                        }
                        words[spaces] = letterGuess;
                        lettersRemaining--;
                        //under.setCharAt(spaces , letterGuess);
                        //System.out.print(under);
                    } 
                }
                System.out.println("That was a good guess");  
                for(int i=0 ; i<word.length(); i++)
                {
                    System.out.print(words[i]);
                }
            }
        
            System.out.println();
            System.out.print("Letters remaining: ");
            System.out.println(lettersRemaining);
            
        }
            PreviousLetter = letterGuess;
        }
            else{
                System.out.println("letters only are allowed, symboles and numbers are not allowed");
            }
        }
        
        
        
        String check = null;
        if (wrong == numberOfGuesses) 
        {
            System.out.println("Sorry, you lose!");
            System.out.println("Do you want play again ? (Y or N)");
            check = input.next();
            if("y".equals(check)){
                main(args);
            }
            else{
                System.exit(0);
            }
        } 
        else 
        {
            System.out.print("Well done, you win! The word was ");
            System.out.println(word);
            System.out.println("Do you want play again ? (Y or N)");
            check = input.next();
            if("y".equals(check)){
                main(args);
            }
            else{
                System.exit(0);
            }
        }
    }   
}

