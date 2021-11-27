package com.example.android_githubclient_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProjectPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ProjectPageFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_page_fragment_container, fragment)
            .commit()
    }
}

