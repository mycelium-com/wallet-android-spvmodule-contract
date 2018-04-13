package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor

import com.mycelium.spvmodule.providers.TransactionContract

class GetMaxFundsTransferrableCursor : MatrixCursor(arrayOf(
        TransactionContract.GetMaxFundsTransferrable.MAX_AMOUNT), 1)
