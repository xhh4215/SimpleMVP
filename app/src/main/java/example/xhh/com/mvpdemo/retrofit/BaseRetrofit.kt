package example.xhh.com.mvpdemo.retrofit

import example.xhh.com.mvpdemo.api.Netapi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xhh on 2018/6/7.
 */
object BaseRetrofit {
    fun retrofit(): Netapi {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
        return retrofit.create(Netapi::class.java)
    }
}