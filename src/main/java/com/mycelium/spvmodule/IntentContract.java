package com.mycelium.spvmodule;

import android.content.Intent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * The contract between the [SpvService] and clients. Contains definitions
 * for the supported Actions.
 */
public interface IntentContract {
    String ACCOUNT_INDEXES_EXTRA = "ACCOUNT_INDEXES";
    String ACCOUNT_INDEX_EXTRA = "ACCOUNT_INDEX";
    String CREATIONTIMESECONDS = "CREATIONTIMESECONDS";
    String SINGLE_ADDRESS_ACCOUNT_GUID = "SINGLE_ADDRESS_ACCOUNT_GUID";
    String SATOSHIS_RECEIVED = "satoshisReceived";
    String SATOSHIS_SENT = "satoshisSent";
    String ACCOUNTS_INDEX = "accountsIndex";
    String OPERATION_ID = "operationId";
    String TRANSACTION_HASH = "transactionHash";
    String IS_SUCCESS = "is_success";
    String MESSAGE = "message";
    String TRANSACTIONS = "TRANSACTIONS";
    String CONNECTED_OUTPUTS = "CONNECTED_OUTPUTS";
    String UTXOS = "UTXOS";
    String TRANSACTION_BYTES = "TRANSACTION_BYTES";

  class BroadcastTransaction {
        public static final String ACTION = "com.mycelium.wallet.broadcastTransaction";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(byte[] transaction) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(TX_EXTRA, transaction);
            return intent;
        }
    }

    class ReceiveTransactions {
        public static final String ACTION = "com.mycelium.wallet.receiveTransactions";

        public static Intent createIntent(int accountId) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            return intent;
        }
    }

    class ReceiveTransactionsSingleAddress {
        public static final String ACTION = "com.mycelium.wallet.receiveTransactionsSingleAddress";

        public static Intent createIntent(String guid) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.SINGLE_ADDRESS_ACCOUNT_GUID, guid);
            return intent;
        }
    }

    class RequestAccountLevelKeysToSPV {
        public static final String ACTION = "com.mycelium.wallet.requestAccountLevelKeysToSPV";
        public static final String ACCOUNT_KEYS = ACTION + "_accountKeys";
        public static final String CREATION_TIME_SECONDS_EXTRA = ACTION + "_creationTimeSeconds";

        public static Intent createIntent(List<Integer> accountIds, List<String> watchingKeysB58, long creationTimeSeconds) {
            Intent intent = new Intent(ACTION);
            intent.putIntegerArrayListExtra(IntentContract.ACCOUNT_INDEXES_EXTRA, new ArrayList<Integer>(accountIds));
            intent.putStringArrayListExtra(ACCOUNT_KEYS, new ArrayList<String>(watchingKeysB58));
            intent.putExtra(CREATION_TIME_SECONDS_EXTRA, creationTimeSeconds);
            return intent;
        }
    }

    class RequestSingleAddressPrivateKeyToSPV {
        public static final String ACTION = "com.mycelium.wallet.requestSingleAddressPrivateKeyToSPV";
        public static final String SINGLE_ADDRESS_GUID = ACTION + "_singleAddressGuid";
        public static final String PRIVATE_KEY = ACTION + "_data";

        public static Intent createIntent(String guid, byte[] private_key) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(SINGLE_ADDRESS_GUID, guid);
            intent.putExtra(PRIVATE_KEY, private_key);
            return intent;
        }
    }

    class CreateUnsignedTransaction {
        public static final String ACTION = "com.mycelium.wallet.createUnsignedTransaction";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(int accountIndex, byte[] transaction) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(ACCOUNT_INDEX_EXTRA, accountIndex);
            intent.putExtra(TX_EXTRA, transaction);
            return intent;
        }
    }

    class SendSignedTransactionToSPV {
        public static final String ACTION = "com.mycelium.wallet.sendSignedTransactionToSPV";
        public static final String TX_EXTRA = ACTION + "_tx";

        public static Intent createIntent(int accountIndex, byte[] transaction) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(ACCOUNT_INDEX_EXTRA, accountIndex);
            intent.putExtra(TX_EXTRA, transaction);
            return intent;
        }
    }

    class RequestWalletSeed {
        public static final String ACTION = "com.mycelium.wallet.requestWalletSeed";
        public static final String BIP39_PASS_PHRASE_EXTRA = ACTION + "_bip39Passphrase";
        public static final String CREATION_TIME_SECONDS_EXTRA = ACTION + "_creationTimeSeconds";

        public static Intent createIntent(int accountId, ArrayList<String> bip39Passphrase, long creationTimeSeconds) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            intent.putStringArrayListExtra(BIP39_PASS_PHRASE_EXTRA, bip39Passphrase);
            intent.putExtra(CREATION_TIME_SECONDS_EXTRA, creationTimeSeconds);
            return intent;
        }
    }

    class SetPrivateKeyExtendedKeyCoinType {
        public static final String ACTION = "com.mycelium.wallet.setPrivateKeyExtendedKeyCoinType";
        public static final String PRIVATE_KEY = ACTION + "_data";

        public static Intent createIntent(byte[] private_key) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(PRIVATE_KEY, private_key);
            return intent;
        }
    }

    class SendFunds {
        public static final String ACTION = "com.mycelium.wallet.sendFunds";
        public static final String OPERATION_ID = ACTION + "_opId";
        public static final String ADDRESS_EXTRA = ACTION + "_address";
        public static final String AMOUNT_EXTRA = ACTION + "_amount";
        public static final String FEE_EXTRA = ACTION + "_fee";
        public static final String FEE_FACTOR_EXTRA = ACTION + "_fee_factor";

        public static Intent createIntent(String operationId, int accountId, String address, long amount, TransactionFee txFee, float txFeeFactor) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            intent.putExtra(OPERATION_ID, operationId);
            intent.putExtra(ADDRESS_EXTRA, address);
            intent.putExtra(AMOUNT_EXTRA, amount);
            intent.putExtra(FEE_EXTRA, txFee.name());
            intent.putExtra(FEE_FACTOR_EXTRA, txFeeFactor);
            return intent;
        }
    }

    class SendFundsSingleAddress {
        public static final String ACTION = "com.mycelium.wallet.sendFundsSingleAddress";
        public static final String OPERATION_ID = ACTION + "_opId";
        public static final String ADDRESS_EXTRA = ACTION + "_address";
        public static final String AMOUNT_EXTRA = ACTION + "_amount";
        public static final String FEE_EXTRA = ACTION + "_fee";
        public static final String FEE_FACTOR_EXTRA = ACTION + "_fee_factor";

        public static Intent createIntent(String operationId, String guid, String address, long amount, TransactionFee fee, float txFeeFactor) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(OPERATION_ID, operationId);
            intent.putExtra(IntentContract.SINGLE_ADDRESS_ACCOUNT_GUID, guid);
            intent.putExtra(ADDRESS_EXTRA, address);
            intent.putExtra(AMOUNT_EXTRA, amount);
            intent.putExtra(FEE_EXTRA, fee.name());
            intent.putExtra(FEE_FACTOR_EXTRA, txFeeFactor);
            return intent;
        }
    }

    class WaitingIntents {
        public static final String ACTION = "com.mycelium.wallet.waitingIntents";
        public static final String RESULT_ACTION = "com.mycelium.wallet.waitingIntentsResult";
        public static final String WAITING_ACTIONS = ACTION + "_actions";

        public static Intent createResultIntent(int accountId, String[] waitingActions) {
            Intent intent = new Intent(RESULT_ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            intent.putExtra(WAITING_ACTIONS, waitingActions);
            return intent;
        }

        public static Intent createIntent(int accountId) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            return intent;
        }
    }

    class RemoveHdWalletAccount {
        public static final String ACTION = "com.mycelium.wallet.removeHdWalletAccount";

        public static Intent createIntent(int accountId) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.ACCOUNT_INDEX_EXTRA, accountId);
            return intent;
        }
    }

    class RemoveSingleAddressWalletAccount {
        public static final String ACTION = "com.mycelium.wallet.removeSingleAddressWalletAccount";

        public static Intent createIntent(String guid) {
            Intent intent = new Intent(ACTION);
            intent.putExtra(IntentContract.SINGLE_ADDRESS_ACCOUNT_GUID, guid);
            return intent;
        }

    }

    /**
     * This intent should be called when app is first started to ensure that no old data related to
     * old app installations remains in modules.
     */
    class ForceCacheClean {
        public static final String ACTION = "com.mycelium.wallet.forceCacheClean";

        public static Intent createIntent() {
            return new Intent(ACTION);
        }
    }
}
