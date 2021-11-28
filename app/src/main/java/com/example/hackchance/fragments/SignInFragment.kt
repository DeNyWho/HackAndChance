package com.example.hackchance.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R
import com.example.hackchance.utils.LoginIntoFacebook
import com.example.hackchance.utils.LoginIntoGoogle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInFragment : Fragment() {
    private var btnLoginFacebook: ImageView? = null
    private var btnLoginGoogle: ImageView? = null
    private lateinit var authFireBase: FirebaseAuth
    private var loginWithFacebookUtils: LoginIntoFacebook? = null
    private var loginWithGoogleUtils: LoginIntoGoogle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        val next = view.findViewById<AppCompatButton>(R.id.next)
        val telephoneNumber = view.findViewById<EditText>(R.id.telephone_number)
        btnLoginGoogle = view.findViewById(R.id.google)
        btnLoginFacebook = view.findViewById(R.id.facebook)
        authFireBase = FirebaseAuth.getInstance()
        loginWithFacebookUtils = LoginIntoFacebook(requireActivity())
        loginWithGoogleUtils = LoginIntoGoogle(requireActivity())

        next.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("call", telephoneNumber.text.toString())
            findNavController().navigate(R.id.action_signInFragment_to_singUpFragment, bundle)
        }

        btnLoginFacebook?.setOnClickListener {
            loginWithFacebookUtils?.startLoginFacebook()
        }

        btnLoginGoogle?.setOnClickListener {
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext())
            loginWithGoogleUtils?.startLoginGoogle()
        }
        loginWithFacebookUtils?.callbackCredentials = ::handleCredentialsLogin
        loginWithGoogleUtils?.callbackCredentials   = ::handleCredentialsLogin
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        loginWithFacebookUtils?.callbackManager?.onActivityResult(requestCode, resultCode, data)
        loginWithGoogleUtils?.onActivityResult(requestCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }


    private fun handleCredentialsLogin(credentials: AuthCredential) {
        authFireBase.signInWithCredential(credentials)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
                    val user = authFireBase.currentUser

                    Log.v("login_activity", "User: Id: ${ user?.uid } name: ${user?.displayName}, email: ${user?.email}")
                } else {
                    task.exception?.printStackTrace()
                    Log.e("login_activity", "Login error: ${ task.exception?.message }")
                    Toast.makeText(requireContext(), "Something went wrong: ${ task.exception?.message }", Toast.LENGTH_SHORT).show()
                }
            }
    }

}