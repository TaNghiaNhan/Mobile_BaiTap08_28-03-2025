package com.example.fragment_tablayout_viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragment_tablayout_viewpager2.CompletedOrderFragment;
import com.example.fragment_tablayout_viewpager2.NewOrderFragment;
import com.example.fragment_tablayout_viewpager2.ProcessingOrderFragment;

public class ViewPaper2Adapter extends FragmentStateAdapter {
    public ViewPaper2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPaper2Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPaper2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NewOrderFragment();
            case 1:
                return new ProcessingOrderFragment(); // Đang xử lý
            case 2:
                return new CompletedOrderFragment(); // Hoàn thành
            default:
                return new NewOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
