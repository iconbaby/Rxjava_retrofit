package com.slkk.rxjava_retrofig;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;


import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.slkk.rxjava_retrofig.elementary_1.ElementaryFragment;
import com.slkk.rxjava_retrofig.map_2.MapFragment;
import com.slkk.rxjava_retrofig.module.cache_6.CacheFragment;
import com.slkk.rxjava_retrofig.token_4.TokenFragment;
import com.slkk.rxjava_retrofig.token_advanced_5.TokenAdvancedFragment;
import com.slkk.rxjava_retrofig.zip_3.ZipFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.toobar)
//    Toolbar toobar;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewpager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new ElementaryFragment();
                    case 1:
                        return new MapFragment();
                    case 2:
                        return new ZipFragment();
                    case 3:
                        return new TokenFragment();
                    case 4:
                        return new TokenAdvancedFragment();
                    case 5:
                        return new CacheFragment();
                    default:
                        return null;
                }

            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.str_element);
                    case 1:
                        return getString(R.string.str_map);

                    case 2:
                        return getString(R.string.str_zip);

                    case 3:
                        return getString(R.string.str_token);

                    case 4:
                        return getString(R.string.str_token_super);

                    case 5:
                        return getString(R.string.str_cache);


                }
                return super.getPageTitle(position);
            }
        });

        tablayout.setupWithViewPager(viewpager);

    }
}
