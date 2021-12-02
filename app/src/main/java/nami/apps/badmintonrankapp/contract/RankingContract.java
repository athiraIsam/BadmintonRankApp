package nami.apps.badmintonrankapp.contract;

import java.util.List;

import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;

public interface RankingContract {

    interface View{
        void onGetRankingSuccess(List<PlayerSingleInfo> playerSingleInfos);
        void onGetDoubleRankingSuccess(List<PlayerDoubleInfo> playerDoubleInfos);
        void onFailure(String error);
    }
    interface Model{
        interface OnListerner
        {
            void onGetSingleRankingSuccess(List<PlayerSingleInfo> playerSingleInfos);
            void onGetDoubleRankingSuccess(List<PlayerDoubleInfo> playerDoubleInfos);
            void onFailure(String error);
        }
        void getMenSingleRankings(OnListerner listerner);
        void getWomenSingleRankings(OnListerner listerner);
        void getMenDoubleRankings(OnListerner listerner);
        void getWomenDoubleRankings(OnListerner listerner);
        void getMixedDoubleRankings(OnListerner listerner);
    }
    interface Presenter{
        void getMenSingleRankings();
        void getWomenSingleRankings();
        void getMenDoubleRankings();
        void getWomenDoubleRankings();
        void getMixedDoubleRankings();
    }
}
