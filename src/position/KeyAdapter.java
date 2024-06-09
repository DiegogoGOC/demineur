package position;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage; 

public class KeyAdapter extends Application implements EventHandler<KeyEvent> {
    Image r1 = new Image("/img/0.png");
    ImageView r = new ImageView(r1);
    Group root;

    public KeyAdapter() {
        root = new Group();
        r.setX(50); r.setY(50);
        r.setFitWidth(10); r.setFitHeight(10);
        root.getChildren().add(r);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("KeyAdapter - Johnen");
        Scene scene = new Scene(root,600,600);
        scene.setOnKeyPressed(this);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    @Override
        public void handle(KeyEvent event) {
            System.out.println("Handle keypress "+event.getCode());
            switch (event.getCode()) {
                case UP: r.setY(r.getY()-10); break;
                case DOWN: r.setY(r.getY()+10); break;
                case LEFT: r.setX(r.getX()-10); break;
                case RIGHT: r.setX(r.getX()+10); break;
                default: break;
            } 
        }
    public static void main(String[] args) { launch(args);}

    }