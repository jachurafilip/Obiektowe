package lab4.szyfrowanie;

public class ROT11 implements Algorithm {
    int znak;
    @Override
    public String crypt (String s)
    {
        String out = "";
        for(int i =0; i<s.length();i++)
        {
            znak = s.charAt(i);
            znak+=11;
            if(znak>122 || (znak>90 && znak <108)) znak-=26;
            out+=(char)znak;
        }
        return out;
    }

    @Override
    public String decrypt(String s)
    {
        String out="";
        for(int i =0; i<s.length(); i++)
        {
            znak = s.charAt(i);
            znak-=11;
            if(znak<65 || (znak>86 && znak< 97)) znak+=26;
            out+=(char)znak;
        }
        return out;


    }
}
