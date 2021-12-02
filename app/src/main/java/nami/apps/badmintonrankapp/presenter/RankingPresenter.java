package nami.apps.badmintonrankapp.presenter;

import java.util.List;

import nami.apps.badmintonrankapp.contract.RankingContract;
import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;

public class RankingPresenter implements RankingContract.Presenter,RankingContract.Model.OnListerner {

    RankingContract.View mainView;
    RankingContract.Model mainModel;

    public RankingPresenter(RankingContract.View mainView, RankingContract.Model mainModel) {
        this.mainView = mainView;
        this.mainModel = mainModel;
    }

    @Override
    public void onGetSingleRankingSuccess(List<PlayerSingleInfo> playerSingleInfos) {
        this.mainView.onGetRankingSuccess(playerSingleInfos);
    }

    @Override
    public void onGetDoubleRankingSuccess(List<PlayerDoubleInfo> playerDoubleInfos) {
        this.mainView.onGetDoubleRankingSuccess(playerDoubleInfos);
    }

    @Override
    public void onFailure(String error) {
        this.mainView.onFailure(error);
    }

    @Override
    public void getMenSingleRankings() {
        this.mainModel.getMenSingleRankings(this);
    }

    @Override
    public void getWomenSingleRankings() {
        this.mainModel.getWomenSingleRankings(this);
    }

    @Override
    public void getMenDoubleRankings() {
        this.mainModel.getMenDoubleRankings(this);
    }

    @Override
    public void getWomenDoubleRankings() {
        this.mainModel.getWomenDoubleRankings(this);
    }

    @Override
    public void getMixedDoubleRankings() {
        this.mainModel.getMixedDoubleRankings(this);
    }
}
