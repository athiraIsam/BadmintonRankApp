package nami.apps.badmintonrankapp.model;

import java.util.List;

import nami.apps.badmintonrankapp.contract.RankingContract;
import nami.apps.badmintonrankapp.model.api.BWFServices;
import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RankingModel implements RankingContract.Model {

    private final BWFServices service;

    public  RankingModel()
    {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://www.bwfshuttleapi.com/rankings")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        service = restAdapter.create(BWFServices.class);
    }
    @Override
    public void getMenSingleRankings(final OnListerner listerner) {
       
        service.getMenSingleRanking(new Callback<List<PlayerSingleInfo>>() {
            @Override
            public void success(List<PlayerSingleInfo> playerSingleInfos, Response response) {
                listerner.onGetSingleRankingSuccess(playerSingleInfos);
            }

            @Override
            public void failure(RetrofitError error) {
                listerner.onFailure(error.getMessage());
            }
        });
    }

    @Override
    public void getWomenSingleRankings(final OnListerner listerner) {
        service.getWomenSingleRanking(new Callback<List<PlayerSingleInfo>>() {
            @Override
            public void success(List<PlayerSingleInfo> playerSingleInfos, Response response) {
                listerner.onGetSingleRankingSuccess(playerSingleInfos);
            }

            @Override
            public void failure(RetrofitError error) {
                listerner.onFailure(error.getMessage());
            }
        });
    }

    @Override
    public void getMenDoubleRankings(final OnListerner listerner) {
        service.getMenDoubleRanking(new Callback<List<PlayerDoubleInfo>>() {
            @Override
            public void success(List<PlayerDoubleInfo> playerDoubleInfos, Response response) {
                listerner.onGetDoubleRankingSuccess(playerDoubleInfos);
            }


            @Override
            public void failure(RetrofitError error) {
                listerner.onFailure(error.getMessage());
            }
        });
    }

    @Override
    public void getWomenDoubleRankings(final OnListerner listerner) {
        service.getWomenDoubleRanking(new Callback<List<PlayerDoubleInfo>>() {
            @Override
            public void success(List<PlayerDoubleInfo> playerDoubleInfos, Response response) {
                listerner.onGetDoubleRankingSuccess(playerDoubleInfos);
            }


            @Override
            public void failure(RetrofitError error) {
                listerner.onFailure(error.getMessage());
            }
        });
    }

    @Override
    public void getMixedDoubleRankings(final OnListerner listerner) {
        service.getMixedDoubleRanking(new Callback<List<PlayerDoubleInfo>>() {
            @Override
            public void success(List<PlayerDoubleInfo> playerDoubleInfos, Response response) {
                listerner.onGetDoubleRankingSuccess(playerDoubleInfos);
            }

            @Override
            public void failure(RetrofitError error) {
                listerner.onFailure(error.getMessage());
            }
        });
    }
}
