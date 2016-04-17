package cc.guoxingnan.mixinanrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaggeredViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StaggeredAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        setData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new StaggeredAdapter(data,this);

        mLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new StaggeredAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(StaggeredViewActivity.this, "click:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(StaggeredViewActivity.this,"delete:"+position,Toast.LENGTH_SHORT).show();
                mAdapter.removeData(position);
            }
        });

    }

    public void setData() {
        data = new ArrayList<String>();
        for(int i = 'A';i<='z'; i++){
            data.add(""+(char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.action_linearlayout:
                startActivity(new Intent(this,MainActivity.class));
                break;

            case R.id.action_add:
                mAdapter.addData(0);
                break;

            case R.id.action_delete:
               mAdapter.removeData(0);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
