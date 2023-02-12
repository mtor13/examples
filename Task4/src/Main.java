public class Main {
    public static void main(String[] args) {

        String words = args[0];
        words = words.replaceAll(" ","");
        String[] Wordlist = words.split(",");
        String result = Wordlist[0];
        for (int i=0;i<Wordlist.length;i++){
            if (result.length()< Wordlist[i].length()){
                result= Wordlist[i];
            }
        }
        System.out.println("The biggest word is " + result);
    }
}