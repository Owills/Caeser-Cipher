import java.util.Scanner;
public class CaesarCipher{
    public static void main(){
        System.out.println();
        System.out.println("Input a string");
        Scanner sc = new Scanner(System.in); 
        String str = sc.nextLine();
        
        System.out.println();
        System.out.println("Input an Integer");
        sc = new Scanner(System.in); 
        int num = sc.nextInt(); 
        
        System.out.println();
        System.out.println("Input a character");
        sc = new Scanner(System.in); 
        String c = sc.next().substring(0,1); 
        
        System.out.println();
        if(c.equals("e")){
            cipher(str,num);
        }  else if (c.equals("d")){
            cipher(str,26-num);
        }else{
            System.out.println("Inputs were entered wrong");
        }    
        
    }    
    public static void cipher(String str, int num){
        String newString = "";
        for (int i=0; i<str.length(); i++) { 
            if (Character.isUpperCase(str.charAt(i))) { 
                char ch = (char)(((int)str.charAt(i) + num - 65) % 26 + 65); 
                newString += ch; 
            }else if (Character.isLowerCase(str.charAt(i))){ 
                char ch = (char)(((int)str.charAt(i) + num - 97) % 26 + 97); 
                newString += ch; 
            } else{
                newString += str.charAt(i);
            }    
        } 
        System.out.println(newString);
    }  
   
}
