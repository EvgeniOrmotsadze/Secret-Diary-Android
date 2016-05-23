package com.example.evgo.secretdiary.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.evgo.secretdiary.App;
import com.example.evgo.secretdiary.R;
import com.example.evgo.secretdiary.model.Setting;

import java.util.List;
import java.util.Set;

/**
 * Created by evgo on 6/11/2015.
 * this is adapter for setting drawable menu
 * simple show display of settings
 */
public class SettingAdapter extends BaseAdapter {

    private List<Setting> settings;
    private Context context;

    public SettingAdapter(Context context,List<Setting> settings){
        this.context = context;
        this.settings = settings;
    }

    @Override
    public int getCount() {
        return settings.size();
    }

    @Override
    public Object getItem(int position) {
        return settings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.setting_list_items,null);
        TextView title = (TextView) convertView.findViewById(R.id.setting_title);
        TextView desc = ( TextView) convertView.findViewById(R.id.setting_description);

        title.setText(settings.get(position).getTitle());
        desc.setText(settings.get(position).getDescription());
       /* switch (settings.get(position).getAction()){
            case App.get
        }*/
        return convertView;
    }
}
