package vn.hcmute.viewflipper_circleindicator.activities;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;
import vn.hcmute.viewflipper_circleindicator.DepthPageTransformer;
import vn.hcmute.viewflipper_circleindicator.R;
import vn.hcmute.viewflipper_circleindicator.adapter.ImagesViewPager2Adapter;
import vn.hcmute.viewflipper_circleindicator.data.Images;

public class MainActivity2 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private List<Images> imagesList1;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(viewPager2.getCurrentItem() == imagesList1.size() - 1){
                viewPager2.setCurrentItem(0);
            }
            else viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        // anh xạ viewpager2
        viewPager2 = findViewById(R.id.viewpager2);
        circleIndicator3 = findViewById(R.id.circle_indicator3);
        imagesList1 = getListImages() ;
        ImagesViewPager2Adapter adapter1 = new ImagesViewPager2Adapter(imagesList1);
        viewPager2.setAdapter(adapter1);
        //liện kết viewpager2 va indicator3
        circleIndicator3.setViewPager(viewPager2);

        //Lang nghe
        // Gọi runnable để auto-slide
        handler.postDelayed(runnable, 3000);

        // Lắng nghe sự kiện chuyển trang
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable); // Dừng auto-slide khi người dùng lướt tay
                handler.postDelayed(runnable, 3000); // Bật lại auto-slide sau 3 giây
            }
        });
        viewPager2.setPageTransformer(new DepthPageTransformer());
    }

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.quangcao));
        list.add(new Images(R.drawable.coffee));
        list.add(new Images(R.drawable.companypizza));
        list.add(new Images(R.drawable.themoingon));
        return list;
    }
}