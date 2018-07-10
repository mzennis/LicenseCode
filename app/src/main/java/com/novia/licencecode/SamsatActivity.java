package com.novia.licencecode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by meta on 10/07/18.
 */
public class SamsatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, SamsatActivity.class);
        context.startActivity(intent);
    }

    // ini function yg di run pertama
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsat);

        // ini untuk munculin tombol back
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ini untuk title dari halaman
        setTitle("Samsat");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
