package example.android.ndsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 2016/02/06.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;

    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private  int mIcons[];

    private String name;
    private int profile;
    private String name2;
    Context context;

    MyAdapter(String Titles[], int Icons[], String Name, String Name2,
              int Profile) {
        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        name2 = Name2;
        profile = Profile;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        int Holderid;

        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        TextView Name2;
        Button button;
        ImageButton Imvbutton;

        public ViewHolder(View itemView,int ViewType) {
            super(itemView);
            if (ViewType == TYPE_ITEM){
                button = (Button) itemView.findViewById(R.id.rowText);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                Holderid = 1;
            }else {
                Name = (TextView) itemView.findViewById(R.id.name);
                Name2 = (TextView) itemView.findViewById(R.id.name2);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                Holderid = 0;
            }
        }

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (viewType == TYPE_ITEM){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
            ViewHolder vhItem = new ViewHolder(v,viewType);

            return vhItem;
        }else if (viewType == TYPE_HEADER){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false);
            ViewHolder vhHeader = new ViewHolder(v,viewType);

            return vhHeader;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position){
        if (holder.Holderid == 1){

            holder.button.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position - 1]);
        }else {

            holder.profile.setImageResource(profile);
            holder.Name.setText(name);
            holder.Name2.setText(name2);
        }
    }

    @Override
    public int getItemCount(){
        return mNavTitles.length+1;
    }

    @Override
    public int getItemViewType(int position){
        if (isPositionHeader(position)){
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}
