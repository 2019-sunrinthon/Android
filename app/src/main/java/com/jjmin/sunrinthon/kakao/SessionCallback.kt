package com.jjmin.sunrinthon.kakao

import android.util.Log
import com.google.gson.Gson
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException
import java.util.logging.Logger

class SessionCallback : ISessionCallback {

    //로그인 성공
    override fun onSessionOpened() {
        requestMe()
    }

    //로그인 실패
    override fun onSessionOpenFailed(exception: KakaoException) {

    }

    /**
     * 사용자 정보 요청 함수_별도의 권한 없이 제공
     * id : 인증 여부를 확인하는 user의 id(long)
     * UUID : 앱과 연동 시에 발급 되는 고유한 id 정보(string)
     * nickname : 사용자 별명(string)
     * thumbnailImagePath : 썸네일 프로필 이미지 경로(string)
     */


    fun requestMe() {
        val keys = ArrayList<String>()
        keys.add("properties.nickname")
        keys.add("kakao_account.email")
        keys.add("kakao_account.age_range")

        UserManagement.getInstance().me(keys,object : MeV2ResponseCallback() {
            override fun onSuccess(result: MeV2Response?) {
                Log.e("SessionCallback :: ", "onSuccess")

                val nickname = result!!.nickname
                val id = result!!.id
                var age = result.kakaoAccount.ageRange
                var email = result.kakaoAccount.email


                Log.e("asdfasdf",Gson().toJson(age))
//                userProfile.
//                userProfile.

                Log.e("Profile name : ", nickname + "")
                Log.e("Profile id: ", id.toString() + "")
                Log.e("Profile email: ", email + "")
                Log.e("Profile age: ", age.toString() + "")

            }            // 세션 오픈 실패, 세션이 삭제된 경우
            override fun onSessionClosed(errorResult: ErrorResult) {
                Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult.errorMessage)
            }

            //사용자 정보 요청 실패
            override fun onFailure(errorResult: ErrorResult?) {
                Log.e("SessionCallback :: ", "onFailure : " + errorResult!!.errorMessage)
            }

        })

    }
}

