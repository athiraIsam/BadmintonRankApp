package nami.apps.badmintonrankapp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nami.apps.badmintonrankapp.R;
import nami.apps.badmintonrankapp.contract.RankingContract;
import nami.apps.badmintonrankapp.model.PlayerMemberID;
import nami.apps.badmintonrankapp.model.RankingModel;
import nami.apps.badmintonrankapp.model.adapter.PlayerDoubleRecyclerViewAdapter;
import nami.apps.badmintonrankapp.model.adapter.PlayerSingleRecyclerViewAdapter;
import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;
import nami.apps.badmintonrankapp.presenter.RankingPresenter;


public class RankingActivity extends AppCompatActivity implements RankingContract.View {

    RankingPresenter presenter;
    ImageButton ms,ws,md,wd,xd;
    PlayerSingleRecyclerViewAdapter singlePlayerAdapter;
    PlayerDoubleRecyclerViewAdapter doublePlayerAdapter;
    RecyclerView playerRecyclerView;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        InitComponent();
        this.presenter = new RankingPresenter(this, new RankingModel());
        this.presenter.getMenSingleRankings();

        ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                presenter.getMenSingleRankings();
                ms.setAlpha(1f);
                ws.setAlpha(0.5f);
                md.setAlpha(0.5f);
                wd.setAlpha(0.5f);
                xd.setAlpha(0.5f);
            }
        });

        ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                presenter.getWomenSingleRankings();
                ms.setAlpha(0.5f);
                ws.setAlpha(1f);
                md.setAlpha(0.5f);
                wd.setAlpha(0.5f);
                xd.setAlpha(0.5f);
            }
        });

        md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                presenter.getMenDoubleRankings();
                ms.setAlpha(0.5f);
                ws.setAlpha(0.5f);
                md.setAlpha(1f);
                wd.setAlpha(0.5f);
                xd.setAlpha(0.5f);
            }
        });
        wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                presenter.getWomenDoubleRankings();
                ms.setAlpha(0.5f);
                ws.setAlpha(0.5f);
                md.setAlpha(0.5f);
                wd.setAlpha(1f);
                xd.setAlpha(0.5f);
            }
        });
        xd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                presenter.getMixedDoubleRankings();
                ms.setAlpha(0.5f);
                ws.setAlpha(0.5f);
                md.setAlpha(0.5f);
                wd.setAlpha(0.5f);
                xd.setAlpha(1f);
            }
        });
    }

    private void InitComponent()
    {
        ms = findViewById(R.id.men_single);
        ws = findViewById(R.id.women_single);
        md = findViewById(R.id.men_double);
        wd = findViewById(R.id.women_double);
        xd = findViewById(R.id.mix_double);

        playerRecyclerView = findViewById(R.id.player_rank_rv);

        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setTitle("Please Wait");
        this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();

        ms.setAlpha(1f);
        ws.setAlpha(0.5f);
        md.setAlpha(0.5f);
        wd.setAlpha(0.5f);
        xd.setAlpha(0.5f);

    }
    @Override
    public void onGetSingleRankingSuccess(List<PlayerSingleInfo> playerSingleInfos) {

        List<Integer> imageRes = new ArrayList<>();
        for(PlayerSingleInfo playerSingleInfo: playerSingleInfos)
            imageRes.add(PlayerMemberID.getSinglePlayerImageID(playerSingleInfo.getMember_id()));

        singlePlayerAdapter = new PlayerSingleRecyclerViewAdapter(this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        playerRecyclerView.setAdapter(singlePlayerAdapter);
        playerRecyclerView.setLayoutManager(layoutManager);

        singlePlayerAdapter.setPlayerSingleInfos(playerSingleInfos);
        singlePlayerAdapter.setImagePlayer(imageRes);

        this.progressDialog.dismiss();
    }

    @Override
    public void onGetDoubleRankingSuccess(List<PlayerDoubleInfo> playerDoubleInfos) {
        List<Integer> imageResPlayer1 = new ArrayList<>();
        List<Integer> imageResPlayer2 = new ArrayList<>();
        for(PlayerDoubleInfo playerDoubleInfo: playerDoubleInfos) {
            imageResPlayer1.add(PlayerMemberID.getDoubleImageID(playerDoubleInfo.getMember_id1()));
            imageResPlayer2.add(PlayerMemberID.getDoubleImageID(playerDoubleInfo.getMember_id2()));
        }

        doublePlayerAdapter = new PlayerDoubleRecyclerViewAdapter(this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        playerRecyclerView.setAdapter(doublePlayerAdapter);
        playerRecyclerView.setLayoutManager(layoutManager);

        doublePlayerAdapter.setPlayerDoubleInfos(playerDoubleInfos);
        doublePlayerAdapter.setImagePlayer1(imageResPlayer1);
        doublePlayerAdapter.setImagePlayer2(imageResPlayer2);

        this.progressDialog.dismiss();
    }

    @Override
    public void onFailure(String error) {
        progressDialog.dismiss();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error)
                .setCancelable(false)
                .setPositiveButton("OK", null).show();
    }
}
