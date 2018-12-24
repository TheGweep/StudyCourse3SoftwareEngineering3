public class ThisClass
{
    Curio arb, bsa, dga, dvc;

    ThisClass() {
        arb = new Curio("sss", 22, "g5g");
        bsa = new Curio("aaa", 33, "3h6");
        dga = new Curio("eee", 66, "qqq");
        dvc = new Curio("ere", 55, "r566");

        System.out.println("AHAHAHAH!!11");

        arb.w_();
        bsa.w_();
        dga.w_();
        dvc.w_();
    }

    public static void main(String[] args) {
        new ThisClass();
    }
}

class Curio
{
     String s;
     int n;
    String p;

    Curio(String str, int numb, String text)
    {
        s = str;
        n = numb;
        p = text;

    }

    void w_()
    {
        System.out.println(s + " " + n +  " " + p);
    }
}