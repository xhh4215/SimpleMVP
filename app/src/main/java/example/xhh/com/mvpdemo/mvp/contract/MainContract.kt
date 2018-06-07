package example.xhh.com.mvpdemo.mvp.contract

import example.xhh.com.mvpdemo.base.BasePresenter

/**
 * Created by xhh on 2018/6/7.
 */
interface MainContract {
    // 封装对前段的View视图的操作
    interface View {
        //加载之前显示进度条
        fun showProgress()

        // 加载成功更新activity数据
        fun <T> onSucceed(model: T)

        //加载失败在actiivty中给出提示
        fun onFail(err: String)

        //加载结束取消进度条
        fun hideProgress()

    }

    // 结合model数据对view进行操作的逻辑
    abstract  class Presenter : BasePresenter() {
        //进行具体的逻辑的处理
        abstract fun loadingData(key: String)

        abstract fun loadMenuData(key: String)
    }
}
