package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor

import com.mycelium.spvmodule.providers.TransactionContract

class SyncProgressCursor : MatrixCursor(arrayOf(
       TransactionContract.GetSyncProgress.PERCENT), 1)
