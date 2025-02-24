public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO
    }


    
    public String encrypt(String message){ //rough draft 2
        String result = "";
        for (int i = 0; i < message.length(); i++) {

            char char1 = message.charAt(i);
            int index = rotors[0].indexOf(char1);
            char char2 = rotors[1].charAt(index);
            int index1 = rotors[2].indexOf(char2);
            char char3 = rotors[2].charAt(index1);
            result += char3;

            if (rotors[0].rotate()) {
                if (rotors[1].rotate()) {
                    rotors[2].rotate();
                }
            }
            
        }
        return result;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
