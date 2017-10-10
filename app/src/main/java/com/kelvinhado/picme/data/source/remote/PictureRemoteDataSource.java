package com.kelvinhado.picme.data.source.remote;

import android.support.annotation.NonNull;

import com.kelvinhado.picme.data.source.Picture;
import com.kelvinhado.picme.data.source.PictureDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by kelvin on 10/10/2017.
 */

public class PictureRemoteDataSource implements PictureDataSource {

    /**
     * Single instance
     */
    private static PictureRemoteDataSource sInstance;

    //prevent direct instantiation
    private PictureRemoteDataSource() {}

    public static PictureRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new PictureRemoteDataSource();
        }
        return sInstance;
    }

    /**
     * Get pictures from the remote source
     * @param callback the results
     */
    @Override
    public void getPictures(@NonNull final LoadPicturesCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("ttp://jsonplaceholder.typicode.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        SamplePlaceHolderService service = retrofit.create(SamplePlaceHolderService.class);
        Observable<List<Picture>> observable = service.getPhotos();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Picture>>() {
                    @Override
                    public void accept(List<Picture> pictureList) throws Exception {
                        callback.onPicturesLoaded(pictureList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onDataNotAvailable();
                    }
                });
    }

    /**
     * Deletes all remotely saved pictures
     * Currently not implemented
     */
    @Override
    public void deleteAllPictures() {

    }

    /**
     * Saves a picture into the remote source
     * Currently not implemented
     */
    @Override
    public void savePicture(@NonNull Picture picture) {

    }
}
