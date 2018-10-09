package fr.wildcodeschool.blablawild2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static final String EXTRA_TRIP = "EXTRA_TRIP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        this.setTitle(R.string.search_an_itinerary);

        Button bSearchItinerary = findViewById(R.id.b_search_itinerary);
        bSearchItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etDeparture = findViewById(R.id.et_departure);
                EditText etDestination = findViewById(R.id.et_destination);
                EditText etDate = findViewById(R.id.et_date);

                String departure = etDeparture.getText().toString();
                String destination = etDestination.getText().toString();
                String date = etDate.getText().toString();

                if (departure.isEmpty() || destination.isEmpty() || date.isEmpty()) {
                    Toast.makeText(ItinerarySearchActivity.this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show();
                } else {
                    TripModel tripModel = new TripModel(departure, destination, date);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference itineraryRef = database.getReference("trips");
                    String key = itineraryRef.push().getKey();
                    itineraryRef.child(key).setValue(tripModel);



                    // sauvegarde la valeur
                    itineraryRef.child(key).setValue(tripModel);

                }
            }
        });
    }
}
