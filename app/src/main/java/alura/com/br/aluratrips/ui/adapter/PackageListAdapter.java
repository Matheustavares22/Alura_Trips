package alura.com.br.aluratrips.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import alura.com.br.aluratrips.R;
import alura.com.br.aluratrips.model.Package;
import alura.com.br.aluratrips.util.DateUtil;
import alura.com.br.aluratrips.util.MoneyUtil;
import alura.com.br.aluratrips.util.ResourceUtil;

public class PackageListAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

    public PackageListAdapter(List<Package> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Object getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View createdView = LayoutInflater.from(context).inflate(R.layout.item_package, parent, false);

        Package aPackage = packages.get(position);

        loadImageView(createdView, aPackage);
        loadTextView(createdView, R.id.item_package_city_name, aPackage.getCity());
        loadTextView(createdView, R.id.item_package_days, DateUtil.formatToText(aPackage.getDays(), context));
        loadTextView(createdView, R.id.item_package_price, MoneyUtil.formatMoneyBrazil(aPackage.getPrice(), context));

        return createdView;
    }

    private void loadImageView(View view, Package dataOfPackage) {
        ImageView cityImage = view.findViewById(R.id.item_package_city_image);
        cityImage.setImageDrawable(ResourceUtil.giveBackDrawable(dataOfPackage.getImage(), context));
    }

    private void loadTextView(View view, int targetTextView, String city) {
        TextView cityName = view.findViewById(targetTextView);
        cityName.setText(city);
    }


}
