package io.wookey.wallet.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import io.wookey.wallet.dialog.LoadingDialog
import io.wookey.wallet.support.extensions.getLocale
import io.wookey.wallet.support.extensions.setLocale

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(setLocale(newBase, getLocale()))
    }

    var loadingDialog: LoadingDialog? = null

    open fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(this)
        }
        loadingDialog?.show()
    }

    open fun hideLoading() {
        if (!isFinishing && !isDestroyed) loadingDialog?.dismiss()
    }
}