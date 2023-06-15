package com.yahmeds.healthcare

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.yahmeds.healthcare.activities.UserProfileActivity
import com.yahmeds.healthcare.fragments.DashBoardFragment
import com.yahmeds.healthcare.fragments.UserProfileFragment

class DashBoardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    private lateinit var drawer: DrawerLayout
    var mToolbar: Toolbar? = null
    lateinit var imgThreeDot: ImageView
    private lateinit var editProfile: TextView

    @SuppressLint("MissingInflatedId", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        drawer = findViewById(R.id.drawer)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            mToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        toggle.syncState()
        val drawable =
            ResourcesCompat.getDrawable(resources, R.drawable.menu, this.theme)
        toggle.isDrawerIndicatorEnabled = false
        toggle.setHomeAsUpIndicator(drawable)
        toggle.toolbarNavigationClickListener = View.OnClickListener {
            if (drawer.isDrawerVisible(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                drawer.openDrawer(GravityCompat.START)
            }
        }
        imgThreeDot = findViewById(R.id.img_three_dot);
        imgThreeDot.setOnClickListener(this)
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        val firstFragment = DashBoardFragment()
        setCurrentFragment(firstFragment)
        init()
        setListener()
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.img_three_dot ->
                    showMoreDialog(this);
                R.id.text_view_profile -> {
                    val fragmentMnager = supportFragmentManager
                    fragmentMnager.popBackStack()
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START)
                    }
                  //  gotoUserProfileFragment(UserProfileFragment())
                    val intent = Intent(this, UserProfileActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }
            }
        }
    }

    // When User cilcks on dialog button, call this method
    fun showMoreDialog(view: DashBoardActivity) {
        /*val dialog = Dialog(this)
        dialog.setContentView(R.layout.dashboard_more_option_dialog)*/
        val viewGroup = findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View =
            LayoutInflater.from(this)
                .inflate(R.layout.dashboard_more_option_dialog, viewGroup, false)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog = builder.create()
        alertDialog.window!!.setGravity(Gravity.TOP)
        alertDialog.show()
        /*val dialogButton = dialog.findViewById<Button>(R.id.dialogButtonOK)
        dialogButton.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(applicationContext, "Dismissed..!!", Toast.LENGTH_SHORT).show()
        }*/
        //dialog.show()
    }
    /* fun setMain() {
         setFragment(DashboardFragment.newInstance(), "DashBoard")
         // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
         //navigationView.getMenu().getItem(0).setChecked(true);
     }*/

    private fun init() {
        editProfile = findViewById(R.id.text_view_profile)

    }

    private fun gotoUserProfileFragment(userProfileFragment: UserProfileFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment, userProfileFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun setListener() {
        editProfile.setOnClickListener(this)
    }
}