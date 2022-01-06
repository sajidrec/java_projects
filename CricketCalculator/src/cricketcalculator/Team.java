package cricketcalculator;

public class Team {

    private String name;
    private int score = 0, wicket = 0;
    private boolean batting = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getWicket() {
        return wicket;
    }

    public void fallOfWicket() {
        this.wicket++;
    }
    
    public void setBattingStatus(boolean s){
        this.batting = s;
    }
    
    public boolean getBattingStatus(){
        return this.batting;
    }

}
