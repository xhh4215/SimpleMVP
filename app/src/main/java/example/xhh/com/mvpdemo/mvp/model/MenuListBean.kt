package example.xhh.com.mvpdemo.mvp.model

import java.io.Serializable

/**
 * Created by xhh on 2018/6/7.
 * 网络请求返回的数据bean
 */
data class MenuListBean(val resultcode: Int, val reasen: String, val result: Array<ResultData>, val errorcode: Int) : Serializable {
    data class ResultData(val parentId: String, val name: String, val list: Array<Data>) : Serializable
    data class Data(val id: Int, val name: String, val parentId: String)
}