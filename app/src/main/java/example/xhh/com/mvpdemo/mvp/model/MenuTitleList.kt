package example.xhh.com.mvpdemo.mvp.model

import java.io.Serializable

/**
 * Created by xhh on 2018/6/7.
 */
data class MenuTitleList(val resultcode: String, val reason: String, val result: Array<ResultBean>, val error_code: Int) : Serializable {
    data class ResultBean(val parentId: String, val name: String, val list: List<Data>) : Serializable
    data class Data(val id: Int, val name: String, val parentId: String) : Serializable
}