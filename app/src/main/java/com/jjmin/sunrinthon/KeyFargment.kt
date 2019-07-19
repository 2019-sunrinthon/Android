package com.jjmin.sunrinthon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jjmin.sunrinthon.adapter.MainListAdapter

class KeyFargment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = KeyFargment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         var view = inflater.inflate(R.layout.fargment_key, container, false)



        return view
    }
}
