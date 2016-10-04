package CS2FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcjes
 */
public class EncodedMessage {
    private Key unlock=new Key();
    private String encryptedMsg=" ";
    private String plainText=" ";
    
    public EncodedMessage(String message, Key unlock){
        plainText=message.toUpperCase();
        this.unlock=unlock;
}
    public EncodedMessage(){
    }
    public Key getUnlock(){
        return unlock;
    }
    public int performShift(int i,String key){
         
        //returns the correct shift 
        //Shift is of the form C=T+K(mod m) such that C=the current char
        //T= the char in the plain text and T=the char in the key word
        //m is 26(alphabet has 26 chars)
        return ((int)key.charAt(i%key.length()))-65; 
    }
    public String encrypt(){
        String message=plainText;
        message=message.replace(" ","");
        String key=unlock.getUnlock();
        //String builder selected because the length of the string 
        //will have to altered as each char is encrypted and then added
        //much easier to handle then an ArrayList of chars 
        StringBuilder encodedMessage=new StringBuilder();
        for(int i=0;i<message.length();i++){ 
        //Conditional operator (?:) determines if the value of the char after the shift is above 90
        //(Not a capital letter char), if it is >90 the value is reduced by 26 (because a char
        //won't be shifted more than 26 "places" in the alphabet) so subtracting 26
        //will ensure it is still a capital letter Char 
        char encrypted=message.charAt(i)+performShift(i,key) >90 ? (char)((message.charAt(i)+performShift(i,key))-26):(char)(message.charAt(i)+performShift(i,key));
        //append method just attaches the char to the StringBuilder 
        encodedMessage.append(encrypted);   
        }
        //Returns the encrypted message in string form  in String form 
        return encodedMessage.toString();
    }
}

