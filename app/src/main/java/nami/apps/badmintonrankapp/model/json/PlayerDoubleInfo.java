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

    @SerializedName("member_id1")
    Integer member_id1;

    @SerializedName("member_id2")
    Integer member_id2;

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

    public Integer getMember_id1() {
        return member_id1;
    }

    public void setMember_id1(Integer member_id1) {
        this.member_id1 = member_id1;
    }

    public Integer getMember_id2() {
        return member_id2;
    }

    public void setMember_id2(Integer member_id2) {
        this.member_id2 = member_id2;
    }
}
