package io.wookey.wallet.feature.setting

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.wookey.wallet.R
import io.wookey.wallet.base.BaseFragment
import io.wookey.wallet.feature.address.AddressBookActivity
import io.wookey.wallet.feature.wallet.WalletManagerActivity
import io.wookey.wallet.support.extensions.versionName
import kotlinx.android.synthetic.main.base_title_second.*
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.setSupportActionBar(toolbar)
        appCompatActivity?.supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowTitleEnabled(false)
        }
        centerTitle.text = getString(R.string.setting)

        walletManager.setOnClickListener { openWalletManager() }

        addressBook.setOnClickListener { openAddressBook() }

        nodeSetting.setOnClickListener { openNodeSetting() }

        language.setOnClickListener { openLanguage() }

        contactUs.setOnClickListener { openContactUs() }

        about.setOnClickListener { openAbout() }

        about.setRightString(versionName())

    }

    private fun openWalletManager() {
        startActivity(Intent(context, WalletManagerActivity::class.java))
    }

    private fun openAddressBook() {
        startActivity(Intent(context, AddressBookActivity::class.java))
    }

    private fun openNodeSetting() {
        startActivity(Intent(context, NodeSettingActivity::class.java))
    }

    private fun openLanguage() {
        startActivity(Intent(context, LanguageActivity::class.java))
    }

    private fun openContactUs() {
        startActivity(Intent(context, ContactUsActivity::class.java))
    }

    private fun openAbout() {
        startActivity(Intent(context, AboutActivity::class.java))
    }
}