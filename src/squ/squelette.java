package squ;
import java.util.Scanner;
import position.position;
import squ.tab.in;
import squ.tab.st;


public class squelette {

    public static void main(String[] args) {
        st tabSt = new st();
        in tabInt = new in();
        afficheBombe(tabInt.getTabIntegers());
        affiche(tabSt.getTabStrings());
        boolean boum = false;
        boolean f = false;
        while (!f&&!boum) {//pb
            boum=miseAJ(tabSt.getTabStrings(),tabInt.getTabIntegers(),question(),boum);
            f =finDuJeu(tabSt.getTabStrings());

        }
        if(!boum) System.out.println("\n----------WIN---------");
    }
//-------------------------------------------------------------------------------------------------------------------
    public static boolean finDuJeu(String[][] tabStrings){
        int n = 0;
        for( int i = tabStrings.length-1;i>=0;i--){
            for( int j = tabStrings.length-1;j>=0;j--){
                if(tabStrings[i][j]=="[   ]") n++;
            }
        }
        return n==10;
    }



    public static boolean miseAJ (String[][] tabStrings, int[][] tab,position p,boolean boum){
        boum = explosion(tab,p);
        if (!boum) {
            tabStrings[p.getY()][p.getX()] = "[ "+tab[p.getY()][p.getX()]+" ]";
            System.out.println();
            afficheO(tabStrings, tab, p);
            affiche(tabStrings);
        }
        else System.out.println("---------------------BOUM-------------------");
        return boum;
        
    }

    public static position question() {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEntrez les");
        System.out.println("cohordonnée x:");
        int x = scanner.nextInt();
        System.out.println("cohordonnée y:");
        int y = scanner.nextInt();
        position p = new position(x, y);
        p.setYByClient(y);
        p.setXByClient(x);
        return p;

    }

    public static Boolean explosion (int[][] tab, position p){ return tab[p.getY()][p.getX()] >= 100;}

//---------------------------------------------------------------------------------------------------------------

    public static void afficheO (String[][] tabStrings,int[][] tab, position p){
       
        if(tab[p.getY()][p.getX()]==0){
            
            for(int i = p.getY()-1; i<p.getY()+2; i++){
                if (i>=0&&i<10){
                    for(int j = p.getX()-1; j<p.getX()+2; j++){
                        if (j>=0&&j<10) {
                            position pos = new position(j, i);
                            boolean clos = tabStrings[i][j]=="[   ]";
                            tabStrings[i][j] = "[ "+tab[i][j]+" ]";
                            if(clos) afficheO (tabStrings,tab,pos);
                        }
                    }
                }
            }
        }
    }


    public static void affiche (String[][] tabStrings){
        for(int i=0;i<tabStrings.length;i++){
            System.out.println();
            for(int j=0;j<tabStrings.length;j++){
                System.out.print(tabStrings[i][j]);
            }
        }
    }

    public static void afficheBombe (int [][] t){
        for(int i=0;i<t.length;i++){
            System.out.println();
            for(int j=0;j<t.length;j++){
                if (t[i][j]<100)System.out.print("[ "+t[i][j]+" ]");
                else System.out.print("[ - ]");
            }}}
}