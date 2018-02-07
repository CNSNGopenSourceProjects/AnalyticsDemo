package br.com.conseng.analyticsdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.gms.analytics.HitBuilders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * Identifica o estado desta atividade no log.
     */
    private val STATE_TAG1 = "Activity 1"

    /**
     * Nome da tela a ser utilizado nos Hit do rastreio.
     */
    private val SCREEN_NAME = "Tela Principal"

    /**
     * Cria o TRACKER de acompanhamento da
     */
    private lateinit var application: AnalyticsApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cria o Tracker que enviará os dados de rastreio da APP para o Google Analytics
        application=AnalyticsApplication(this)
        val tracker=application.tracker
        // Set screen name
        tracker.setScreenName(SCREEN_NAME)
        // Send a screen view
        // Send a screen view.
        tracker.send(HitBuilders.ScreenViewBuilder().build())
        // This event will also be sent with the most recently set screen name.
        // Build and send an Event.
        tracker.send(HitBuilders.EventBuilder()
                .setCategory(getString(categoryId))
                .setAction(getString(actionId))
                .setLabel(getString(labelId))
                .build())
        // Clear the screen name field when we're done.
        tracker.setScreenName(null)

        printCurrentState("onCreate")

        val btnNext : Button = btn_next_activity
        btnNext.setOnClickListener { v: View? ->
            val intent= Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        printCurrentState("onStart")
    }

    override fun onResume() {
        super.onResume()
        printCurrentState("onResume")
    }

    override fun onPause() {
        super.onPause()
        printCurrentState("onPause")
    }

    override fun onStop() {
        super.onStop()
        printCurrentState("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        printCurrentState("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        printCurrentState("onDestroy")
    }

    private fun printCurrentState(estado:String) {
        Log.d(STATE_TAG1, "state=$estado")
//        println("$STATE_TAG1 : state=$estado")
    }
}
