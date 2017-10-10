package com.kelvinhado.picme.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.kelvinhado.picme.data.source.PictureRepository;
import com.kelvinhado.picme.data.source.local.PictureLocalDataSource;
import com.kelvinhado.picme.data.source.remote.PictureRemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by kelvin on 10/10/2017.
 */

public class Injection {

    public static PictureRepository providePicturesRepository(@NonNull Context context) {
        checkNotNull(context);
        return PictureRepository.getInstance(
                PictureRemoteDataSource.getInstance(),
                PictureLocalDataSource.getInstance());
    }
}
