package lesson1.obstacles;

import lesson1.Competitors.Competitor;
import lesson1.Competitors.Team;

public class Course{
    Obstacle [] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team t) {
        for (Competitor c: t.competitors
        ) {
            for(Obstacle o:obstacles){
                o.doIt(c);
            }
        }
    }
}
