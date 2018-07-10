package com.novia.licencecode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by meta on 10/07/18.
 */
public class HelpActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, HelpActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        // ini untuk munculin tombol back
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ini untuk title dari halaman
        setTitle("Bantuan");

        TextView bantuan = findViewById(R.id.bantuan);
        bantuan.setText(Html.fromHtml("<b>Disini</b> bantuannya taro yak"));
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
