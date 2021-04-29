package com.example.weekfourui.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import com.example.weekfourui.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call the create notification method
        createNotification()

        openFragment(ProductsFragment())
        //getting bottom navigation view and attaching the listener
        var navigation: BottomNavigationView = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val noti = findViewById<ImageView>(R.id.notification_imageView)
        noti.setOnClickListener {
            createNotification()
        }

    }


    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_payments -> {
//                toolbar.title = "Payments"
                    val paymentsFragment = PaymentsFragment.newInstance()
                    openFragment(paymentsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_products -> {
                    val productsFragment = ProductsFragment.newInstance()
                    openFragment(productsFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_history -> {
                    val historyFragment = HistoryFragment.newInstance()
                    openFragment(historyFragment)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigation_support -> {
                    val supportFragment = SupportFragment.newInstance()
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment( fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    private fun createNotification() {
        // Create the NotificationChannel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("ID", name, importance).apply {
                description = descriptionText
            }


            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)


            //create an explicit intent to open the second activity
            val notifyIntent = Intent(this, MainActivity::class.java).apply {
            }


            //get the pending intent
            val notifyPendingIntent =
                PendingIntent.getActivity(this, 0, notifyIntent, 0)

            //notification builder
            var builder = NotificationCompat.Builder(this, "ID")
                .setContentTitle("My notification")
                .setSmallIcon(R.drawable.photo)
                .setContentText("You have a notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)


                // Set the intent that will fire when the user taps the notification
                .setContentIntent(notifyPendingIntent)
                .setAutoCancel(true)


            //set on click listener to notification imageView to open this assignment
            notification_imageView.setOnClickListener {
                notificationManager.notify(100, builder.build());
            }
        }
    }
}