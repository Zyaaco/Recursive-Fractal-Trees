import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Branch {
    PApplet p = Main.processing;
    PVector begin;
    PVector end;
    boolean finished = false;

    Branch(PVector begin, PVector end) {
        this.begin = begin;
        this.end = end;
    }

    void jitter() {
        end.x += p.random(-1, 1);
        end.y += p.random(-1, 1);
    }

    void show() {
        p.stroke(255);
        p.line(begin.x, begin.y, end.x, end.y);
    }

    Branch branchA() {
        float angle = p.random(PConstants.PI/4, PConstants.PI/2);
        finished = true;
        PVector dir = PVector.sub(end, begin);
        dir.rotate(angle);
        dir.mult(0.67f);
        PVector newEnd = PVector.add(end, dir);

        return new Branch(end, newEnd);
    }

    Branch branchB() {
        float angle = p.random(PConstants.PI/4, PConstants.PI/2);
        PVector dir = PVector.sub(end, begin);
        dir.rotate(-angle);
        dir.mult(0.67f);
        PVector newEnd = PVector.add(end, dir);

        return new Branch(end, newEnd);
    }
}
