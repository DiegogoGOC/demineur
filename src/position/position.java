package position;
import java.lang.Math;

public class position {
    int x=0;
    int y=0;
    public position(){this.x=0; this.y=0;}
    public position(int x, int y){this.x=x; this.y=y;}
    public position(position p){this.x=p.x;this.y=p.y;}

    public int getX() {return this.x;}
    public int getY() {return this.y;}

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setYByClient(int y) {this.y = Math.abs(y-10);}
    public void setXByClient(int x) {this.x = x-1;}
    public void setXY(int x, int y){ setX(x-1);setY(y-1);}
    public void setXY(position p){setX(p.x-1); setY(p.y-1);}
}