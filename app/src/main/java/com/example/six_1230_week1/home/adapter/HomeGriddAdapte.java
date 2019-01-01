package com.example.six_1230_week1.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.six_1230_week1.R;
import com.example.six_1230_week1.home.bean.HomeBean;
import com.nostra13.universalimageloader.core.ImageLoader;


public class HomeGriddAdapte extends BaseAdapter {
    private Context context;
    private HomeBean beanOne;

    public HomeGriddAdapte(Context context, HomeBean beanOne) {
        this.context = context;
        this.beanOne = beanOne;
    }

    @Override
    public int getCount() {
        return beanOne.getResult().getRxxp().get(0).getCommodityList().size();
    }

    @Override
    public Object getItem(int position) {
        return beanOne.getResult().getRxxp().get(0).getCommodityList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.layout_list, null);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.view_image);
            holder.title = convertView.findViewById(R.id.title);
            holder.price = convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(beanOne.getResult().getRxxp().get(0).getCommodityList().get(position).getMasterPic(), holder.image);
        holder.price.setText("¥" + beanOne.getResult().getRxxp().get(0).getCommodityList().get(position).getPrice() + "");
        holder.title.setText(beanOne.getResult().getRxxp().get(0).getCommodityList().get(position).getCommodityName());
        return convertView;
    }

    class ViewHolder {
        private ImageView image;
        private TextView title, price;
    }
}
