package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import saulmm.coordinatorexamples.rxjava.Course;
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

    private String[] names = {"1","2","3"};

    private List<Student> mStudents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mStudents = new ArrayList<>();
        mStudents.add(getStudent("李一"));
        mStudents.add(getStudent("王二"));
        mStudents.add(getStudent("张三"));

        Observable.from(mStudents)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.couses);
                    }
                })
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        Log.i(TAG,"course: " + course.courseName);
                    }
                });


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

    private Student getStudent(String name) {
        Student student = new Student();
        student.name = name;

        List<Course> courses = new ArrayList<>();
//        courses.add(new Course("英文"));

        student.couses = courses;

        return student;
    }


}
