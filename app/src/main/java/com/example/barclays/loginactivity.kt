package com.example.barclays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.barclays.databinding.ActivityLoginactivityBinding
import com.google.firebase.auth.FirebaseAuth

class loginactivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginactivityBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var loginRedirectText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.loginPassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, homeactivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Set OnClickListener on loginRedirectText
        loginRedirectText = findViewById(R.id.loginRedirectText)
        loginRedirectText.setOnClickListener {
            val intent = Intent(this, signinactivity::class.java)
            startActivity(intent)
        }
    }
}
