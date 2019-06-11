package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/6 10:46 AM
 * @desc :
 */
public class DemoActivity extends AppCompatActivity{

    private List<String> folders = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);



    }




}
