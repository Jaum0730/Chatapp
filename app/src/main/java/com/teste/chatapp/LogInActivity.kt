package com.teste.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.compose.setContent
import com.google.firebase.auth.FirebaseAuth
import com.teste.chatapp.compose.LoginLayoutScreenPreview


private lateinit var dbAuth:FirebaseAuth

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        setContent {
            LoginLayoutScreenPreview()
        }

=======
        setContent{
            LoginLayoutScreenPreview()
        }
        //olhar utilidade
>>>>>>> 7a3e9b8cfecdf94b0baf4f8b1354e9bbc30dfae1
        dbAuth = FirebaseAuth.getInstance()

        var txtLoginEmail: EditText = findViewById<EditText>(R.id.txtLoginEmail)
        var txtLoginPassword: EditText = findViewById<EditText>(R.id.txtLoginPassword)
        var btn_login: Button = findViewById(R.id.Login)

        btn_login.setOnClickListener(){
            val email = txtLoginEmail.text.toString()
            val senha = txtLoginPassword.text.toString()

            login(email, senha);

        }
    }

    private fun login(email: String, senha: String){
        dbAuth.signInWithEmailAndPassword(email, senha)

            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this@LogInActivity, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show()

                }
            }
    }
}

