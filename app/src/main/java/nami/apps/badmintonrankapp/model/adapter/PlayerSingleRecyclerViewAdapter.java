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
import nami.apps.badmintonrankapp.model.json.PlayerSingleInfo;

public class PlayerSingleRecyclerViewAdapter extends RecyclerView.Adapter<PlayerSingleRecyclerViewAdapter.ViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    List<PlayerSingleInfo> playerSingleInfos;
    List<Integer> imageRes;

    public PlayerSingleRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.player_single_info_recycler_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.name.setText(playerSingleInfos.get(position).getPlayerName());
            holder.rank.setText(playerSingleInfos.get(position).getRank());
            holder.info.setText("Points: " + playerSingleInfos.get(position).getPoints() +
                    "\nTournaments: " +playerSingleInfos.get(position).getTournaments());
            holder.player1.setImageResource(imageRes.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,rank,info;
        ImageView player1;
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
            if (this.playerSingleInfos == null)
                return 0;
            else
                return this.playerSingleInfos.size();
    }

    public void setPlayerSingleInfos(List<PlayerSingleInfo> playerSingleInfos)
    {
        if(this.playerSingleInfos!=null)
             this.playerSingleInfos.clear();

        this.playerSingleInfos = playerSingleInfos;
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
