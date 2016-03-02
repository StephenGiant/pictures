package pictures.example.administrator.multyunits.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import pictures.example.administrator.multyunits.adapter.SimpleAdapter;
import pictures.example.administrator.multyunits.R;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_content)
    RecyclerView rvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("多单位");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setSubtitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setSubtitle("多单位!");
        initView();
    }
private  void initView(){
    LinearLayoutManager manager = new LinearLayoutManager(this);
    manager.setOrientation(LinearLayoutManager.VERTICAL);
    rvContent.setLayoutManager(manager);
    ArrayList<String> data1 = new ArrayList<String>();
    for(int x=0;x<100;x++){
        data1.add("数据"+x);
    }
    SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,data1);
    rvContent.setAdapter(adapter);
}

}
