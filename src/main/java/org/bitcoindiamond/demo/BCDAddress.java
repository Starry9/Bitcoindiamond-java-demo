package org.bitcoindiamond.demo;

import org.bitcoindiamondj.core.*;
import org.bitcoindiamondj.params.MainNetParams;
import org.bitcoindiamondj.script.Script;

public class BCDAddress {
    private static NetworkParameters params = MainNetParams.get();

    /**
     * Check address is valid
     * @param address Base58 string address
     * @return boolean
     */
    public static boolean isValidAddress(String address) {
        try {
            // Get a new Address object from import string address
            Address.fromString(params, address);
            return true;
        } catch(AddressFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Make new ECKey
        ECKey key = new ECKey();

        // Get private key
        String privateKeyWIF = key.getPrivateKeyAsWiF(params);
        System.out.println("Private key (WIF): " + privateKeyWIF);

        // Get public key
        String publicKeyHex = key.getPublicKeyAsHex();
        System.out.println("Public key hex: " + publicKeyHex);

        // Get P2PKH address
        Address addressP2PKH = Address.fromKey(params, key, Script.ScriptType.P2PKH);
        Address addressLegacy = LegacyAddress.fromKey(params, key);
        assert (addressLegacy.equals(addressP2PKH));
        System.out.println("Address(P2PKH): " + addressP2PKH);

        // Get P2WPKH address
        Address addressP2WPKH = Address.fromKey(params, key, Script.ScriptType.P2WPKH);
        System.out.println("Address(P2WPKH): " + addressP2WPKH);

        // Validate address
        boolean validRes = isValidAddress(addressP2PKH.toString());
        System.out.println("Address " + addressP2PKH + " is valid: " + validRes);
    }
}
