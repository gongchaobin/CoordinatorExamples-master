package saulmm.coordinatorexamples;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import saulmm.coordinatorexamples.mode2.IMilk;
import saulmm.coordinatorexamples.mode2.RedBeanAddition;
import saulmm.coordinatorexamples.mode2.SoybeanMilk;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/5 11:29 AM
 * @desc :
 */
public class TestActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;

    private static final String TAG = TestActivity.class.getSimpleName();

    private AsyncTask mAsyncTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
        setContentView(R.layout.activity_test3);

        Log.i(TAG,"onCreate");

//        mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        ListTestAdapter adapter = new ListTestAdapter();
//        mRecyclerView.setAdapter(adapter);
//
//
//        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) mRecyclerView.getLayoutParams();
//        lp.setBehavior(new SampleHeaderBehavior());
//
//
//        Uri uri = Uri.parse("content://saulmm.coordinatorexamples.db.myprovider/user");
//
//        ContentResolver resolver = getContentResolver();
//
//        resolver.registerContentObserver(uri, true, new ContentObserver(mHandler) {
//            @Override
//            public void onChange(boolean selfChange) {
//                Log.i(TAG,"onChange");
//                super.onChange(selfChange);
//            }
//
//            @Override
//            public void onChange(boolean selfChange, Uri uri) {
//                Log.i(TAG,"onChange11");
//                super.onChange(selfChange, uri);
//            }
//        });
//
//        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("_id",3);
//        contentValues.put("name","Iverson");
//
//        resolver.insert(uri,contentValues);
//
//        Cursor cursor = resolver.query(uri,new String[]{"_id","name"}, null, null, null);
//        while (cursor.moveToNext()) {
//            Log.i(TAG,"id: " + cursor.getInt(0) + " name: " + cursor.getString(1));
//        }
//
//        cursor.close();


//        IOfficialAccount xdxx = new OfficialAccount("小道消息");
//        IOfficialAccount rmrb = new OfficialAccount("人民日报");
//
//        IWechatUser zs = new WebchatUser("张三", xdxx);
//        IWechatUser ls = new WebchatUser("李四", rmrb);
//
//        xdxx.notifySubscriber("走在前沿，拥抱变化");
//        rmrb.notifySubscriber("热爱祖国，热爱人民");


        IMilk milk = new SoybeanMilk();
        milk = new RedBeanAddition(milk);

        Log.i(TAG,"milk: " + milk.getDescription() + " cost: " + milk.cost());

    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

}
