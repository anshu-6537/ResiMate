package com.example.resimate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.resimate.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // TO SET MORNING AFTERNOON TEXT
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val time=findViewById<TextView>(R.id.time)
        Log.d("hh", hour.toString())
        var text=""
        if(hour<12)
            text="  Hello, \n  Good Morning !!"
        else if(hour<=18)
            text="  Hello, \n  Good Afternoon !!"
        else
            text="  Hello, \n  Good Evening !!"
        time.text=text
//        Toast.makeText(this,"$hour : $minute",Toast.LENGTH_SHORT).show()

        val notification = findViewById<ImageView>(R.id.notification)
        notification.setOnClickListener {
            val intent = Intent(this, Notification::class.java)
            startActivity(intent)
        }


        // ....... NAVIGATION DRAWER .......
        val drawerLayout=findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView=findViewById<NavigationView>(R.id.nav_view)

        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.viewRoom -> startActivity(Intent(applicationContext,RoomType::class.java))
                R.id.privacy -> startActivity(Intent(applicationContext, termsNcondition::class.java))
                R.id.share -> share()
                R.id.rate -> Toast.makeText(applicationContext, "rate", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(applicationContext,"logout",Toast.LENGTH_SHORT).show()

            }
            true
        }
        val btnOpenDrawer: ImageButton = findViewById(R.id.btnOpenDrawer)
        btnOpenDrawer.setOnClickListener {
            drawerLayout.openDrawer(findViewById(R.id.nav_view));
        }

        val studBtn = findViewById<ImageView>(R.id.student_login)
        val adminBtn = findViewById<ImageView>(R.id.admin_login)

        studBtn.setOnClickListener {
            startActivity(Intent(this,StudWelcomePg::class.java))
        }
        adminBtn.setOnClickListener {
            startActivity(Intent(this,AdmWelcomePg::class.java))
        }

        val viewRoom=findViewById<TextView>(R.id.viewRoom)
        viewRoom.setOnClickListener {
            startActivity(Intent(this,RoomType::class.java))
        }
    }

    private fun share() {
        val intent = Intent(Intent.ACTION_SEND)
        val url = "https://github.com/anshu-6537/ResiMate"
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Hey, Checkout this cool app $url")
        val chooser = Intent.createChooser(intent, "Share this app using ...")
        startActivity(chooser)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item))

            return true

        return super.onOptionsItemSelected(item)
    }
}