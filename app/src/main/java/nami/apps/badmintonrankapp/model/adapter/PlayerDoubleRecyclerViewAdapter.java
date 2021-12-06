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

public class PlayerDoubleRecyclerViewAdapter extends RecyclerView.Adapter<PlayerDoubleRecyclerViewAdapter.ViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    List<PlayerDoubleInfo> playerDoubleInfos;
    List<Integer> imageResPlayer1;
    List<Integer> imageResPlayer2;

    public PlayerDoubleRecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.player_double_info_recycler_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ranking.setText(playerDoubleInfos.get(position).getRank());
        holder.player1_name.setText(playerDoubleInfos.get(position).getPlayerName1());
        holder.player2_name.setText(playerDoubleInfos.get(position).getPlayerName2());
        holder.info.setText("Points: " + playerDoubleInfos.get(position).getPoints() +
                "\nTournaments: " +playerDoubleInfos.get(position).getTournaments());
        holder.player1_image.setImageResource(imageResPlayer1.get(position));
        holder.player2_image.setImageResource(imageResPlayer2.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView player1_image,player2_image;
        TextView player1_name,player2_name,ranking,info;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            player1_image = itemView.findViewById(R.id.image_player1_rank);
            player2_image = itemView.findViewById(R.id.image_player2_rank);
            player1_name = itemView.findViewById(R.id.player1_name_rank);
            player2_name = itemView.findViewById(R.id.player2_name_rank);
            ranking = itemView.findViewById(R.id.rank_number);
            info = itemView.findViewById(R.id.info_rank);

        }
    }

    @Override
    public int getItemCount() {
            if (this.playerDoubleInfos == null)
                return 0;
            else
                return this.playerDoubleInfos.size();
    }

    public void setPlayerDoubleInfos(List<PlayerDoubleInfo> playerDoubleInfos)
    {
        if(this.playerDoubleInfos!=null)
             this.playerDoubleInfos.clear();

        this.playerDoubleInfos = playerDoubleInfos;
        notifyDataSetChanged();
    }

    public void setImagePlayer1(List<Integer> imageResPlayer1)
    {
        if(this.imageResPlayer1!=null)
            this.imageResPlayer1.clear();

        this.imageResPlayer1 = imageResPlayer1;
        notifyDataSetChanged();
    }

    public void setImagePlayer2(List<Integer> imageResPlayer2)
    {
        if(this.imageResPlayer2!=null)
            this.imageResPlayer2.clear();

        this.imageResPlayer2 = imageResPlayer2;
        notifyDataSetChanged();
    }



}
