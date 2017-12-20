package example.com.essitrack_clone_nd.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import example.com.essitrack_clone_nd.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;
    public Typeface gotham_book, gotham_medium, gotham_bold;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        gotham_book = Typeface.createFromAsset(_context.getAssets(), "fonts/Gotham-Book.ttf");

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        txtListChild.setTypeface(gotham_book);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        gotham_book = Typeface.createFromAsset(_context.getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(_context.getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(_context.getAssets(), "fonts/gothambold1.ttf");




        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        final TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(gotham_medium);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        lblListHeader.setTextColor(Color.parseColor("#FFFFFF"));

        final ImageView lblListHolder = (ImageView) convertView
                .findViewById(R.id.groupHolder);
        lblListHolder.setImageResource(R.drawable.right_arrow);
        lblListHolder.setColorFilter(Color.parseColor("#70808B"));

        RelativeLayout bevGroup = (RelativeLayout) convertView.findViewById(R.id.faq_click);

        if(isExpanded)
        {
            bevGroup.setBackgroundColor(Color.parseColor("#FFFFFF"));
            lblListHeader.setTextColor(Color.parseColor("#31363a"));
            lblListHeader.setTypeface(gotham_medium);
            lblListHolder.setImageResource(R.drawable.down_arrow);
            lblListHolder.setColorFilter(Color.parseColor("#70808B"));
        }
        else
        {
            bevGroup.setBackgroundColor(Color.parseColor("#CCE4F5"));
            lblListHeader.setTextColor(Color.parseColor("#000000"));
            lblListHolder.setImageResource(R.drawable.right_arrow);
            lblListHeader.setTypeface(gotham_medium);
            lblListHolder.setColorFilter(Color.parseColor("#70808B"));
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}