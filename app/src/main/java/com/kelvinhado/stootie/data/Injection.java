package com.kelvinhado.stootie.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kelvinhado.stootie.data.source.StootieRepository;
import com.kelvinhado.stootie.data.source.remote.StootieRemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 10/10/2017.
 */

public class Injection {

    public static StootieRepository providePicturesRepository(@NonNull Context context) {
        checkNotNull(context);
        return StootieRepository.getInstance(StootieRemoteDataSource.getInstance());
    }
}
