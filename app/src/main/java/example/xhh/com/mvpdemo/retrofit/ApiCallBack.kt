package example.xhh.com.mvpdemo.retrofit

import retrofit2.HttpException
import rx.Subscriber

/**
 * Created by xhh on 2018/6/7.
 */
abstract class ApiCallBack<M> : Subscriber<M>() {
    abstract fun onSuccess(model: M)

    abstract fun onFailure(e: HttpException)

    override fun onNext(model: M) {
        onSuccess(model)
    }

    override fun onError(e: Throwable?) {
        if (e is HttpException) {
            onFailure(e)
        }
    }

    override fun onCompleted() = Unit
}