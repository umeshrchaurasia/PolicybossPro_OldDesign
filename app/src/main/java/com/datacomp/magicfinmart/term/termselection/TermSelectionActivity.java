package com.datacomp.magicfinmart.term.termselection;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

public class TermSelectionActivity extends BaseActivity {
    RecyclerView rvTermSelection;
    TermSelectionItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init() {
        rvTermSelection = (RecyclerView) findViewById(R.id.rvTermSelection);
        rvTermSelection.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvTermSelection.setLayoutManager(layoutManager);
        mAdapter = new TermSelectionItemAdapter(this);
        rvTermSelection.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_home:
                onBackPressed();
//                Intent intent = new Intent(this, HomeActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                intent.putExtra("MarkTYPE", "FROM_HOME");
//                startActivity(intent);
//
//                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//    @Override
//    public void onBackPressed() {
//
//        supportFinishAfterTransition();
//        super.onBackPressed();
//    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
        // return super.onSupportNavigateUp();
    }
}
