package com.example.recyclerview_with_indicator;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.recyclerview_with_indicator.IconAdapter;
import com.example.recyclerview_with_indicator.LinePagerIndicatorDecoration;
import com.example.recyclerview_with_indicator.IconModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcIcon;
    private List<IconModel> arrayList1;
    private IconAdapter iconAdapter;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ RecyclerView
        rcIcon = findViewById(R.id.rcIcon);

        // Khởi tạo danh sách icon
        arrayList1 = new ArrayList<>();
        loadIconData();

        // Cấu hình RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));

        // Thiết lập Adapter
        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterListener(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });

    }

    private void loadIconData() {
        arrayList1.add(new IconModel(R.drawable.icon1, "Number 1"));
        arrayList1.add(new IconModel(R.drawable.icon2, "Number 2"));
        arrayList1.add(new IconModel(R.drawable.icon3, "Number 3"));
        arrayList1.add(new IconModel(R.drawable.icon4, "Number 4"));
        arrayList1.add(new IconModel(R.drawable.icon5, "Number 5"));
        arrayList1.add(new IconModel(R.drawable.icon6, "Number 6"));
        arrayList1.add(new IconModel(R.drawable.icon7, "Number 7:"));
        arrayList1.add(new IconModel(R.drawable.icon8, "Number 8"));
        arrayList1.add(new IconModel(R.drawable.icon9, "Number 9"));
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();

        if (text == null || text.trim().isEmpty()) {
            iconAdapter.setListenerList(arrayList1); // Hiển thị toàn bộ danh sách nếu ô tìm kiếm trống
            return;
        }

        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) { // Sửa getDecs() thành getDesc()
                list.add(iconModel);
            }
        }

        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(list);
        }
    }
}