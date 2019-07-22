package com.example.slide;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.adapter.QuestionAdapter;
import com.example.manhinhchucnang.R;
import com.example.model.Question;

import java.util.ArrayList;

public class ScreenSlideActivity extends FragmentActivity {
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private long timeLeftMillisecond = 4500000;
    private boolean timeRunning;


    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;
    public static ScreenSlidePageFragment sc = ScreenSlidePageFragment.newInstance(NUM_PAGES);
    ;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter pagerAdapter;
    QuestionAdapter getquestion;
    ArrayList<Question> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        countdownText = findViewById(R.id.tvTimer);
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());
        arrayList = new ArrayList<Question>();
        arrayList = getquestion.getQuestion(1, "");

        Counting();
    }

    public void Counting() {
        if (timeRunning)
            stopTimer();
        else
            startTimer();
    }

    public void startTimer() {

        countDownTimer = new CountDownTimer(timeLeftMillisecond, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftMillisecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        timeRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timeRunning = false;
    }

    public void updateTimer() {
        int minutes = (int) timeLeftMillisecond / 60000;
        int seconds = (int) timeLeftMillisecond % 60000 / 1000;
        String timeLeft;
        timeLeft = "" + minutes + ":";
        if (minutes == 0 && seconds == 0) {
            stopTimer();
        } else if (seconds < 10) timeLeft += "0";
        timeLeft += seconds;
        countdownText.setText(timeLeft);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }
}