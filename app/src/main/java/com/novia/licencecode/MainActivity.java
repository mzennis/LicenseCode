package com.novia.licencecode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlatNomor = findViewById(R.id.btn_platnomor);
        Button btnSamsat = findViewById(R.id.btn_samsat);

        btnPlatNomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlatNomorActivity.start(MainActivity.this);
            }
        });

        btnSamsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SamsatActivity.start(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            HelpActivity.start(MainActivity.this);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
