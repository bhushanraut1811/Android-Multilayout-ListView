package com.example.bhushanraut.multilayoutlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bhushanraut.multilayoutlist.R;
import com.example.bhushanraut.multilayoutlist.constants.ViewRowType;
import com.example.bhushanraut.multilayoutlist.modalclass.Player;

import java.util.ArrayList;

/**
 * Created by bhushan.raut on 1/7/2016.
 * <p>CustomListAdapter to populate the ListView</p>
 */
public class CustomListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Player> mPlayerList;

    public CustomListAdapter(Context mContext, ArrayList<Player> mPlayerList) {
        this.mContext = mContext;
        this.mPlayerList = mPlayerList;
    }

    @Override

    public int getCount() {
        return mPlayerList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlayerList.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return mPlayerList.get(position).getmViewRowType();

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int typeOfLayout = getItemViewType(position);
        ViewTypeOneHolder typeOneHolder;
        ViewTypeTwoHolder typeTwoHolder;
        //

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (typeOfLayout == ViewRowType.IMAGE_ROW) {
                convertView = inflater.inflate(R.layout.row_with_image, parent, false);
                typeOneHolder = new ViewTypeOneHolder();
                typeOneHolder.playerPicImageView = (ImageView) convertView.findViewById(R.id.iv_contact_image);
                typeOneHolder.numberTextView = (TextView) convertView.findViewById(R.id.tv_number);
                typeOneHolder.nameTextView = (TextView) convertView.findViewById(R.id.tv_name);
                convertView.setTag(typeOneHolder);


            } else {
                convertView = inflater.inflate(R.layout.row_without_image, parent, false);
                typeTwoHolder = new ViewTypeTwoHolder();
                typeTwoHolder.detailsTextView = (TextView) convertView.findViewById(R.id.tv_details);
                typeTwoHolder.linkTextView = (TextView) convertView.findViewById(R.id.tv_link);

                convertView.setTag(typeTwoHolder);
            }
        }


        if (typeOfLayout == ViewRowType.IMAGE_ROW) {

            typeOneHolder = (ViewTypeOneHolder) convertView.getTag();
            typeOneHolder.playerPicImageView.setImageDrawable(mContext.getResources().getDrawable(mPlayerList.get(position).getmImage()));


            typeOneHolder.nameTextView.setText(mPlayerList.get(position).getmName());
            typeOneHolder.numberTextView.setText(mPlayerList.get(position).getmNoOfMatches());


        } else {

            typeTwoHolder = (ViewTypeTwoHolder) convertView.getTag();
            typeTwoHolder.detailsTextView.setText(mPlayerList.get(position).getmPlayerDetails());
            typeTwoHolder.linkTextView.setText(mPlayerList.get(position).getmLink());

            typeTwoHolder.detailsTextView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }

            });

        }

        return convertView;
    }

    static class ViewTypeOneHolder {
        ImageView playerPicImageView;
        TextView nameTextView;
        TextView numberTextView;

    }

    static class ViewTypeTwoHolder {

        TextView detailsTextView;
        TextView linkTextView;

    }


}
