package Marathon;

import Marathon.Obstacle.Cross;
import Marathon.Obstacle.Obstacle;
import Marathon.Obstacle.Wall;
public class Course {
    private int[] wall = {2, 3, 1};
    public int[] cross = {80, 120, 200};
    Obstacle[] course = new Obstacle[6];

    public Course() {
        for (int j = 0; j < course.length; j++) {
            for (int i = 0; i < cross.length; i++) {
                course[j] = new Cross(this.cross[i]);
                j++;
            }
            for (int i = 0; i < wall.length; i++) {
                course[j] = new Wall(this.wall[i]);
                j++;
            }
        }
    }

    public void doIt(Team team) {
        for (Competitor teamd : team.competitors) {
            for (Obstacle o : course) {
                o.doIt(teamd);
                if (!teamd.isOnDistance()) break;
            }
        }
    }
}