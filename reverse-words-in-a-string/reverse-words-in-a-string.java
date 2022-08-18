class Solution {
    public String reverseWords(String s)
    {
        int i=0;
        int length=s.length();   
        int j=0;
        String res=null;
        String sub=null;
        while(i<length)
        {
            while(i<length && s.charAt(i)==' ') i++;
            if(i==length) break;
            j=i+1;

            while(j<length && s.charAt(j)!=' ') j++;
            sub=s.substring(i,j);

            res=res==null?sub:sub+" "+res;  
            
            i=j+1;
        }
        return res;
    }
}

/*
"  cat  dog " -> dog cat
        i
            j



*/