package saulmm.coordinatorexamples.rxjava;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/14 5:42 PM
 * @desc :
 */
public interface MovieService {


    @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);



//    @POST("top250")
//    @FormUrlEncoded
//    Call<MovieSubject> getTop250 (@Field("start") int start , @Field("count") int count);
}
