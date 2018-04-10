package com.mycelium.spvmodule.providers.data;

import android.database.MatrixCursor

import com.mycelium.spvmodule.providers.TransactionContract

class EstimateFeeFromTransferrableAmountCursor : MatrixCursor(arrayOf(
        TransactionContract.EstimateFeeFromTransferrableAmount.ESTIMATED_FEE), 1)
