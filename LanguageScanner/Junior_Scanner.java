package TINY_Lang_Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Junior_Scanner
{
    enum TINY_DFN_STATES{START,IN_NUM,IN_ID,IN_ASSIGN,IN_COMMENT,OTHER,DONE}
    
    //HELPER FUNCTIONS
     static boolean Identify_String(String input_String)
    {
        //CHECKS IF THE INPUT STRING IS INITIALIZED WITH A LETTER 
        return input_String.matches("^[a-zA-Z][a-zA-Z]+$|[a-zA-Z]+");
    }
    static boolean Identify_Colon(String input_String)
    {
        return input_String.matches(":");
    }
    //CHECKS IF THE INPUT STRING IS A SYMBOL
    static boolean Identify_Symbol(String input_String)
    {
        return Arrays.asList(Symbols_Special).contains(input_String);
    }
    //CHECKS IF THE INPUT STRING IS A DIGIT
    static boolean Identify_Digit(String input_String)
    {
        return input_String.matches("\\d+");
    }
    public static void Scanner_Representation()
    {
        for(int i=0; i<Tokens_List.size(); i++)
        {
            System.out.println("TOKEN TYPE:   "+Tokens_List.get(i).Token_Type+"    TOKEN VALUE:    "+Tokens_List.get(i).Token_Val);
        }
    }
    static void Table_Creation()
    {
        //RESERVED WORDS MAP
        ReservedWords.put("if","Reserved Word");
        ReservedWords.put("then","Reserved Word");
        ReservedWords.put("else","Reserved Word");
        ReservedWords.put("end","Reserved Word");
        ReservedWords.put("repeat","Reserved Word");
        ReservedWords.put("until","Reserved Word");
        ReservedWords.put("read","Reserved Word");
        ReservedWords.put("write","Reserved Word");
        //SYMBOLS MAP
        Symbols.put("+","Addition Operator");
        Symbols.put("-","Subtract Operator");
        Symbols.put("–", "Subtract Operator");
        Symbols.put("–", "Subtract Operator");
        Symbols.put("*","Multiplication Operator");
        Symbols.put("/","Divsion Operator");
        Symbols.put("=","Equal Operator");
        Symbols.put("<","Less than Operator");
        Symbols.put(">","Greater than Operator");
        Symbols.put("(","Open Bracket");
        Symbols.put(")","Closed Bracket");
        Symbols.put(";","Semi Colon Operator");
    }
    static public ArrayList<Character>  Input_CharArray = new ArrayList<Character>();
    static public String [] Words_Reserved = {"if","then","else","end","repeat","until","read","write"};
    static public String [] Symbols_Special ={"+", "-", "*", "/", "=", "<", ">", "(", ")", ";","–","–"}; 
    static public ArrayList<Token> Tokens_List = new ArrayList<Token>();
    static public HashMap<String, String> Symbols=new HashMap<>();
    static public HashMap<String, String> ReservedWords=new HashMap<>();

    static TINY_DFN_STATES Curr_State =TINY_DFN_STATES.START;
    static boolean Nxt_State=false;
    
    public Junior_Scanner(){}
    
    public static void Scanning (String Input_String )
    {
      
        Input_String+=" "; //White Space is added in order to allow the last character of the string to be tokenized
        Table_Creation();
        Input_CharArray.clear();
        String TokenHolder="";

        for (char Single_IP_Char : Input_String.toCharArray())
        {
            Input_CharArray.add(Single_IP_Char); 
                //Creating a Character array and enqueueing the input string individually character by character 
                //to the character array for easier iteration
        }
        for(int i=0; i<Input_CharArray.size(); i++) {
            String Pointed_Char = Input_CharArray.get(i).toString();
                if(null!=Curr_State) //CHECKING THE STATES ACCORDING TO TINY-LANGUAGE-SCANNER DFA
            switch (Curr_State) {
                case START:
                    if (Pointed_Char.matches("[a-zA-Z]")) {
                        Curr_State = TINY_DFN_STATES.IN_ID;
                    }
                    if (Pointed_Char.matches(" ")) {
                        Curr_State = TINY_DFN_STATES.START;
                        continue;
                    }
                    if (Identify_Digit(Pointed_Char)) {
                        Curr_State = TINY_DFN_STATES.IN_NUM;
                    }
                    if (Pointed_Char.matches("[{]")) {
                        Curr_State = TINY_DFN_STATES.IN_COMMENT;
                    }
                    if (Identify_Colon(Pointed_Char)) {
                        Curr_State = TINY_DFN_STATES.IN_ASSIGN;
                    }
                    if (Identify_Symbol(Pointed_Char)) {
                        Curr_State=TINY_DFN_STATES.DONE;
                    }
                    break;
                case IN_COMMENT:
                    if (Pointed_Char.matches("[}]")) {
                        Curr_State = TINY_DFN_STATES.DONE;
                    }
                    else {
                        Curr_State = TINY_DFN_STATES.IN_COMMENT;
                    }
                    break;
                case IN_ID:
                    //Overlooping another Letter
                    if (Pointed_Char.matches("[a-zA-Z_]")) {
                        Curr_State = TINY_DFN_STATES.IN_ID;

                    }
                    //If white space, move to the DONE State as it's the Token Splitter identfied
                    else if (Pointed_Char.matches(" ")) {
                        Curr_State = TINY_DFN_STATES.DONE;

                    }
//get to the OTHER state in case of different input other than letter or White Space
                    else{
                        Curr_State=TINY_DFN_STATES.OTHER;
                    }
                    break;
                case IN_NUM:
                    if (Pointed_Char.matches("[0-9]+")) {

                        Curr_State = TINY_DFN_STATES.IN_NUM;
                    }
                    else if (Pointed_Char.matches(" ")) {

                        Curr_State = TINY_DFN_STATES.DONE;
                    }
                    else{
                        Curr_State = TINY_DFN_STATES.OTHER;
                    }
                    break;
                case IN_ASSIGN:
                    if (Pointed_Char.matches("=")) {
                        Curr_State = TINY_DFN_STATES.DONE;
                    }
                    else {
                        Curr_State=TINY_DFN_STATES.OTHER;
                    }
                    break;
                default:
                    break;
            }
            if(Curr_State!=TINY_DFN_STATES.OTHER)
            {
                TokenHolder+=Pointed_Char;

            }
//            UPDATING THE NEXT STATE TO TRUE TO ALLOW THE TOKENIZATION OF THE CURRENT TOKEN 
            if(Curr_State==TINY_DFN_STATES.OTHER)
            {
                Curr_State=TINY_DFN_STATES.DONE;
                Nxt_State=true;
            }
            if(Curr_State==TINY_DFN_STATES.DONE)
            {

                //UPDATING THE LIST OF TOKENS WITH THE TOKEN HOLDER
                IDENTIFY(TokenHolder, Tokens_List);

                //HANDLING THE CHARACTERS RESULTANT OF THE OTHER STATE IN THE PREVIOUS LINES
                if(Nxt_State)
                {
                    //HANDLING THE TOKEN COMING FROM THE OTHER STATE
                        TokenHolder = Pointed_Char;
                        
//                        IN CASE THE POINTED CHARACTER IS ONE OF THE MAIN KNOWN STATES WITHIN THE DFA
//                        SO AN ITERATION WILL BE ITERATED AMONG ALL STATES TO COMPARE IF THE CURR_STATE IS 
//                        ONE OF THE DEFINED STATES
                        
                        if(Identify_Colon(Pointed_Char))
                        {
                            Curr_State=TINY_DFN_STATES.IN_ASSIGN;
                        }
                        
                        if(Pointed_Char.matches("[{]"))
                        {
                            Curr_State=TINY_DFN_STATES.IN_COMMENT;
                        }
                       
                        if(Identify_Digit(Pointed_Char))
                        {
                            Curr_State=TINY_DFN_STATES.IN_NUM;
                        }
                        

                        if(Identify_String(Pointed_Char))
                        {
                            Curr_State=TINY_DFN_STATES.IN_ID;
                            //LETTER COMING FROM THE IN_NUM STATE
                        }
               // GROUPED INTO ONE STEP AS THE SYMBOL IS AN INDIVIDUAL TOKEN
                        if (Identify_Symbol(Pointed_Char))
                        {
                                    IDENTIFY(Pointed_Char, Tokens_List);
                                    TokenHolder="";
                                    Curr_State=TINY_DFN_STATES.START;
                        }
               //UPDAING THE NEXT STATE TO FALSE AND RESETTING THE TokenHolder TO BLANK IN ORDER TO SCAN THE CHARACTERS IN QUEUE
                        Nxt_State=false;}
                  
                    else {
                        TokenHolder = "";
                    }
                    //RESETTING THE CURRENT STATE TO START
                    Curr_State = TINY_DFN_STATES.START;
                    }
        }
    }
    //ADD THE TOKEN TO THE Tokens_List
    static void IDENTIFY(String TOKEN, ArrayList<Token> Tokens_List)
    {
        if(TOKEN.endsWith(" ")) //ELIMINATE THE WHITE SPACE AT THE END OF TOKEN IN CASE IT EXISTS
        {
            TOKEN = TOKEN.substring(0,(TOKEN.length())-1);
        }
       //IDENTIFYING IF THE TOKEN STARTS WITH A LETTER
        if(Identify_String(TOKEN))
        {
            if(Arrays.asList(Words_Reserved).contains(TOKEN))
            {
                //CHECKING IF THE TOKEN IS FROM THE RESERVED LISTS
                Tokens_List.add(new Token(TOKEN,ReservedWords.get(TOKEN)));
            }
            else
            {
                //ELSE, CONSIDER THE TOKEN AS AN IDENTIFIER
                Tokens_List.add(new Token(TOKEN,"Identifier"));
            }
        }
        //TOKEN IS ASSIGNMENT
        else if(TOKEN.matches(":="))
        {
            Tokens_List.add(new Token(TOKEN,"Assign Operator"));
        }
        //TOKEN IS A NUMBER
        else if(Identify_Digit(TOKEN))
        {
            Tokens_List.add(new Token(TOKEN, "Number"));
        }
        //SYMBOL TOKEN
        else if(Identify_Symbol(TOKEN)) {
            Tokens_List.add(new Token(TOKEN, Symbols.get(TOKEN)));
        }
    }}

