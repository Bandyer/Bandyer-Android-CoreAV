/*
 * Copyright (C) 2018 Bandyer S.r.l. All Rights Reserved.
 * See LICENSE.txt for licensing information
 */

package com.bandyer.demo_core_av.networking;

import com.bandyer.demo_core_av.App;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author kristiyan
 **/

@SuppressWarnings("WeakerAccess")
public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static String clientUrl;

    public static Retrofit getClient(String url) {
        if (retrofit == null || !url.equals(clientUrl)) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(App.okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(App.gson))
                    .build();
            clientUrl = url;
        }
        return retrofit;
    }
}