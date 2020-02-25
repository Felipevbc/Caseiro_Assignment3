import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
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
          } else {
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
        int Answer = sc.nextInt();
        return Answer;
    }
    
    
    private static boolean isAnswerCorrect(int RightAnswer, int UserAnswer) {
        return RightAnswer == UserAnswer;
    }
    
   
    public static void displayCorrectResponse() {
    	   
         SecureRandom secureRandom = new SecureRandom();
    	  
           int ResponseNumber = secureRandom.nextInt(4);
           
          
           if(ResponseNumber == 0) {
        	   System.out.println("Very Good!\n); 
           } 
           
           else if (ResponseNumber == 1) {
        	   System.out.println("Excellent!\n); 
           } 
           
           else if (ResponseNumber == 2) {
        	   System.out.println("Nice Work!\n");  
           } 
           
           else if (ResponseNumber == 3) {
        	   System.out.println("Keep Up The Good Work!\n");  
           }
    }
   
    
    public static void displayIncorrectResponse() {
    	   
         SecureRandom secureRandom = new SecureRandom();
    	   
           int ResponseNumber = secureRandom.nextInt(4);
           
           
           if(ResponseNumber == 0) {
        	   System.out.println("No. Please Try Again.\n");   
           } 
           
           else if (ResponseNumber == 1) {
        	   System.out.println("Wrong. Try Once More.\n");  
           }                                    
           
           else if (ResponseNumber == 2) {
        	   System.out.println("Don't Give Up!\n");  
           } 
           
           else if (ResponseNumber == 3) {
        	   System.out.println("No. Keep Trying.\n");  
           }
    }
}
