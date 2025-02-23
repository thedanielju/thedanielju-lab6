public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }

    //shifts rotor values one step
    //update startChar to new first character
    //return true if full cycle (original startChar = new startChar)
    public boolean rotate(){ 
        char[] charArray = rotorValues.toCharArray();
        char holdFirst = charArray[0]; //hold the first character for comparison later
        
        for (int i = 0; i < charArray.length-1; i++) { //shift each character by 1 to the right
            charArray[i] = charArray[i+1];
        } 

        charArray[charArray.length - 1] = holdFirst; //put first character to the end
        rotorValues = new String(charArray); 

        if (charArray[0] == startChar) { //check if rotor has completed a full cycle
            return true;
        } else {
            return false;
        }
    }
    
    //search for c in rotorValues
    //return index in the array
    //if not found, return -1
    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
        return index;
    }

    public char charAt(int idx){
        //TODO
    }
}
    
