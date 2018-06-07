package example.xhh.com.mvpdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import example.xhh.com.mvpdemo.R
import example.xhh.com.mvpdemo.mvp.contract.MainContract
import example.xhh.com.mvpdemo.mvp.model.MenuListBean
import example.xhh.com.mvpdemo.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMenuInfoId.setOnClickListener{
            val prezenter = MainPresenter(this@MainActivity)
            prezenter.loadingData("853543bbaef41e396965fdfa87fc2d80")
        }

    }

    override fun showProgress() {
        Toast.makeText(this@MainActivity, "数据正在加载", Toast.LENGTH_LONG).show()
    }

    override fun onSucceed(model: MenuListBean) {
        for (i in 0 .. model.result.size) {
            MenuTextId.append(model.result[i].name)
        }
    }

    override fun onFail(err: String) {
        Toast.makeText(this@MainActivity, "数据加载失败", Toast.LENGTH_LONG).show()
    }

    override fun hideProgress() {
        Toast.makeText(this@MainActivity, "数据加载结束", Toast.LENGTH_LONG).show()
    }
}
