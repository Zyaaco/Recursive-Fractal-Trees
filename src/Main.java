import processing.core.*;

import javax.swing.plaf.SliderUI;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }

    float angle = PI/4;

    public void settings() {
        size(400, 400);
    }

    public void setup() {

    }


    public void draw() {
        background(60);

        translate(200, height);

        stroke(255);
        branch(100);
    }

    void branch(float len) {
        line(0, 0, 0, -len);
        translate(0, -len);
        if( len > 1 ) {
            push();
            rotate(angle);
            branch(len*0.67f);
            pop();
            push();
            rotate(-angle);
            branch(len*0.67f);
            pop();
        }
    }
}