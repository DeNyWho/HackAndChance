package com.example.hackchance.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.postDelayed
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.hackchance.R
import android.text.Editable

import android.text.TextWatcher
import android.widget.*


class SingUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sing_up, container, false)
        val bundle = arguments
        val name = view.findViewById<EditText>(R.id.name)
        val hello = view.findViewById<TextView>(R.id.hello)
        val under_hello = view.findViewById<TextView>(R.id.under_hello)
        val passwordField = view.findViewById<FrameLayout>(R.id.password)
        val underPasswordField = view.findViewById<TextView>(R.id.under_password)
        val passwordEdit = view.findViewById<EditText>(R.id.reg_edit)
        val underEMailHello = view.findViewById<TextView>(R.id.under_email)
        val emailEdit = view.findViewById<EditText>(R.id.email_edit)
        val next = view.findViewById<AppCompatButton>(R.id.next)
        val first = view.findViewById<ImageView>(R.id.first)
        val second = view.findViewById<ImageView>(R.id.second)
        val emailFrame = view.findViewById<FrameLayout>(R.id.emailFrame)
        val third = view.findViewById<ImageView>(R.id.third)

        val handler = Handler()
        name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                hello.isVisible = true
                hello.text = "Привет, ${name.text}"
                under_hello.isVisible = true
                handler.postDelayed(1000) {
                    passwordField.isVisible = true
                    underPasswordField.isVisible = true
                }
            }
        })
        passwordEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if(s.length>7) {
                    second.isVisible = true
                    handler.postDelayed(1000) {
                        underEMailHello.isVisible = true
                        emailEdit.isVisible = true
                    }
                }
                else second.isVisible = false
                first.isVisible = s.contains('1') || s.contains('2') || s.contains('3') || s.contains('4')|| s.contains('5') || s.contains('6') || s.contains('7')|| s.contains('8') || s.contains('9')
                if(s.length>7 && s.contains('1') || s.contains('2') || s.contains('3') || s.contains('4')|| s.contains('5') || s.contains('6') || s.contains('7')|| s.contains('8') || s.contains('9'))
                {
                    emailFrame.isVisible = true
                }
            }
        })
        emailEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    third.isVisible = true
                    val handler = Handler()
                    handler.postDelayed(800){
                        next.isVisible = true
                    }
                } else third.isVisible = false
            }
        })
        next.setOnClickListener {
                    findNavController().navigate(R.id.action_singUpFragment_to_mainFragment)
        }
        val number = bundle?.getString("call")

        return view
    }

}