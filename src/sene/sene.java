package sene;

import Img.imgJAVA.img;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import position.position;
import squ.squeletteC;

public class sene{

    ImageView g = (new img("grille")).getI();
    ImageView r = (new img("actu")).getI();
    squeletteC squ; Group root= new Group();
    Scene scene = new Scene(root,400,400);

    public sene (){
        squ = new squeletteC();
        g.setFitWidth(400); g.setFitHeight(400);
        r.setX(155); r.setY(155);r.setFitWidth(50); r.setFitHeight(50);
        root.getChildren().add(g);        
        root.getChildren().add(r);
    }
    public ImageView getG() {
        return g;
    }
    public ImageView getR() {
        return r;
    }
    public Scene getScene() {
        return scene;
    }
    public squeletteC getSqu() {
        return squ;
    }


    public position pixToCase(double x,double y){return new position((dToi((x+5)/40)),dToi((y+5)/40));}

    public static int dToi(double n){ return (int) Math.round(n);}
    
    public void M_A_J(position p){
        this.squ.maj(p);
        Affiche(p);
        this.squ.win();    
        if(this.squ.getF())CreeImgB("win1");
    }

    public void Affiche (position p){
        for(int i=0;i<this.squ.getTs().length;i++){
            for(int j=0;j<this.squ.getTs().length;j++){
                if (this.squ.getTs()[i][j] != "[   ]"){
                    DominoZero(p);
                    AfficheCase(p,new position(dToi(r.getX()),dToi(r.getY())));
                    
                }}}}

    public void CreeImg (String s){ CreeImg(s,new position(dToi(r.getX()),dToi(r.getY())));}

    public void CreeImg (String s,position p){
        ImageView I = (new img(s)).getI();
        I.setFitWidth(20); I.setFitHeight(20);
        I.setY(p.getY()+15); I.setX(p.getX()+15);
        root.getChildren().add(I);
    }

    public void CreeImgB (String s){
        ImageView I = (new img(s)).getI();
        I.setFitWidth(400); I.setFitHeight(400);
        root.getChildren().add(I);
    }

    public void DominoZero(position p) {
        position np;
        if(this.squ.getTi()[p.getY()][p.getX()]==0){
            for(int i = p.getY()-1; i<p.getY()+2; i++){if (i>=0&&i<10){
                    for(int j = p.getX()-1; j<p.getX()+2; j++){if (j>=0&&j<10) {
                            np= new position(j, i);
                            boolean clos = this.squ.getTs()[i][j]=="[   ]";
                            this.squ.getTs()[i][j] = "[ "+ this.squ.getTi()[i][j] +" ]";
                            if(clos) {
                                DominoZero(np);
                                position nnp = CaseToPixel(np);
                                AfficheCase(np,nnp);
                            }
                        }}}}}
    }

    public static position CaseToPixel(position p){return new position((((p.getX()*40)-5)),((p.getY()*40)-5));}

    public void AfficheCase(position pc, position pa){
        switch (this.squ.getTi()[pc.getY()][pc.getX()]) {
            case 0:CreeImg("0",pa);break;
            case 1:CreeImg("1",pa);break;
            case 2:CreeImg("2",pa);break;
            case 3:CreeImg("3",pa);break;
            case 4:CreeImg("4",pa);break;
            case 5:CreeImg("5",pa);break;
            case 6:CreeImg("6",pa);break;
            case 7:CreeImg("7",pa);break;
            case 8:CreeImg("8",pa);break;
            case 9:CreeImg("9",pa);break;
            default:CreeImgB("boum");break;
        }
    }



    
}
