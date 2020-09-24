
import java.util.Scanner;
public class noKnownSlide{
    public static Wordlist wl;
    public static void main(){
        wl = new Wordlist("wordlist copy.txt");
        System.out.println();
        System.out.println("Input a string");
        Scanner sc = new Scanner(System.in); 
        String str = sc.nextLine();

        System.out.println(cipher(str,findSlider(str)));
    }   
    public static int findSlider(String str){
      int num = 0;  
      str = str.replaceAll("[^a-zA-Z0-9]", " ");
      String[] strA = str.split(" ");
      int best = 0;
      int counter = 0;
      for(int i = 1; i< 27; i++){
          for(int j = 0; j<strA.length; j ++){
              String temp = cipher(strA[j],i);
              if(wl.checkWord(temp))
                    counter ++;    
          }  
          if (counter > best){
              
              num = i;
              best = counter;
          } 
          counter = 0;
      }    
      return num;  
    }    
    public static String cipher(String str, int num){
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
        return newString;
    }  
}
