package example.xhh.com.mvpdemo.mvp.presenter

import example.xhh.com.mvpdemo.mvp.contract.MainContract
import example.xhh.com.mvpdemo.mvp.model.MenuTitleList
import example.xhh.com.mvpdemo.retrofit.ApiCallBack
import example.xhh.com.mvpdemo.retrofit.BaseRetrofit
import retrofit2.HttpException

/**
 * Created by xhh on 2018/6/7.
 */
class MainPresenter(val view: MainContract.View) : MainContract.Presenter() {
    override fun loadMenuData(map: String) {
        view.showProgress()
        addSubscription(BaseRetrofit.retrofit().getCategory(map), object : ApiCallBack<MenuTitleList>() {
            override fun onSuccess(model: MenuTitleList) {
                view.onSucceed(model)
            }

            override fun onFailure(e: HttpException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun loadingData(key: String) {
        view.showProgress()
        addSubscription(BaseRetrofit.retrofit().getCategoryPost(key), object : ApiCallBack<MenuTitleList>() {
            override fun onSuccess(model: MenuTitleList) {
                view.onSucceed(model)
            }

            override fun onFailure(e: HttpException) {
                view.onFail(e.message())
                view.hideProgress()
            }

        })
    }


}