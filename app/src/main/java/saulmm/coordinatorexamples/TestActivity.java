package saulmm.coordinatorexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import saulmm.coordinatorexamples.behavvior.SampleHeaderBehavior;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/5 11:29 AM
 * @desc :
 */
public class TestActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
        setContentView(R.layout.activity_test2);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListTestAdapter adapter = new ListTestAdapter();
        mRecyclerView.setAdapter(adapter);


        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) mRecyclerView.getLayoutParams();
        lp.setBehavior(new SampleHeaderBehavior());

    }

    public static void start(Context context) {
        Intent i = new Intent(context, TestActivity.class);
        context.startActivity(i);
    }


    private class ListTestAdapter extends RecyclerView.Adapter<ListTestAdapter.Holder> {

        private List<String> mList;

        public ListTestAdapter() {
            mList = new ArrayList<>();

            for(int i = 0;i < 50;i++) {
                mList.add(String.valueOf(i));
            }
        }


        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(TestActivity.this);
            textView.setTextSize(24);
            textView.setTextColor(TestActivity.this.getResources().getColor(android.R.color.black));

            Holder holder = new Holder(textView);
            return holder;
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            public Holder(View itemView) {
                super(itemView);
            }
        }

    }


}
