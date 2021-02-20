package com.envercelik.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.envercelik.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName = MyName("Enver Çelik")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName

        binding.buttonDone.setOnClickListener {
            addNickName(it)
        }
    }


     private fun addNickName(view: View) {

         binding.apply {

             //binding.textViewNickname.text = binding.editTextNickname.text.toString()
             myName?.nickName = binding.editTextNickname.text.toString()
             invalidateAll()
             binding.editTextNickname.visibility = View.GONE
             binding.textViewNickname.visibility = View.VISIBLE

             view.visibility = View.GONE

         }



         hideTheKeyboard(view)

    }

    private fun hideTheKeyboard(view:View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}