package com.mycelium.spvmodule.providers.data

import android.database.MatrixCursor
import com.mycelium.spvmodule.providers.TransactionContract

class GetPrivateKeysCountCursor : MatrixCursor(arrayOf(
        TransactionContract.GetPrivateKeysCount.EXTERNAL_KEYS_COUNT,TransactionContract.GetPrivateKeysCount.INTERNAL_KEYS_COUNT), 2)
