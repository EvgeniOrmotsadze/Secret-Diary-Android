package com.example.evgo.secretdiary.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.evgo.secretdiary.App;
import com.example.evgo.secretdiary.R;
import com.example.evgo.secretdiary.model.Diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by evgo on 6/6/2015.
 * this adapter for users diary
 * there was also filter but don't use any more bacause filter works from diary activity
 * there choose random color for user not
 */
public class DiaryAdapter extends BaseAdapter  {

    private List<Diary> diaryList;
    private Context context;
    public int selectedItem;

    public DiaryAdapter(List<Diary> diaryList,Context context){
        this.diaryList = diaryList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return diaryList.size();
    }

    @Override
    public Object getItem(int position) {
        return diaryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderView holderView;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.list_view_items,null);
            ImageView img = (ImageView) convertView.findViewById(R.id.shelf);
            TextView txt = (TextView) convertView.findViewById(R.id.text_view_list);
            Button bg = (Button) convertView.findViewById(R.id.visual_btn);
            holderView = new HolderView();
            holderView.imageView = img;
            holderView.textViewD = txt;
            holderView.bg = bg;
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }



        Diary diary = diaryList.get(position);
        String setTxt = diary.getMonth().substring(0,3) + " | " + diary.getDay() + " | "  + diary.getYear() + "       " + " \n";
        if(diary.getTitle().length() > App.maxLength){
            setTxt += diary.getTitle().substring(0,App.maxLength) + "..";
        }else{
            setTxt += diary.getTitle();
        }
        holderView.textViewD.setText(setTxt);
        int imageResource = R.drawable.seperator;
        holderView.imageView.setImageResource(imageResource);

        Drawable draw  = convertView.getResources().getDrawable(diary.getColor());
        holderView.bg.setBackgroundDrawable(draw);
        return convertView;
    }



   /* @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                ArrayList<Diary> FilteredArrayNames = new ArrayList<Diary>();
                constraint = constraint.toString().toLowerCase();

                for(Diary filterDiary : diaryList){
                    Log.d("filter",filterDiary.getTitle());
                    if(filterDiary.getTitle().toLowerCase().startsWith(constraint.toString())){
                        FilteredArrayNames.add(filterDiary);
                    }
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                diaryList = (List<Diary>) results.values;
                notifyDataSetChanged();
            }
        };


        return filter;
    }*/

    public static class HolderView{
        ImageView imageView;
        TextView textViewD;
        Button bg;
    }

}
