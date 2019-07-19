package com.jjmin.sunrinthon

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.jjmin.sunrinthon.adapter.MainListAdapter
import com.jjmin.sunrinthon.data.MainSettingData
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HomeFragment : Fragment() {

    var array = ArrayList<MainSettingData>()

    lateinit var adapter : MainListAdapter

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initArray()

        var view = inflater.inflate(R.layout.fragment_home, container, false)


        adapter = MainListAdapter()
        view.mainRecyclerview.adapter = adapter
        adapter.submitList(array)


        return view
    }

    fun initArray(){
        array.add(MainSettingData("나는 돈이 많다","나는 1억 이상의 차가 있다.","나는 통장잔고가 1.5억 이상 있다.",
                "나는 1000만원 이상의 시계가 있다.","나는 20억 이상의 집에 살고 있다.","나는 일을 안해도 평생 놀 수 있다.."))


        array.add(MainSettingData("나는 축구를 잘한다","나는 국내 3부 리그 안에서 활동 한다.","나는 라보나킥을 할 줄 안다.",
                "나는 패널너킥 방어율이 20퍼센트 이상이다.","나는 전국 혹은 소년 체전에 출전한 경험이있다.",
                "나는 슬라이딩 태클을 해서 카드를 받지 않은적이 있다."))


        array.add(MainSettingData("나는 개발을 잘한다","나는 어셈블리 코드를 주석 없이 읽을 수 있다.",
                "나는 대회 총 상금이 3억원 이상이다.","나는 디버깅 없이 코딩을 완성할 수 있다.",
                "나는 언어를 만들어본적이 있다.","나는 OS를 만들어본적이 있다."))

        array.add(MainSettingData("나는 공부를 잘한다","나는 QS 대학순위 100위 안에 있는 대학에 다닌다.",
                "나는 모의고사 국 영 수 합이 3이 나온적이있다.",
                "나는 박사과정은 수료하였다.","나는 작성한 논문 중에 50회 이상 인용된 적이 있다.","나는 토익 950점 이상이다."))
    }
}