package lesson1;

import lesson1.Competitors.*;
import lesson1.obstacles.*;


public class MainClass {

    public static void main(String[] args) {
        /*В реализации решил убрать ограничение на количество участников и препятствий, надеюсь так можно :)*/
        Course c = new Course(new Obstacle[]{new Cross(400), new Water(1), new Wall(4)});
        Team team = new Team("Котлетки", new Competitor[]{new Cat("Барсик"), new Dog("Бобик"), new Human("Саша"), new Human("Андрей")});
        System.out.println("Информация обо всех участниках команды");
        team.showTeamInfo();
        System.out.println("============================================");
        c.doIt(team);
        team.showResult();
    }
}
