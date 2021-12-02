package nami.apps.badmintonrankapp.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nami.apps.badmintonrankapp.R;
import nami.apps.badmintonrankapp.contract.RankingContract;
import nami.apps.badmintonrankapp.model.PlayerMemberID;
import nami.apps.badmintonrankapp.model.RankingModel;
import nami.apps.badmintonrankapp.model.adapter.PlayerRecyclerViewAdapter;
import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;
import nami.apps.badmintonrankapp.presenter.RankingPresenter;


public class RankingActivity extends AppCompatActivity implements RankingContract.View {

    RankingPresenter presenter;
    ImageButton ms,ws,md,wd,xd;
    ImageView imRank1,imRank2,imRank3;
    PlayerRecyclerViewAdapter adapter;
    RecyclerView playerRecyclerView;
    TextView name_rank1,name_rank2,name_rank3,
    points_rank1,points_rank2,points_rank3,rank1,rank2,rank3,
    tournaments_rank1,tournaments_rank2,tournaments_rank3;
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

        name_rank1 = findViewById(R.id.name_rank_1);
        name_rank2 = findViewById(R.id.name_rank_2);
        name_rank3 = findViewById(R.id.name_rank_3);

        points_rank1 = findViewById(R.id.points_1);
        points_rank2 = findViewById(R.id.points_2);
        points_rank3 = findViewById(R.id.points_3);

        tournaments_rank1 = findViewById(R.id.tournaments_1);
        tournaments_rank2 = findViewById(R.id.tournaments_2);
        tournaments_rank3 = findViewById(R.id.tournaments_3);

        rank1 = findViewById(R.id.rank_number_1);
        rank2 = findViewById(R.id.rank_number_2);
        rank3 = findViewById(R.id.rank_number_3);

        imRank1 = findViewById(R.id.image_rank_1);
        imRank2 = findViewById(R.id.image_rank_2);
        imRank3 = findViewById(R.id.image_rank_3);

        adapter = new PlayerRecyclerViewAdapter(this);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        playerRecyclerView.setAdapter(adapter);
        playerRecyclerView.setLayoutManager(layoutManager);

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
    public void onGetRankingSuccess(List<PlayerSingleInfo> playerSingleInfos) {

        name_rank1.setText(playerSingleInfos.get(0).getPlayerName());
        name_rank2.setText(playerSingleInfos.get(1).getPlayerName());
        name_rank3.setText(playerSingleInfos.get(2).getPlayerName());

        points_rank1.setText("Points: " + playerSingleInfos.get(0).getPoints());
        points_rank2.setText("Points: " + playerSingleInfos.get(1).getPoints());
        points_rank3.setText("Points: " + playerSingleInfos.get(2).getPoints());

        tournaments_rank1.setText("Tournaments: " + playerSingleInfos.get(0).getTournaments());
        tournaments_rank2.setText("Tournaments: " + playerSingleInfos.get(1).getTournaments());
        tournaments_rank3.setText("Tournaments: " + playerSingleInfos.get(2).getTournaments());

        List<Integer> imageRes = new ArrayList<>();
        for(PlayerSingleInfo playerSingleInfo: playerSingleInfos)
            imageRes.add(PlayerMemberID.getMenSingleImageID(playerSingleInfo.getMember_id()));

        adapter.setPlayerSingleInfos(playerSingleInfos);
        adapter.setImagePlayer(imageRes);

        rank1.setText("Rank 1");
        rank2.setText("Rank 2");
        rank3.setText("Rank 3");

        imRank1.setVisibility(View.VISIBLE);
        imRank2.setVisibility(View.VISIBLE);
        imRank3.setVisibility(View.VISIBLE);

        imRank1.setImageResource(PlayerMemberID.getMenSingleImageID(playerSingleInfos.get(0).getMember_id()));
        imRank2.setImageResource(PlayerMemberID.getMenSingleImageID(playerSingleInfos.get(1).getMember_id()));
        imRank3.setImageResource(PlayerMemberID.getMenSingleImageID(playerSingleInfos.get(2).getMember_id()));

        this.progressDialog.dismiss();
    }

    @Override
    public void onGetDoubleRankingSuccess(List<PlayerDoubleInfo> playerDoubleInfos) {
        name_rank1.setText(playerDoubleInfos.get(0).getPlayerName1()
                + "/\n" + playerDoubleInfos.get(0).getPlayerName2());
        name_rank2.setText(playerDoubleInfos.get(1).getPlayerName1()
                + "/\n" + playerDoubleInfos.get(1).getPlayerName2());
        name_rank3.setText(playerDoubleInfos.get(2).getPlayerName1()
                + "/\n" + playerDoubleInfos.get(2).getPlayerName2());

        points_rank1.setText("Points: " + playerDoubleInfos.get(0).getPoints());
        points_rank2.setText("Points: " + playerDoubleInfos.get(1).getPoints());
        points_rank3.setText("Points: " + playerDoubleInfos.get(2).getPoints());

        tournaments_rank1.setText("Tournaments: " + playerDoubleInfos.get(0).getTournaments());
        tournaments_rank2.setText("Tournaments: " + playerDoubleInfos.get(1).getTournaments());
        tournaments_rank3.setText("Tournaments: " + playerDoubleInfos.get(2).getTournaments());

        adapter.setPlayerDoubleInfos(playerDoubleInfos);

        rank1.setText("Rank 1");
        rank2.setText("Rank 2");
        rank3.setText("Rank 3");

        imRank1.setVisibility(View.VISIBLE);
        imRank2.setVisibility(View.VISIBLE);
        imRank3.setVisibility(View.VISIBLE);

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
