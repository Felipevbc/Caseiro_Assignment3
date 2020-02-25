import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
  
	
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String UserInput;
      
       do {
           quiz(sc);
           System.out.print("Would You Like to Try Again? (Please enter Yes or No): ");
           UserInput = sc.next();
	   System.out.println();
          } 
       
       while(UserInput.equalsIgnoreCase("Yes"));
       sc.close();
   }

   
   public static void quiz(Scanner sc) {
       SecureRandom rand = new SecureRandom();

       int CorrectAnswers = 0;

       for (int count = 1; count <= 10; count++) {
          
           int FirstNumber = rand.nextInt(10);
           int SecondNumber = rand.nextInt(10);
           int RightAnswer = FirstNumber * SecondNumber;

           askQuestion(FirstNumber,SecondNumber,count);

           int UserAnswer = readResponse(sc);

           if (isAnswerCorrect(RightAnswer, UserAnswer)) {
               displayCorrectResponse(rand);
               CorrectAnswers++;
           } 
           
           else
               displayIncorrectResponse(rand);
       }
       
       displayCompletionMessage(CorrectAnswers);
   }
   
   
   public static void askQuestion(int FirstNumber, int SecondNumber, int count) {
       System.out.println("Question #" + count + " What is " + FirstNumber + " * " + SecondNumber + "?\n");
   }
   
   
   public static int readResponse(Scanner sc) {
       System.out.print("Please enter your answer: \n");
       int UserResponse = sc.nextInt();
       return UserResponse;
   }

   public static void displayCompletionMessage(int CorrectAnswers) {
       
       double Score = ((double) CorrectAnswers / 10.0) * 100.0;
       
       System.out.println("You got " + Score +" % of your answers correctly.\n");
       
       if (Score < 75) {
           System.out.println("Please ask your teacher for extra help.\n");
       }
       
	else {
           System.out.println("Congratulations, you are ready to go to next level!\n"); 
       }
   }
   
   public static boolean isAnswerCorrect(int RightAnswer, int UserResponse) {
       
       return RightAnswer == UserResponse;
   }

  
   public static void displayCorrectResponse(SecureRandom rand) {
	    
       SecureRandom secureRandom = new SecureRandom();
       int ResponseNumber = secureRandom.nextInt(4);
       
       if(ResponseNumber == 0) {
    	   System.out.println("Very Good!\n");   
       } 
       
       else if (ResponseNumber == 1) {
    	   System.out.println("Excellent!\n");  
       } 
       
       else if (ResponseNumber == 2) {
    	    System.out.println("Nice Work!\n");  
       } 
       
       else if (ResponseNumber == 3) {
    	   System.out.println("Keep Up The Good Work!\n");  
       }
   }

   
   public static void displayIncorrectResponse(SecureRandom rand) {
	   
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
