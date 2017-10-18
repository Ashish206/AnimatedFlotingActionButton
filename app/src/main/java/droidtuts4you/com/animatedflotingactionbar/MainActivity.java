package droidtuts4you.com.animatedflotingactionbar;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mMainFab;
    private FloatingActionButton mFab1;
    private FloatingActionButton mFab2;
    private Animation mFab_Open,mFab_Close,mRotate_Clockwise,mRotate_Anticlockwise;
    private Boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainFab = (FloatingActionButton)findViewById(R.id.main_fab);
        mFab1 = (FloatingActionButton)findViewById(R.id.fab1);
        mFab2 = (FloatingActionButton)findViewById(R.id.fab2);
        mFab_Open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        mFab_Close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        mRotate_Clockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        mRotate_Anticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        mMainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFabOpen)
                {
                    mFab1.startAnimation(mFab_Close);
                    mFab2.startAnimation(mFab_Close);
                    mMainFab.startAnimation(mRotate_Anticlockwise);
                    mFab1.setClickable(false);
                    mFab2.setClickable(false);
                    isFabOpen = false;
                }
                else
                {
                    mFab1.startAnimation(mFab_Open);
                    mFab2.startAnimation(mFab_Open);
                    mMainFab.startAnimation(mRotate_Clockwise);
                    mFab1.setClickable(true);
                    mFab2.setClickable(true);
                    isFabOpen = true;
                }
            }
        });
        
        mFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
            }
        });
        mFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Twitter", Toast.LENGTH_SHORT).show();
            }
        });
    }
}