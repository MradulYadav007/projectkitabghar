package com.example.first;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUpload;

    public ImageAdapter (Context context, List<Upload> upload){
        mContext=context;
        mUpload=upload;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        return  new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
      Upload uploadcurrent =mUpload.get(position);
      holder.t1.setText(uploadcurrent.getname());
        Picasso.with(mContext)
                .load(uploadcurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.i1);
    }

    @Override
    public int getItemCount() {
        return mUpload.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView t1;
        public ImageView i1;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.text_view_name);
            i1=itemView.findViewById(R.id.imageview3);
        }
    }
}
