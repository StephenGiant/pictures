package pictures.example.administrator.multyunits.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pictures.example.administrator.multyunits.R;
import pictures.example.administrator.multyunits.adapter.SimpleAdapter;
import pictures.example.administrator.multyunits.decorator.MyDivider;
import pictures.example.administrator.multyunits.decorator.MySpaceDecration;

public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.vp_content)
    ViewPager vpContent;
    @Bind(R.id.indicator)
    TabLayout indicator;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_act);
        ButterKnife.bind(this);
        initView();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    List<View> views;
    View view1;
    View view2;
    View view3;
    ArrayList<String> function_list;
    private void initView() {
         view1 = View.inflate(this, R.layout.pager1, null);

        view2 = View.inflate(this, R.layout.pager2, null);
         view3 = View.inflate(this, R.layout.pager3, null);
        views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);

       function_list = new ArrayList<String>();
        function_list.add("复核订单");
        function_list.add("绑定箱号");
        function_list.add("详细复核");
        function_list.add("指令下架");


        final String[] titles = {"邓紫棋", "车模", "杨幂"};
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public CharSequence getPageTitle(int position) {


                return titles[position];
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        vpContent.setAdapter(pagerAdapter);
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                   switch(position){
                       case 0:
                           initView1();
                           break;
                       default:
                           break;
                   }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indicator.setupWithViewPager(vpContent);
        indicator.setTabGravity(TabLayout.GRAVITY_FILL);
        indicator.setTabMode(TabLayout.MODE_FIXED);
//        for(int x=0;x<indicator.getTabCount();x++){
//            TabLayout.Tab tab = indicator.getTabAt(x);
//            tab.setCustomView(getTabView(x));
//        }
vpContent.setCurrentItem(0);
        initView1();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

       builder.setTitle("MD对话框").setMessage("MD风格").setPositiveButton("确定", null).setInverseBackgroundForced(true).setCancelable(false).create().show();

    }

    public View getTabView(int position){
        View view = View.inflate(Main2Activity.this, R.layout.tabview, null);
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText("页签" + (position + 1));
        return view;
    }
    SimpleAdapter adapter;
    private void initView1(){
        RecyclerView functions = (RecyclerView) views.get(0).findViewById(R.id.functions);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

//        LinearLayoutManager manager = new LinearLayoutManager(Main2Activity.this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
        functions.setLayoutManager(manager);
        if(adapter==null) {
            adapter = new SimpleAdapter(Main2Activity.this, function_list);
            MySpaceDecration spaceDecration = new MySpaceDecration(10);
            MyDivider myDivider = new MyDivider(this, MyDivider.VERTICAL_LIST);
            functions.setAdapter(adapter);
//            functions.addItemDecoration(spaceDecration);
//            functions.addItemDecoration(myDivider);
        }else{
            adapter.notifyDataSetChanged();
        }
    }
}
