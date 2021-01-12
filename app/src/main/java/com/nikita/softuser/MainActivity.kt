package com.nikita.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            if (username == "softwarica" && password == "coventry") {
                Toast.makeText(this@MainActivity, "User Logged in", Toast.LENGTH_SHORT).show()

                val intent = Intent ( this, HomeActivity::class.java)
                startActivity(intent)
            }
            else{
                etUsername.setText("");
                etPassword.setText("");
                etUsername.requestFocus()
                Toast.makeText(this@MainActivity, "Invalid Username or password", Toast.LENGTH_LONG).show()
            }

        }

    }
}