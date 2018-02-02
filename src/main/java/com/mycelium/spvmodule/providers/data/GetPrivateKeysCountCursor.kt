package com.mycelium.spvmodule.providers.data

import android.database.MatrixCursor
import com.mycelium.spvmodule.providers.TransactionContract

class GetPrivateKeysCountCursor : MatrixCursor(arrayOf(
        TransactionContract.GetPrivateKeysCount.KEYS_COUNT), 1)
