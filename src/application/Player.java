package application;


public class Player{
    private static int hp  = 5;
    private static int score = 0;

    public void setHp(int hp){
        this.hp = hp;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void newStatus(){
        this.hp = 5;
        this.score = 0;
    }
    public int getHp(){
        return hp;
    }
    public int getScore() {
        return score;
    }
}
