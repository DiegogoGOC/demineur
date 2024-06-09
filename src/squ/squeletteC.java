package squ;
import java.util.Random;
import java.util.Scanner;
import position.position;
import squ.tab.in;
import squ.tab.st;


public class squeletteC {
    int[][] ti = new int[10][10];
    String[][]  ts=new String[10][10];
    boolean boum ;
    boolean f;

    

    public squeletteC(){
        boum = false;
        f = false;
        this.ts = (new st()).getTabStrings();
        this.ti = (new in()).getTabIntegers();
        
    }
    public int[][] getTi() {return ti;}
    public String[][] getTs() {return ts;}
    public boolean getBoum() {return this.boum;}
    public boolean getF() {return this.f;}

    public void setBoum(boolean boum) {this.boum = boum;}
    public void setF(boolean f) {this.f = f;}
    public void setTi(int[][] ti) {this.ti = ti;}
    public void setTs(String[][] ts) {this.ts = ts;}
    public void maj (position p){setBoum(miseAJ(getTs(),getTi(),p,getBoum()));}
    public void win () {setF(finDuJeu(getTs()));};

    public boolean drap(position p){
        if(getTs()[p.getY()][p.getX()]=="[ D ]") getTs()[p.getY()][p.getX()]="[   ]";
        else getTs()[p.getY()][p.getX()]="[ D ]";
        afficheBombe(getTi());
        return getTs()[p.getY()][p.getX()]=="[ D ]";
    }
    public boolean drapQU(position p){
        return getTs()[p.getY()][p.getX()]=="[ D ]";
    }
    
    

    public static void main(String[] args) {       
		
        squeletteC squ = new squeletteC();
        afficheBombe(squ.getTi());
        affiche(squ.getTs());
        while (!squ.getF()&&!squ.getBoum()) {
            squ.maj(question());
            squ.win();
            

        }
        if(!squ.getBoum()) System.out.println("\n----------WIN---------");
    }
//-------------------------------------------------------------------------------------------------------------------
    public static boolean finDuJeu(String[][] tabStrings){
        int n = 0;
        for( int i = tabStrings.length-1;i>=0;i--){
            for( int j = tabStrings.length-1;j>=0;j--){
                if (tabStrings[i][j]=="[   ]") n =100;
                if(tabStrings[i][j]=="[ D ]") n++;
            }
        }
        return n==10;
    }


    public static boolean miseAJ (String[][] tabStrings, int[][] tab,position p,boolean boum){
        boum = explosion(tab,p);
        if (!boum) {
            tabStrings[p.getY()][p.getX()] = "[ "+tab[p.getY()][p.getX()]+" ]";
            System.out.println();
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