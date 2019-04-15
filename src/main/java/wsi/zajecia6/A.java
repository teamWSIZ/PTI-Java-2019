package wsi.zajecia6;

public class A {

    static boolean isOK(String s) {
        //
        s.charAt(1);    //znak na pozycji 1 (zaczyna sie od 0)
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOK("(("));     //false
        System.out.println(isOK("()"));     //true
        System.out.println(isOK("(()())"));     //true
        System.out.println(isOK("())("));     //false
        System.out.println(isOK("("));     //false
    }

}
