package example.com.essitrack_clone_nd.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.bean.Recyclerview;

/**
 * Created by Appy-Sales on 06-12-2017.
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>  implements Filterable {
    public Typeface gotham_book, gotham_medium, gotham_bold;

    private List<Recyclerview> tracklist;
    private List<Recyclerview> tracklistFiltered;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView status, referenceno, reference,trackingno,tracking,deliveryby,ddate,entryon,entrydate;
        ImageView ivStar;
        public MyViewHolder(View itemView) {
            super(itemView);
            status= itemView.findViewById(R.id.status);
            reference= itemView.findViewById(R.id.reference);
            referenceno= itemView.findViewById(R.id.referenceno);
            tracking= itemView.findViewById(R.id.tracking);
            trackingno= itemView.findViewById(R.id.trackingno);
            deliveryby= itemView.findViewById(R.id.delivery);
            ddate= itemView.findViewById(R.id.date);
            entryon= itemView.findViewById(R.id.entryOn);
            entrydate= itemView.findViewById(R.id.entryDate);
            ivStar= itemView.findViewById(R.id.ivStar);

        }
    }
    public RecyclerviewAdapter(List<Recyclerview> tracklist) {
        this.tracklist = tracklist;
        this.tracklistFiltered=tracklist;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_orders_list, parent, false);
        RelativeLayout color;
        final ProgressBar progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        color =  itemView.findViewById(R.id.color);
        color.setBackgroundColor(Color.parseColor("#E96250"));
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Recyclerview recyclerview = tracklistFiltered.get(position);
        holder.status.setText(recyclerview.getStatus());
        holder.reference.setText(recyclerview.getReference());
        holder.referenceno.setText(recyclerview.getReferenceno());
        holder.tracking.setText(recyclerview.getTracking());
        holder.trackingno.setText(recyclerview.getTrackingno());
        holder.ddate.setText(recyclerview.getDdate());
        holder.entrydate.setText(recyclerview.getEntrydate());
        if(recyclerview.isBoomarked())
            holder.ivStar.setImageResource(R.drawable.star);
        else
            holder.ivStar.setImageResource(R.drawable.star1);
        holder.ivStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recyclerview.isBoomarked())
                {
                    recyclerview.setBoomarked(false);
                    holder.ivStar.setImageResource(R.drawable.star1);
                }else {
                    recyclerview.setBoomarked(true);
                    holder.ivStar.setImageResource(R.drawable.star);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return tracklistFiltered.size();
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<Recyclerview> filteredList = new ArrayList<>();
                String charString=charSequence.toString();
                if (charString.isEmpty()){
                    filteredList=tracklist;
                }
                else {

                    for (Recyclerview row : tracklist){
                        if (row.getReference().toLowerCase().contains(charString.toLowerCase()) || row.getTracking().contains(charSequence)){
                            filteredList.add(row);
                        }
                    }
                    //tracklistFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values=filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                tracklistFiltered = (ArrayList<Recyclerview>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }



}
