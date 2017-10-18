package com.kelvinhado.stootie.data.source.remote;

/**
 * Created by kelvin on 10/10/2017.
 */

import com.kelvinhado.stootie.data.source.remote.pojo.Collection;
import com.kelvinhado.stootie.data.source.remote.pojo.StootieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Retrofit service used to fetch data from the remote server
 */
public interface StootieService {

    @GET("stoots.json?lat=48.8694023&lng=2.3522692&radius=50&stoot_type[]=miss  ion&page=1&per_page=50")
    Observable<StootieResponse> getStooties();


    @Headers({
            "Accept-Version: 2.0.0",
            "X-Request-Id: 5f3b4f3c-44ca-4447-89e4-759e00d9b2b2"
    })
    @GET("stoot/mission/{id}")
    Observable<Collection> getStootie(@Path("id") String id);
}
