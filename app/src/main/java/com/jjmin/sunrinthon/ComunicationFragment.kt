package com.jjmin.sunrinthon

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jjmin.sunrinthon.adapter.CommunityAdapter
import com.jjmin.sunrinthon.data.model.Communy
import kotlinx.android.synthetic.main.fragment_comunication.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class ComunicationFragment : Fragment() {
    lateinit var adapter : CommunityAdapter
    var array = ArrayList<Communy>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_comunication, container, false)

        adapter = CommunityAdapter()

        array.add(Communy("나는 OS를 만들었다","sadf","독고현"))
        array.add(Communy("나는 대회 총 상금이 3억원 이상이다","asdf","나재민"))
        array.add(Communy("나는 모의고사 국 영 수 합이 3이 나온적이있다.","Asdf","독고현"))
        array.add(Communy("나는 작성한 논문 중에 50회 이상 인용된 적이 있다.","asdf","윤성현"))
        array.add(Communy("나는 토익 950점 이상이다.","Asdf","독고현"))
        array.add(Communy("나는 전국 혹은 소년 체전에 출전한 경험이있다.","asdf","운성현"))
        array.add(Communy("나는 국내 3부 리그 안에서 활동 한다.","sadf","독고현"))

        view.communityRecycler.adapter = adapter
        adapter.submitList(array)

        view.fab.onClick {
            startActivityForResult(Intent(activity,AddMemoActivity::class.java),100)
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() = ComunicationFragment()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 100){
                var name = data?.getStringExtra("name")as String
                var content = data?.getStringExtra("content")as String
                array.add(Communy(name,content,"나재민"))
                adapter.submitList(array)
            }
        }
    }
}