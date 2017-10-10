package com.kelvinhado.picme.data.source.remote;

/**
 * Created by kelvin on 10/10/2017.
 */

import com.kelvinhado.picme.data.source.Picture;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Retrofit service used to fetch data from the remote server
 */
public interface SamplePlaceHolderService {

    @GET("photos")
    Observable<List<Picture>> getPhotos();
}
