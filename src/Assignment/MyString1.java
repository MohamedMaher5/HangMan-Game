package Assignment;

public class MyString1 {
    private int length;
    private char [] chars;
    public MyString1(char[] c)
    {
        chars = new char[c.length];
    
        for (int i=0; i<c.length; i++)
            chars[i] = c[i];
    }

    private MyString1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public char charAt(int index) 
    {
        if (index < 0 || index >= chars.length)
            return ' ';

        else
            return chars[index];
    }
    /*public int length()
    {
        return chars.length;
    }*/
    public int length()
    {
        int i = 0;
        while (chars[i] != 0)
            i++;
        return i;
    }
    public boolean equals(MyString1 s)
    {
        if ( (s instanceof MyString1) && (this.length() != ((MyString1)s).length()))
            return false;
        else
            return this.toString().equals(s.toString());
    }
    public MyString1 toLowerCase ()
    {
            
        MyString1 newMyString = new MyString1(); 
        newMyString.length = this.length;
        newMyString.chars = new char [this.length];
		
        for (int i = 0; i < this.length; i++)
        {
            if ((this.chars[i] >= 'A') && (this.chars[i] <= 'Z'))
                newMyString.chars[i] = (char)(this.chars[i] + 32);
            else
                newMyString.chars[i] = this.chars[i];
        }
            return newMyString;
    }
    public MyString1 toLowerCase2() 
    {
	int Al = 'a' - 'A';
	char[] chars = getString();
	for (int i = 0; i < getString().length; i++) {
	    if (chars[i] >= 'A' && chars[i] <= 'Z') {
		chars[i] = (char) (chars[i] + Al);
	    }
	}
	return new MyString1(chars);
    }
    public MyString1 substring(int beginIndex, int endIndex) 
    {
	if (beginIndex < 0)
            throw new StringIndexOutOfBoundsException(beginIndex);
	if (endIndex > length) 
	    throw new StringIndexOutOfBoundsException(endIndex);
	if (beginIndex > endIndex) 
	    throw new StringIndexOutOfBoundsException(endIndex - beginIndex);
	
	MyString1 result = new MyString1();
	result.length = endIndex - beginIndex + 1;
	result.chars = new char [result.length];

	for (int i = 0; i < result.length; i++)
		result.chars[i] = this.chars[beginIndex + i];

        return result;
    }
    public static MyString1 valueOf(int i)
    {
        
        char[] c = new char[i];
        
        MyString1 ms = new MyString1(c);
        return ms;
    }
    public static void main(String[] args) {
        char[] c = {'a','b','c','d'};
        MyString1 m = new MyString1(c);
    }

    private char[] getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
