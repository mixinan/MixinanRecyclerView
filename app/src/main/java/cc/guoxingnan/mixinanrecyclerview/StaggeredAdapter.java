package cc.guoxingnan.mixinanrecyclerview;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StaggeredAdapter extends MyAdapter {
    private List<Integer> mHeights;

    public StaggeredAdapter(List<String> data, Context context) {
        super(data,context);
        mHeights = new ArrayList<Integer>();
        for(int i=0;i<data.size();i++){
            mHeights.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(data.get(position));

        setUpItemEvent(holder);
    }
}