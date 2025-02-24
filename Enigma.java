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

            char ogChar = message.charAt(i); //get character 1 from message
            int innerIndex = rotors[0].indexOf(ogChar); // find corresponding position in inner rotor (0)
            char middleChar = rotors[1].charAt(innerIndex); // get matching char from middle rotor (1)
            int middleIndex = rotors[1].indexOf(middleChar); // find corresponding position in middle rotor (1)
            char outerChar = rotors[2].charAt(middleIndex); // get matching char from outside rotor (2)
            result += outerChar;

            rotate();
            
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
