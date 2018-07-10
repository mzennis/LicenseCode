package com.novia.licencecode;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.novia.licencecode.adapter.OnItemClickListener;
import com.novia.licencecode.adapter.SamsatAdapter;
import com.novia.licencecode.db.DataSamsat;
import com.novia.licencecode.db.Samsat;
import com.novia.licencecode.db.SamsatDb;

import java.util.List;

/**
 * Created by meta on 10/07/18.
 */
public class SamsatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, SamsatActivity.class);
        context.startActivity(intent);
    }

    private SamsatDb database;
    private SamsatAdapter adapter;

    private RecyclerView recyclerView;

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

        database = new SamsatDb(this);
        adapter = new SamsatAdapter(this);

        recyclerView = findViewById(R.id.recyclerview);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Samsat item = adapter.getItem(position);
                Toast.makeText(SamsatActivity.this,
                        item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        // logic jika data udah ada, langsung ke list. kalau belum ditambah dulu ke db
        List<Samsat> data = database.getSamsatList();
        if (data != null && !data.isEmpty()) {
            addData(data);
        } else {
            DataSamsat.save(this); // untuk nambah data ke db

            // add data ke list pas udh selesai disave
            List<Samsat> items = database.getSamsatList();
            addData(items);
        }
    }

    private void addData(List<Samsat> data) {
        adapter.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();
        if (manager != null)
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                List<Samsat> data = database.getSamsatListByKeyword(s);
                if (data != null && !data.isEmpty()){
                    adapter.clear();
                    adapter.addAll(data);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });
        return true;
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
