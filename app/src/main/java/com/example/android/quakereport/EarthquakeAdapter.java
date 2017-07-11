package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A custom adapter for the earthquake class.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    static class ViewHolder{
        // Get the earthquake info info text views to set their text to the values from the current
        // earthquake in the list.
        @BindView(R.id.magnitude) TextView magnitudeView;
        @BindView(R.id.location) TextView locationView;
        @BindView(R.id.distance) TextView distanceView;
        @BindView(R.id.date) TextView dateView;
        @BindView(R.id.time) TextView timeView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    /**
     * Instantiates a new {@link EarthquakeAdapter}.
     *
     * @param context           the context
     * @param earthquakeList    the earthquake list
     */
    EarthquakeAdapter(Context context, List<Earthquake> earthquakeList) {
        super(context, 0, earthquakeList);

    }

    private int getMagnitudeColor(double magnitude){
        switch((int)magnitude){
            case 0:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        View listItemView = convertView;

        // Choose alternative layouts for list item to position the image to the left or right in
        // the list item.
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
            holder = new ViewHolder(listItemView);
            listItemView.setTag(holder);
        }
        else{
            holder = (ViewHolder) listItemView.getTag();
        }

        final Earthquake currentEarthquake = getItem(position);

        String location = currentEarthquake.getLocation();
        String distance = "";
        if(location.contains(LOCATION_SEPARATOR)){
            int index = location.indexOf(LOCATION_SEPARATOR) + LOCATION_SEPARATOR.length();
            distance = location.substring(0, index);
            location = location.substring(index);
        }

        DecimalFormat df = new DecimalFormat("0.0");
        holder.magnitudeView.setText(df.format(currentEarthquake.getMagnitude()));
        holder.locationView.setText(location);
        holder.distanceView.setText(distance);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM, dd, yyyy", Locale.ENGLISH);
        SimpleDateFormat stf = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        Date date = new Date(currentEarthquake.getDateTime());
        holder.dateView.setText(sdf.format(date));
        holder.timeView.setText(stf.format(date));


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) holder.magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentEarthquake.getDetailsURL()));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}
