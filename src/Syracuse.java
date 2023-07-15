import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Syracuse {
    public static void main(String[] args) {
        try {
            int x = Integer.parseInt(args[0]);
            FileWriter fw=new FileWriter("f"+x+".dat");
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write("n Un");
            bw.newLine();
            syracuse(x,0,0, bw);
            bw.close();
        }
        catch (Exception e) {
            System.out.println("Erreur " + e);
        }

    }
/*    public static int Collatz(int x, int cpt, int max, BufferedWriter bw) throws IOException {
        String test = String.valueOf(x);
        bw.write("La valeur de x est : "+ test);
        System.out.println("Le temps de vol est : "+cpt);
        if (x>max) max = x;
        if (x==1) {
            System.out.println("altimax="+max);
            System.out.println("dureevol="+cpt);
            return 0;
        } else if (x % 2 == 0) {
            return Collatz(x/2,cpt+1,max,bw);
        } else {
            return Collatz(3*x+1,cpt+1,max,bw);
        }
    }*/
    public static int collatz(int x){
        if (x % 2 == 0)
            return x/2;
        else return 3*x+1;
    }
    public static void syracuse(int x,int max,int cpt,BufferedWriter bw) throws IOException {
        if (x>max) max = x;
        if (x==1) {
            bw.write(cpt + " " + x);
            bw.newLine();
            bw.write("altimax=" + max);
            bw.newLine();
            bw.write("dureevol=" + cpt);
            return;
        }else{
            bw.write(cpt + " " + x);
            bw.newLine();
            syracuse(collatz(x),max,cpt+1,bw);}
    }
}