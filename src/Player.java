public class Player {
    private int ID;
    private int rating;
    private int playedGames;

    public Player(int ID, int rating, int playedGames){
        this.ID = ID;
        this.rating = rating;
        this.playedGames = playedGames;
    }


    public int getID() {
        return ID;
    }

    public int getRating() {
        return rating;
    }

    public int getPlayedGames() {
        return playedGames;
    }


}
