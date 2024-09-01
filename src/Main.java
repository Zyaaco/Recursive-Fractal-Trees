import processing.core.*;

import java.util.ArrayList;

public class Main extends PApplet {
    public static PApplet processing;
    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    ArrayList<Branch> tree;
    boolean jitter = false;


    public void settings() {
        size(400, 400);
    }

    public void setup() {
        processing = this;
        PVector a = new PVector(width/2f, height);
        PVector b = new PVector(width/2f, height-100);
        Branch root = new Branch(a, b);

        tree = new ArrayList<>();
        tree.add(root);

        for (int j = 0; j < 12; j++) {
            for (int i = tree.size()-1; i >= 0; i--) {
                Branch branch = tree.get(i);
                if(!branch.finished) {
                    tree.add(branch.branchA());
                    tree.add(branch.branchB());
                    branch.finished = true;
                }
            }
        }
    }


    public void draw() {
        background(60);
        for (Branch branch : tree) {
            branch.show();
            if(jitter) {
                branch.jitter();
            }
        }
    }
}