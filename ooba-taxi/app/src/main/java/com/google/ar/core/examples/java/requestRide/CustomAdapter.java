package com.google.ar.core.examples.java.requestRide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.ar.core.examples.java.helloar.R;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RideViewHolder> {
    private List<Ride> rides;
    public CustomAdapter() {
        rides = new ArrayList<>();
    }
    public void setRides(List<Ride> rides) {
        this.rides = rides;
        notifyDataSetChanged();
    }
    @Override
    public RideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom item view
        View customItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ride, parent, false);

        // Create a RideViewHolder instance with the custom item view
        RideViewHolder rideViewHolder = new RideViewHolder(customItemView);

        return rideViewHolder;
    }

    @Override
    public void onBindViewHolder(RideViewHolder holder, int position) {
        // Get the ride data for the current position
        Ride ride = rides.get(position);

        // Set data to the UI elements in the RideViewHolder
        holder.avatarImageView.setImageResource(ride.getAvatar()); // Set avatar image
        holder.nameTextView.setText(ride.getName()); // Set name
        holder.ratingTextView.setText("Rating: " + ride.getRating()); // Set rating
        holder.priceTextView.setText("$" + ride.getPrice()); // Set price
        holder.timeTextView.setText("Estimated Time (in Mins): " + ride.getTime()); // Set time
    }

    @Override
    public int getItemCount() {
        return rides.size();
    }

    // ViewHolder class for the custom item view
    public class RideViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView nameTextView;
        TextView ratingTextView;
        TextView priceTextView;
        TextView timeTextView;

        public RideViewHolder(View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }
}
