package edu.psu.sweng888.hondacatalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Catalog extends AppCompatActivity {
    // ListView used to display cars at a dealership
    private ListView vehicleCatalog;
    // Button used to display vehicle information
    private Button showDetails;
    // Array used to store vehicle information
    private Car[] inventory;
    // Variable used to store the selected vehicle
    private Car selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // initialize class variables
        this.vehicleCatalog = findViewById(R.id.vehicle_catalog);
        this.showDetails = findViewById(R.id.show_details);
        this.selected = null;

        // populate vehicle inventory
        populateInventory();

        // item adapter
        ArrayAdapter<Car> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.inventory);

        // display vehicle inventory
        this.vehicleCatalog.setAdapter(adapter);

        // when an item is selected
        this.vehicleCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = inventory[position];
                vehicleCatalog.setSelector(R.color.gray);
            }
        });

        // when showDetails is clicked
        this.showDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selected != null) {
                    Intent intent = new Intent(Catalog.this, ListItem.class);
                    intent.putExtra("selected_vehicle", selected);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a vehicle.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Populates inventory with 12 different cars
     */
    public void populateInventory() {
        // Honda Civic
        Car civicSedan = new Car("Honda", "Civic Sedan", 2018, 44000, 18350, 1);
        Car civicHatch = new Car("Honda", "Civic Hatchback", 2015, 67110, 14299, 2);
        Car civicSi = new Car("Honda", "Civic Si", 2024, 100, 23950, 0);
        Car civicTypeR = new Car("Honda", "Civic Type R", 2021, 31010, 34000, 1);

        // Honda Accord
        Car accord = new Car("Honda", "Accord", 2009, 103670, 9600, 3);
        Car accordHybrid = new Car("Honda", "Accord Hybrid", 2022, 39880, 27900, 0);

        // Honda CRV
        Car crv = new Car("Honda", "CR-V", 2001, 107300, 3500, 3);

        // Honda Pilot
        Car pilot = new Car("Honda", "Pilot", 2011, 171000, 6500, 2);

        // Honda Passport
        Car passport = new Car("Honda", "Passport", 2024, 2100, 41900, 0);

        // Honda Odyssey
        Car odyssey = new Car("Honda", "Odyssey", 2006, 91200, 9250, 2);

        // Honda Ridgeline
        Car ridgeline = new Car("Honda", "Ridgeline", 2024, 8800, 39750, 0);

        // Honda Prelude
        Car prelude = new Car("Honda", "Prelude", 2001, 53000, 4500, 1);

        // Add Car values to the inventory Array
        this.inventory = new Car[]{civicSedan, civicHatch, civicSi, civicTypeR, accord, accordHybrid, crv, pilot, passport, odyssey, ridgeline, prelude};
    }
}
