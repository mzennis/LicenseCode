package com.novia.licencecode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.novia.licencecode.adapter.PlatNomorAdapter;
import com.novia.licencecode.db.DataPlatNomor;
import com.novia.licencecode.db.PlatNomor;
import com.novia.licencecode.db.PlatNomorDb;
import com.novia.licencecode.db.SamsatDb;

import java.util.List;

/**
 * Created by meta on 10/07/18.
 */
public class PlatNomorActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, PlatNomorActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView recyclerView;

    private PlatNomorDb database;
    private PlatNomorAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platnomor);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Plat Nomor");

        database = new PlatNomorDb(this);
        adapter = new PlatNomorAdapter(this);

        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        // logic jika data udah ada, langsung ke list. kalau belum ditambah dulu ke db
        List<PlatNomor> data = database.getPlatNomorList();
        if (data != null && !data.isEmpty()) {
            addData(data);
        } else {
            DataPlatNomor.save(this); // untuk nambah data ke db

            // add data ke list pas udh selesai disave
            List<PlatNomor> items = database.getPlatNomorList();
            addData(items);
        }
    }

    private void addData(List<PlatNomor> data) {
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else if (item.getItemId() == R.id.action_search) {
            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
