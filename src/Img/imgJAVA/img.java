package Img.imgJAVA;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class img {
    Image i1 = new Image("/img/imgPNG/grille.png");
    ImageView i = new ImageView(i1);

    public img (String si){
        this.i1 = new Image("/img/imgPNG/"+si+".png");
        this.i =  new ImageView(i1);
    }
    public ImageView getI() {
        return i;
    }

    
}
