public class Hello {
    public static void main(String[] args){
        // build StringBuilder
        StringBuilder str
                = new StringBuilder(5);
        str.append("Matus");
        int myint = 5;
        String converted = Integer.toString(myint);

        System.out.println("Hello " + str.toString() + converted);
        System.out.println(converted);
    }
}
