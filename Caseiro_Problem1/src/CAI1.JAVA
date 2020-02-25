import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
        public static void main(String[] args) {
        Quiz();
    }

    
    public static void Quiz() {
        
        SecureRandom secureRandom = new SecureRandom();
        
        int FirstNumber = secureRandom.nextInt(10);
        int SecondNumber = secureRandom.nextInt(10);
        
        
        int RightAnswer = FirstNumber * SecondNumber;
        int UserAnswer = -1;
       
       
        while (true) {
            
          askQuestion(FirstNumber, SecondNumber);
           
          
          UserAnswer = readResponse();
            
          if (isAnswerCorrect(RightAnswer, UserAnswer)) {
              displayCorrectResponse();
              break;
          } 
            
          else {
              displayIncorrectResponse();
          }
       }
    }
    
    
    public static void askQuestion(int FirstNumber, int SecondNumber) {
        System.out.print("What is " + FirstNumber + " * " + SecondNumber + "? \n ");
    }

    
    public static int readResponse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your answer: \n");
        int UserAnswer = sc.nextInt();
        return UserAnswer;
    }
    
    
    public static boolean isAnswerCorrect(int RightAnswer, int UserAnswer) {
        return RightAnswer == UserAnswer;
    }
    
    
    public static void displayCorrectResponse() {
        System.out.println("Very good!\n");
    }
   
    
    public static void displayIncorrectResponse() {
        System.out.println("No. Please try again.\n");
    }
}
