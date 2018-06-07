package example.xhh.com.mvpdemo.api

import example.xhh.com.mvpdemo.mvp.model.MenuListBean
import retrofit2.http.*
import rx.Observable

/**
 * Created by xhh on 2018/6/7.
 */
interface Netapi {
    /***
     * 获取菜系列表的请求接口 使用的是post请求
     * @Field @FieldMap  这两个注释是在发送post请求提交数据的时候使用
     */
    @GET("cook/category")
    fun getCategory(@Query("key") key: String): Observable<MenuListBean>
}