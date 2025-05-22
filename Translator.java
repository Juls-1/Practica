public class Translator{

    private String msg="";
    private static final String ALPABETH[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "};
    private static final String MORSE_ALPABETH[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","/"};
   
    public String translateToMorse(String signal){
        msg="";
        signal=signal.toLowerCase();
        for (int i=0; i<signal.length(); i++){
            for (int j=0; j<ALPABETH.length; j++){
                if ((signal.charAt(i)+"").equals((ALPABETH[j]))){
                    msg+=MORSE_ALPABETH[j]+" ";
                }
            }
        }
        return msg;
    
    }

    public String translateFromMorse(String signal) {
        msg = "";
        for (int i=0; i<signal.length(); i++) {
            String code = "";
            while (i<signal.length() && signal.charAt(i)!=' ') {
                code += signal.charAt(i);
                i++;
            }
            for (int j = 0; j < MORSE_ALPABETH.length; j++) {
                if (code.equals(MORSE_ALPABETH[j])) {
                    msg += ALPABETH[j];
                }
            }
        }
        return msg;
    }


    public String getMsg(){return msg;}

}