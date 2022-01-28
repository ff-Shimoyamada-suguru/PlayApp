package com.example.playapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MypageActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        var name = findViewById<TextView>(R.id.textView)

        auth = FirebaseAuth.getInstance()

        val user = Firebase.auth.currentUser?.email
        user?.let {
            name.text = "You're $user"
        }


        val buttonLogout = findViewById<Button>(R.id.LogoutButton)
        buttonLogout.setOnClickListener {
            Firebase.auth.signOut()
//            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}