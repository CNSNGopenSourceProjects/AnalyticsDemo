package br.com.conseng.analyticsdemo

import android.app.Application
import android.content.Context
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker


/**
 * Provê o rastreador do seu aplicativo.
 * @param [context] contexto da aplicação.
 * @param [reportException] reportar problemas na aplicação ou não. Default = true.
 * @param [reportActivity] rastrear automaticamente as Activities ou não. Default = true.
 * @see [https://developers.google.com/analytics/devguides/collection/android/v4/advanced]
 */
class AnalyticsApplication(context: Context,
                           reportException: Boolean = true,
                           reportActivity: Boolean = true) : Application() {

    /**
     * Rastreador da aplicação.
     */
    val tracker: Tracker

    /**
     * Determina se deve rastrear automaticamente todas as Activities ou não.
     */
    var autoActivityTracking: Boolean = true
        set(value) {
            tracker.enableAutoActivityTracking(value)
            field = value
        }

    /**
     * Determina se deve rastrear as excessões e "trash" da aplicação ou não.
     */
    var exceptionReporting: Boolean = true
        set(value) {
            tracker.enableExceptionReporting(value)
            field = value
        }

    init {
        val analytics = GoogleAnalytics.getInstance(context)
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        tracker = analytics.newTracker(R.xml.global_tracker)
        // Rastrear as excessões e "trash" da aplicação
        this.exceptionReporting = reportException
        tracker.enableExceptionReporting(reportException)
        // Rastrear automaticamente todas as Activity
        this.autoActivityTracking = reportActivity
        tracker.enableAutoActivityTracking(reportActivity)
    }
}