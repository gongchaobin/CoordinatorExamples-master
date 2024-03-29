package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import saulmm.coordinatorexamples.rxjava.Student;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/14 4:31 PM
 * @desc :
 */
public class RxJavaTestActivity extends AppCompatActivity{

    private static final String TAG = RxJavaTestActivity.class.getSimpleName();
    private static final String BASE_URL = "https://api.douban.com/v2/movie/";

    private static final long TIME = 10 * 1000;
    private String[] names = {"1","2","3"};
    private List<Student> mStudents;

    private static final String CACHE_NAME = "111";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);









//        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onNext(4);
//                emitter.onComplete();
//            }
//        });
//
//        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("A");
//                emitter.onNext("B");
//                emitter.onNext("C");
//                emitter.onComplete();
//            }
//        });
//
//        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
//
//            @Override
//            public String apply(Integer integer, String s) throws Exception {
//                return integer + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.i(TAG,"onSubscribe");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i(TAG,"onNext: " + s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new HttpLoggingInterceptor())
//                .build();


        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(TIME, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(TIME,TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(TIME,TimeUnit.SECONDS );
        httpClientBuilder.retryOnConnectionFailure(true);
//
////         添加公共参数
////        BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder()
////                .addHeaderParam("userName","")//添加公共参数
////                .addHeaderParam("device","")
////                .build();


        File cacheFile = new File(this.getExternalCacheDir(),CACHE_NAME);
        Cache cache = new Cache(cacheFile,1024 * 1024 * 50);
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

//                Response response = chain.proceed(request);
//                //网络可用
//                if (NetworkUtils.isAvailable(RetrofitApplication.getContext())) {
//                    int maxAge = 0;
//                    // 有网络时 在响应头中加入：设置缓存超时时间0个小时
//                    response.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + maxAge)
//                            .build();
//                } else {
//                    // 无网络时，在响应头中加入：设置超时为4周
//                    int maxStale = 60 * 60 * 24 * 28;
//                    response.newBuilder()
//                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                            .build();
//                }
                return null;
            }
        };



//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.i(TAG,"message: " + message);
//            }
//        });
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        httpClientBuilder.addInterceptor(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
//
//        MovieService movieService = retrofit.create(MovieService.class);
//
//        movieService.getTop250(0,20)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new DisposableObserver<MovieSubject>() {
//
//                    @Override
//                    public void onNext(MovieSubject movieSubject) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//        Call<MovieSubject> call = movieService.getTop250(0,20);
//
//        // 异步请求
//        call.enqueue(new Callback<MovieSubject>() {
//            @Override
//            public void onResponse(Call<MovieSubject> call, Response<MovieSubject> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<MovieSubject> call, Throwable t) {
//
//            }
//        });



//        Response<MovieSubject> response = call.execute();


    }












    private void testRxJava() {
        mStudents = new ArrayList<>();
//        mStudents.add(getStudent("李一"));
//        mStudents.add(getStudent("王二"));
//        mStudents.add(getStudent("张三"));
//
//        Observable.from(mStudents)
//                .flatMap(new Func1<Student, Observable<Course>>() {
//                    @Override
//                    public Observable<Course> call(Student student) {
//                        return Observable.from(student.couses);
//                    }
//                })
//                .subscribe(new Action1<Course>() {
//                    @Override
//                    public void call(Course course) {
//                        Log.i(TAG,"course: " + course.courseName);
//                    }
//                });

//        Observable.from(mStudents)
//                .map(new Func1<Student, String>() {
//                    @Override
//                    public String call(Student student) {
//                        return student.name;
//                    }
//                }).subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.i(TAG,"studentName: " + s);
//                    }
//                });


//        Observable.just(1,2,3,4)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        Log.i(TAG,"integer: " + integer);
//                    }
//                });
//
//
//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.i(TAG,"s: " + s);
//                    }
//                });
    }

//
//    private Student getStudent(String name) {
//        Student student = new Student();
//        student.name = name;
//
//        List<Course> courses = new ArrayList<>();
////        courses.add(new Course("英文"));
//
//        student.couses = courses;
//
//        return student;
//    }


}
