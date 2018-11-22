package lesson1.obstacles;

import lesson1.Competitors.Competitor;
import lesson1.Competitors.Team;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team t) {
        for (Competitor c : t.getCompetitors()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if(!c.isOnDistance()) break;
            }
        }
    }
}
