package br.com.conseng.analyticsdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.google.android.gms.analytics.HitBuilders

/**
 * Cria o TRACKER de acompanhamento da
 */
lateinit var analytics: AnalyticsApplication


class MainActivity : AppCompatActivity() {

    /**
     * Identifica o estado desta atividade no log.
     */
    private val STATE_TAG1 = "Activity 1"

    /**
     * Nome da tela a ser utilizado nos Hit do rastreio.
     */
    private val SCREEN_NAME = "Tela Principal"

//    /**
//     * Cria o TRACKER de acompanhamento da
//     */
//    private lateinit var application: AnalyticsApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cria o Tracker que enviará os dados de rastreio da APP para o Google Analytics
        analytics = AnalyticsApplication(this)

        printCurrentState("onCreate")
    }

    /**
     * Processa o click do botão para abrir a segunda Activity.
     * @param [view] view associada ao evento.
     */
    fun nextActivity(view: View) {
        //  Ratreia o evento de click para o Google Analytics
        val tracker = analytics.tracker
        tracker.send(HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Click")
                .build())
        // Chama a segunda atividade
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        printCurrentState("onStart")
    }

    override fun onResume() {
        super.onResume()

        // Cria o Tracker que enviará os dados de rastreio da APP para o Google Analytics
        val tracker = analytics.tracker
        // Set screen name
        tracker.setScreenName(SCREEN_NAME)
        // Send a screen view
        tracker.send(HitBuilders.ScreenViewBuilder().build())
        // Clear the screen name field when we're done.
        tracker.setScreenName(null)

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

    private fun printCurrentState(estado: String) {
        Log.d(STATE_TAG1, "state=$estado")
//        println("$STATE_TAG1 : state=$estado")
    }
}
