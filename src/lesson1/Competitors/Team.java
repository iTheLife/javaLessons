package lesson1.Competitors;

public class Team{

    private String teamName;
    private Competitor [] competitors;

    public Team(String teamName, Competitor[] competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    /*public Team(String teamName, Competitor ... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }*/
    public void showTeamInfo(){
        System.out.println("Команда: " + teamName);
        for(Competitor c: competitors){
            c.showInfo();
        }
    }

    public void showResult(){
        System.out.println("Команда: " + teamName + ", участники преодолевшие полосу препятствий:");
        for(Competitor c: competitors){
            if(c.isOnDistance()) c.showInfo();
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }
}
