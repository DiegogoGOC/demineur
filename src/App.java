import javafx.application.Application;
import javafx.stage.Stage;
import position.position;
import sene.sene;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
 
public class App extends Application implements EventHandler<KeyEvent> {
    sene sn = new sene();

    public static void main(String[] args) { launch(args);}

    public App() {}

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("KeyAdapter - Johnen");
        sn.getScene().setOnKeyPressed(this);
        primaryStage.setScene(sn.getScene());
        primaryStage.show();}

        @Override
        public void handle(KeyEvent event) {
                System.out.println("Handle keypress "+event.getCode());
                switch (event.getCode()) {
                    case UP: if (!(sn.getR().getY()<0))sn.getR().setY(sn.getR().getY()-40); break;
                    case DOWN: if (!(sn.getR().getY()>350))sn.getR().setY(sn.getR().getY()+40); break;
                    case LEFT: if (!(sn.getR().getX()<0))sn.getR().setX(sn.getR().getX()-40); break;
                    case RIGHT: if (!(sn.getR().getX()>350))sn.getR().setX(sn.getR().getX()+40); break;
                    case D :{                    
                        if(sn.getSqu().drap(sn.pixToCase(sn.getR().getX(),sn.getR().getY())))sn.CreeImg("Rond_rouge");
                        else sn.CreeImg("vide");
                    } break;
                    case SPACE :position p = sn.pixToCase(sn.getR().getX(),sn.getR().getY());
                    if(!sn.getSqu().drapQU(p)){sn.M_A_J(p);}
                    break;
                    default: break;
                }}

    

    }