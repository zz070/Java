package Test;

public class PassWord {
    public static void main(String[] args) {
        String s = "uGJGSUGU*%&*%&weigfrbc348";
        System.out.println(function(s));
    }

    private static String function(String s) {
        char[] c =s.toCharArray();
        char[] cc = new char[c.length];
        if(c.length == 0||c.length>50){
            return "";
        }
        int j = 0;
        for(int i = 0;i<c.length;i++){
            if(c[i] =='A'){
                cc[j] = 'z';
                j++;
            }
            if(c[i] =='a'){
                cc[j] ='Z';
                j++;
            }
            if(c[i]=='0'){
                cc[j] = '9';
                j++;
            }
            if(c[i]>='b'&&c[i]<='z'){
                cc[j] =(char)(c[i]-33);
                j++;
            }
            if(c[i]>='B'&&c[i]<='Z'){
                cc[j] =(char)(c[i]+31);
                j++;
            }
            if(c[i]>='1'&&c[i]<='9'){
                cc[j] =(char)(c[i]-1);
                j++;
            }
        }
        String ss = "";
        for(int i = 0;i<j;i++){
            ss+=cc[i];
        }
        return ss;
    }
}
