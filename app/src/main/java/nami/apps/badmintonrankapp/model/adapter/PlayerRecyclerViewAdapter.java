package nami.apps.badmintonrankapp.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nami.apps.badmintonrankapp.R;
import nami.apps.badmintonrankapp.model.json.PlayerDoubleInfo;
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;

public class PlayerRecyclerViewAdapter extends RecyclerView.Adapter<PlayerRecyclerViewAdapter.ViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    List<PlayerSingleInfo> playerSingleInfos;
    List<PlayerDoubleInfo> playerDoubleInfos;
    List<Integer> imageRes;
    boolean isASinglePlayer = false;

    public PlayerRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.player_info_recycler_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(isASinglePlayer)
        {
            holder.name.setText(playerSingleInfos.get(position+3).getPlayerName());
            holder.rank.setText(playerSingleInfos.get(position+3).getRank());
            holder.info.setText("Points: " + playerSingleInfos.get(position+3).getPoints() +
                    "\nTournaments: " +playerSingleInfos.get(position+3).getTournaments());
            holder.player1.setImageResource(imageRes.get(position+3));
        }
        else {
            holder.name.setText(playerDoubleInfos.get(position+3).getPlayerName1()+"/\n"
                    + playerDoubleInfos.get(position+3).getPlayerName2());
            holder.rank.setText(playerDoubleInfos.get(position+3).getRank());
            holder.info.setText("Points: " + playerDoubleInfos.get(position+3).getPoints() +
                    "\nTournaments: " +playerDoubleInfos.get(position+3).getTournaments());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,rank,info;
        ImageView player1,player2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_rank);
            rank = itemView.findViewById(R.id.rank_number);
            info = itemView.findViewById(R.id.info_rank);

            player1 = itemView.findViewById(R.id.image_rank);
        }
    }

    @Override
    public int getItemCount() {
        if(isASinglePlayer) {
            if (this.playerSingleInfos == null)
                return 0;
            else
                return this.playerSingleInfos.size()-3;
        }
        else {
            if (this.playerDoubleInfos == null)
                return 0;
            else
                return this.playerDoubleInfos.size()-3;
        }
    }

    public void setPlayerSingleInfos(List<PlayerSingleInfo> playerSingleInfos)
    {
        if(this.playerSingleInfos!=null)
             this.playerSingleInfos.clear();

        this.playerSingleInfos = playerSingleInfos;
        isASinglePlayer = true;
        notifyDataSetChanged();
    }
    public void setPlayerDoubleInfos(List<PlayerDoubleInfo> playerDoubleInfos)
    {
        if(this.playerDoubleInfos!=null)
            this.playerDoubleInfos.clear();

        this.playerDoubleInfos = playerDoubleInfos;
        isASinglePlayer = false;
        notifyDataSetChanged();
    }

    public void setImagePlayer(List<Integer> imageRes)
    {
        if(this.imageRes!=null)
            this.imageRes.clear();

        this.imageRes = imageRes;
        notifyDataSetChanged();
    }


}
