package com.example.growgh.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Adapter  extends FragmentStateAdapter {
    ArrayList<Fragment> arrFrag;
    public Adapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> arr) {
        super(fragmentActivity);
        this.arrFrag=arr;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrFrag.get(position);
    }

    @Override
    public int getItemCount() {
        return arrFrag.size();
    }
}
