package com.jjmin.sunrinthon

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjmin.sunrinthon.utils.SharedUtils
import kotlinx.android.synthetic.main.fragment_setting.*
import kotlinx.android.synthetic.main.fragment_setting.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class SettingFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SettingFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_setting, container, false)

        view.logout.onClick {
            userDelete()
        }

        return view
    }


    fun userDelete() {
        SharedUtils.delete()
        activity?.finish()
    }
}
