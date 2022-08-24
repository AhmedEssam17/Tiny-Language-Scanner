package TINY_Lang_Scanner;
public class Token
{
    enum TokenType{Number,Identifier,Operator,Assignment,Reserved_Word}
    public String Token_Val;
    public String Token_Type;
    public Token(String Tok_Val, String Tok_Type)
    {this.Token_Val = Tok_Val; this.Token_Type = Tok_Type;}
    public String Val_Getter(){return this.Token_Val;}
    String Token_Printer() {return Token_Val +" type of "+Token_Type;}
}
