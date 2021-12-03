package com.anncode.paging32

import android.app.Application
import com.anncode.paging32.di.DaggerApplicationComponent

/**
 * Created by anahi.salgado on 01-Dec-21.
 */

class MyApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()

}
