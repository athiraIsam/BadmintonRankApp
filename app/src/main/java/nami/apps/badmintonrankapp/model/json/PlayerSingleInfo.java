package nami.apps.badmintonrankapp.model.json;

import com.google.gson.annotations.SerializedName;

public class PlayerSingleInfo {

    @SerializedName("country")
    String country;

    @SerializedName("player")
    String playerName;

    @SerializedName("points")
    String points;

    @SerializedName("rank")
    String rank;

    @SerializedName("tournaments")
    String tournaments;


    @SerializedName("member_id")
    Integer member_id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }
}
