import java.security.SecureRandom;

import java.util.Scanner;

public class CAI5 {


    public static void main(String[] args) {
    	
    	
        Scanner sc = new Scanner(System.in);
       
        String a;
        
        do {
           
            quiz(sc);
            
            System.out.print("Would You Like to Try Again? (Please enter Yes or No): ");
            a = sc.next();
            System.out.println();
            
        } while (a.equalsIgnoreCase("Yes"));
        
        sc.close();
    }
    
  
    public static void quiz(Scanner sc) {

    	
        SecureRandom rand = new SecureRandom();
        
        int CorrectAnswers = 0;
        int RightAnswer = 0;
        int mixed, count;
        
       
        int Difficulty = readDifficulty(sc);
        
        int Operation = readProblemType(sc);
        
       
        for (count = 1; count <= 10; count++) {
        
            int FirstNumber = generateQuestionArgument(rand, Difficulty);
            
            int SecondNumber = generateQuestionArgument(rand, Difficulty);
            
            switch (Operation) {
                case 1:
                    
                    RightAnswer = Operation(FirstNumber, SecondNumber, count, 1);
                    break;
               
               case 2:
                    
                    RightAnswer = Operation(FirstNumber, SecondNumber, count, 2);
                    break;
                
                case 3:
                    
                    RightAnswer = Operation(FirstNumber, SecondNumber, count, 3);
                    break;
               
               case 4:
                    
                    RightAnswer = Operation(FirstNumber, SecondNumber, count, 4);
                    break;
                
                case 5:
                
                    mixed = rand.nextInt(4) + 1;
                    RightAnswer = Operation(FirstNumber, SecondNumber, count, mixed);
                    break;
                
                default:
                	
                    System.out.println("Invalid!");
                    break;
            }
            
            int UserResponse = readResponse(sc);
            
            if (isAnswerCorrect(RightAnswer,UserResponse)) {
                displayCorrectResponse(rand);
                CorrectAnswers++;
            } else
                displayIncorrectResponse(rand);
        }
        
        displayCompletionMessage(CorrectAnswers);
    }
    
    
    public static int readDifficulty(Scanner sc) {
        System.out.printf("Choose your difficulty: \n");
        return sc.nextInt();
    }
    
    
    public static int generateQuestionArgument(SecureRandom rand, int Difficulty) {
        
        int UserChoice = 0;
       
        
        if (Difficulty == 1)
            UserChoice = rand.nextInt(10);
        
        else if (Difficulty == 2)
            UserChoice = rand.nextInt(100);
        
        else if (Difficulty == 3)
            UserChoice = rand.nextInt(1000);
        
        else
            UserChoice = rand.nextInt(10000);
       
        return UserChoice;
    }

   
    public static int readProblemType(Scanner sc) {
        
        System.out.println("1 = Addition\n");
        
        System.out.println("2 = Multiplication\n");
        
        System.out.println("3 = Subtraction\n");
       
        System.out.println("4 = Division\n");
        
        System.out.println("5 = Mixed Mode\n");
        
        System.out.println("Select the Desired Operation:");
        int Operation = sc.nextInt();
        
        return Operation;
    }
    
    
    public static int chooseOperation(int FirstNumber, int SecondNumber, int count, int UserChoice) {
        
        int Answer = 0;
        
        
        switch (UserChoice) {
            case 1:
                Answer = Addition(FirstNumber, SecondNumber, count);
                break;
            case 2:
                Answer = Multiplication(FirstNumber, SecondNumber,count);
                break;
            case 3:
                Answer = Subtraction(FirstNumber, SecondNumber, count);
                break;
            case 4:
                Answer = Division(FirstNumber, SecondNumber,count);
                break;
        }
        
        return Answer;
    }
    
     public static int Addition(int FirstNumber, int SecondNumber, int count) {
        System.out.println("Question#" + count + " What is " + FirstNumber + " + " + SecondNumber + " ?");
        int RightAnswer = FirstNumber + SecondNumber;
        return RightAnswer;
    }
    
    public static int Multiplication(int FirstNumber, int SecondNumber, int count) {
        System.out.println("Question #" + count + " What is " + FirstNumber + " * " + SecondNumber + " ?");
        int RightAnswer = FirstNumber * SecondNumber;
        return RightAnswer;
    }
    
    public static int Subtraction(int FirstNumber, int SecondNumber, int count) {
        System.out.println("Question #" + count + " What is " + FirstNumber + " - " + SecondNumber + " ?");
        int RightAnswer = FirstNumber - SecondNumber;
        return RightAnswer;
    }
    
    
    public static int Division(int FirstNumber, int SecondNumber, int count) {
        System.out.println("Question #" + count + " What is " + FirstNumber + " / " + SecondNumber + " ?");
        int RightAnswer = FirstNumber / SecondNumber;
        return RightAnswer;
    }
    
   
    public static int readResponse(Scanner sc) {
        System.out.print("Please enter your answer: ");
        int UserResponse = sc.nextInt();
        return UserResponse;
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
    
    public static void displayCompletionMessage(int CorrectAnswers) {
        
        double Score = ((double) CorrectAnswers / 10.0) * 100.0;
        System.out.println(""You got " + Score + " % of your answers correctly.\n"");
        
        if (Score < 75)
            System.out.println("Please ask your teacher for extra help.\n");
        
        else
            System.out.println("Congratulations, you are ready to go to next level!\n");
    }
    
}
