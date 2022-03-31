package com.ita.mybestyoutube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YoutubeVideoViewHolder>{

    private List<YoutubeVideo> youtubeVideos;
    private OnItemClickListener onItemClickListener;

    public class YoutubeVideoViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvDescription;

        public YoutubeVideoViewHolder(View itemView){
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleDisplay);
            tvDescription = itemView.findViewById(R.id.tvDescriptionDisplay);

        }
    }

    public YoutubeVideoAdapter(List<YoutubeVideo> youtubeVideos, OnItemClickListener onItemClickListener) {
        this.youtubeVideos = youtubeVideos;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.youtubevideo_item, parent, false);
        return new YoutubeVideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeVideoViewHolder holder, int position) {
        YoutubeVideo youtubeVideo = youtubeVideos.get(position);
        holder.tvTitle.setText(youtubeVideo.getTitle());
        holder.tvDescription.setText(youtubeVideo.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (onItemClickListener != null){
            onItemClickListener.onItemClick(youtubeVideo);
            }
        }
        });

    }

    @Override
    public int getItemCount() { return youtubeVideos.size();}

    public interface OnItemClickListener {
        void onItemClick(YoutubeVideo item);
    }
}
