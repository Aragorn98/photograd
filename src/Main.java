import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        Player player1;
        int player1_id;
        int player1_rating;
        int player1_Games;
        int ratingRange;
        int playedGamesRange;
        ArrayList<Player> possibleCompetitors = new ArrayList<>();
        ArrayList<Player> lastCompetitors = new ArrayList<>();
        ArrayList<Player> players = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            players.add(new Player(i, rnd.nextInt(2000), rnd.nextInt(1000)));
        }
        player1 = players.get(rnd.nextInt(1000)+1);
        player1_id = player1.getID();
        player1_rating = player1.getRating();
        player1_Games = player1.getPlayedGames();

        System.out.println("Player1 info:" + "\n" + "id = " + player1_id + ", rating = " + player1_rating + ", played games = " + player1_Games);

        for (int i = 0; i < 5; i++) {
            lastCompetitors.add(players.get(rnd.nextInt(1000)));
        }
        ratingRange = 50;
        playedGamesRange = 50;
        while(true){
            for (Player player: players
                 ) {
                if (!(player1_rating < player.getRating() - ratingRange || player1_rating > player.getRating() + ratingRange)
                && !(player1_Games < player.getPlayedGames()-playedGamesRange || player1_Games > player.getPlayedGames()+playedGamesRange)) {

                    if(!lastCompetitors.contains(player)){
                        possibleCompetitors.add(player);
                    }
                }
            }
            if(possibleCompetitors.isEmpty() && ratingRange!=100){
                ratingRange+=10;
                playedGamesRange+=10;
            }
            else break;
        }
        possibleCompetitors.remove(player1);
        System.out.println("\n" + "Possible competitors info:");
        for (Player player: possibleCompetitors
             ) {
            System.out.println("id = " + player.getID() + ", rating = " + player.getRating() + ", played games = " + player.getPlayedGames() + "\n");
        }

        int[] ranges = new int[possibleCompetitors.size()];
        for (int i = 0; i < ranges.length; i++) {
            ranges[i] = Math.abs(player1_rating - possibleCompetitors.get(i).getRating()) +
                    Math.abs(player1_Games - possibleCompetitors.get(i).getPlayedGames());
        }

        int min = ranges[0];
        int index=0;
        for (int i=0; i<ranges.length;i++) {
            if(ranges[i] < min){
                min = ranges[i];
                index = i;
            }
        }
        System.out.println("Player2 info:" + "\n" + "id = " + possibleCompetitors.get(index).getID() +
                ", rating = " + possibleCompetitors.get(index).getRating()
                + ", played games = " + possibleCompetitors.get(index).getPlayedGames());

    }
}
