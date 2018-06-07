package example.xhh.com.mvpdemo.retrofit

import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by xhh on 2018/6/7.
 */
open class RxSubscriptionManager {
    private val subscriptions = CompositeSubscription()
    /**
     * 添加一个subscriptions订阅
     */
    fun <M> addSubscription(observable: Observable<M>, subscriber: Subscriber<M>): Subscription {
        return observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber).also {
            subscriptions.add(it)
        }
    }

    /***
     * 删除一个subscriptions订阅
     */
    fun removeSubscription(subscription: Subscription) {
        subscriptions.remove(subscription)
    }

    /***
     *  取消所有进行中的 ReactiveX 订阅, 避免资源浪费
     */
    fun cleanSubscriptions() {
        if (subscriptions.hasSubscriptions()) {
            subscriptions.clear()
        }
    }
}