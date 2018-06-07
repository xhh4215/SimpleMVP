package example.xhh.com.mvpdemo.api

import example.xhh.com.mvpdemo.mvp.model.MenuTitleList
import retrofit2.http.*
import rx.Observable

/**
 * Created by xhh on 2018/6/7.
 */
interface Netapi {
    /***
     * mvp开发模式练习接口
     * 获取菜系列表的请求接口 使用的是get请求
     * 使用@Query 注解为get请求传入参数
     */
    @GET("cook/category")
    fun getCategory(@Query("key") key: String): Observable<MenuTitleList>

    /**
     * 使用post表单请求获取菜单
     * 使用@Field为post请求提供单个参数
     * 使用@FieldMap为post请求提供多个参数
     * 使用@FormUrlEncoded指定为表单提交
     * @POST
     *
     */
    @FormUrlEncoded
    @POST("cook/category")
    fun getCategoryPost(@Field("key") key: String): Observable<MenuTitleList>
}