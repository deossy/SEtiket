package com.adorable.setiket.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.adorable.setiket.database.DatabaseClient.Companion.getInstance
import com.adorable.setiket.model.ModelDatabase
import com.adorable.setiket.database.dao.DatabaseDao
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    var dataList: LiveData<List<ModelDatabase>>
    var databaseDao: DatabaseDao?

    fun deleteDataById(uid: Int) {
        Completable.fromAction {
            databaseDao?.deleteDataById(uid) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        databaseDao = getInstance(application)?.appDatabase?.databaseDao()
        dataList =databaseDao!!.getAllData()
    }

}