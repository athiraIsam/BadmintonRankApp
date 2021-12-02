package nami.apps.badmintonrankapp.model.json;

import com.google.gson.annotations.SerializedName;

public class PlayerDoubleInfo {

    @SerializedName("country")
    String country;

    @SerializedName("player1")
    String playerName1;

    @SerializedName("player2")
    String playerName2;

    @SerializedName("points")
    String points;

    @SerializedName("rank")
    String rank;

    @SerializedName("tournaments")
    String tournaments;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayerName1() {
        return playerName1;
    }

    public void setPlayerName1(String playerName1) {
        this.playerName1 = playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }

    public void setPlayerName2(String playerName2) {
        this.playerName2 = playerName2;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTournaments() {
        return tournaments;
    }

    public void setTournaments(String tournaments) {
        this.tournaments = tournaments;
    }
}
