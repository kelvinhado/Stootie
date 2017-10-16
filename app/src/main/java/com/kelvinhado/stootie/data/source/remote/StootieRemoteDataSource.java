package com.kelvinhado.stootie.data.source.remote;

import android.support.annotation.NonNull;

import com.kelvinhado.stootie.data.model.Stootie;
import com.kelvinhado.stootie.data.source.StootieDataSource;
import com.kelvinhado.stootie.data.source.remote.pojo.Collection;
import com.kelvinhado.stootie.data.source.remote.pojo.StootieResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by kelvin on 10/10/2017.
 */

public class StootieRemoteDataSource implements StootieDataSource {

    /**
     * Single instance
     */
    private static StootieRemoteDataSource sInstance;

    //prevent direct instantiation
    private StootieRemoteDataSource() {}

    public static StootieRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new StootieRemoteDataSource();
        }
        return sInstance;
    }

    /**
     * Get pictures from the remote source
     * @param callback the results
     */
    @Override
    public void getStooties(@NonNull final LoadStootiesCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bff-mobile-dev.stootie.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        final StootieService service = retrofit.create(StootieService.class);
        Observable<StootieResponse> observable = service.getStooties();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<StootieResponse, List<Stootie>>() {
                    @Override
                    public List<Stootie> apply(StootieResponse stootieResponse) throws Exception {
                        List<Stootie> stooties = new ArrayList<>();
                        for(Collection stoot : stootieResponse.getCollection()) {
                            Stootie stootie = new Stootie(
                                    stoot.getId(),
                                    stoot.getTitle(),
                                    stoot.getUser().getFirstname(),
                                    stoot.getUser().getLastname(),
                                    Double.parseDouble(stoot.getUnit_price()),
                                    stoot.getAddress(),
                                    stoot.getCreated_at()
                                    );
                            stooties.add(stootie);
                        }
                        return stooties;
                    }
                })
                .subscribe(new Consumer<List<Stootie>>() {
                    @Override
                    public void accept(List<Stootie> stooties) throws Exception {
                        callback.onStootiesLoaded(stooties);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getStootie(@NonNull LoadStootieCallback callback) {
        // TODO
    }

    @Override
    public void refreshData() {
        // Not required because the {@link StootieRepository} handles the logic of refreshing the
        // pictures from all the available data sources.
    }
}
