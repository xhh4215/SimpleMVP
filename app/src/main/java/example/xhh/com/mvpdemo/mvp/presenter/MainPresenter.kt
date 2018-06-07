package example.xhh.com.mvpdemo.mvp.presenter

import example.xhh.com.mvpdemo.mvp.model.MenuListBean
import example.xhh.com.mvpdemo.mvp.contract.MainContract
import example.xhh.com.mvpdemo.retrofit.ApiCallBack
import example.xhh.com.mvpdemo.retrofit.BaseRetrofit
import retrofit2.HttpException

/**
 * Created by xhh on 2018/6/7.
 */
class MainPresenter(val view: MainContract.View) : MainContract.Presenter() {
    override fun loadingData(key: String) {
        view.showProgress()
        addSubscription(BaseRetrofit.retrofit().getCategory(key), object : ApiCallBack<MenuListBean>() {
            override fun onSuccess(model: MenuListBean) {
                view.onSucceed(model)
            }

            override fun onFailure(e: HttpException) {
                view.onFail(e.message())
                view.hideProgress()
            }

        })
    }


}