package com.eme.dogbreed.util;

import android.content.Context;

import com.eme.dogbreed.data.DogRepository;
import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.remote.RemoteAPIFactory;

public class InjectorUtils {

    public static IDogRepository getDogRepository(Context context) {
        return DogRepository.getInstance(RemoteAPIFactory.create());
    }
}
