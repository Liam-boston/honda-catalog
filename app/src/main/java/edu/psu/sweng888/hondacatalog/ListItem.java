package edu.psu.sweng888.hondacatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListItem extends AppCompatActivity {
    // TextViews used to display vehicle information
    private TextView title;
    private TextView subtitle;
    // Button used to return to Catalog
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        // initialize class variables
        this.title = findViewById(R.id.title);
        this.subtitle = findViewById(R.id.subtitle);
        this.backButton = findViewById(R.id.backButton);

        // get the selected vehicle from the Intent extras
        Car selected = (Car) getIntent().getSerializableExtra("selected_vehicle");

        // concatenate title values together
        String titleText = selected.getYear() + " " + selected.getMake() + " " + selected.getModel();

        // concatenate subtitle values together
        String subtitleText = "$" + selected.getValuation() + ".00  |  " + selected.getMileage() + " mi  |  " + selected.getNumPrevOwners() + " previous owner(s)";

        // display Car values
        this.title.setText(titleText);
        this.subtitle.setText(subtitleText);

        // when backButton is clicked
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListItem.this, Catalog.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Returned successfully.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
