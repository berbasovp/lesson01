package Marathon.Obstacle;

import Marathon.Competitor;
import Marathon.Obstacle.Obstacle;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }

    String str = "asd asdasd asdasdasd asdas" +
            "asdasdasd asdasda asdasd asd" +
            "asd asdasdasd asda" +
            "asdas dasdasd";

}