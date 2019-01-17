package com.company.applicationname.app.job

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters


class CategorySyncWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        Log.e("CategorySyncWork: ", "Syncing categories")
        return Result.success()
    }


    companion object {
        const val TAG = "CategorySyncWork"
    }


}