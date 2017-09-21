package com.example.admin.pullrefresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ArrayList<String> monHoc;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        listView  = (ListView) findViewById(R.id.lvSubject);
        monHoc = new ArrayList<>();
        monHoc.add("Toán Học");
        monHoc.add("Vật Lí");
        monHoc.add("Hóa Học");
        monHoc.add("Sinh Học");
        monHoc.add("Tin Học");
        monHoc.add("Giáo Dục Công Dân");
        monHoc.add("Tiếng Anh");
        monHoc.add("Ngữ Văn");
        monHoc.add("Công Nghệ");
        monHoc.add("Giáo Dục Công Dân");
        monHoc.add("Tiếng Anh");
        monHoc.add("Ngữ Văn");
        monHoc.add("Công Nghệ");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, monHoc);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.refresh_1, R.color.refresh_2,R.color.refresh_3);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        Collections.shuffle(monHoc);
                        adapter.notifyDataSetChanged();
                    }
                }, 3000);
            }
        });
    }
}
