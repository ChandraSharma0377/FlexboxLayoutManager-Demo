package com.chandra.flexlayout;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        final FlexBoxAdapter adapter = new FlexBoxAdapter(this, getDataList());
        recyclerView.setAdapter(adapter);
        Button btn_select = findViewById(R.id.btn_select);
        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Select List: ",adapter.getSelectedDataList().toString());
            }
        });

    }

    private ArrayList<FlexItemDto> getDataList() {
        ArrayList<FlexItemDto> arrayList = new ArrayList<>();
        arrayList.add(new FlexItemDto("Alpha", false));
        arrayList.add(new FlexItemDto("New Flex Layout", false));
        arrayList.add(new FlexItemDto("Steam Inhalation", false));
        arrayList.add(new FlexItemDto("Plenty of fluids", false));
        arrayList.add(new FlexItemDto("Nebulization", false));
        arrayList.add(new FlexItemDto("Plenty of Green vegetables & fruits", false));
        arrayList.add(new FlexItemDto("To avoid strong smells of perfumes, deodrent, agarbatti dhoop", false));
        arrayList.add(new FlexItemDto("No oil & no spicy food ", false));
        arrayList.add(new FlexItemDto("Drink more water", false));
        arrayList.add(new FlexItemDto("Increase content of salad in your diet", false));
        arrayList.add(new FlexItemDto("Consume less sugar", false));
        arrayList.add(new FlexItemDto("30 min Brisk walking a day", false));
        arrayList.add(new FlexItemDto("Drink milk every day", false));

        Collections.sort(arrayList, new Comparator<FlexItemDto>() {
            @Override
            public int compare(FlexItemDto o1, FlexItemDto o2) {
                return o1.getLabel().compareTo(o2.getLabel());
            }
        });
        return arrayList;
    }
}
