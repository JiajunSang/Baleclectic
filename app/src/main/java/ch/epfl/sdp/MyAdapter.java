package ch.epfl.sdp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// adapter provides a binding from an app-specific data set to views
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PerformanceViewHolder> {
    public List<Performance> performances;

    // take a view/row as a parameter
    // find all the child views by Id
    // attach child views to each row
    public class PerformanceViewHolder extends RecyclerView.ViewHolder {
        private TextView artist, date, stage;

        public PerformanceViewHolder (View itemView) {
            super(itemView);
            artist = (TextView) itemView.findViewById(R.id.artist);
            date = (TextView) itemView.findViewById(R.id.date);
            stage = (TextView) itemView.findViewById(R.id.stage);
        }
    }

    public MyAdapter(List<Performance> performances) {
        this.performances = performances;
    }

    // create the total numbers of visible ViewHolders
    // attach ViewHolders to each row
    @NonNull
    @Override
    public PerformanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        return new PerformanceViewHolder(itemView);
    }

    // bind data from the ArrayList to all the child views
    @Override
    public void onBindViewHolder(PerformanceViewHolder holder, int position) {
        Performance performance = performances.get(position);
        holder.artist.setText(performance.getArtist());
        holder.date.setText(performance.getDate());
        holder.stage.setText(performance.getStage());
    }

    @Override
    public int getItemCount() {
        return performances.size();
    }


    /*
    String activitiesName[], activitiesDescription[];
    int imageSet[];
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    // initialize the class inside the activity
    public MyAdapter(Context ct, String activities_name[], String activities_description[], int artistImage[]) {
         context = ct;
         activitiesName = activities_name;
         activitiesDescription = activities_description;
         imageSet = artistImage;
    }

    // create ViewHolder object whenever the RecyclerView needs a new one
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate a new view
        View itemView =  LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //using holder to find the elements
        holder.activities_name.setText(activitiesName[position]);
        holder.activities_details.setText(activitiesDescription[position]);
        holder.artist_image.setImageResource(imageSet[position]);
    }

    // return number of items in the data set held by the adapter
    @Override
    public int getItemCount() {
        return imageSet.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //elements ID in Cardview: 2 textview and 1 imageview
        TextView activities_name, activities_details;
        ImageView artist_image;

        //MyViewHolder is communicating with onBindViewHolder
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find the element ID
            activities_name = itemView.findViewById(R.id.activities_name);
            activities_details = itemView.findViewById(R.id.activities_details);
            artist_image = itemView.findViewById(R.id.artist_image);
        }
    }

*/
}