package com.wanda.advancedlight.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wanda.advancedlight.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/7/30.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<String> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    List<Integer> mHeights = new ArrayList<Integer>();
    public RecyclerViewAdapter(Context context, List<String> list){
        this.mList = list;
        this.mContext = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler,parent,false));
        return holder;
    }



    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        for (int i=0;i<10;i++){
            mHeights.add((int)(100+Math.random()*300));
        }
        ViewGroup.LayoutParams lp = holder.textView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.textView.setLayoutParams(lp);
        holder.textView.setText(mList.get(position));
        if (mOnItemClickListener !=null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.textView,pos);
                }
            });
            holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.textView,pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void removeData(int position){
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_item)
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
