package com.jjmin.sunrinthon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jjmin.sunrinthon.adapter.KeyListAdapter
import com.jjmin.sunrinthon.adapter.MainListAdapter
import com.jjmin.sunrinthon.data.KeyData
import kotlinx.android.synthetic.main.fargment_key.view.*

class KeyFargment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = KeyFargment()
    }

    lateinit var keyadapter : KeyListAdapter
    var array = ArrayList<KeyData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        keyadapter = KeyListAdapter()

         var view = inflater.inflate(R.layout.fargment_key, container, false)

        array.add(KeyData("1",R.drawable.kfc,"KFC 치킨","매콤하고 달콤한 KFA의 대표 주자 치킨!"))
        array.add(KeyData("2",R.drawable.mc,"맥도날드","한입에 쏙 들어가는 맥도날드 햄버거"))
        array.add(KeyData("3",R.drawable.br,"베스킨 라빈스","여러가지 맛을 고를수 있는 아이스크림!"))
        array.add(KeyData("4",R.drawable.pizzahot,"피자","고급 프리미엄 퀄리티 높은 피자"))

        view.keyRecyclerView.adapter = keyadapter
        keyadapter.submitList(array)

        return view
    }
}
