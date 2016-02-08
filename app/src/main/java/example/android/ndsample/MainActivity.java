package example.android.ndsample;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{

    String TITLES[]={"１ば～ん","２ば～ん","３ば～ん","４ば～ん","閉じる"};
    int ICONS[] = {R.drawable.dummymaru,R.drawable.dummymaru,R.drawable.dummymaru,R.drawable.dummymaru,R.drawable.dummybatu};

    String NAME = "浦島さん";
    String NAME2 = "浦島さ～～ん";

    int PROFILE = R.drawable.dummymaru;

    private Toolbar toolbar;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;
    Button mButton;

    NestedScrollView NSV;

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NSV = (NestedScrollView) findViewById(R.id.Nest);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "浦島さぁぁぁぁぁぁん", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(TITLES,ICONS,NAME,NAME2,PROFILE);

        mRecyclerView.setAdapter(mAdapter);
        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e){
                return true;
            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());

                switch (recyclerView.getChildPosition(child)){
                    case 1:
                        Toast.makeText(MainActivity.this,"(∩´∀｀)∩ﾜｰｲ"+recyclerView.getChildPosition(child)+"ば～ん",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this,"(∩´∀｀)∩ﾜｰｲ"+recyclerView.getChildPosition(child)+"ば～ん",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(MainActivity.this,"(∩´∀｀)∩ﾜｰｲ"+recyclerView.getChildPosition(child)+"ば～ん",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(MainActivity.this,"(∩´∀｀)∩ﾜｰｲ"+recyclerView.getChildPosition(child)+"ば～ん",
                                Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Drawer.closeDrawers();
                        Toast.makeText(MainActivity.this,"閉じた！", Toast.LENGTH_SHORT).show();

                        break;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
//        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,
                R.string.openDrawer,R.string.closeDrawer){

            @Override
        public void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
            }

            @Override
        public void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
            }
        };
        Drawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
