package squ.tab;

import java.util.Random;

import position.position;

public class in {
    int[][] tabIntegers = new int[10][10];
    public in (){
        positionerAllBombe(tabIntegers);
    }
    public int[][] getTabIntegers() {
        return tabIntegers;
    }
    public void setTabIntegers(int[][] tabIntegers) {
        this.tabIntegers = tabIntegers;
    }

        public static void positionerAllBombe(int[][] tab) {
        for(int n=10; n>0;n--){
            position p = new position();
            p = positionBombe();
            if (tab[p.getY()][p.getX()]>100) n++;
            else {
                positionerBombe(tab,p);
                plusUn(tab,p);
            }
        }
    }
    
    public static position positionBombe() {
        Random r = new Random();
        position p =new position(r.nextInt(9),r.nextInt(9));
        return p;
    }

    public static void positionerBombe(int[][] tab, position p) {tab[p.getY()][p.getX()]=100;}

    public static void plusUn(int[][] tab, position p){
        for(int i = p.getY()-1; i<p.getY()+2; i++){
            if (i>=0&&i<10){
                for(int j = p.getX()-1; j<p.getX()+2; j++){
                    if (j>=0&&j<10) tab[i][j]++;
                 }
            }
        }
    }
}
