package com.example.restaurantmenu;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<MenuItem> {

	private final Context context;
	private final List<MenuItem> items;

	public MyListAdapter(Context context, List<MenuItem> items) {
		super(context, R.layout.listrow, items);
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listrow, null);
			holder = new ViewHolder();
			initRowView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		setRowView(position, holder);
		return convertView;
	}

	private void setRowView(int position, ViewHolder holder) {
		holder.nameView.setText(items.get(position).getMenuItemName());
		holder.priceView.setText("$"+items.get(position).getMenuItemPrice());;
	}

	private void initRowView(View convertView, ViewHolder holder) {
		holder.nameView = (TextView) convertView.findViewById(R.id.name);
		holder.priceView = (TextView) convertView.findViewById(R.id.price);
	}
	
	@Override
	public void notifyDataSetChanged()
	{
	    super.notifyDataSetChanged();
	}

	private static class ViewHolder {
		public TextView nameView;
		public TextView priceView;
	}

}
