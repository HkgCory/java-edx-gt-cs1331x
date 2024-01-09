public class StringOperations {
    public static void main(String[] args) {
        String str = ("Kin Hang Lo");
        str = 'A' + str.substring(1);
        System.out.println(str);
        str = str.substring(0,str.length()-1) + 'Z';
        System.out.println(str);

        String url = "http://www.gatech.edu";
        System.out.println(url.substring(11,17));
        
        url = url.substring(11, 17) + "1331";
        System.out.println(url);
    }
}
