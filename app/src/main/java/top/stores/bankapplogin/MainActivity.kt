package top.stores.bankapplogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton : Button
    private lateinit var userNameTxt : EditText
    private lateinit var passwordTxt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.btn_login)
        userNameTxt = findViewById(R.id.txt_user_name)
        passwordTxt = findViewById(R.id.txt_password)


        val preferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)

        if (preferences.contains("userName") || preferences.contains("password")){
            val intent = Intent(this, ActivityTwo::class.java)
            startActivity(intent)
        }


        loginButton.setOnClickListener {
            val userName = userNameTxt.text.toString()
            val password = passwordTxt.text.toString()

            val sharedPrefereces = getSharedPreferences("Prefs", Context.MODE_PRIVATE);
            val editor = sharedPrefereces.edit()
            editor.putString("userName",userName)
            editor.putString("password",password)
            editor.apply()

            val intent = Intent(this, ActivityTwo::class.java)
            startActivity(intent)
        }


    }
}