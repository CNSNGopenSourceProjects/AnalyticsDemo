package br.com.conseng.analyticsdemo

import android.content.OperationApplicationException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.google.android.gms.analytics.HitBuilders

class Main2Activity : AppCompatActivity() {

    /**
     * Identifica o estado desta atividade no log.
     */
    private val STATE_TAG2 = "Activity 2"

    /**
     * Nome da tela a ser utilizado nos Hit do rastreio.
     */
    private val SCREEN_NAME = "Tela Secundária"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        printCurrentState("onCreate")
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

    /**
     * Processa o click do botão para simular uma exceção fatal.
     * @param [view] view associada ao evento.
     */
    fun emulateException(view: View) {
        val tracker = analytics.tracker
        tracker.send(HitBuilders.ExceptionBuilder()
                .setDescription("Exemplo")
                .setFatal(true)
                .build())
    }

    /**
     * Gera uma excessão fatal para a aplicação.
     * @param [view] view associada ao evento.
     */
    fun forceException(view: View) {
        throw OperationApplicationException("Exceção fatal forçada pela aplicação")
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
        Log.d(STATE_TAG2, "state=$estado")
//        println("$STATE_TAG2 : state=$estado")
    }
}
