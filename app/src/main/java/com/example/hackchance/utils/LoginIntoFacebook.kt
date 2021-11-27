package com.example.hackchance.utils

import android.app.Activity
import android.util.Log
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.FacebookSdk.getApplicationContext
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider

class LoginIntoFacebook(val context: Activity) {
    var callbackManager: CallbackManager? = null

    var callbackCredentials: ((AuthCredential) -> Unit)? = null

    init {
        callbackManager = CallbackManager.Factory.create()

        registerCallback()
    }

    private fun registerCallback() {
        LoginManager.getInstance().registerCallback(callbackManager, object:
            FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                val credentials = FacebookAuthProvider.getCredential(result.accessToken.token)

                callbackCredentials?.invoke(credentials)
            }

            override fun onCancel() {
                Log.d("facebook","Login is cancel")
            }

            override fun onError(error: FacebookException) {
                error.printStackTrace()
                Log.d("facebook","Something went wrong${error.message}")
            }
        })
    }

    fun startLoginFacebook() {
        LoginManager.getInstance().logInWithReadPermissions(context, listOf("email", "public_profile"))
    }
}