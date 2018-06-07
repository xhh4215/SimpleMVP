package example.xhh.com.mvpdemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import example.xhh.com.mvpdemo.R
import example.xhh.com.mvpdemo.mvp.contract.MainContract
import example.xhh.com.mvpdemo.mvp.model.MenuTitleList
import example.xhh.com.mvpdemo.mvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, View.OnClickListener {

    val prezenter = MainPresenter(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMenuInfoId.setOnClickListener(this@MainActivity)
        getMenuId.setOnClickListener(this@MainActivity)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.getMenuId -> {
//                val map = mapOf("key" to "853543bbaef41e396965fdfa87fc2d80", "menu" to "红烧肉", "rn" to "10", "pn" to "3")
                prezenter.loadMenuData("853543bbaef41e396965fdfa87fc2d80")
            }
            R.id.getMenuInfoId -> {
                prezenter.loadingData("853543bbaef41e396965fdfa87fc2d80")

            }
        }
    }

    override fun <T> onSucceed(model: T) {
        when (model) {
            is MenuTitleList -> {
                for (i in 0..model.result.size) {
                    Log.d("菜单列表数据", model.toString())

                    MenuTextId.text = model.result[i].name
                }
            }
        }
    }

    override fun showProgress() {
        Toast.makeText(this@MainActivity, "数据正在加载", Toast.LENGTH_LONG).show()
    }


    override fun onFail(err: String) {
        Toast.makeText(this@MainActivity, "数据加载失败", Toast.LENGTH_LONG).show()
    }

    override fun hideProgress() {
        Toast.makeText(this@MainActivity, "数据加载结束", Toast.LENGTH_LONG).show()
    }
}
