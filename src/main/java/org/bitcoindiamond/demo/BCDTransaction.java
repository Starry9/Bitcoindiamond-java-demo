package org.bitcoindiamond.demo;

import org.bitcoindiamondj.core.*;
import org.bitcoindiamondj.core.Utils;
import org.bitcoindiamondj.crypto.TransactionSignature;
import org.bitcoindiamondj.params.MainNetParams;
import org.bitcoindiamondj.script.*;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class BCDTransaction {
    private static final Logger log = LoggerFactory.getLogger(BCDTransaction.class);
    // Use MainNet Network
    private static NetworkParameters params = MainNetParams.get();
    // RPC user name
    private static final String rpcUser = "bcd";
    // RPC password
    private static final String rpcPassword = "123456";
    // RPC host IP
    private static final String rpcHost = "127.0.0.1";
    // RPC port
    private static final String rpcPort = "7116";

    /**
     * Sign transaction, support P2PK and P2PKH
     * @param tx unsigned transaction
     * @param key ECKey for inputs
     */
    private static void signTransaction(Transaction tx, ECKey key) {
        for (int i = 0; i < tx.getInputs().size(); i++) {
            Script scriptPubKey = tx.getInput(i).getScriptSig();
            // sign hash
            Sha256Hash hash = tx.hashForSignature(i, scriptPubKey, Transaction.SigHash.ALL, true);
            ECKey.ECDSASignature ecdsaSignature = key.sign(hash);

            // Add signature in transaction input
            TransactionSignature txSignature = new TransactionSignature(ecdsaSignature, Transaction.SigHash.ALL, true);
            if (ScriptPattern.isP2PK(scriptPubKey)) {
                tx.getInput(i).setScriptSig(ScriptBuilder.createInputScript(txSignature));
            } else {
                if (!ScriptPattern.isP2PKH(scriptPubKey)) {
                    throw new ScriptException(ScriptError.SCRIPT_ERR_UNKNOWN_ERROR, "Unable to sign this scriptPubKey: " + scriptPubKey);
                }
                tx.getInput(i).setScriptSig(ScriptBuilder.createInputScript(txSignature, key));
            }
        }
    }

    /**
     * Broadcasts the signed transaction.
     * @param transactionRawHex transaction raw hex in string format
     */
    public static void broadcastRawTransaction(String transactionRawHex) {
        try {
            URL url = new URL("http://" + rpcUser + ':' + rpcPassword + "@" + rpcHost + ":" + rpcPort + "/");
            BitcoinJSONRPCClient bitcoinClient = new BitcoinJSONRPCClient(url);

            // Broadcast transaction
            String broadcastResult = bitcoinClient.sendRawTransaction(transactionRawHex);
            log.info("Broadcast transaction result: " + broadcastResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        // Import private key
        String prv = "Ky5wKP8XHxxXidG1TQqvisEJmrZV5C5juEPTHTm4dD5fBpoCEXU4";
        DumpedPrivateKey dumpedPrivateKey = DumpedPrivateKey.fromBase58(params, prv);
        ECKey key = dumpedPrivateKey.getKey();

        // Get address
        Address sourceAddress = Address.fromKey(params, key, Script.ScriptType.P2PKH);
        log.info("address: " + sourceAddress);
        assert (sourceAddress.toString().equals("1JWweKX2Xkhpg8JsJUL7Z7woGKD5Nr2Nua"));

        // Select UTXO
        String txid = "ce2622646cfd30bb3e1b3e76ceae1198e37bb498da875972a706c6222e69899a";
        long index = 0;

        // Send to address and amount
        String toAddr = "191asczKcfyH26b4QvcowW1W5LRCQ3BJ3u";
        Address toAddress = Address.fromString(params, toAddr);
        long toAmount = 999000;

        // Create empty bitcoindiamond transaction
        Transaction tx = new Transaction(params);

        // Add input
        Script script = ScriptBuilder.createOutputScript(sourceAddress);
        tx.addInput(Sha256Hash.wrap(txid), index, script);

        // Add output
        tx.addOutput(Coin.valueOf(toAmount), toAddress);

        // Sign
        signTransaction(tx, key);

        // Versify transaction valid
        tx.verify();

        // Serialize
        byte[] rawTransaction = tx.bitcoinSerialize();
        String hexRawTransaction = Utils.HEX.encode(rawTransaction);
        log.debug("Raw BCD tx hex: " + hexRawTransaction);

        // Deserialize
        byte[] newRawTransaction = Utils.HEX.decode(hexRawTransaction);
        Transaction newTx = new Transaction(params, newRawTransaction);
        log.debug("New transaction: " + newTx);
        String newHexRawTransaction = Utils.HEX.encode(newTx.bitcoinSerialize());
        log.debug("new transaction hex: " + newHexRawTransaction);
        assert (newHexRawTransaction.equals(hexRawTransaction));

        // Broadcast transaction over RPC
        broadcastRawTransaction(newHexRawTransaction);
    }
}
