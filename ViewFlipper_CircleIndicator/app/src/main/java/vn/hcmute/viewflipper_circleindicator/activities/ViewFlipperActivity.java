package vn.hcmute.viewflipper_circleindicator.activities;

import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.AnimationUtils;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.viewflipper_circleindicator.R;

public class ViewFlipperActivity extends AppCompatActivity {
    ViewFlipper viewFlipperMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_flipper);
        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        ActionViewFlipperMain();

    }
    //hàm Flipper
    private void ActionViewFlipperMain() {
        List<String> arrayListFlipper = new ArrayList<>();
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/quangcao.png");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/coffee.jpg");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/companypizza.jpeq");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/themoingon.jpeq");
        for (int i = 0; i < arrayListFlipper.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(arrayListFlipper.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imageView);
            viewFlipperMain.setFlipInterval(3000);
            viewFlipperMain.setAutoStart(true);
            //thiết lập animation cho flipper
            Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
            Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
            viewFlipperMain.setInAnimation(slide_in);
            viewFlipperMain.setOutAnimation(slide_out);
        }
    }

}