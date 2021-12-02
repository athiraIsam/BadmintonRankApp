package nami.apps.badmintonrankapp.model.api;

import java.util.List;

import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;
import retrofit.Callback;
import retrofit.http.GET;

public interface BWFServices {
    @GET("/api/MS")
    void getMenSingleRanking(Callback<List<PlayerSingleInfo>> playerInfo);

    @GET("/api/WS")
    void getWomenSingleRanking(Callback<List<PlayerSingleInfo>> playerInfo);

    @GET("/api/MD")
    void getMenDoubleRanking(Callback<List<PlayerDoubleInfo>> playerInfo);

    @GET("/api/WD")
    void getWomenDoubleRanking(Callback<List<PlayerDoubleInfo>> playerInfo);

    @GET("/api/XD")
    void getMixedDoubleRanking(Callback<List<PlayerDoubleInfo>> playerInfo);


}
