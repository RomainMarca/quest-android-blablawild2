package fr.wildcodeschool.blablawild2;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

       // TripModel tripModel = getIntent().getParcelableExtra(ItinerarySearchActivity.EXTRA_TRIP);
       // this.setTitle(String.format(getString(R.string.departure_to_destination), tripModel.getDeparture(), tripModel.getDestination()));

        RecyclerView listItineraries = findViewById(R.id.list_itineraries);
        // TODO : préciser le type de layout de la liste

        final ArrayList<ItineraryModel> itineraryModels = new ArrayList<>();
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Eric Cartman", new Date(), 15));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Stan Marsh", new Date(), 20));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kenny Broflovski", new Date(), 12));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Kyle McCormick", new Date(), 18));
        itineraryModels.add(new ItineraryModel("Paris", "Tokyo", "Wendy Testaburger", new Date(), 16));

        // TODO : afficher la liste d'itinéraires avec un adapter

        // TODO : préciser le type de layout de la liste
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listItineraries.setLayoutManager(layoutManager);

        listItineraries.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), listItineraries, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ItineraryModel itinerary = itineraryModels.get(position);
                Toast.makeText(getApplicationContext(), itinerary.getDriver(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        final ItineraryRecyclerAdapter adapter = new ItineraryRecyclerAdapter(itineraryModels);
        listItineraries.setAdapter(adapter);
    }
}
