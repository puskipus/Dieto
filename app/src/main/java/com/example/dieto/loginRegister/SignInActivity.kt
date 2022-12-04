package com.example.dieto.loginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.dieto.MainActivity
import com.example.dieto.R
import com.example.dieto.databinding.ActivitySignInBinding
import com.example.dieto.utilities.Constants
import com.example.dieto.utilities.PreferenceManager
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_in) //ORI

        preferenceManager = PreferenceManager(applicationContext)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.textCreateNewAccount.setOnClickListener {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }
        binding.buttonSignIn.setOnClickListener {
            if ( isValidSignInDetails() ) {
                login()
            }
        }
    }

    private fun login() {
        loading(true)
        val database = Firebase.firestore

        database.collection(Constants.KEY_COLLECTION_USERS)
            .whereEqualTo( Constants.KEY_EMAIL, binding.inputEmail.text.toString() )
            .whereEqualTo( Constants.KEY_PASSWORD, binding.inputPassword.text.toString() )
            .get()
            .addOnSuccessListener { task ->
                if ( !task.isEmpty ) {
                    val documentSnapshot: DocumentSnapshot = task.documents.get(0)
                    preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true)
                    preferenceManager.putString(Constants.KEY_USER_ID, documentSnapshot.id)
                    documentSnapshot.getString(Constants.KEY_NAME)?.let { preferenceManager.putString(Constants.KEY_NAME, it) }
                    documentSnapshot.getString(Constants.KEY_IMAGE)?.let { preferenceManager.putString(Constants.KEY_USER_ID, it) }

                    val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    showToast("Login Success")
                } else {
                    loading(false)
                    showToast("Unable to Sign In")
                }
            }.addOnFailureListener { exception ->
                loading(false)
                exception.message?.let { showToast(it) }
            }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun isValidSignInDetails(): Boolean {
        if ( binding.inputEmail.text.toString().trim().isEmpty() ) {
            showToast("Enter Email")
            return false
        } else if ( !Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.text.toString()).matches() ) {
            showToast("Enter Valid Email")
            return false
        } else if ( binding.inputPassword.text.toString().trim().isEmpty() ) {
            showToast("Enter Password")
            return false
        } else {
            return true
        }
    }

    private fun loading(isLoading: Boolean) {
        if ( isLoading ) {
            binding.buttonSignIn.visibility = View.INVISIBLE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.buttonSignIn.visibility = View.VISIBLE
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

}