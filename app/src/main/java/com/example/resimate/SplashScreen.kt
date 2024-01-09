package com.example.resimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val topanim= AnimationUtils.loadAnimation(this,R.anim.anim)
        val splash=findViewById<ImageView>(R.id.splash)
        splash.startAnimation(topanim)

        val bottomanim= AnimationUtils.loadAnimation(this,R.anim.anim)
        val bottomsplash=findViewById<ImageView>(R.id.cllge)
        splash.startAnimation(topanim)
//        val splash_time_out= 5000
        val homeIntent= Intent(this@SplashScreen,MainActivity::class.java)

//        handler =Handler()
        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, 3000)
    }
}