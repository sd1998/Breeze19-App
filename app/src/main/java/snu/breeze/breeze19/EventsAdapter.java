package snu.breeze.breeze19;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import java.util.ArrayList;



public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    private final String TAG = EventsAdapter.class.getSimpleName();

    private ArrayList<Object> eventsData;
    private Context Context;

    private ExpansionLayoutCollection expansionLayoutCollection = new ExpansionLayoutCollection();

    public EventsAdapter(ArrayList<Object> EventsData, Context context){
        this.eventsData = EventsData;
        this.Context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.expansion_layout_component,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(eventsData.get(position));
        Log.d(TAG,"Component inflated");
        expansionLayoutCollection.add(holder.getExpansionLayout());
    }

    @Override
    public int getItemCount() {
        return eventsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final String TAG = ViewHolder.class.getSimpleName();

        private ExpansionLayout expansionLayout;
        private TextView eventName;
        private TextView eventDetails;
        private TextView eventContact;
        private TextView eventDate;
        private TextView eventVenue;


        public ViewHolder(View view){
            super(view);
            expansionLayout = (ExpansionLayout) view.findViewById(R.id.expansion_layout);
            expansionLayoutCollection.openOnlyOne(false);
            // expansionLayout.setEnable(false);
            eventName = view.findViewById(R.id.event_name);
            eventDetails = (TextView) view.findViewById(R.id.event_details);
            eventVenue = (TextView) view.findViewById(R.id.event_venue);
            eventContact = view.findViewById(R.id.event_contact);
            eventDate = view.findViewById(R.id.event_date);

        }

        public void bind(Object data){
            float attendance = 0.0f;
            Log.d(TAG,"happing");
            ArrayList<String> details_here;
            eventName.setText(((EventsData) data).geteventsName());
            DisplayMetrics displayMetrics =Context.getResources().getDisplayMetrics();
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;
            eventName.setTextSize(height/125);
                eventDate.setText(((EventsData) data).geteventDate());
                eventContact.setText(((EventsData) data).getEventContact());
                eventDetails.setText(((EventsData) data).geteventsDetails());
                eventVenue.setText(((EventsData) data).geteventVenue());
            expansionLayout.collapse(true);
        }

        public ExpansionLayout getExpansionLayout(){
            return expansionLayout;
        }
    }

}
