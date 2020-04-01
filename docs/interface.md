# Bitcoindiamond Interface

- [JSON-RPC](#json-rpc)
  * [Blockchain](#blockchain)
    + [getbestblockhash](#getbestblockhash)
    + [getblock "blockhash" ( verbosity )](#getblock-blockhash--verbosity-)
    + [getblockchaininfo](#getblockchaininfo)
    + [getblockcount](#getblockcount)
    + [getblockhash height](#getblockhash-height)
    + [getblockheader "hash" ( verbose )](#getblockheader-hash--verbose-)
    + [getblockstats hash_or_height ( stats )](#getblockstats-hash_or_height--stats-)
    + [getchaintips](#getchaintips)
    + [getchaintxstats ( nblocks blockhash )](#getchaintxstats--nblocks-blockhash-)
    + [getdifficulty](#getdifficulty)
    + [getmempoolancestors txid (verbose)](#getmempoolancestors-txid-verbose)
    + [getmempooldescendants txid (verbose)](#getmempooldescendants-txid-verbose)
    + [getmempoolentry txid](#getmempoolentry-txid)
    + [getmempoolinfo](#getmempoolinfo)
    + [getrawmempool ( verbose )](#getrawmempool--verbose-)
    + [gettxout "txid" n ( include_mempool )](#gettxout-txid-n--include_mempool-)
    + [gettxoutproof ["txid",...] ( blockhash )](#gettxoutproof-txid--blockhash-)
    + [gettxoutsetinfo](#gettxoutsetinfo)
    + [preciousblock "blockhash"](#preciousblock-blockhash)
    + [pruneblockchain](#pruneblockchain)
    + [savemempool](#savemempool)
    + [scantxoutset ( )](#scantxoutset----)
    + [verifychain ( checklevel nblocks )](#verifychain--checklevel-nblocks-)
    + [verifytxoutproof "proof"](#verifytxoutproof-proof)
  * [Control](#control)
    + [getmemoryinfo ("mode")](#getmemoryinfo-mode)
    + [help ( "command" )](#help--command-)
    + [logging ( )](#logging----)
    + [stop](#stop)
    + [uptime](#uptime)
  * [Generating](#generating)
    + [generate nblocks ( maxtries )](#generate-nblocks--maxtries-)
    + [generatetoaddress nblocks address (maxtries)](#generatetoaddress-nblocks-address-maxtries)
  * [Mining](#mining)
    + [getblocktemplate ( TemplateRequest )](#getblocktemplate--templaterequest-)
    + [getmininginfo](#getmininginfo)
    + [getnetworkhashps ( nblocks height )](#getnetworkhashps--nblocks-height-)
    + [prioritisetransaction](#prioritisetransaction---)
    + [submitblock "hexdata" ( "dummy" )](#submitblock-hexdata---dummy-)
  * [Network](#network)
    + [addnode "node" "add|remove|onetry"](#addnode-node-addremoveonetry)
    + [clearbanned](#clearbanned)
    + [disconnectnode "[address]" [nodeid]](#disconnectnode-address-nodeid)
    + [getaddednodeinfo ( "node" )](#getaddednodeinfo--node-)
    + [getconnectioncount](#getconnectioncount)
    + [getnettotals](#getnettotals)
    + [getnetworkinfo](#getnetworkinfo)
    + [getpeerinfo](#getpeerinfo)
    + [listbanned](#listbanned)
    + [ping](#ping)
    + [setban "subnet" "add|remove" (bantime) (absolute)](#setban-subnet-addremove-bantime-absolute)
    + [setnetworkactive true|false](#setnetworkactive-truefalse)
  * [Rawtransactions](#rawtransactions)
    + [combinepsbt ["psbt",...]](#combinepsbt-psbt)
    + [combinerawtransaction ["hexstring",...]](#combinerawtransaction-hexstring)
    + [converttopsbt "hexstring" ( permitsigdata iswitness )](#converttopsbt-hexstring--permitsigdata-iswitness-)
    + [createpsbt [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )](#createpsbt-txididvoutn-addressamountdatahex--locktime---replaceable-)
    + [createrawtransaction [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )](#createrawtransaction-txididvoutn-addressamountdatahex--locktime---replaceable-)
    + [decodepsbt "psbt"](#decodepsbt-psbt)
    + [decoderawtransaction "hexstring" ( iswitness )](#decoderawtransaction-hexstring--iswitness-)
    + [decodescript "hexstring"](#decodescript-hexstring)
    + [finalizepsbt "psbt" ( extract )](#finalizepsbt-psbt--extract-)
    + [fundrawtransaction "hexstring" ( options iswitness )](#fundrawtransaction-hexstring--options-iswitness-)
    + [getrawtransaction "txid" ( verbose "blockhash" )](#getrawtransaction-txid--verbose-blockhash-)
    + [sendrawtransaction "hexstring" ( allowhighfees )](#sendrawtransaction-hexstring--allowhighfees-)
    + [signrawtransaction "hexstring" ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] ["privatekey1",...] sighashtype )](#signrawtransaction-hexstring--txididvoutnscriptpubkeyhexredeemscripthex-privatekey1-sighashtype-)
    + [signrawtransactionwithkey "hexstring" ["privatekey1",...] ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] sighashtype )](#signrawtransactionwithkey-hexstring-privatekey1--txididvoutnscriptpubkeyhexredeemscripthex-sighashtype-)
    + [testmempoolaccept ["rawtxs"] ( allowhighfees )](#testmempoolaccept-rawtxs--allowhighfees-)
  * [Util](#util)
    + [createmultisig nrequired ["key",...] ( "address_type" )](#createmultisig-nrequired-key--address_type-)
    + [estimatesmartfee conf_target ("estimate_mode")](#estimatesmartfee-conf_target-estimate_mode)
    + [signmessagewithprivkey "privkey" "message"](#signmessagewithprivkey-privkey-message)
    + [validateaddress "address"](#validateaddress-address)
    + [verifymessage "address" "signature" "message"](#verifymessage-address-signature-message)
  * [Wallet](#wallet)
    + [abandontransaction "txid"](#abandontransaction-txid)
    + [abortrescan](#abortrescan)
    + [addmultisigaddress nrequired ["key",...] ( "label" "address_type" )](#addmultisigaddress-nrequired-key--label-address_type-)
    + [backupwallet "destination"](#backupwallet-destination)
    + [bumpfee "txid" ( options )](#bumpfee-txid--options-)
    + [createwallet "wallet_name" ( disable_private_keys )](#createwallet-wallet_name--disable_private_keys-)
    + [dumpprivkey "address"](#dumpprivkey-address)
    + [dumpwallet "filename"](#dumpwallet-filename)
    + [encryptwallet "passphrase"](#encryptwallet-passphrase)
    + [getaddressesbylabel "label"](#getaddressesbylabel-label)
    + [getaddressinfo "address"](#getaddressinfo-address)
    + [getbalance ( "(dummy)" minconf include_watchonly )](#getbalance--dummy-minconf-include_watchonly-)
    + [getnewaddress ( "label" "address_type" )](#getnewaddress--label-address_type-)
    + [getrawchangeaddress ( "address_type" )](#getrawchangeaddress--address_type-)
    + [getreceivedbyaddress "address" ( minconf )](#getreceivedbyaddress-address--minconf-)
    + [gettransaction "txid" ( include_watchonly )](#gettransaction-txid--include_watchonly-)
    + [getunconfirmedbalance](#getunconfirmedbalance)
    + [getwalletinfo](#getwalletinfo)
    + [importaddress "address" ( "label" rescan p2sh )](#importaddress-address--label-rescan-p2sh-)
    + [importmulti "requests" ( "options" )](#importmulti-requests--options-)
    + [importprivkey "privkey" ( "label" ) ( rescan )](#importprivkey-privkey--label---rescan-)
    + [importprunedfunds](#importprunedfunds)
    + [importpubkey "pubkey" ( "label" rescan )](#importpubkey-pubkey--label-rescan-)
    + [importwallet "filename"](#importwallet-filename)
    + [keypoolrefill ( newsize )](#keypoolrefill--newsize-)
    + [listaddressgroupings](#listaddressgroupings)
    + [listlabels ( "purpose" )](#listlabels--purpose-)
    + [listlockunspent](#listlockunspent)
    + [listreceivedbyaddress ( minconf include_empty include_watchonly address_filter )](#listreceivedbyaddress--minconf-include_empty-include_watchonly-address_filter-)
    + [listsinceblock ( "blockhash" target_confirmations include_watchonly include_removed )](#listsinceblock--blockhash-target_confirmations-include_watchonly-include_removed-)
    + [listtransactions (label count skip include_watchonly)](#listtransactions-label-count-skip-include_watchonly)
    + [listunspent ( minconf maxconf ["addresses",...] [include_unsafe] [query_options])](#listunspent--minconf-maxconf--addresses-include_unsafe-query_options)
    + [listwallets](#listwallets)
    + [loadwallet "filename"](#loadwallet-filename)
    + [lockunspent unlock ([{"txid":"txid","vout":n},...])](#lockunspent-unlock-txidtxidvoutn)
    + [removeprunedfunds "txid"](#removeprunedfunds-txid)
    + [rescanblockchain ("start_height") ("stop_height")](#rescanblockchain-start_height-stop_height)
    + [sendmany "" {"address":amount,...} ( minconf "comment" ["address",...] replaceable conf_target "estimate_mode")](#sendmany--addressamount--minconf-comment-address-replaceable-conf_target-estimate_mode)
    + [sendtoaddress "address" amount ( "comment" "comment_to" subtractfeefromamount replaceable conf_target "estimate_mode")](#sendtoaddress-address-amount--comment-comment_to-subtractfeefromamount-replaceable-conf_target-estimate_mode)
    + [sethdseed ( "newkeypool" "seed" )](#sethdseed--newkeypool-seed-)
    + [settxfee amount](#settxfee-amount)
    + [signmessage "address" "message"](#signmessage-address-message)
    + [signrawtransactionwithwallet "hexstring" ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] sighashtype )](#signrawtransactionwithwallet-hexstring--txididvoutnscriptpubkeyhexredeemscripthex-sighashtype-)
    + [unloadwallet ( "wallet_name" )](#unloadwallet--wallet_name-)
    + [walletcreatefundedpsbt [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable ) ( options bip32derivs )](#walletcreatefundedpsbt-txididvoutn-addressamountdatahex--locktime---replaceable---options-bip32derivs-)
    + [walletlock](#walletlock)
    + [walletpassphrase "passphrase" timeout](#walletpassphrase-passphrase-timeout)
    + [walletpassphrasechange "oldpassphrase" "newpassphrase"](#walletpassphrasechange-oldpassphrase-newpassphrase)
    + [walletprocesspsbt "psbt" ( sign "sighashtype" bip32derivs )](#walletprocesspsbt-psbt--sign-sighashtype-bip32derivs-)
  * [Zmq](#zmq)
    + [getzmqnotifications](#getzmqnotifications)
- [REST Interface](#rest-interface)
  * [Transactions](#transactions)
  * [Blocks](#blocks)
  * [Blockheaders](#blockheaders)
  * [Chaininfos](#chaininfos)
  * [Query UTXO set](#query-utxo-set)
  * [Memory pool](#memory-pool)


## JSON-RPC 

### Blockchain

#### getbestblockhash

Returns the hash of the best (tip) block in the longest blockchain.

Result:
"hex"      (string) the block hash hex encoded

Examples:
> bitcoindiamond-cli getbestblockhash
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getbestblockhash", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblock "blockhash" ( verbosity )

If verbosity is 0, returns a string that is serialized, hex-encoded data for block 'hash'.
If verbosity is 1, returns an Object with information about block <hash>.
If verbosity is 2, returns an Object with information about block <hash> and information about each transaction.

Arguments:
1. "blockhash"          (string, required) The block hash
2. verbosity              (numeric, optional, default=1) 0 for hex encoded data, 1 for a json object, and 2 for json object with transaction data

Result (for verbosity = 0):
"data"             (string) A string that is serialized, hex-encoded data for block 'hash'.

Result (for verbosity = 1):
{
  "hash" : "hash",     (string) the block hash (same as provided)
  "confirmations" : n,   (numeric) The number of confirmations, or -1 if the block is not on the main chain
  "size" : n,            (numeric) The block size
  "strippedsize" : n,    (numeric) The block size excluding witness data
  "weight" : n           (numeric) The block weight as defined in BIP 141
  "height" : n,          (numeric) The block height or index
  "version" : n,         (numeric) The block version
  "versionHex" : "00000000", (string) The block version formatted in hexadecimal
  "merkleroot" : "xxxx", (string) The merkle root
  "tx" : [               (array of string) The transaction ids
     "transactionid"     (string) The transaction id
     ,...
  ],
  "time" : ttt,          (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
  "mediantime" : ttt,    (numeric) The median block time in seconds since epoch (Jan 1 1970 GMT)
  "nonce" : n,           (numeric) The nonce
  "bits" : "1d00ffff", (string) The bits
  "difficulty" : x.xxx,  (numeric) The difficulty
  "chainwork" : "xxxx",  (string) Expected number of hashes required to produce the chain up to this block (in hex)
  "nTx" : n,             (numeric) The number of transactions in the block.
  "previousblockhash" : "hash",  (string) The hash of the previous block
  "nextblockhash" : "hash"       (string) The hash of the next block
}

Result (for verbosity = 2):
{
  ...,                     Same output as verbosity = 1.
  "tx" : [               (array of Objects) The transactions in the format of the getrawtransaction RPC. Different from verbosity = 1 "tx" result.
         ,...
  ],
  ,...                     Same output as verbosity = 1.
}

Examples:
> bitcoindiamond-cli getblock "00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblock", "params": ["00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblockchaininfo

Returns an object containing various state info regarding blockchain processing.

Result:
{
  "chain": "xxxx",              (string) current network name as defined in BIP70 (main, test, regtest)
  "blocks": xxxxxx,             (numeric) the current number of blocks processed in the server
  "headers": xxxxxx,            (numeric) the current number of headers we have validated
  "bestblockhash": "...",       (string) the hash of the currently best block
  "difficulty": xxxxxx,         (numeric) the current difficulty
  "mediantime": xxxxxx,         (numeric) median time for the current best block
  "verificationprogress": xxxx, (numeric) estimate of verification progress [0..1]
  "initialblockdownload": xxxx, (bool) (debug information) estimate of whether this node is in Initial Block Download mode.
  "chainwork": "xxxx"           (string) total amount of work in active chain, in hexadecimal
  "size_on_disk": xxxxxx,       (numeric) the estimated size of the block and undo files on disk
  "pruned": xx,                 (boolean) if the blocks are subject to pruning
  "pruneheight": xxxxxx,        (numeric) lowest-height complete block stored (only present if pruning is enabled)
  "automatic_pruning": xx,      (boolean) whether automatic pruning is enabled (only present if pruning is enabled)
  "prune_target_size": xxxxxx,  (numeric) the target size used by pruning (only present if automatic pruning is enabled)
  "softforks": [                (array) status of softforks in progress
     {
        "id": "xxxx",           (string) name of softfork
        "version": xx,          (numeric) block version
        "reject": {             (object) progress toward rejecting pre-softfork blocks
           "status": xx,        (boolean) true if threshold reached
        },
     }, ...
  ],
  "bip9_softforks": {           (object) status of BIP9 softforks in progress
     "xxxx" : {                 (string) name of the softfork
        "status": "xxxx",       (string) one of "defined", "started", "locked_in", "active", "failed"
        "bit": xx,              (numeric) the bit (0-28) in the block version field used to signal this softfork (only for "started" status)
        "startTime": xx,        (numeric) the minimum median time past of a block at which the bit gains its meaning
        "timeout": xx,          (numeric) the median time past of a block at which the deployment is considered failed if not yet locked in
        "since": xx,            (numeric) height of the first block to which the status applies
        "statistics": {         (object) numeric statistics about BIP9 signalling for a softfork (only for "started" status)
           "period": xx,        (numeric) the length in blocks of the BIP9 signalling period
           "threshold": xx,     (numeric) the number of blocks with the version bit set required to activate the feature
           "elapsed": xx,       (numeric) the number of blocks elapsed since the beginning of the current period
           "count": xx,         (numeric) the number of blocks with the version bit set in the current period
           "possible": xx       (boolean) returns false if there are not enough blocks left in this period to pass activation threshold
        }
     }
  }
  "warnings" : "...",           (string) any network and blockchain warnings.
}

Examples:
> bitcoindiamond-cli getblockchaininfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockchaininfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblockcount

Returns the number of blocks in the longest blockchain.

Result:
n    (numeric) The current block count

Examples:
> bitcoindiamond-cli getblockcount
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockcount", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblockhash height

Returns hash of block in best-block-chain at height provided.

Arguments:
1. height         (numeric, required) The height index

Result:
"hash"         (string) The block hash

Examples:
> bitcoindiamond-cli getblockhash 1000
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockhash", "params": [1000] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblockheader "hash" ( verbose )

If verbose is false, returns a string that is serialized, hex-encoded data for blockheader 'hash'.
If verbose is true, returns an Object with information about blockheader <hash>.

Arguments:
1. "hash"          (string, required) The block hash
2. verbose           (boolean, optional, default=true) true for a json object, false for the hex encoded data

Result (for verbose = true):
{
  "hash" : "hash",     (string) the block hash (same as provided)
  "confirmations" : n,   (numeric) The number of confirmations, or -1 if the block is not on the main chain
  "height" : n,          (numeric) The block height or index
  "version" : n,         (numeric) The block version
  "versionHex" : "00000000", (string) The block version formatted in hexadecimal
  "merkleroot" : "xxxx", (string) The merkle root
  "time" : ttt,          (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
  "mediantime" : ttt,    (numeric) The median block time in seconds since epoch (Jan 1 1970 GMT)
  "nonce" : n,           (numeric) The nonce
  "bits" : "1d00ffff", (string) The bits
  "difficulty" : x.xxx,  (numeric) The difficulty
  "chainwork" : "0000...1f3"     (string) Expected number of hashes required to produce the current chain (in hex)
  "nTx" : n,             (numeric) The number of transactions in the block.
  "previousblockhash" : "hash",  (string) The hash of the previous block
  "nextblockhash" : "hash",      (string) The hash of the next block
}

Result (for verbose=false):
"data"             (string) A string that is serialized, hex-encoded data for block 'hash'.

Examples:
> bitcoindiamond-cli getblockheader "00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockheader", "params": ["00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getblockstats hash_or_height ( stats )

Compute per block statistics for a given window. All amounts are in satoshis.
It won't work for some heights with pruning.
It won't work without -txindex for utxo_size_inc, *fee or *feerate stats.

Arguments:
1. "hash_or_height"     (string or numeric, required) The block hash or height of the target block
2. "stats"              (array,  optional) Values to plot, by default all values (see result below)
    [
      "height",         (string, optional) Selected statistic
      "time",           (string, optional) Selected statistic
      ,...
    ]

Result:
{                           (json object)
  "avgfee": xxxxx,          (numeric) Average fee in the block
  "avgfeerate": xxxxx,      (numeric) Average feerate (in satoshis per virtual byte)
  "avgtxsize": xxxxx,       (numeric) Average transaction size
  "blockhash": xxxxx,       (string) The block hash (to check for potential reorgs)
  "feerate_percentiles": [  (array of numeric) Feerates at the 10th, 25th, 50th, 75th, and 90th percentile weight unit (in satoshis per virtual byte)
      "10th_percentile_feerate",      (numeric) The 10th percentile feerate
      "25th_percentile_feerate",      (numeric) The 25th percentile feerate
      "50th_percentile_feerate",      (numeric) The 50th percentile feerate
      "75th_percentile_feerate",      (numeric) The 75th percentile feerate
      "90th_percentile_feerate",      (numeric) The 90th percentile feerate
  ],
  "height": xxxxx,          (numeric) The height of the block
  "ins": xxxxx,             (numeric) The number of inputs (excluding coinbase)
  "maxfee": xxxxx,          (numeric) Maximum fee in the block
  "maxfeerate": xxxxx,      (numeric) Maximum feerate (in satoshis per virtual byte)
  "maxtxsize": xxxxx,       (numeric) Maximum transaction size
  "medianfee": xxxxx,       (numeric) Truncated median fee in the block
  "mediantime": xxxxx,      (numeric) The block median time past
  "mediantxsize": xxxxx,    (numeric) Truncated median transaction size
  "minfee": xxxxx,          (numeric) Minimum fee in the block
  "minfeerate": xxxxx,      (numeric) Minimum feerate (in satoshis per virtual byte)
  "mintxsize": xxxxx,       (numeric) Minimum transaction size
  "outs": xxxxx,            (numeric) The number of outputs
  "subsidy": xxxxx,         (numeric) The block subsidy
  "swtotal_size": xxxxx,    (numeric) Total size of all segwit transactions
  "swtotal_weight": xxxxx,  (numeric) Total weight of all segwit transactions divided by segwit scale factor (4)
  "swtxs": xxxxx,           (numeric) The number of segwit transactions
  "time": xxxxx,            (numeric) The block time
  "total_out": xxxxx,       (numeric) Total amount in all outputs (excluding coinbase and thus reward [ie subsidy + totalfee])
  "total_size": xxxxx,      (numeric) Total size of all non-coinbase transactions
  "total_weight": xxxxx,    (numeric) Total weight of all non-coinbase transactions divided by segwit scale factor (4)
  "totalfee": xxxxx,        (numeric) The fee total
  "txs": xxxxx,             (numeric) The number of transactions (excluding coinbase)
  "utxo_increase": xxxxx,   (numeric) The increase/decrease in the number of unspent outputs
  "utxo_size_inc": xxxxx,   (numeric) The increase/decrease in size for the utxo index (not discounting op_return and similar)
}

Examples:
> bitcoindiamond-cli getblockstats 1000 '["minfeerate","avgfeerate"]'
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblockstats", "params": [1000 '["minfeerate","avgfeerate"]'] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getchaintips

Return information about all known tips in the block tree, including the main chain as well as orphaned branches.

Result:
[
  {
    "height": xxxx,         (numeric) height of the chain tip
    "hash": "xxxx",         (string) block hash of the tip
    "branchlen": 0          (numeric) zero for main chain
    "status": "active"      (string) "active" for the main chain
  },
  {
    "height": xxxx,
    "hash": "xxxx",
    "branchlen": 1          (numeric) length of branch connecting the tip to the main chain
    "status": "xxxx"        (string) status of the chain (active, valid-fork, valid-headers, headers-only, invalid)
  }
]
Possible values for status:
1.  "invalid"               This branch contains at least one invalid block
2.  "headers-only"          Not all blocks for this branch are available, but the headers are valid
3.  "valid-headers"         All blocks are available for this branch, but they were never fully validated
4.  "valid-fork"            This branch is not part of the active chain, but is fully validated
5.  "active"                This is the tip of the active main chain, which is certainly valid

Examples:
> bitcoindiamond-cli getchaintips
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getchaintips", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getchaintxstats ( nblocks blockhash )

Compute statistics about the total number and rate of transactions in the chain.

Arguments:
1. nblocks      (numeric, optional) Size of the window in number of blocks (default: one month).
2. "blockhash"  (string, optional) The hash of the block that ends the window.

Result:
{
  "time": xxxxx,                         (numeric) The timestamp for the final block in the window in UNIX format.
  "txcount": xxxxx,                      (numeric) The total number of transactions in the chain up to that point.
  "window_final_block_hash": "...",      (string) The hash of the final block in the window.
  "window_block_count": xxxxx,           (numeric) Size of the window in number of blocks.
  "window_tx_count": xxxxx,              (numeric) The number of transactions in the window. Only returned if "window_block_count" is > 0.
  "window_interval": xxxxx,              (numeric) The elapsed time in the window in seconds. Only returned if "window_block_count" is > 0.
  "txrate": x.xx,                        (numeric) The average rate of transactions per second in the window. Only returned if "window_interval" is > 0.
}

Examples:
> bitcoindiamond-cli getchaintxstats
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getchaintxstats", "params": [2016] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getdifficulty

Returns the proof-of-work difficulty as a multiple of the minimum difficulty.

Result:
n.nnn       (numeric) the proof-of-work difficulty as a multiple of the minimum difficulty.

Examples:
> bitcoindiamond-cli getdifficulty
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getdifficulty", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getmempoolancestors txid (verbose)

If txid is in the mempool, returns all in-mempool ancestors.

Arguments:
1. "txid"                 (string, required) The transaction id (must be in mempool)
2. verbose                  (boolean, optional, default=false) True for a json object, false for array of transaction ids

Result (for verbose=false):
[                       (json array of strings)
  "transactionid"           (string) The transaction id of an in-mempool ancestor transaction
  ,...
]

Result (for verbose=true):
{                           (json object)
  "transactionid" : {       (json object)
    "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
    "fee" : n,              (numeric) transaction fee in BCD (DEPRECATED)
    "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
    "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
    "height" : n,           (numeric) block height when transaction entered pool
    "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
    "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
    "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
    "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
    "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
    "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
    "wtxid" : hash,         (string) hash of serialized transaction, including witness data
    "fees" : {
        "base" : n,         (numeric) transaction fee in BCD
        "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BCD
        "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BCD
        "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BCD
    }
    "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
        "transactionid",    (string) parent transaction id
       ... ]
    "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
        "transactionid",    (string) child transaction id
       ... ]
  }, ...
}

Examples:
> bitcoindiamond-cli getmempoolancestors "mytxid"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolancestors", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getmempooldescendants txid (verbose)

If txid is in the mempool, returns all in-mempool descendants.

Arguments:
1. "txid"                 (string, required) The transaction id (must be in mempool)
2. verbose                  (boolean, optional, default=false) True for a json object, false for array of transaction ids

Result (for verbose=false):
[                       (json array of strings)
  "transactionid"           (string) The transaction id of an in-mempool descendant transaction
  ,...
]

Result (for verbose=true):
{                           (json object)
  "transactionid" : {       (json object)
    "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
    "fee" : n,              (numeric) transaction fee in BCD (DEPRECATED)
    "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
    "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
    "height" : n,           (numeric) block height when transaction entered pool
    "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
    "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
    "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
    "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
    "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
    "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
    "wtxid" : hash,         (string) hash of serialized transaction, including witness data
    "fees" : {
        "base" : n,         (numeric) transaction fee in BCD
        "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BCD
        "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BCD
        "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BCD
    }
    "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
        "transactionid",    (string) parent transaction id
       ... ]
    "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
        "transactionid",    (string) child transaction id
       ... ]
  }, ...
}

Examples:
> bitcoindiamond-cli getmempooldescendants "mytxid"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempooldescendants", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getmempoolentry txid

Returns mempool data for given transaction

Arguments:
1. "txid"                   (string, required) The transaction id (must be in mempool)

Result:
{                           (json object)
    "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
    "fee" : n,              (numeric) transaction fee in BCD (DEPRECATED)
    "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
    "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
    "height" : n,           (numeric) block height when transaction entered pool
    "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
    "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
    "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
    "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
    "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
    "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
    "wtxid" : hash,         (string) hash of serialized transaction, including witness data
    "fees" : {
        "base" : n,         (numeric) transaction fee in BCD
        "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BCD
        "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BCD
        "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BCD
    }
    "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
        "transactionid",    (string) parent transaction id
       ... ]
    "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
        "transactionid",    (string) child transaction id
       ... ]
}

Examples:
> bitcoindiamond-cli getmempoolentry "mytxid"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolentry", "params": ["mytxid"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getmempoolinfo

Returns details on the active state of the TX memory pool.

Result:
{
  "size": xxxxx,               (numeric) Current tx count
  "bytes": xxxxx,              (numeric) Sum of all virtual transaction sizes as defined in BIP 141. Differs from actual serialized size because witness data is discounted
  "usage": xxxxx,              (numeric) Total memory usage for the mempool
  "maxmempool": xxxxx,         (numeric) Maximum memory usage for the mempool
  "mempoolminfee": xxxxx       (numeric) Minimum fee rate in BCD/kB for tx to be accepted. Is the maximum of minrelaytxfee and minimum mempool fee
  "minrelaytxfee": xxxxx       (numeric) Current minimum relay fee for transactions
}

Examples:
> bitcoindiamond-cli getmempoolinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmempoolinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getrawmempool ( verbose )

Returns all transaction ids in memory pool as a json array of string transaction ids.

Hint: use getmempoolentry to fetch a specific transaction from the mempool.

Arguments:
1. verbose (boolean, optional, default=false) True for a json object, false for array of transaction ids

Result: (for verbose = false):
[                     (json array of string)
  "transactionid"     (string) The transaction id
  ,...
]

Result: (for verbose = true):
{                           (json object)
  "transactionid" : {       (json object)
    "size" : n,             (numeric) virtual transaction size as defined in BIP 141. This is different from actual serialized size for witness transactions as witness data is discounted.
    "fee" : n,              (numeric) transaction fee in BCD (DEPRECATED)
    "modifiedfee" : n,      (numeric) transaction fee with fee deltas used for mining priority (DEPRECATED)
    "time" : n,             (numeric) local time transaction entered pool in seconds since 1 Jan 1970 GMT
    "height" : n,           (numeric) block height when transaction entered pool
    "descendantcount" : n,  (numeric) number of in-mempool descendant transactions (including this one)
    "descendantsize" : n,   (numeric) virtual transaction size of in-mempool descendants (including this one)
    "descendantfees" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) (DEPRECATED)
    "ancestorcount" : n,    (numeric) number of in-mempool ancestor transactions (including this one)
    "ancestorsize" : n,     (numeric) virtual transaction size of in-mempool ancestors (including this one)
    "ancestorfees" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) (DEPRECATED)
    "wtxid" : hash,         (string) hash of serialized transaction, including witness data
    "fees" : {
        "base" : n,         (numeric) transaction fee in BCD
        "modified" : n,     (numeric) transaction fee with fee deltas used for mining priority in BCD
        "ancestor" : n,     (numeric) modified fees (see above) of in-mempool ancestors (including this one) in BCD
        "descendant" : n,   (numeric) modified fees (see above) of in-mempool descendants (including this one) in BCD
    }
    "depends" : [           (array) unconfirmed transactions used as inputs for this transaction
        "transactionid",    (string) parent transaction id
       ... ]
    "spentby" : [           (array) unconfirmed transactions spending outputs from this transaction
        "transactionid",    (string) child transaction id
       ... ]
  }, ...
}

Examples:
> bitcoindiamond-cli getrawmempool true
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrawmempool", "params": [true] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### gettxout "txid" n ( include_mempool )

Returns details about an unspent transaction output.

Arguments:
1. "txid"             (string, required) The transaction id
2. "n"                (numeric, required) vout number
3. "include_mempool"  (boolean, optional) Whether to include the mempool. Default: true.     Note that an unspent output that is spent in the mempool won't appear.

Result:
{
  "bestblock":  "hash",    (string) The hash of the block at the tip of the chain
  "confirmations" : n,       (numeric) The number of confirmations
  "value" : x.xxx,           (numeric) The transaction value in BCD
  "scriptPubKey" : {         (json object)
     "asm" : "code",       (string)
     "hex" : "hex",        (string)
     "reqSigs" : n,          (numeric) Number of required signatures
     "type" : "pubkeyhash", (string) The type, eg pubkeyhash
     "addresses" : [          (array of string) array of bitcoindiamond addresses
        "address"     (string) bitcoindiamond address
        ,...
     ]
  },
  "coinbase" : true|false   (boolean) Coinbase or not
}

Examples:

Get unspent transactions
> bitcoindiamond-cli listunspent

View the details
> bitcoindiamond-cli gettxout "txid" 1

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "gettxout", "params": ["txid", 1] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### gettxoutproof ["txid",...] ( blockhash )

Returns a hex-encoded proof that "txid" was included in a block.

NOTE: By default this function only works sometimes. This is when there is an
unspent output in the utxo for this transaction. To make it always work,
you need to maintain a transaction index, using the -txindex command line option or
specify the block in which the transaction is included manually (by blockhash).

Arguments:
1. "txids"       (string) A json array of txids to filter
    [
      "txid"     (string) A transaction hash
      ,...
    ]
2. "blockhash"   (string, optional) If specified, looks for txid in the block with this hash

Result:
"data"           (string) A string that is a serialized, hex-encoded data for the proof.

#### gettxoutsetinfo

Returns statistics about the unspent transaction output set.
Note this call may take some time.

Result:
{
  "height":n,     (numeric) The current block height (index)
  "bestblock": "hex",   (string) The hash of the block at the tip of the chain
  "transactions": n,      (numeric) The number of transactions with unspent outputs
  "txouts": n,            (numeric) The number of unspent transaction outputs
  "bogosize": n,          (numeric) A meaningless metric for UTXO set size
  "hash_serialized_2": "hash", (string) The serialized hash
  "disk_size": n,         (numeric) The estimated size of the chainstate on disk
  "total_amount": x.xxx          (numeric) The total amount
}

Examples:
> bitcoindiamond-cli gettxoutsetinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "gettxoutsetinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### preciousblock "blockhash"

Treats a block as if it were received before others with the same work.

A later preciousblock call can override the effect of an earlier one.

The effects of preciousblock are not retained across restarts.

Arguments:
1. "blockhash"   (string, required) the hash of the block to mark as precious

Result:

Examples:
> bitcoindiamond-cli preciousblock "blockhash"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "preciousblock", "params": ["blockhash"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### pruneblockchain

Arguments:
1. "height"       (numeric, required) The block height to prune up to. May be set to a discrete height, or a unix timestamp
                  to prune blocks whose block time is at least 2 hours older than the provided timestamp.

Result:
n    (numeric) Height of the last block pruned.

Examples:
> bitcoindiamond-cli pruneblockchain 1000
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "pruneblockchain", "params": [1000] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### savemempool

Dumps the mempool to disk. It will fail until the previous dump is fully loaded.

Examples:
> bitcoindiamond-cli savemempool
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "savemempool", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### scantxoutset <action> ( <scanobjects> )

EXPERIMENTAL warning: this call may be removed or changed in future releases.

Scans the unspent transaction output set for entries that match certain output descriptors.
Examples of output descriptors are:
    addr(<address>)                      Outputs whose scriptPubKey corresponds to the specified address (does not include P2PK)
    raw(<hex script>)                    Outputs whose scriptPubKey equals the specified hex scripts
    combo(<pubkey>)                      P2PK, P2PKH, P2WPKH, and P2SH-P2WPKH outputs for the given pubkey
    pkh(<pubkey>)                        P2PKH outputs for the given pubkey
    sh(multi(<n>,<pubkey>,<pubkey>,...)) P2SH-multisig outputs for the given threshold and pubkeys

In the above, <pubkey> either refers to a fixed public key in hexadecimal notation, or to an xpub/xprv optionally followed by one
or more path elements separated by "/", and optionally ending in "/*" (unhardened), or "/*'" or "/*h" (hardened) to specify all
unhardened or hardened child keys.
In the latter case, a range needs to be specified by below if different from 1000.
For more information on output descriptors, see the documentation in the doc/descriptors.md file.

Arguments:
1. "action"                       (string, required) The action to execute
                                      "start" for starting a scan
                                      "abort" for aborting the current scan (returns true when abort was successful)
                                      "status" for progress report (in %) of the current scan
2. "scanobjects"                  (array, required) Array of scan objects
    [                             Every scan object is either a string descriptor or an object:
        "descriptor",             (string, optional) An output descriptor
        {                         (object, optional) An object with output descriptor and metadata
          "desc": "descriptor",   (string, required) An output descriptor
          "range": n,             (numeric, optional) Up to what child index HD chains should be explored (default: 1000)
        },
        ...
    ]

Result:
{
  "unspents": [
    {
    "txid" : "transactionid",     (string) The transaction id
    "vout": n,                    (numeric) the vout value
    "scriptPubKey" : "script",    (string) the script key
    "amount" : x.xxx,             (numeric) The total amount in BCD of the unspent output
    "height" : n,                 (numeric) Height of the unspent transaction output
   }
   ,...],
 "total_amount" : x.xxx,          (numeric) The total amount of all found unspent outputs in BCD
]

#### verifychain ( checklevel nblocks )

Verifies blockchain database.

Arguments:
1. checklevel   (numeric, optional, 0-4, default=3) How thorough the block verification is.
2. nblocks      (numeric, optional, default=6, 0=all) The number of blocks to check.

Result:
true|false       (boolean) Verified or not

Examples:
> bitcoindiamond-cli verifychain
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "verifychain", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### verifytxoutproof "proof"

Verifies that a proof points to a transaction in a block, returning the transaction it commits to
and throwing an RPC error if the block is not in our best chain

Arguments:
1. "proof"    (string, required) The hex-encoded proof generated by gettxoutproof

Result:
["txid"]      (array, strings) The txid(s) which the proof commits to, or empty array if the proof can not be validated.

### Control

#### getmemoryinfo ("mode")

Returns an object containing information about memory usage.
Arguments:
1. "mode" determines what kind of information is returned. This argument is optional, the default mode is "stats".
  - "stats" returns general statistics about memory usage in the daemon.
  - "mallocinfo" returns an XML string describing low-level heap state (only available if compiled with glibc 2.10+).

Result (mode "stats"):
{
  "locked": {               (json object) Information about locked memory manager
    "used": xxxxx,          (numeric) Number of bytes used
    "free": xxxxx,          (numeric) Number of bytes available in current arenas
    "total": xxxxxxx,       (numeric) Total number of bytes managed
    "locked": xxxxxx,       (numeric) Amount of bytes that succeeded locking. If this number is smaller than total, locking pages failed at some point and key data could be swapped to disk.
    "chunks_used": xxxxx,   (numeric) Number allocated chunks
    "chunks_free": xxxxx,   (numeric) Number unused chunks
  }
}

Result (mode "mallocinfo"):
"<malloc version="1">..."

Examples:
> bitcoindiamond-cli getmemoryinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmemoryinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### help ( "command" )

List all commands, or get help for a specified command.

Arguments:
1. "command"     (string, optional) The command to get help on

Result:
"text"     (string) The help text

#### logging ( <include> <exclude> )

Gets and sets the logging configuration.
When called without an argument, returns the list of categories with status that are currently being debug logged or not.
When called with arguments, adds or removes categories from debug logging and return the lists above.
The arguments are evaluated in order "include", "exclude".
If an item is both included and excluded, it will thus end up being excluded.
The valid logging categories are: net, tor, mempool, http, bench, zmq, db, rpc, estimatefee, addrman, selectcoins, reindex, cmpctblock, rand, prune, proxy, mempoolrej, libevent, coindb, qt, leveldb
In addition, the following are available as category names with special meanings:
  - "all",  "1" : represent all logging categories.
  - "none", "0" : even if other logging categories are specified, ignore all of them.

Arguments:
1. "include"        (array of strings, optional) A json array of categories to add debug logging
     [
       "category"   (string) the valid logging category
       ,...
     ]
2. "exclude"        (array of strings, optional) A json array of categories to remove debug logging
     [
       "category"   (string) the valid logging category
       ,...
     ]

Result:
{                   (json object where keys are the logging categories, and values indicates its status
  "category": 0|1,  (numeric) if being debug logged or not. 0:inactive, 1:active
  ...
}

Examples:
> bitcoindiamond-cli logging "[\"all\"]" "[\"http\"]"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "logging", "params": [["all"], "[libevent]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### stop

Stop Bitcoindiamond server.

#### uptime

Returns the total uptime of the server.

Result:
ttt        (numeric) The number of seconds that the server has been running

Examples:
> bitcoindiamond-cli uptime
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "uptime", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

### Generating 

#### generate nblocks ( maxtries )

Mine up to nblocks blocks immediately (before the RPC call returns) to an address in the wallet.

Arguments:
1. nblocks      (numeric, required) How many blocks are generated immediately.
2. maxtries     (numeric, optional) How many iterations to try (default = 1000000).

Result:
[ blockhashes ]     (array) hashes of blocks generated

Examples:

Generate 11 blocks

> bitcoindiamond-cli generate 11

#### generatetoaddress nblocks address (maxtries)

Mine blocks immediately to a specified address (before the RPC call returns)

Arguments:
1. nblocks      (numeric, required) How many blocks are generated immediately.
2. address      (string, required) The address to send the newly generated bitcoindiamond to.
3. maxtries     (numeric, optional) How many iterations to try (default = 1000000).

Result:
[ blockhashes ]     (array) hashes of blocks generated

Examples:

Generate 11 blocks to myaddress

> bitcoindiamond-cli generatetoaddress 11 "myaddress"

### Mining

#### getblocktemplate ( TemplateRequest )

If the request parameters include a 'mode' key, that is used to explicitly select between the default 'template' request or a 'proposal'.
It returns data needed to construct a block to work on.
For full specification, see BIPs 22, 23, 9, and 145:
    https://github.com/bitcoin/bips/blob/master/bip-0022.mediawiki
    https://github.com/bitcoin/bips/blob/master/bip-0023.mediawiki
    https://github.com/bitcoin/bips/blob/master/bip-0009.mediawiki#getblocktemplate_changes
    https://github.com/bitcoin/bips/blob/master/bip-0145.mediawiki

Arguments:
1. template_request         (json object, optional) A json object in the following spec
     {
       "mode":"template"    (string, optional) This must be set to "template", "proposal" (see BIP 23), or omitted
       "capabilities":[     (array, optional) A list of strings
           "support"          (string) client side supported feature, 'longpoll', 'coinbasetxn', 'coinbasevalue', 'proposal', 'serverlist', 'workid'
           ,...
       ],
       "rules":[            (array, optional) A list of strings
           "support"          (string) client side supported softfork deployment
           ,...
       ]
     }


Result:
{
  "version" : n,                    (numeric) The preferred block version
  "rules" : [ "rulename", ... ],    (array of strings) specific block rules that are to be enforced
  "vbavailable" : {                 (json object) set of pending, supported versionbit (BIP 9) softfork deployments
      "rulename" : bitnumber          (numeric) identifies the bit number as indicating acceptance and readiness for the named softfork rule
      ,...
  },
  "vbrequired" : n,                 (numeric) bit mask of versionbits the server requires set in submissions
  "previousblockhash" : "xxxx",     (string) The hash of current highest block
  "transactions" : [                (array) contents of non-coinbase transactions that should be included in the next block
      {
         "data" : "xxxx",             (string) transaction data encoded in hexadecimal (byte-for-byte)
         "txid" : "xxxx",             (string) transaction id encoded in little-endian hexadecimal
         "hash" : "xxxx",             (string) hash encoded in little-endian hexadecimal (including witness data)
         "depends" : [                (array) array of numbers
             n                          (numeric) transactions before this one (by 1-based index in 'transactions' list) that must be present in the final block if this one is
             ,...
         ],
         "fee": n,                    (numeric) difference in value between transaction inputs and outputs (in satoshis); for coinbase transactions, this is a negative Number of the total collected block fees (ie, not including the block subsidy); if key is not present, fee is unknown and clients MUST NOT assume there isn't one
         "sigops" : n,                (numeric) total SigOps cost, as counted for purposes of block limits; if key is not present, sigop cost is unknown and clients MUST NOT assume it is zero
         "weight" : n,                (numeric) total transaction weight, as counted for purposes of block limits
      }
      ,...
  ],
  "coinbaseaux" : {                 (json object) data that should be included in the coinbase's scriptSig content
      "flags" : "xx"                  (string) key name is to be ignored, and value included in scriptSig
  },
  "coinbasevalue" : n,              (numeric) maximum allowable input to coinbase transaction, including the generation award and transaction fees (in satoshis)
  "coinbasetxn" : { ... },          (json object) information for coinbase transaction
  "target" : "xxxx",                (string) The hash target
  "mintime" : xxx,                  (numeric) The minimum timestamp appropriate for next block time in seconds since epoch (Jan 1 1970 GMT)
  "mutable" : [                     (array of string) list of ways the block template may be changed
     "value"                          (string) A way the block template may be changed, e.g. 'time', 'transactions', 'prevblock'
     ,...
  ],
  "noncerange" : "00000000ffffffff",(string) A range of valid nonces
  "sigoplimit" : n,                 (numeric) limit of sigops in blocks
  "sizelimit" : n,                  (numeric) limit of block size
  "weightlimit" : n,                (numeric) limit of block weight
  "curtime" : ttt,                  (numeric) current timestamp in seconds since epoch (Jan 1 1970 GMT)
  "bits" : "xxxxxxxx",              (string) compressed target of next block
  "height" : n                      (numeric) The height of the next block
}

Examples:
> bitcoindiamond-cli getblocktemplate {"rules": ["segwit"]}
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getblocktemplate", "params": [{"rules": ["segwit"]}] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getmininginfo

Returns a json object containing mining-related information.
Result:
{
  "blocks": nnn,             (numeric) The current block
  "currentblockweight": nnn, (numeric) The last block weight
  "currentblocktx": nnn,     (numeric) The last block transaction
  "difficulty": xxx.xxxxx    (numeric) The current difficulty
  "networkhashps": nnn,      (numeric) The network hashes per second
  "pooledtx": n              (numeric) The size of the mempool
  "chain": "xxxx",           (string) current network name as defined in BIP70 (main, test, regtest)
  "warnings": "..."          (string) any network and blockchain warnings
}

Examples:
> bitcoindiamond-cli getmininginfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getmininginfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getnetworkhashps ( nblocks height )

Returns the estimated network hashes per second based on the last n blocks.
Pass in [blocks] to override # of blocks, -1 specifies since last difficulty change.
Pass in [height] to estimate the network speed at the time when a certain block was found.

Arguments:
1. nblocks     (numeric, optional, default=120) The number of blocks, or -1 for blocks since last difficulty change.
2. height      (numeric, optional, default=-1) To estimate at the time of the given height.

Result:
x             (numeric) Hashes per second estimated

Examples:
> bitcoindiamond-cli getnetworkhashps
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnetworkhashps", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### prioritisetransaction <txid> <dummy value> <fee delta>

Accepts the transaction into mined blocks at a higher (or lower) priority

Arguments:
1. "txid"       (string, required) The transaction id.
2. dummy          (numeric, optional) API-Compatibility for previous API. Must be zero or null.
                  DEPRECATED. For forward compatibility use named arguments and omit this parameter.
3. fee_delta      (numeric, required) The fee value (in satoshis) to add (or subtract, if negative).
                  Note, that this value is not a fee rate. It is a value to modify absolute fee of the TX.
                  The fee is not actually paid, only the algorithm for selecting transactions into a block
                  considers the transaction as it would have paid a higher (or lower) fee.

Result:
true              (boolean) Returns true

Examples:
> bitcoindiamond-cli prioritisetransaction "txid" 0.0 10000
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "prioritisetransaction", "params": ["txid", 0.0, 10000] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### submitblock "hexdata"  ( "dummy" )

Attempts to submit new block to network.
See https://en.bitcoin.it/wiki/BIP_0022 for full specification.

Arguments
1. "hexdata"        (string, required) the hex-encoded block data to submit
2. "dummy"          (optional) dummy value, for compatibility with BIP22. This value is ignored.

Result:

Examples:
> bitcoindiamond-cli submitblock "mydata"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "submitblock", "params": ["mydata"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

### Network

#### addnode "node" "add|remove|onetry"

Attempts to add or remove a node from the addnode list.
Or try a connection to a node once.
Nodes added using addnode (or -connect) are protected from DoS disconnection and are not required to be
full nodes/support SegWit as other outbound peers are (though such peers will not be synced from).

Arguments:
1. "node"     (string, required) The node (see getpeerinfo for nodes)
2. "command"  (string, required) 'add' to add a node to the list, 'remove' to remove a node from the list, 'onetry' to try a connection to the node once

Examples:
> bitcoindiamond-cli addnode "192.168.0.6:8333" "onetry"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "addnode", "params": ["192.168.0.6:8333", "onetry"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### clearbanned

Clear all banned IPs.

Examples:
> bitcoindiamond-cli clearbanned
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "clearbanned", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### disconnectnode "[address]" [nodeid]

Immediately disconnects from the specified peer node.

Strictly one out of 'address' and 'nodeid' can be provided to identify the node.

To disconnect by nodeid, either set 'address' to the empty string, or call using the named 'nodeid' argument only.

Arguments:
1. "address"     (string, optional) The IP address/port of the node
2. "nodeid"      (number, optional) The node ID (see getpeerinfo for node IDs)

Examples:
> bitcoindiamond-cli disconnectnode "192.168.0.6:8333"
> bitcoindiamond-cli disconnectnode "" 1
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "disconnectnode", "params": ["192.168.0.6:8333"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "disconnectnode", "params": ["", 1] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getaddednodeinfo ( "node" )

Returns information about the given added node, or all added nodes
(note that onetry addnodes are not listed here)

Arguments:
1. "node"   (string, optional) If provided, return information about this specific node, otherwise all nodes are returned.

Result:
[
  {
    "addednode" : "192.168.0.201",   (string) The node IP address or name (as provided to addnode)
    "connected" : true|false,          (boolean) If connected
    "addresses" : [                    (list of objects) Only when connected = true
       {
         "address" : "192.168.0.201:8333",  (string) The bitcoindiamond server IP and port we're connected to
         "connected" : "outbound"           (string) connection, inbound or outbound
       }
     ]
  }
  ,...
]

Examples:
> bitcoindiamond-cli getaddednodeinfo "192.168.0.201"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getaddednodeinfo", "params": ["192.168.0.201"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getconnectioncount

Returns the number of connections to other nodes.

Result:
n          (numeric) The connection count

Examples:
> bitcoindiamond-cli getconnectioncount
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getconnectioncount", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getnettotals

Returns information about network traffic, including bytes in, bytes out,
and current time.

Result:
{
  "totalbytesrecv": n,   (numeric) Total bytes received
  "totalbytessent": n,   (numeric) Total bytes sent
  "timemillis": t,       (numeric) Current UNIX time in milliseconds
  "uploadtarget":
  {
    "timeframe": n,                         (numeric) Length of the measuring timeframe in seconds
    "target": n,                            (numeric) Target in bytes
    "target_reached": true|false,           (boolean) True if target is reached
    "serve_historical_blocks": true|false,  (boolean) True if serving historical blocks
    "bytes_left_in_cycle": t,               (numeric) Bytes left in current time cycle
    "time_left_in_cycle": t                 (numeric) Seconds left in current time cycle
  }
}

Examples:
> bitcoindiamond-cli getnettotals
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnettotals", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getnetworkinfo

Returns an object containing various state info regarding P2P networking.

Result:
{
  "version": xxxxx,                      (numeric) the server version
  "subversion": "/Satoshi:x.x.x/",     (string) the server subversion string
  "protocolversion": xxxxx,              (numeric) the protocol version
  "localservices": "xxxxxxxxxxxxxxxx", (string) the services we offer to the network
  "localrelay": true|false,              (bool) true if transaction relay is requested from peers
  "timeoffset": xxxxx,                   (numeric) the time offset
  "connections": xxxxx,                  (numeric) the number of connections
  "networkactive": true|false,           (bool) whether p2p networking is enabled
  "networks": [                          (array) information per network
  {
    "name": "xxx",                     (string) network (ipv4, ipv6 or onion)
    "limited": true|false,               (boolean) is the network limited using -onlynet?
    "reachable": true|false,             (boolean) is the network reachable?
    "proxy": "host:port"               (string) the proxy that is used for this network, or empty if none
    "proxy_randomize_credentials": true|false,  (string) Whether randomized credentials are used
  }
  ,...
  ],
  "relayfee": x.xxxxxxxx,                (numeric) minimum relay fee for transactions in BCD/kB
  "incrementalfee": x.xxxxxxxx,          (numeric) minimum fee increment for mempool limiting or BIP 125 replacement in BCD/kB
  "localaddresses": [                    (array) list of local addresses
  {
    "address": "xxxx",                 (string) network address
    "port": xxx,                         (numeric) network port
    "score": xxx                         (numeric) relative score
  }
  ,...
  ]
  "warnings": "..."                    (string) any network and blockchain warnings
}

Examples:
> bitcoindiamond-cli getnetworkinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnetworkinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getpeerinfo

Returns data about each connected network node as a json array of objects.

Result:
[
  {
    "id": n,                   (numeric) Peer index
    "addr":"host:port",      (string) The IP address and port of the peer
    "addrbind":"ip:port",    (string) Bind address of the connection to the peer
    "addrlocal":"ip:port",   (string) Local address as reported by the peer
    "services":"xxxxxxxxxxxxxxxx",   (string) The services offered
    "relaytxes":true|false,    (boolean) Whether peer has asked us to relay transactions to it
    "lastsend": ttt,           (numeric) The time in seconds since epoch (Jan 1 1970 GMT) of the last send
    "lastrecv": ttt,           (numeric) The time in seconds since epoch (Jan 1 1970 GMT) of the last receive
    "bytessent": n,            (numeric) The total bytes sent
    "bytesrecv": n,            (numeric) The total bytes received
    "conntime": ttt,           (numeric) The connection time in seconds since epoch (Jan 1 1970 GMT)
    "timeoffset": ttt,         (numeric) The time offset in seconds
    "pingtime": n,             (numeric) ping time (if available)
    "minping": n,              (numeric) minimum observed ping time (if any at all)
    "pingwait": n,             (numeric) ping wait (if non-zero)
    "version": v,              (numeric) The peer version, such as 70001
    "subver": "/Satoshi:0.8.5/",  (string) The string version
    "inbound": true|false,     (boolean) Inbound (true) or Outbound (false)
    "addnode": true|false,     (boolean) Whether connection was due to addnode/-connect or if it was an automatic/inbound connection
    "startingheight": n,       (numeric) The starting height (block) of the peer
    "banscore": n,             (numeric) The ban score
    "synced_headers": n,       (numeric) The last header we have in common with this peer
    "synced_blocks": n,        (numeric) The last block we have in common with this peer
    "inflight": [
       n,                        (numeric) The heights of blocks we're currently asking from this peer
       ...
    ],
    "whitelisted": true|false, (boolean) Whether the peer is whitelisted
    "bytessent_per_msg": {
       "addr": n,              (numeric) The total bytes sent aggregated by message type
       ...
    },
    "bytesrecv_per_msg": {
       "addr": n,              (numeric) The total bytes received aggregated by message type
       ...
    }
  }
  ,...
]

Examples:
> bitcoindiamond-cli getpeerinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getpeerinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listbanned

List all banned IPs/Subnets.

Examples:
> bitcoindiamond-cli listbanned
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listbanned", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### ping

Requests that a ping be sent to all other nodes, to measure ping time.
Results provided in getpeerinfo, pingtime and pingwait fields are decimal seconds.
Ping command is handled in queue with all other commands, so it measures processing backlog, not just network ping.

Examples:
> bitcoindiamond-cli ping
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "ping", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### setban "subnet" "add|remove" (bantime) (absolute)

Attempts to add or remove an IP/Subnet from the banned list.

Arguments:
1. "subnet"       (string, required) The IP/Subnet (see getpeerinfo for nodes IP) with an optional netmask (default is /32 = single IP)
2. "command"      (string, required) 'add' to add an IP/Subnet to the list, 'remove' to remove an IP/Subnet from the list
3. "bantime"      (numeric, optional) time in seconds how long (or until when if [absolute] is set) the IP is banned (0 or empty means using the default time of 24h which can also be overwritten by the -bantime startup argument)
4. "absolute"     (boolean, optional) If set, the bantime must be an absolute timestamp in seconds since epoch (Jan 1 1970 GMT)

Examples:
> bitcoindiamond-cli setban "192.168.0.6" "add" 86400
> bitcoindiamond-cli setban "192.168.0.0/24" "add"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "setban", "params": ["192.168.0.6", "add", 86400] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### setnetworkactive true|false

Disable/enable all p2p network activity.

Arguments:

1. "state"        (boolean, required) true to enable networking, false to disable

### Rawtransactions

#### combinepsbt ["psbt",...]

Combine multiple partially signed Bitcoin transactions into one transaction.
Implements the Combiner role.

Arguments:
1. "txs"                   (string) A json array of base64 strings of partially signed transactions
    [
      "psbt"             (string) A base64 string of a PSBT
      ,...
    ]

Result:
  "psbt"          (string) The base64-encoded partially signed transaction

Examples:

> bitcoindiamond-cli combinepsbt ["mybase64_1", "mybase64_2", "mybase64_3"]

#### combinerawtransaction ["hexstring",...]

Combine multiple partially signed transactions into one transaction.
The combined transaction may be another partially signed transaction or a
fully signed transaction.
Arguments:
1. "txs"         (string) A json array of hex strings of partially signed transactions
    [
      "hexstring"     (string) A transaction hash
      ,...
    ]

Result:
"hex"            (string) The hex-encoded raw transaction with signature(s)

Examples:

> bitcoindiamond-cli combinerawtransaction ["myhex1", "myhex2", "myhex3"]

#### converttopsbt "hexstring" ( permitsigdata iswitness )

converttopsbt "hexstring" ( permitsigdata iswitness )

Converts a network serialized transaction to a PSBT. This should be used only with createrawtransaction and fundrawtransaction
createpsbt and walletcreatefundedpsbt should be used for new applications.

Arguments:
1. "hexstring"              (string, required) The hex string of a raw transaction
2. permitsigdata           (boolean, optional, default=false) If true, any signatures in the input will be discarded and conversion.
                              will continue. If false, RPC will fail if any signatures are present.
3. iswitness               (boolean, optional) Whether the transaction hex is a serialized witness transaction.
                              If iswitness is not present, heuristic tests will be used in decoding. If true, only witness deserializaion
                              will be tried. If false, only non-witness deserialization wil be tried. Only has an effect if
                              permitsigdata is true.

Result:
  "psbt"        (string)  The resulting raw transaction (base64-encoded string)

Examples:

Create a transaction
> bitcoindiamond-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"data\":\"00010203\"}]"

Convert the transaction to a PSBT

> bitcoindiamond-cli converttopsbt "rawtransaction"

#### createpsbt [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )

Creates a transaction in the Partially Signed Transaction format.
Implements the Creator role.

Arguments:
1. "inputs"                (array, required) A json array of json objects
     [
       {
         "txid":"id",      (string, required) The transaction id
         "vout":n,         (numeric, required) The output number
         "sequence":n      (numeric, optional) The sequence number
       }
       ,...
     ]
2. "outputs"               (array, required) a json array with outputs (key-value pairs)
   [
    {
      "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoin address, the value (float or string) is the amount in BCD
    },
    {
      "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
    }
    ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
                             accepted as second parameter.
   ]
3. locktime                  (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
4. replaceable               (boolean, optional, default=false) Marks this transaction as BIP125 replaceable.
                             Allows this transaction to be replaced by a transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.

Result:
  "psbt"        (string)  The resulting raw transaction (base64-encoded string)

Examples:

> bitcoindiamond-cli createpsbt "[{\"txid\":\"myid\",\"vout\

#### createrawtransaction [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable )

Create a transaction spending the given inputs and creating new outputs.
Outputs can be addresses or data.
Returns hex-encoded raw transaction.
Note that the transaction's inputs are not signed, and
it is not stored in the wallet or transmitted to the network.

Arguments:
1. "inputs"                (array, required) A json array of json objects
     [
       {
         "txid":"id",      (string, required) The transaction id
         "vout":n,         (numeric, required) The output number
         "sequence":n      (numeric, optional) The sequence number
       }
       ,...
     ]
2. "outputs"               (array, required) a json array with outputs (key-value pairs)
   [
    {
      "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoindiamond address, the value (float or string) is the amount in BCD
    },
    {
      "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
    }
    ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
                             accepted as second parameter.
   ]
3. locktime                  (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
4. replaceable               (boolean, optional, default=false) Marks this transaction as BIP125 replaceable.
                             Allows this transaction to be replaced by a transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.

Result:
"transaction"              (string) hex string of the transaction

Examples:
> bitcoindiamond-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"address\":0.01}]"
> bitcoindiamond-cli createrawtransaction "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"data\":\"00010203\"}]"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"address\":0.01}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createrawtransaction", "params": ["[{\"txid\":\"myid\",\"vout\":0}]", "[{\"data\":\"00010203\"}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### decodepsbt "psbt"

Return a JSON object representing the serialized, base64-encoded partially signed Bitcoin transaction.

Arguments:
1. "psbt"            (string, required) The PSBT base64 string

Result:
{
  "tx" : {                   (json object) The decoded network-serialized unsigned transaction.
    ...                                      The layout is the same as the output of decoderawtransaction.
  },
  "unknown" : {                (json object) The unknown global fields
    "key" : "value"            (key-value pair) An unknown key-value pair
     ...
  },
  "inputs" : [                 (array of json objects)
    {
      "non_witness_utxo" : {   (json object, optional) Decoded network transaction for non-witness UTXOs
        ...
      },
      "witness_utxo" : {            (json object, optional) Transaction output for witness UTXOs
        "amount" : x.xxx,           (numeric) The value in BCD
        "scriptPubKey" : {          (json object)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
          "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
          "address" : "address"     (string) Bitcoin address if there is one
        }
      },
      "partial_signatures" : {             (json object, optional)
        "pubkey" : "signature",           (string) The public key and signature that corresponds to it.
        ,...
      }
      "sighash" : "type",                  (string, optional) The sighash type to be used
      "redeem_script" : {       (json object, optional)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
          "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
        }
      "witness_script" : {       (json object, optional)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
          "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
        }
      "bip32_derivs" : {          (json object, optional)
        "pubkey" : {                     (json object, optional) The public key with the derivation path as the value.
          "master_fingerprint" : "fingerprint"     (string) The fingerprint of the master key
          "path" : "path",                         (string) The path
        }
        ,...
      }
      "final_scriptsig" : {       (json object, optional)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
        }
       "final_scriptwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
      "unknown" : {                (json object) The unknown global fields
        "key" : "value"            (key-value pair) An unknown key-value pair
         ...
      },
    }
    ,...
  ]
  "outputs" : [                 (array of json objects)
    {
      "redeem_script" : {       (json object, optional)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
          "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
        }
      "witness_script" : {       (json object, optional)
          "asm" : "asm",            (string) The asm
          "hex" : "hex",            (string) The hex
          "type" : "pubkeyhash",    (string) The type, eg 'pubkeyhash'
      }
      "bip32_derivs" : [          (array of json objects, optional)
        {
          "pubkey" : "pubkey",                     (string) The public key this path corresponds to
          "master_fingerprint" : "fingerprint"     (string) The fingerprint of the master key
          "path" : "path",                         (string) The path
          }
        }
        ,...
      ],
      "unknown" : {                (json object) The unknown global fields
        "key" : "value"            (key-value pair) An unknown key-value pair
         ...
      },
    }
    ,...
  ]
  "fee" : fee                      (numeric, optional) The transaction fee paid if all UTXOs slots in the PSBT have been filled.
}

Examples:

> bitcoindiamond-cli decodepsbt "psbt"

#### decoderawtransaction "hexstring" ( iswitness )

Return a JSON object representing the serialized, hex-encoded transaction.

Arguments:
1. "hexstring"      (string, required) The transaction hex string
2. iswitness          (boolean, optional) Whether the transaction hex is a serialized witness transaction
                         If iswitness is not present, heuristic tests will be used in decoding

Result:
{
  "txid" : "id",        (string) The transaction id
  "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
  "size" : n,             (numeric) The transaction size
  "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
  "weight" : n,           (numeric) The transaction's weight (between vsize*4 - 3 and vsize*4)
  "version" : n,          (numeric) The version
  "locktime" : ttt,       (numeric) The lock time
  "vin" : [               (array of json objects)
     {
       "txid": "id",    (string) The transaction id
       "vout": n,         (numeric) The output number
       "scriptSig": {     (json object) The script
         "asm": "asm",  (string) asm
         "hex": "hex"   (string) hex
       },
       "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
       "sequence": n     (numeric) The script sequence number
     }
     ,...
  ],
  "vout" : [             (array of json objects)
     {
       "value" : x.xxx,            (numeric) The value in BCD
       "n" : n,                    (numeric) index
       "scriptPubKey" : {          (json object)
         "asm" : "asm",          (string) the asm
         "hex" : "hex",          (string) the hex
         "reqSigs" : n,            (numeric) The required sigs
         "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
         "addresses" : [           (json array of string)
           "12tvKAXCxZjSmdNbao16dKXC8tRWfcF5oc"   (string) bitcoin address
           ,...
         ]
       }
     }
     ,...
  ],
}

Examples:
> bitcoindiamond-cli decoderawtransaction "hexstring"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "decoderawtransaction", "params": ["hexstring"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### decodescript "hexstring"

Decode a hex-encoded script.

Arguments:
1. "hexstring"     (string) the hex encoded script

Result:
{
  "asm":"asm",   (string) Script public key
  "hex":"hex",   (string) hex encoded public key
  "type":"type", (string) The output type
  "reqSigs": n,    (numeric) The required signatures
  "addresses": [   (json array of string)
     "address"     (string) bitcoindiamond address
     ,...
  ],
  "p2sh","address" (string) address of P2SH script wrapping this redeem script (not returned if the script is already a P2SH).
}

Examples:
> bitcoindiamond-cli decodescript "hexstring"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "decodescript", "params": ["hexstring"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### finalizepsbt "psbt" ( extract )

Finalize the inputs of a PSBT. If the transaction is fully signed, it will produce a
network serialized transaction which can be broadcast with sendrawtransaction. Otherwise a PSBT will be
created which has the final_scriptSig and final_scriptWitness fields filled for inputs that are complete.
Implements the Finalizer and Extractor roles.

Arguments:
1. "psbt"                 (string) A base64 string of a PSBT
2. "extract"              (boolean, optional, default=true) If true and the transaction is complete,
                             extract and return the complete transaction in normal network serialization instead of the PSBT.

Result:
{
  "psbt" : "value",          (string) The base64-encoded partially signed transaction if not extracted
  "hex" : "value",           (string) The hex-encoded network transaction if extracted
  "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
  ]
}

Examples:

> bitcoindiamond-cli finalizepsbt "psbt"

#### fundrawtransaction "hexstring" ( options iswitness )

Add inputs to a transaction until it has enough in value to meet its out value.
This will not modify existing inputs, and will add at most one change output to the outputs.
No existing outputs will be modified unless "subtractFeeFromOutputs" is specified.
Note that inputs which were signed may need to be resigned after completion since in/outputs have been added.
The inputs added will not be signed, use signrawtransaction for that.
Note that all existing inputs must have their previous output transaction be in the wallet.
Note that all inputs selected must be of standard form and P2SH scripts must be
in the wallet using importaddress or addmultisigaddress (to calculate fees).
You can see whether this is the case by checking the "solvable" field in the listunspent output.
Only pay-to-pubkey, multisig, and P2SH versions thereof are currently supported for watch-only

Arguments:
1. "hexstring"           (string, required) The hex string of the raw transaction
2. options                 (object, optional)
   {
     "changeAddress"          (string, optional, default pool address) The bitcoin address to receive the change
     "changePosition"         (numeric, optional, default random) The index of the change output
     "change_type"            (string, optional) The output type to use. Only valid if changeAddress is not specified. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.
     "includeWatching"        (boolean, optional, default false) Also select inputs which are watch only
     "lockUnspents"           (boolean, optional, default false) Lock selected unspent outputs
     "feeRate"                (numeric, optional, default not set: makes wallet determine the fee) Set a specific fee rate in BCD/kB
     "subtractFeeFromOutputs" (array, optional) A json array of integers.
                              The fee will be equally deducted from the amount of each specified output.
                              The outputs are specified by their zero-based index, before any change output is added.
                              Those recipients will receive less bitcoins than you enter in their corresponding amount field.
                              If no outputs are specified here, the sender pays the fee.
                                  [vout_index,...]
     "replaceable"            (boolean, optional) Marks this transaction as BIP125 replaceable.
                              Allows this transaction to be replaced by a transaction with higher fees
     "conf_target"            (numeric, optional) Confirmation target (in blocks)
     "estimate_mode"          (string, optional, default=UNSET) The fee estimate mode, must be one of:
         "UNSET"
         "ECONOMICAL"
         "CONSERVATIVE"
   }
                         for backward compatibility: passing in a true instead of an object will result in {"includeWatching":true}
3. iswitness               (boolean, optional) Whether the transaction hex is a serialized witness transaction
                              If iswitness is not present, heuristic tests will be used in decoding

Result:
{
  "hex":       "value", (string)  The resulting raw transaction (hex-encoded string)
  "fee":       n,         (numeric) Fee in BCD the resulting transaction pays
  "changepos": n          (numeric) The position of the added change output, or -1
}

Examples:

Create a transaction with no inputs
> bitcoindiamond-cli createrawtransaction "[]" "{\"myaddress\":0.01}"

Add sufficient unsigned inputs to meet the output value
> bitcoindiamond-cli fundrawtransaction "rawtransactionhex"

Sign the transaction
> bitcoindiamond-cli signrawtransaction "fundedtransactionhex"

Send the transaction

> bitcoindiamond-cli sendrawtransaction "signedtransactionhex"

#### getrawtransaction "txid" ( verbose "blockhash" )

NOTE: By default this function only works for mempool transactions. If the -txindex option is
enabled, it also works for blockchain transactions. If the block which contains the transaction
is known, its hash can be provided even for nodes without -txindex. Note that if a blockhash is
provided, only that block will be searched and if the transaction is in the mempool or other
blocks, or if this node does not have the given block available, the transaction will not be found.
DEPRECATED: for now, it also works for transactions with unspent outputs.

Return the raw transaction data.

If verbose is 'true', returns an Object with information about 'txid'.
If verbose is 'false' or omitted, returns a string that is serialized, hex-encoded data for 'txid'.

Arguments:
1. "txid"      (string, required) The transaction id
2. verbose     (bool, optional, default=false) If false, return a string, otherwise return a json object
3. "blockhash" (string, optional) The block in which to look for the transaction

Result (if verbose is not set or set to false):
"data"      (string) The serialized, hex-encoded data for 'txid'

Result (if verbose is set to true):
{
  "in_active_chain": b, (bool) Whether specified block is in the active chain or not (only present with explicit "blockhash" argument)
  "hex" : "data",       (string) The serialized, hex-encoded data for 'txid'
  "txid" : "id",        (string) The transaction id (same as provided)
  "hash" : "id",        (string) The transaction hash (differs from txid for witness transactions)
  "size" : n,             (numeric) The serialized transaction size
  "vsize" : n,            (numeric) The virtual transaction size (differs from size for witness transactions)
  "weight" : n,           (numeric) The transaction's weight (between vsize*4-3 and vsize*4)
  "version" : n,          (numeric) The version
  "locktime" : ttt,       (numeric) The lock time
  "vin" : [               (array of json objects)
     {
       "txid": "id",    (string) The transaction id
       "vout": n,         (numeric)
       "scriptSig": {     (json object) The script
         "asm": "asm",  (string) asm
         "hex": "hex"   (string) hex
       },
       "sequence": n      (numeric) The script sequence number
       "txinwitness": ["hex", ...] (array of string) hex-encoded witness data (if any)
     }
     ,...
  ],
  "vout" : [              (array of json objects)
     {
       "value" : x.xxx,            (numeric) The value in BCD
       "n" : n,                    (numeric) index
       "scriptPubKey" : {          (json object)
         "asm" : "asm",          (string) the asm
         "hex" : "hex",          (string) the hex
         "reqSigs" : n,            (numeric) The required sigs
         "type" : "pubkeyhash",  (string) The type, eg 'pubkeyhash'
         "addresses" : [           (json array of string)
           "address"        (string) bitcoindiamond address
           ,...
         ]
       }
     }
     ,...
  ],
  "blockhash" : "hash",   (string) the block hash
  "confirmations" : n,      (numeric) The confirmations
  "time" : ttt,             (numeric) The transaction time in seconds since epoch (Jan 1 1970 GMT)
  "blocktime" : ttt         (numeric) The block time in seconds since epoch (Jan 1 1970 GMT)
}

Examples:
> bitcoindiamond-cli getrawtransaction "mytxid"
> bitcoindiamond-cli getrawtransaction "mytxid" true
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrawtransaction", "params": ["mytxid", true] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/
> bitcoindiamond-cli getrawtransaction "mytxid" false "myblockhash"
> bitcoindiamond-cli getrawtransaction "mytxid" true "myblockhash"

#### sendrawtransaction "hexstring" ( allowhighfees )

Submits raw transaction (serialized, hex-encoded) to local node and network.

Also see createrawtransaction and signrawtransaction calls.

Arguments:
1. "hexstring"    (string, required) The hex string of the raw transaction)
2. allowhighfees    (boolean, optional, default=false) Allow high fees

Result:
"hex"             (string) The transaction hash in hex

Examples:

Create a transaction
> bitcoindiamond-cli createrawtransaction "[{\"txid\" : \"mytxid\",\"vout\":0}]" "{\"myaddress\":0.01}"
> Sign the transaction, and get back the hex
> bitcoindiamond-cli signrawtransaction "myhex"

Send the transaction (signed hex)
> bitcoindiamond-cli sendrawtransaction "signedhex"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sendrawtransaction", "params": ["signedhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### signrawtransaction "hexstring" ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] ["privatekey1",...] sighashtype )

DEPRECATED. Sign inputs for raw transaction (serialized, hex-encoded).
The second optional argument (may be null) is an array of previous transaction outputs that
this transaction depends on but may not yet be in the block chain.
The third optional argument (may be null) is an array of base58-encoded private
keys that, if given, will be the only keys used to sign the transaction.


Arguments:
1. "hexstring"     (string, required) The transaction hex string
2. "prevtxs"       (string, optional) An json array of previous dependent transaction outputs
     [               (json array of json objects, or 'null' if none provided)
       {
         "txid":"id",             (string, required) The transaction id
         "vout":n,                  (numeric, required) The output number
         "scriptPubKey": "hex",   (string, required) script key
         "redeemScript": "hex",   (string, required for P2SH or P2WSH) redeem script
         "amount": value            (numeric, required) The amount spent
       }
       ,...
    ]
3. "privkeys"     (string, optional) A json array of base58-encoded private keys for signing
    [                  (json array of strings, or 'null' if none provided)
      "privatekey"   (string) private key in base58-encoding
      ,...
    ]
4. "sighashtype"     (string, optional, default=ALL) The signature hash type. Must be one of
       "ALL"
       "NONE"
       "SINGLE"
       "ALL|ANYONECANPAY"
       "NONE|ANYONECANPAY"
       "SINGLE|ANYONECANPAY"

Result:
{
  "hex" : "value",           (string) The hex-encoded raw transaction with signature(s)
  "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
  "errors" : [                 (json array of objects) Script verification errors (if there are any)
    {
      "txid" : "hash",           (string) The hash of the referenced, previous transaction
      "vout" : n,                (numeric) The index of the output to spent and used as input
      "scriptSig" : "hex",       (string) The hex-encoded signature script
      "sequence" : n,            (numeric) Script sequence number
      "error" : "text"           (string) Verification or signing error related to the input
    }
    ,...
  ]
}

Examples:
> bitcoindiamond-cli signrawtransaction "myhex"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signrawtransaction", "params": ["myhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### signrawtransactionwithkey "hexstring" ["privatekey1",...] ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] sighashtype )

Sign inputs for raw transaction (serialized, hex-encoded).
The second argument is an array of base58-encoded private
keys that will be the only keys used to sign the transaction.
The third optional argument (may be null) is an array of previous transaction outputs that
this transaction depends on but may not yet be in the block chain.

Arguments:
1. "hexstring"                      (string, required) The transaction hex string
2. "privkeys"                       (string, required) A json array of base58-encoded private keys for signing
    [                               (json array of strings)
      "privatekey"                  (string) private key in base58-encoding
      ,...
    ]
3. "prevtxs"                        (string, optional) An json array of previous dependent transaction outputs
     [                              (json array of json objects, or 'null' if none provided)
       {
         "txid":"id",               (string, required) The transaction id
         "vout":n,                  (numeric, required) The output number
         "scriptPubKey": "hex",     (string, required) script key
         "redeemScript": "hex",     (string, required for P2SH or P2WSH) redeem script
         "amount": value            (numeric, required) The amount spent
       }
       ,...
    ]
4. "sighashtype"                    (string, optional, default=ALL) The signature hash type. Must be one of
       "ALL"
       "NONE"
       "SINGLE"
       "ALL|ANYONECANPAY"
       "NONE|ANYONECANPAY"
       "SINGLE|ANYONECANPAY"

Result:
{
  "hex" : "value",                  (string) The hex-encoded raw transaction with signature(s)
  "complete" : true|false,          (boolean) If the transaction has a complete set of signatures
  "errors" : [                      (json array of objects) Script verification errors (if there are any)
    {
      "txid" : "hash",              (string) The hash of the referenced, previous transaction
      "vout" : n,                   (numeric) The index of the output to spent and used as input
      "scriptSig" : "hex",          (string) The hex-encoded signature script
      "sequence" : n,               (numeric) Script sequence number
      "error" : "text"              (string) Verification or signing error related to the input
    }
    ,...
  ]
}

Examples:
> bitcoindiamond-cli signrawtransactionwithkey "myhex"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signrawtransactionwithkey", "params": ["myhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### testmempoolaccept ["rawtxs"] ( allowhighfees )

Returns if raw transaction (serialized, hex-encoded) would be accepted by mempool.

This checks if the transaction violates the consensus or policy rules.

See sendrawtransaction call.

Arguments:
1. ["rawtxs"]       (array, required) An array of hex strings of raw transactions.
                                        Length must be one for now.
2. allowhighfees    (boolean, optional, default=false) Allow high fees

Result:
[                   (array) The result of the mempool acceptance test for each raw transaction in the input array.
                            Length is exactly one for now.
 {
  "txid"           (string) The transaction hash in hex
  "allowed"        (boolean) If the mempool allows this tx to be inserted
  "reject-reason"  (string) Rejection string (only present when 'allowed' is false)
 }
]

Examples:

Create a transaction
> bitcoindiamond-cli createrawtransaction "[{\"txid\" : \"mytxid\",\"vout\":0}]" "{\"myaddress\":0.01}"
> Sign the transaction, and get back the hex
> bitcoindiamond-cli signrawtransaction "myhex"

Test acceptance of the transaction (signed hex)
> bitcoindiamond-cli testmempoolaccept "signedhex"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "testmempoolaccept", "params": [["signedhex"]] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

### Util

#### createmultisig nrequired ["key",...] ( "address_type" )

Creates a multi-signature address with n signature of m keys required.
It returns a json object with the address and redeemScript.

Arguments:
1. nrequired                    (numeric, required) The number of required signatures out of the n keys.
2. "keys"                       (string, required) A json array of hex-encoded public keys
     [
       "key"                    (string) The hex-encoded public key
       ,...
     ]
3. "address_type"               (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is legacy.

Result:
{
  "address":"multisigaddress",  (string) The value of the new multisig address.
  "redeemScript":"script"       (string) The string value of the hex-encoded redemption script.
}

Examples:

Create a multisig address from 2 public keys
> bitcoindiamond-cli createmultisig 2 "[\"03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd\",\"03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626\"]"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createmultisig", "params": [2, "[\"03789ed0bb717d88f7d321a368d905e7430207ebbd82bd342cf11ae157a7ace5fd\",\"03dbc6764b8884a92e871274b87583e6d5c2a58819473e17e107ef3f6aa5a61626\"]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### estimatesmartfee conf_target ("estimate_mode")

Estimates the approximate fee per kilobyte needed for a transaction to begin
confirmation within conf_target blocks if possible and return the number of blocks
for which the estimate is valid. Uses virtual transaction size as defined
in BIP 141 (witness data is discounted).

Arguments:
1. conf_target     (numeric) Confirmation target in blocks (1 - 1008)
2. "estimate_mode" (string, optional, default=CONSERVATIVE) The fee estimate mode.
                   Whether to return a more conservative estimate which also satisfies
                   a longer history. A conservative estimate potentially returns a
                   higher feerate and is more likely to be sufficient for the desired
                   target, but is not as responsive to short term drops in the
                   prevailing fee market.  Must be one of:
       "UNSET" (defaults to CONSERVATIVE)
       "ECONOMICAL"
       "CONSERVATIVE"

Result:
{
  "feerate" : x.x,     (numeric, optional) estimate fee rate in BCD/kB
  "errors": [ str... ] (json array of strings, optional) Errors encountered during processing
  "blocks" : n         (numeric) block number where estimate was found
}

The request target will be clamped between 2 and the highest target
fee estimation is able to return based on how long it has been running.
An error is returned if not enough transactions and blocks
have been observed to make an estimate for any number of blocks.

Example:

> bitcoindiamond-cli estimatesmartfee 6

#### signmessagewithprivkey "privkey" "message"

Sign a message with the private key of an address

Arguments:
1. "privkey"         (string, required) The private key to sign the message with.
2. "message"         (string, required) The message to create a signature of.

Result:
"signature"          (string) The signature of the message encoded in base 64

Examples:

Create the signature
> bitcoindiamond-cli signmessagewithprivkey "privkey" "my message"

Verify the signature
> bitcoindiamond-cli verifymessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "signature" "my message"

As json rpc

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signmessagewithprivkey", "params": ["privkey", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### validateaddress "address"

Return information about the given bitcoindiamond address.
DEPRECATION WARNING: Parts of this command have been deprecated and moved to getaddressinfo. Clients must
transition to using getaddressinfo to access this information before upgrading to v0.18. The following deprecated
fields have moved to getaddressinfo and will only be shown here with -deprecatedrpc=validateaddress: ismine, iswatchonly,
script, hex, pubkeys, sigsrequired, pubkey, addresses, embedded, iscompressed, account, timestamp, hdkeypath, kdmasterkeyid.

Arguments:
1. "address"                    (string, required) The bitcoindiamond address to validate

Result:
{
  "isvalid" : true|false,       (boolean) If the address is valid or not. If not, this is the only property returned.
  "address" : "address",        (string) The bitcoindiamond address validated
  "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
  "isscript" : true|false,      (boolean) If the key is a script
  "iswitness" : true|false,     (boolean) If the address is a witness address
  "witness_version" : version   (numeric, optional) The version number of the witness program
  "witness_program" : "hex"     (string, optional) The hex value of the witness program
}

Examples:
> bitcoindiamond-cli validateaddress "1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "validateaddress", "params": ["1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### verifymessage "address" "signature" "message"

Verify a signed message

Arguments:
1. "address"         (string, required) The bitcoin address to use for the signature.
2. "signature"       (string, required) The signature provided by the signer in base 64 encoding (see signmessage).
3. "message"         (string, required) The message that was signed.

Result:
true|false   (boolean) If the signature is verified or not.

Examples:

Unlock the wallet for 30 seconds
> bitcoindiamond-cli walletpassphrase "mypassphrase" 30

Create the signature
> bitcoindiamond-cli signmessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "my message"

Verify the signature
> bitcoindiamond-cli verifymessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "signature" "my message"

As json rpc

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "verifymessage", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX", "signature", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

### Wallet

#### abandontransaction "txid"

Mark in-wallet transaction <txid> as abandoned
This will mark this transaction and all its in-wallet descendants as abandoned which will allow
for their inputs to be respent.  It can be used to replace "stuck" or evicted transactions.
It only works on transactions which are not included in a block and are not currently in the mempool.
It has no effect on transactions which are already abandoned.

Arguments:
1. "txid"    (string, required) The transaction id

Result:

Examples:
> bitcoindiamond-cli abandontransaction "1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "abandontransaction", "params": ["1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### abortrescan

Stops current wallet rescan triggered by an RPC call, e.g. by an importprivkey call.

Examples:

Import a private key
> bitcoindiamond-cli importprivkey "mykey"

Abort the running wallet rescan
> bitcoindiamond-cli abortrescan

As a JSON-RPC call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "abortrescan", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### addmultisigaddress nrequired ["key",...] ( "label" "address_type" )

Add a nrequired-to-sign multisignature address to the wallet. Requires a new wallet backup.
Each key is a Bitcoindiamond address or hex-encoded public key.
This functionality is only intended for use with non-watchonly addresses.
See `importaddress` for watchonly p2sh address support.
If 'label' is specified, assign address to that label.

Arguments:
1. nrequired                      (numeric, required) The number of required signatures out of the n keys or addresses.
2. "keys"                         (string, required) A json array of bitcoindiamond addresses or hex-encoded public keys
     [
       "address"                  (string) bitcoindiamond address or hex-encoded public key
       ...,
     ]
3. "label"                        (string, optional) A label to assign the addresses to.
4. "address_type"                 (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -addresstype.

Result:
{
  "address":"multisigaddress",    (string) The value of the new multisig address.
  "redeemScript":"script"         (string) The string value of the hex-encoded redemption script.
}

Examples:

Add a multisig address from 2 addresses
> bitcoindiamond-cli addmultisigaddress 2 "[\"16sSauSf5pF2UkUwvKGq4qjNRzBZYqgEL5\",\"171sgjn4YtPu27adkKGrdDwzRTxnRkBfKV\"]"

As json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "addmultisigaddress", "params": [2, "[\"16sSauSf5pF2UkUwvKGq4qjNRzBZYqgEL5\",\"171sgjn4YtPu27adkKGrdDwzRTxnRkBfKV\"]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### backupwallet "destination"

Safely copies current wallet file to destination, which can be a directory or a path with filename.

Arguments:
1. "destination"   (string) The destination directory or file

Examples:
> bitcoindiamond-cli backupwallet "backup.dat"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "backupwallet", "params": ["backup.dat"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### bumpfee "txid" ( options )

Bumps the fee of an opt-in-RBF transaction T, replacing it with a new transaction B.
An opt-in RBF transaction with the given txid must be in the wallet.
The command will pay the additional fee by decreasing (or perhaps removing) its change output.
If the change output is not big enough to cover the increased fee, the command will currently fail
instead of adding new inputs to compensate. (A future implementation could improve this.)
The command will fail if the wallet or mempool contains a transaction that spends one of T's outputs.
By default, the new fee will be calculated automatically using estimatesmartfee.
The user can specify a confirmation target for estimatesmartfee.
Alternatively, the user can specify totalFee, or use RPC settxfee to set a higher fee rate.
At a minimum, the new fee rate must be high enough to pay an additional new relay fee (incrementalfee
returned by getnetworkinfo) to enter the node's mempool.

Arguments:
1. txid                  (string, required) The txid to be bumped
2. options               (object, optional)
   {
     "confTarget"        (numeric, optional) Confirmation target (in blocks)
     "totalFee"          (numeric, optional) Total fee (NOT feerate) to pay, in satoshis.
                         In rare cases, the actual fee paid might be slightly higher than the specified
                         totalFee if the tx change output has to be removed because it is too close to
                         the dust threshold.
     "replaceable"       (boolean, optional, default true) Whether the new transaction should still be
                         marked bip-125 replaceable. If true, the sequence numbers in the transaction will
                         be left unchanged from the original. If false, any input sequence numbers in the
                         original transaction that were less than 0xfffffffe will be increased to 0xfffffffe
                         so the new transaction will not be explicitly bip-125 replaceable (though it may
                         still be replaceable in practice, for example if it has unconfirmed ancestors which
                         are replaceable).
     "estimate_mode"     (string, optional, default=UNSET) The fee estimate mode, must be one of:
         "UNSET"
         "ECONOMICAL"
         "CONSERVATIVE"
   }

Result:
{
  "txid":    "value",   (string)  The id of the new transaction
  "origfee":  n,         (numeric) Fee of the replaced transaction
  "fee":      n,         (numeric) Fee of the new transaction
  "errors":  [ str... ] (json array of strings) Errors encountered during processing (may be empty)
}

Examples:

Bump the fee, get the new transaction's txid

> bitcoindiamond-cli bumpfee <txid>

#### createwallet "wallet_name" ( disable_private_keys )

Creates and loads a new wallet.

Arguments:
1. "wallet_name"          (string, required) The name for the new wallet. If this is a path, the wallet will be created at the path location.
2. disable_private_keys   (boolean, optional, default: false) Disable the possibility of private keys (only watchonlys are possible in this mode).

Result:
{
  "name" :    <wallet_name>,        (string) The wallet name if created successfully. If the wallet was created using a full path, the wallet_name will be the full path.
  "warning" : <warning>,            (string) Warning message if wallet was not loaded cleanly.
}

Examples:
> bitcoindiamond-cli createwallet "testwallet"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "createwallet", "params": ["testwallet"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### dumpprivkey "address"

Reveals the private key corresponding to 'address'.
Then the importprivkey can be used with this output

Arguments:
1. "address"   (string, required) The bitcoin address for the private key

Result:
"key"                (string) The private key

Examples:
> bitcoindiamond-cli dumpprivkey "myaddress"
> bitcoindiamond-cli importprivkey "mykey"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "dumpprivkey", "params": ["myaddress"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### dumpwallet "filename"

Dumps all wallet keys in a human-readable format to a server-side file. This does not allow overwriting existing files.
Imported scripts are included in the dumpfile, but corresponding BIP173 addresses, etc. may not be added automatically by importwallet.
Note that if your wallet contains keys which are not derived from your HD seed (e.g. imported keys), these are not covered by
only backing up the seed itself, and must be backed up too (e.g. ensure you back up the whole dumpfile).

Arguments:
1. "filename"    (string, required) The filename with path (either absolute or relative to bitcoind)

Result:
{                           (json object)
  "filename" : {        (string) The filename with full absolute path
}

Examples:
> bitcoindiamond-cli dumpwallet "test"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "dumpwallet", "params": ["test"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### encryptwallet "passphrase"

Encrypts the wallet with 'passphrase'. This is for first time encryption.
After this, any calls that interact with private keys such as sending or signing
will require the passphrase to be set prior the making these calls.
Use the walletpassphrase call for this, and then walletlock call.
If the wallet is already encrypted, use the walletpassphrasechange call.
Note that this will shutdown the server.

Arguments:
1. "passphrase"    (string) The pass phrase to encrypt the wallet with. It must be at least 1 character, but should be long.

Examples:

Encrypt your wallet
> bitcoindiamond-cli encryptwallet "my pass phrase"

Now set the passphrase to use the wallet, such as for signing or sending bitcoin
> bitcoindiamond-cli walletpassphrase "my pass phrase"

Now we can do something like sign
> bitcoindiamond-cli signmessage "address" "test message"

Now lock the wallet again by removing the passphrase
> bitcoindiamond-cli walletlock

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "encryptwallet", "params": ["my pass phrase"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getaddressesbylabel "label"

Returns the list of addresses assigned the specified label.

Arguments:
1. "label"  (string, required) The label.

Result:
{ (json object with addresses as keys)
  "address": { (json object with information about address)
    "purpose": "string" (string)  Purpose of address ("send" for sending address, "receive" for receiving address)
  },...
}

Examples:
> bitcoindiamond-cli getaddressesbylabel "tabby"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getaddressesbylabel", "params": ["tabby"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getaddressinfo "address"

Return information about the given bitcoin address. Some information requires the address
to be in the wallet.

Arguments:
1. "address"                    (string, required) The bitcoin address to get the information of.

Result:
{
  "address" : "address",        (string) The bitcoin address validated
  "scriptPubKey" : "hex",       (string) The hex encoded scriptPubKey generated by the address
  "ismine" : true|false,        (boolean) If the address is yours or not
  "iswatchonly" : true|false,   (boolean) If the address is watchonly
  "isscript" : true|false,      (boolean) If the key is a script
  "iswitness" : true|false,     (boolean) If the address is a witness address
  "witness_version" : version   (numeric, optional) The version number of the witness program
  "witness_program" : "hex"     (string, optional) The hex value of the witness program
  "script" : "type"             (string, optional) The output script type. Only if "isscript" is true and the redeemscript is known. Possible types: nonstandard, pubkey, pubkeyhash, scripthash, multisig, nulldata, witness_v0_keyhash, witness_v0_scripthash, witness_unknown
  "hex" : "hex",                (string, optional) The redeemscript for the p2sh address
  "pubkeys"                     (string, optional) Array of pubkeys associated with the known redeemscript (only if "script" is "multisig")
    [
      "pubkey"
      ,...
    ]
  "sigsrequired" : xxxxx        (numeric, optional) Number of signatures required to spend multisig output (only if "script" is "multisig")
  "pubkey" : "publickeyhex",    (string, optional) The hex value of the raw public key, for single-key addresses (possibly embedded in P2SH or P2WSH)
  "embedded" : {...},           (object, optional) Information about the address embedded in P2SH or P2WSH, if relevant and known. It includes all getaddressinfo output fields for the embedded address, excluding metadata ("timestamp", "hdkeypath", "hdseedid") and relation to the wallet ("ismine", "iswatchonly", "account").
  "iscompressed" : true|false,  (boolean) If the address is compressed
  "label" :  "label"         (string) The label associated with the address, "" is the default account
  "account" : "account"         (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account associated with the address, "" is the default account
  "timestamp" : timestamp,      (number, optional) The creation time of the key if available in seconds since epoch (Jan 1 1970 GMT)
  "hdkeypath" : "keypath"       (string, optional) The HD keypath if the key is HD and available
  "hdseedid" : "<hash160>"      (string, optional) The Hash160 of the HD seed
  "hdmasterkeyid" : "<hash160>" (string, optional) alias for hdseedid maintained for backwards compatibility. Will be removed in V0.18.
  "labels"                      (object) Array of labels associated with the address.
    [
      { (json object of label data)
        "name": "labelname" (string) The label
        "purpose": "string" (string) Purpose of address ("send" for sending address, "receive" for receiving address)
      },...
    ]
}

Examples:
> bitcoindiamond-cli getaddressinfo "1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getaddressinfo", "params": ["1PSSGeFHDnKNxiEyFrD1wcEaHr9hrQDDWc"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getbalance ( "(dummy)" minconf include_watchonly )

Returns the total available balance.
The available balance is what the wallet considers currently spendable, and is
thus affected by options which limit spendability such as -spendzeroconfchange.

Arguments:
1. (dummy)           (string, optional) Remains for backward compatibility. Must be excluded or set to "*".
2. minconf           (numeric, optional, default=0) Only include transactions confirmed at least this many times.
3. include_watchonly (bool, optional, default=false) Also include balance in watch-only addresses (see 'importaddress')

Result:
amount              (numeric) The total amount in BCD received for this account.

Examples:

The total amount in the wallet with 1 or more confirmations
> bitcoindiamond-cli getbalance

The total amount in the wallet at least 6 blocks confirmed
> bitcoindiamond-cli getbalance "*" 6

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getbalance", "params": ["*", 6] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getnewaddress ( "label" "address_type" )

Returns a new Bitcoindiamond address for receiving payments.
If 'label' is specified, it is added to the address book
so payments received with the address will be associated with 'label'.

Arguments:
1. "label"          (string, optional) The label name for the address to be linked to. If not provided, the default label "" is used. It can also be set to the empty string "" to represent the default label. The label does not need to exist, it will be created if there is no label by the given name.
2. "address_type"   (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -addresstype.

Result:
"address"    (string) The new bitcoindiamond address

Examples:
> bitcoindiamond-cli getnewaddress
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getnewaddress", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getrawchangeaddress ( "address_type" )

Returns a new bitcoindiamond address, for receiving change.
This is for use with raw transactions, NOT normal use.

Arguments:
1. "address_type"           (string, optional) The address type to use. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.

Result:
"address"    (string) The address

Examples:
> bitcoindiamond-cli getrawchangeaddress
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getrawchangeaddress", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getreceivedbyaddress "address" ( minconf )

Returns the total amount received by the given address in transactions with at least minconf confirmations.

Arguments:
1. "address"         (string, required) The bitcoindiamond address for transactions.
2. minconf             (numeric, optional, default=1) Only include transactions confirmed at least this many times.

Result:
amount   (numeric) The total amount in BCD received at this address.

Examples:

The amount from transactions with at least 1 confirmation
> bitcoindiamond-cli getreceivedbyaddress "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX"

The amount including unconfirmed transactions, zero confirmations
> bitcoindiamond-cli getreceivedbyaddress "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" 0

The amount with at least 6 confirmations
> bitcoindiamond-cli getreceivedbyaddress "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" 6

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getreceivedbyaddress", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX", 6] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### gettransaction "txid" ( include_watchonly )

Get detailed information about in-wallet transaction <txid>

Arguments:
1. "txid"                  (string, required) The transaction id
2. "include_watchonly"     (bool, optional, default=false) Whether to include watch-only addresses in balance calculation and details[]

Result:
{
  "amount" : x.xxx,        (numeric) The transaction amount in BCD
  "fee": x.xxx,            (numeric) The amount of the fee in BCD. This is negative and only available for the
                              'send' category of transactions.
  "confirmations" : n,     (numeric) The number of confirmations
  "blockhash" : "hash",  (string) The block hash
  "blockindex" : xx,       (numeric) The index of the transaction in the block that includes it
  "blocktime" : ttt,       (numeric) The time in seconds since epoch (1 Jan 1970 GMT)
  "txid" : "transactionid",   (string) The transaction id.
  "time" : ttt,            (numeric) The transaction time in seconds since epoch (1 Jan 1970 GMT)
  "timereceived" : ttt,    (numeric) The time received in seconds since epoch (1 Jan 1970 GMT)
  "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
                                                   may be unknown for unconfirmed transactions not in the mempool
  "details" : [
    {
      "account" : "accountname",      (string) DEPRECATED. This field will be removed in a V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account name involved in the transaction, can be "" for the default account.
      "address" : "address",          (string) The bitcoin address involved in the transaction
      "category" : "send|receive",    (string) The category, either 'send' or 'receive'
      "amount" : x.xxx,                 (numeric) The amount in BCD
      "label" : "label",              (string) A comment for the address/transaction, if any
      "vout" : n,                       (numeric) the vout value
      "fee": x.xxx,                     (numeric) The amount of the fee in BCD. This is negative and only available for the
                                           'send' category of transactions.
      "abandoned": xxx                  (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the
                                           'send' category of transactions.
    }
    ,...
  ],
  "hex" : "data"         (string) Raw data for transaction
}

Examples:
> bitcoindiamond-cli gettransaction "1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"
> bitcoindiamond-cli gettransaction "1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d" true
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "gettransaction", "params": ["1075db55d416d3ca199f55b6084e2115b9345e16c5cf302fc80e9d5fbf5d48d"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### getunconfirmedbalance

Returns the server's total unconfirmed balance

#### getwalletinfo

Returns an object containing various wallet state info.

Result:
{
  "walletname": xxxxx,               (string) the wallet name
  "walletversion": xxxxx,            (numeric) the wallet version
  "balance": xxxxxxx,                (numeric) the total confirmed balance of the wallet in BCD
  "unconfirmed_balance": xxx,        (numeric) the total unconfirmed balance of the wallet in BCD
  "immature_balance": xxxxxx,        (numeric) the total immature balance of the wallet in BCD
  "txcount": xxxxxxx,                (numeric) the total number of transactions in the wallet
  "keypoololdest": xxxxxx,           (numeric) the timestamp (seconds since Unix epoch) of the oldest pre-generated key in the key pool
  "keypoolsize": xxxx,               (numeric) how many new keys are pre-generated (only counts external keys)
  "keypoolsize_hd_internal": xxxx,   (numeric) how many new keys are pre-generated for internal use (used for change outputs, only appears if the wallet is using this feature, otherwise external keys are used)
  "unlocked_until": ttt,             (numeric) the timestamp in seconds since epoch (midnight Jan 1 1970 GMT) that the wallet is unlocked for transfers, or 0 if the wallet is locked
  "paytxfee": x.xxxx,                (numeric) the transaction fee configuration, set in BCD/kB
  "hdseedid": "<hash160>"            (string, optional) the Hash160 of the HD seed (only present when HD is enabled)
  "hdmasterkeyid": "<hash160>"       (string, optional) alias for hdseedid retained for backwards-compatibility. Will be removed in V0.18.
  "private_keys_enabled": true|false (boolean) false if privatekeys are disabled for this wallet (enforced watch-only wallet)
}

Examples:
> bitcoindiamond-cli getwalletinfo
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getwalletinfo", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### importaddress "address" ( "label" rescan p2sh )

Adds an address or script (in hex) that can be watched as if it were in your wallet but cannot be used to spend. Requires a new wallet backup.

Arguments:
1. "address"          (string, required) The Bitcoin address (or hex-encoded script)
2. "label"            (string, optional, default="") An optional label
3. rescan               (boolean, optional, default=true) Rescan the wallet for transactions
4. p2sh                 (boolean, optional, default=false) Add the P2SH version of the script as well

Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
may report that the imported address exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.
If you have the full public key, you should call importpubkey instead of this.

Note: If you import a non-standard raw script in hex form, outputs sending to it will be treated
as change, and not show up in many RPCs.

Examples:

Import an address with rescan
> bitcoindiamond-cli importaddress "myaddress"

Import using a label without rescan
> bitcoindiamond-cli importaddress "myaddress" "testing" false

As a JSON-RPC call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importaddress", "params": ["myaddress", "testing", false] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### importmulti "requests" ( "options" )

Import addresses/scripts (with private or public keys, redeem script (P2SH)), rescanning all addresses in one-shot-only (rescan can be disabled via options). Requires a new wallet backup.

Arguments:
1. requests     (array, required) Data to be imported
    [     (array of json objects)
    {
      "scriptPubKey": "<script>" | { "address":"<address>" }, (string / json, required) Type of scriptPubKey (string for script, json for address)
      "timestamp": timestamp | "now"                        , (integer / string, required) Creation time of the key in seconds since epoch (Jan 1 1970 GMT),
                                                              or the string "now" to substitute the current synced blockchain time. The timestamp of the oldest
                                                              key will determine how far back blockchain rescans need to begin for missing wallet transactions.
                                                              "now" can be specified to bypass scanning, for keys which are known to never have been used, and
                                                              0 can be specified to scan the entire blockchain. Blocks up to 2 hours before the earliest key
                                                              creation time of all keys being imported by the importmulti call will be scanned.
      "redeemscript": "<script>"                            , (string, optional) Allowed only if the scriptPubKey is a P2SH address or a P2SH scriptPubKey
      "pubkeys": ["<pubKey>", ... ]                         , (array, optional) Array of strings giving pubkeys that must occur in the output or redeemscript
      "keys": ["<key>", ... ]                               , (array, optional) Array of strings giving private keys whose corresponding public keys must occur in the output or redeemscript
      "internal": <true>                                    , (boolean, optional, default: false) Stating whether matching outputs should be treated as not incoming payments
      "watchonly": <true>                                   , (boolean, optional, default: false) Stating whether matching outputs should be considered watched even when they're not spendable, only allowed if keys are empty
      "label": <label>                                      , (string, optional, default: '') Label to assign to the address (aka account name, for now), only allowed with internal=false
    }
    ,...
    ]
2. options                 (json, optional)
    {
     "rescan": <false>,         (boolean, optional, default: true) Stating if should rescan the blockchain after all imports
    }

Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
may report that the imported keys, addresses or scripts exists but related transactions are still missing.

Examples:
> bitcoindiamond-cli importmulti '[{ "scriptPubKey": { "address": "<my address>" }, "timestamp":1455191478 }, { "scriptPubKey": { "address": "<my 2nd address>" }, "label": "example 2", "timestamp": 1455191480 }]'
> bitcoindiamond-cli importmulti '[{ "scriptPubKey": { "address": "<my address>" }, "timestamp":1455191478 }]' '{ "rescan": false}'

Response is an array with the same size as the input that has the execution result :
  [{ "success": true } , { "success": false, "error": { "code": -1, "message": "Internal Server Error"} }, ... ]

#### importprivkey "privkey" ( "label" ) ( rescan )

Adds a private key (as returned by dumpprivkey) to your wallet. Requires a new wallet backup.
Hint: use importmulti to import more than one private key.

Arguments:
1. "privkey"          (string, required) The private key (see dumpprivkey)
2. "label"            (string, optional, default="") An optional label
3. rescan               (boolean, optional, default=true) Rescan the wallet for transactions

Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
may report that the imported key exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.

Examples:

Dump a private key
> bitcoindiamond-cli dumpprivkey "myaddress"

Import the private key with rescan
> bitcoindiamond-cli importprivkey "mykey"

Import using a label and without rescan
> bitcoindiamond-cli importprivkey "mykey" "testing" false

Import using default blank label and without rescan
> bitcoindiamond-cli importprivkey "mykey" "" false

As a JSON-RPC call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importprivkey", "params": ["mykey", "testing", false] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### importprunedfunds

Imports funds without rescan. Corresponding address or script must previously be included in wallet. Aimed towards pruned wallets. The end-user is responsible to import additional transactions that subsequently spend the imported outputs or rescan after the point in the blockchain the transaction is included.

Arguments:
1. "rawtransaction" (string, required) A raw transaction in hex funding an already-existing address in wallet
2. "txoutproof"     (string, required) The hex output from gettxoutproof that contains the transaction

#### importpubkey "pubkey" ( "label" rescan )

Adds a public key (in hex) that can be watched as if it were in your wallet but cannot be used to spend. Requires a new wallet backup.

Arguments:
1. "pubkey"           (string, required) The hex-encoded public key
2. "label"            (string, optional, default="") An optional label
3. rescan               (boolean, optional, default=true) Rescan the wallet for transactions

Note: This call can take over an hour to complete if rescan is true, during that time, other rpc calls
may report that the imported pubkey exists but related transactions are still missing, leading to temporarily incorrect/bogus balances and unspent outputs until rescan completes.

Examples:

Import a public key with rescan
> bitcoindiamond-cli importpubkey "mypubkey"

Import using a label without rescan
> bitcoindiamond-cli importpubkey "mypubkey" "testing" false

As a JSON-RPC call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importpubkey", "params": ["mypubkey", "testing", false] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### importwallet "filename"

Imports keys from a wallet dump file (see dumpwallet). Requires a new wallet backup to include imported keys.

Arguments:
1. "filename"    (string, required) The wallet file

Examples:

Dump the wallet
> bitcoindiamond-cli dumpwallet "test"

Import the wallet
> bitcoindiamond-cli importwallet "test"

Import using the json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "importwallet", "params": ["test"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### keypoolrefill ( newsize )

Fills the keypool.

Arguments
1. newsize     (numeric, optional, default=100) The new keypool size

Examples:
> bitcoindiamond-cli keypoolrefill
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "keypoolrefill", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listaddressgroupings

Lists groups of addresses which have had their common ownership
made public by common use as inputs or as the resulting change
in past transactions

Result:
[
  [
    [
      "address",            (string) The bitcoindiamond address
      amount,                 (numeric) The amount in BCD
      "label"               (string, optional) The label
    ]
    ,...
  ]
  ,...
]

Examples:
> bitcoindiamond-cli listaddressgroupings
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listaddressgroupings", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listlabels ( "purpose" )

Returns the list of all labels, or labels that are assigned to addresses with a specific purpose.

Arguments:
1. "purpose"    (string, optional) Address purpose to list labels for ('send','receive'). An empty string is the same as not providing this argument.

Result:
[               (json array of string)
  "label",      (string) Label name
  ...
]

Examples:

List all labels
> bitcoindiamond-cli listlabels

List labels that have receiving addresses
> bitcoindiamond-cli listlabels receive

List labels that have sending addresses
> bitcoindiamond-cli listlabels send

As json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listlabels", "params": [receive] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listlockunspent

Returns list of temporarily unspendable outputs.
See the lockunspent call to lock and unlock transactions for spending.

Result:
[
  {
    "txid" : "transactionid",     (string) The transaction id locked
    "vout" : n                      (numeric) The vout value
  }
  ,...
]

Examples:

List the unspent transactions
> bitcoindiamond-cli listunspent

Lock an unspent transaction
> bitcoindiamond-cli lockunspent false "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"

List the locked transactions
> bitcoindiamond-cli listlockunspent

Unlock the transaction again
> bitcoindiamond-cli lockunspent true "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listlockunspent", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listreceivedbyaddress ( minconf include_empty include_watchonly address_filter )

List balances by receiving address.

Arguments:
1. minconf           (numeric, optional, default=1) The minimum number of confirmations before payments are included.
2. include_empty     (bool, optional, default=false) Whether to include addresses that haven't received any payments.
3. include_watchonly (bool, optional, default=false) Whether to include watch-only addresses (see 'importaddress').
4. address_filter    (string, optional) If present, only return information on this address.

Result:
[
  {
    "involvesWatchonly" : true,        (bool) Only returned if imported addresses were involved in transaction
    "address" : "receivingaddress",  (string) The receiving address
    "account" : "accountname",       (string) DEPRECATED. Backwards compatible alias for label.
    "amount" : x.xxx,                  (numeric) The total amount in BCD received by the address
    "confirmations" : n,               (numeric) The number of confirmations of the most recent transaction included
    "label" : "label",               (string) The label of the receiving address. The default label is "".
    "txids": [
       "txid",                         (string) The ids of transactions received with the address
       ...
    ]
  }
  ,...
]

Examples:
> bitcoindiamond-cli listreceivedbyaddress
> bitcoindiamond-cli listreceivedbyaddress 6 true
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listreceivedbyaddress", "params": [6, true, true] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listreceivedbyaddress", "params": [6, true, true, "1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listsinceblock ( "blockhash" target_confirmations include_watchonly include_removed )

Get all transactions in blocks since block [blockhash], or all transactions if omitted.
If "blockhash" is no longer a part of the main chain, transactions from the fork point onward are included.
Additionally, if include_removed is set, transactions affecting the wallet which were removed are returned in the "removed" array.

Arguments:
1. "blockhash"            (string, optional) The block hash to list transactions since
2. target_confirmations:    (numeric, optional, default=1) Return the nth block hash from the main chain. e.g. 1 would mean the best block hash. Note: this is not used as a filter, but only affects [lastblock] in the return value
3. include_watchonly:       (bool, optional, default=false) Include transactions to watch-only addresses (see 'importaddress')
4. include_removed:         (bool, optional, default=true) Show transactions that were removed due to a reorg in the "removed" array
                                                           (not guaranteed to work on pruned nodes)

Result:
{
  "transactions": [
    "account":"accountname",       (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The account name associated with the transaction. Will be "" for the default account.
    "address":"address",    (string) The bitcoin address of the transaction. Not present for move transactions (category = move).
    "category":"send|receive",     (string) The transaction category. 'send' has negative amounts, 'receive' has positive amounts.
    "amount": x.xxx,          (numeric) The amount in BCD. This is negative for the 'send' category, and for the 'move' category for moves
                                          outbound. It is positive for the 'receive' category, and for the 'move' category for inbound funds.
    "vout" : n,               (numeric) the vout value
    "fee": x.xxx,             (numeric) The amount of the fee in BCD. This is negative and only available for the 'send' category of transactions.
    "confirmations": n,       (numeric) The number of confirmations for the transaction. Available for 'send' and 'receive' category of transactions.
                                          When it's < 0, it means the transaction conflicted that many blocks ago.
    "blockhash": "hashvalue",     (string) The block hash containing the transaction. Available for 'send' and 'receive' category of transactions.
    "blockindex": n,          (numeric) The index of the transaction in the block that includes it. Available for 'send' and 'receive' category of transactions.
    "blocktime": xxx,         (numeric) The block time in seconds since epoch (1 Jan 1970 GMT).
    "txid": "transactionid",  (string) The transaction id. Available for 'send' and 'receive' category of transactions.
    "time": xxx,              (numeric) The transaction time in seconds since epoch (Jan 1 1970 GMT).
    "timereceived": xxx,      (numeric) The time received in seconds since epoch (Jan 1 1970 GMT). Available for 'send' and 'receive' category of transactions.
    "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
                                                   may be unknown for unconfirmed transactions not in the mempool
    "abandoned": xxx,         (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the 'send' category of transactions.
    "comment": "...",       (string) If a comment is associated with the transaction.
    "label" : "label"       (string) A comment for the address/transaction, if any
    "to": "...",            (string) If a comment to is associated with the transaction.
  ],
  "removed": [
    <structure is the same as "transactions" above, only present if include_removed=true>
    Note: transactions that were re-added in the active chain will appear as-is in this array, and may thus have a positive confirmation count.
  ],
  "lastblock": "lastblockhash"     (string) The hash of the block (target_confirmations-1) from the best block on the main chain. This is typically used to feed back into listsinceblock the next time you call it. So you would generally use a target_confirmations of say 6, so you will be continually re-notified of transactions until they've reached 6 confirmations plus any new ones
}

Examples:
> bitcoindiamond-cli listsinceblock
> bitcoindiamond-cli listsinceblock "000000000000000bacf66f7497b7dc45ef753ee9a7d38571037cdb1a57f663ad" 6
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listsinceblock", "params": ["000000000000000bacf66f7497b7dc45ef753ee9a7d38571037cdb1a57f663ad", 6] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listtransactions (label count skip include_watchonly)

If a label name is provided, this will return only incoming transactions paying to addresses with the specified label.

Returns up to 'count' most recent transactions skipping the first 'from' transactions.
Note that the "account" argument and "otheraccount" return value have been removed in V0.17. To use this RPC with an "account" argument, restart
bitcoind with -deprecatedrpc=accounts

Arguments:
1. "label"    (string, optional) If set, should be a valid label name to return only incoming transactions
              with the specified label, or "*" to disable filtering and return all transactions.
2. count          (numeric, optional, default=10) The number of transactions to return
3. skip           (numeric, optional, default=0) The number of transactions to skip
4. include_watchonly (bool, optional, default=false) Include transactions to watch-only addresses (see 'importaddress')

Result:
[
  {
    "address":"address",    (string) The bitcoindiamond address of the transaction.
    "category":"send|receive", (string) The transaction category.
    "amount": x.xxx,          (numeric) The amount in BCD. This is negative for the 'send' category, and is positive
                                        for the 'receive' category,
    "label": "label",       (string) A comment for the address/transaction, if any
    "vout": n,                (numeric) the vout value
    "fee": x.xxx,             (numeric) The amount of the fee in BCD. This is negative and only available for the
                                         'send' category of transactions.
    "confirmations": n,       (numeric) The number of confirmations for the transaction. Negative confirmations indicate the
                                         transaction conflicts with the block chain
    "trusted": xxx,           (bool) Whether we consider the outputs of this unconfirmed transaction safe to spend.
    "blockhash": "hashvalue", (string) The block hash containing the transaction.
    "blockindex": n,          (numeric) The index of the transaction in the block that includes it.
    "blocktime": xxx,         (numeric) The block time in seconds since epoch (1 Jan 1970 GMT).
    "txid": "transactionid", (string) The transaction id.
    "time": xxx,              (numeric) The transaction time in seconds since epoch (midnight Jan 1 1970 GMT).
    "timereceived": xxx,      (numeric) The time received in seconds since epoch (midnight Jan 1 1970 GMT).
    "comment": "...",       (string) If a comment is associated with the transaction.
    "bip125-replaceable": "yes|no|unknown",  (string) Whether this transaction could be replaced due to BIP125 (replace-by-fee);
                                                     may be unknown for unconfirmed transactions not in the mempool
    "abandoned": xxx          (bool) 'true' if the transaction has been abandoned (inputs are respendable). Only available for the
                                         'send' category of transactions.
  }
]

Examples:

List the most recent 10 transactions in the systems
> bitcoindiamond-cli listtransactions

List transactions 100 to 120
> bitcoindiamond-cli listtransactions "*" 20 100

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listtransactions", "params": ["*", 20, 100] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listunspent ( minconf maxconf  ["addresses",...] [include_unsafe] [query_options])

Returns array of unspent transaction outputs
with between minconf and maxconf (inclusive) confirmations.
Optionally filter to only include txouts paid to specified addresses.

Arguments:
1. minconf          (numeric, optional, default=1) The minimum confirmations to filter
2. maxconf          (numeric, optional, default=9999999) The maximum confirmations to filter
3. "addresses"      (string) A json array of bitcoin addresses to filter
    [
      "address"     (string) bitcoin address
      ,...
    ]
4. include_unsafe (bool, optional, default=true) Include outputs that are not safe to spend
                  See description of "safe" attribute below.
5. query_options    (json, optional) JSON with query options
    {
      "minimumAmount"    (numeric or string, default=0) Minimum value of each UTXO in BCD
      "maximumAmount"    (numeric or string, default=unlimited) Maximum value of each UTXO in BCD
      "maximumCount"     (numeric or string, default=unlimited) Maximum number of UTXOs
      "minimumSumAmount" (numeric or string, default=unlimited) Minimum sum value of all UTXOs in BCD
    }

Result
[                   (array of json object)
  {
    "txid" : "txid",          (string) the transaction id
    "vout" : n,               (numeric) the vout value
    "address" : "address",    (string) the bitcoin address
    "label" : "label",        (string) The associated label, or "" for the default label
    "account" : "account",    (string) DEPRECATED. This field will be removed in V0.18. To see this deprecated field, start bitcoind with -deprecatedrpc=accounts. The associated account, or "" for the default account
    "scriptPubKey" : "key",   (string) the script key
    "amount" : x.xxx,         (numeric) the transaction output amount in BCD
    "confirmations" : n,      (numeric) The number of confirmations
    "redeemScript" : n        (string) The redeemScript if scriptPubKey is P2SH
    "spendable" : xxx,        (bool) Whether we have the private keys to spend this output
    "solvable" : xxx,         (bool) Whether we know how to spend this output, ignoring the lack of keys
    "safe" : xxx              (bool) Whether this output is considered safe to spend. Unconfirmed transactions
                              from outside keys and unconfirmed replacement transactions are considered unsafe
                              and are not eligible for spending by fundrawtransaction and sendtoaddress.
  }
  ,...
]

Examples
> bitcoindiamond-cli listunspent
> bitcoindiamond-cli listunspent 6 9999999 "[\"1PGFqEzfmQch1gKD3ra4k18PNj3tTUUSqg\",\"1LtvqCaApEdUGFkpKMM4MstjcaL4dKg8SP\"]"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listunspent", "params": [6, 9999999 "[\"1PGFqEzfmQch1gKD3ra4k18PNj3tTUUSqg\",\"1LtvqCaApEdUGFkpKMM4MstjcaL4dKg8SP\"]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/
> bitcoindiamond-cli listunspent 6 9999999 '[]' true '{ "minimumAmount": 0.005 }'
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listunspent", "params": [6, 9999999, [] , true, { "minimumAmount": 0.005 } ] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### listwallets

Returns a list of currently loaded wallets.
For full information on the wallet, use "getwalletinfo"

Result:
[                         (json array of strings)
  "walletname"            (string) the wallet name
   ...
]

Examples:
> bitcoindiamond-cli listwallets
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "listwallets", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### loadwallet "filename"

Loads a wallet from a wallet file or directory.
Note that all wallet command-line options used when starting bitcoind will be
applied to the new wallet (eg -zapwallettxes, upgradewallet, rescan, etc).

Arguments:
1. "filename"    (string, required) The wallet directory or .dat file.

Result:
{
  "name" :    <wallet_name>,        (string) The wallet name if loaded successfully.
  "warning" : <warning>,            (string) Warning message if wallet was not loaded cleanly.
}

Examples:
> bitcoindiamond-cli loadwallet "test.dat"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "loadwallet", "params": ["test.dat"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### lockunspent unlock ([{"txid":"txid","vout":n},...])

Updates list of temporarily unspendable outputs.
Temporarily lock (unlock=false) or unlock (unlock=true) specified transaction outputs.
If no transaction outputs are specified when unlocking then all current locked transaction outputs are unlocked.
A locked transaction output will not be chosen by automatic coin selection, when spending bitcoins.
Locks are stored in memory only. Nodes start with zero locked outputs, and the locked output list
is always cleared (by virtue of process exit) when a node stops or fails.
Also see the listunspent call

Arguments:
1. unlock            (boolean, required) Whether to unlock (true) or lock (false) the specified transactions
2. "transactions"  (string, optional) A json array of objects. Each object the txid (string) vout (numeric)
     [           (json array of json objects)
       {
         "txid":"id",    (string) The transaction id
         "vout": n         (numeric) The output number
       }
       ,...
     ]

Result:
true|false    (boolean) Whether the command was successful or not

Examples:

List the unspent transactions
> bitcoindiamond-cli listunspent

Lock an unspent transaction
> bitcoindiamond-cli lockunspent false "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"

List the locked transactions
> bitcoindiamond-cli listlockunspent

Unlock the transaction again
> bitcoindiamond-cli lockunspent true "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "lockunspent", "params": [false, "[{\"txid\":\"a08e6907dbbd3d809776dbfc5d82e371b764ed838b5655e72f463568df1aadf0\",\"vout\":1}]"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### removeprunedfunds "txid"

Deletes the specified transaction from the wallet. Meant for use with pruned wallets and as a companion to importprunedfunds. This will affect wallet balances.

Arguments:
1. "txid"           (string, required) The hex-encoded id of the transaction you are deleting

Examples:
> bitcoindiamond-cli removeprunedfunds "a8d0c0184dde994a09ec054286f1ce581bebf46446a512166eae7628734ea0a5"

As a JSON-RPC call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "removeprunedfunds", "params": ["a8d0c0184dde994a09ec054286f1ce581bebf46446a512166eae7628734ea0a5"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### rescanblockchain ("start_height") ("stop_height")

Rescan the local blockchain for wallet related transactions.

Arguments:
1. "start_height"    (numeric, optional) block height where the rescan should start
2. "stop_height"     (numeric, optional) the last block height that should be scanned

Result:
{
  "start_height"     (numeric) The block height where the rescan has started. If omitted, rescan started from the genesis block.
  "stop_height"      (numeric) The height of the last rescanned block. If omitted, rescan stopped at the chain tip.
}

Examples:
> bitcoindiamond-cli rescanblockchain 100000 120000
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "rescanblockchain", "params": [100000, 120000] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### sendmany "" {"address":amount,...} ( minconf "comment" ["address",...] replaceable conf_target "estimate_mode")

Send multiple times. Amounts are double-precision floating point numbers.
Note that the "fromaccount" argument has been removed in V0.17. To use this RPC with a "fromaccount" argument, restart
bitcoind with -deprecatedrpc=accounts


Arguments:
1. "dummy"               (string, required) Must be set to "" for backwards compatibility.
2. "amounts"             (string, required) A json object with addresses and amounts
    {
      "address":amount   (numeric or string) The bitcoindiamond address is the key, the numeric amount (can be string) in BCD is the value
      ,...
    }
3. minconf                 (numeric, optional, default=1) Only use the balance confirmed at least this many times.
4. "comment"             (string, optional) A comment
5. subtractfeefrom         (array, optional) A json array with addresses.
                           The fee will be equally deducted from the amount of each selected address.
                           Those recipients will receive less bitcoindiamonds than you enter in their corresponding amount field.
                           If no addresses are specified here, the sender pays the fee.
    [
      "address"          (string) Subtract fee from this address
      ,...
    ]
6. replaceable            (boolean, optional) Allow this transaction to be replaced by a transaction with higher fees via BIP 125
7. conf_target            (numeric, optional) Confirmation target (in blocks)
8. "estimate_mode"      (string, optional, default=UNSET) The fee estimate mode, must be one of:
       "UNSET"
       "ECONOMICAL"
       "CONSERVATIVE"

Result:
"txid"                   (string) The transaction id for the send. Only 1 transaction is created regardless of
                                    the number of addresses.

Examples:

Send two amounts to two different addresses:
> bitcoindiamond-cli sendmany "" "{\"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX\":0.01,\"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz\":0.02}"

Send two amounts to two different addresses setting the confirmation and comment:
> bitcoindiamond-cli sendmany "" "{\"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX\":0.01,\"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz\":0.02}" 6 "testing"

Send two amounts to two different addresses, subtract fee from amount:
> bitcoindiamond-cli sendmany "" "{\"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX\":0.01,\"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz\":0.02}" 1 "" "[\"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX\",\"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz\"]"

As a json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sendmany", "params": ["", {"1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX":0.01,"1353tsE8YMTA4EuV7dgUXGjNFf9KpVvKHz":0.02}, 6, "testing"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### sendtoaddress "address" amount ( "comment" "comment_to" subtractfeefromamount replaceable conf_target "estimate_mode")

Send an amount to a given address.

Arguments:
1. "address"            (string, required) The bitcoindiamond address to send to.
2. "amount"             (numeric or string, required) The amount in BCD to send. eg 0.1
3. "comment"            (string, optional) A comment used to store what the transaction is for.
                             This is not part of the transaction, just kept in your wallet.
4. "comment_to"         (string, optional) A comment to store the name of the person or organization
                             to which you're sending the transaction. This is not part of the
                             transaction, just kept in your wallet.
5. subtractfeefromamount  (boolean, optional, default=false) The fee will be deducted from the amount being sent.
                             The recipient will receive less bitcoins than you enter in the amount field.
6. replaceable            (boolean, optional) Allow this transaction to be replaced by a transaction with higher fees via BIP 125
7. conf_target            (numeric, optional) Confirmation target (in blocks)
8. "estimate_mode"      (string, optional, default=UNSET) The fee estimate mode, must be one of:
       "UNSET"
       "ECONOMICAL"
       "CONSERVATIVE"

Result:
"txid"                  (string) The transaction id.

Examples:
> bitcoindiamond-cli sendtoaddress "1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd" 0.1
> bitcoindiamond-cli sendtoaddress "1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd" 0.1 "donation" "seans outpost"
> bitcoindiamond-cli sendtoaddress "1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd" 0.1 "" "" true
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sendtoaddress", "params": ["1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd", 0.1, "donation", "seans outpost"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### sethdseed ( "newkeypool" "seed" )

Set or generate a new HD wallet seed. Non-HD wallets will not be upgraded to being a HD wallet. Wallets that are already
HD will have a new HD seed set so that new keys added to the keypool will be derived from this new seed.

Note that you will need to MAKE A NEW BACKUP of your wallet after setting the HD wallet seed.

Arguments:
1. "newkeypool"         (boolean, optional, default=true) Whether to flush old unused addresses, including change addresses, from the keypool and regenerate it.
                             If true, the next address from getnewaddress and change address from getrawchangeaddress will be from this new seed.
                             If false, addresses (including change addresses if the wallet already had HD Chain Split enabled) from the existing
                             keypool will be used until it has been depleted.
2. "seed"               (string, optional) The WIF private key to use as the new HD seed; if not provided a random seed will be used.
                             The seed value can be retrieved using the dumpwallet command. It is the private key marked hdseed=1

Examples:
> bitcoindiamond-cli sethdseed
> bitcoindiamond-cli sethdseed false
> bitcoindiamond-cli sethdseed true "wifkey"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "sethdseed", "params": [true, "wifkey"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### settxfee amount

Set the transaction fee per kB for this wallet. Overrides the global -paytxfee command line parameter.

Arguments:
1. amount         (numeric or string, required) The transaction fee in BCD/kB

Result
true|false        (boolean) Returns true if successful

Examples:
> bitcoindiamond-cli settxfee 0.00001
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "settxfee", "params": [0.00001] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### signmessage "address" "message"

Sign a message with the private key of an address

Arguments:
1. "address"         (string, required) The bitcoindiamond address to use for the private key.
2. "message"         (string, required) The message to create a signature of.

Result:
"signature"          (string) The signature of the message encoded in base 64

Examples:

Unlock the wallet for 30 seconds
> bitcoindiamond-cli walletpassphrase "mypassphrase" 30

Create the signature
> bitcoindiamond-cli signmessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "my message"

Verify the signature
> bitcoindiamond-cli verifymessage "1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX" "signature" "my message"

As json rpc

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signmessage", "params": ["1D1ZrZNe3JUo7ZycKEYQQiQAWd9y54F4XX", "my message"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### signrawtransactionwithwallet "hexstring" ( [{"txid":"id","vout":n,"scriptPubKey":"hex","redeemScript":"hex"},...] sighashtype )

Sign inputs for raw transaction (serialized, hex-encoded).
The second optional argument (may be null) is an array of previous transaction outputs that
this transaction depends on but may not yet be in the block chain.


Arguments:
1. "hexstring"                      (string, required) The transaction hex string
2. "prevtxs"                        (string, optional) An json array of previous dependent transaction outputs
     [                              (json array of json objects, or 'null' if none provided)
       {
         "txid":"id",               (string, required) The transaction id
         "vout":n,                  (numeric, required) The output number
         "scriptPubKey": "hex",     (string, required) script key
         "redeemScript": "hex",     (string, required for P2SH or P2WSH) redeem script
         "amount": value            (numeric, required) The amount spent
       }
       ,...
    ]
3. "sighashtype"                    (string, optional, default=ALL) The signature hash type. Must be one of
       "ALL"
       "NONE"
       "SINGLE"
       "ALL|ANYONECANPAY"
       "NONE|ANYONECANPAY"
       "SINGLE|ANYONECANPAY"

Result:
{
  "hex" : "value",                  (string) The hex-encoded raw transaction with signature(s)
  "complete" : true|false,          (boolean) If the transaction has a complete set of signatures
  "errors" : [                      (json array of objects) Script verification errors (if there are any)
    {
      "txid" : "hash",              (string) The hash of the referenced, previous transaction
      "vout" : n,                   (numeric) The index of the output to spent and used as input
      "scriptSig" : "hex",          (string) The hex-encoded signature script
      "sequence" : n,               (numeric) Script sequence number
      "error" : "text"              (string) Verification or signing error related to the input
    }
    ,...
  ]
}

Examples:
> bitcoindiamond-cli signrawtransactionwithwallet "myhex"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "signrawtransactionwithwallet", "params": ["myhex"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### unloadwallet ( "wallet_name" )

Unloads the wallet referenced by the request endpoint otherwise unloads the wallet specified in the argument.
Specifying the wallet name on a wallet endpoint is invalid.
Arguments:
1. "wallet_name"    (string, optional) The name of the wallet to unload.

Examples:
> bitcoindiamond-cli unloadwallet wallet_name
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "unloadwallet", "params": [wallet_name] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### walletcreatefundedpsbt [{"txid":"id","vout":n},...] [{"address":amount},{"data":"hex"},...] ( locktime ) ( replaceable ) ( options bip32derivs )

Creates and funds a transaction in the Partially Signed Transaction format. Inputs will be added if supplied inputs are not enough
Implements the Creator and Updater roles.

Arguments:
1. "inputs"                (array, required) A json array of json objects
     [
       {
         "txid":"id",      (string, required) The transaction id
         "vout":n,         (numeric, required) The output number
         "sequence":n      (numeric, optional) The sequence number
       }
       ,...
     ]
2. "outputs"               (array, required) a json array with outputs (key-value pairs)
   [
    {
      "address": x.xxx,    (obj, optional) A key-value pair. The key (string) is the bitcoin address, the value (float or string) is the amount in BCD
    },
    {
      "data": "hex"        (obj, optional) A key-value pair. The key must be "data", the value is hex encoded data
    }
    ,...                     More key-value pairs of the above form. For compatibility reasons, a dictionary, which holds the key-value pairs directly, is also
                             accepted as second parameter.
   ]
3. locktime                  (numeric, optional, default=0) Raw locktime. Non-0 value also locktime-activates inputs
                             Allows this transaction to be replaced by a transaction with higher fees. If provided, it is an error if explicit sequence numbers are incompatible.
4. options                 (object, optional)
   {
     "changeAddress"          (string, optional, default pool address) The bitcoin address to receive the change
     "changePosition"         (numeric, optional, default random) The index of the change output
     "change_type"            (string, optional) The output type to use. Only valid if changeAddress is not specified. Options are "legacy", "p2sh-segwit", and "bech32". Default is set by -changetype.
     "includeWatching"        (boolean, optional, default false) Also select inputs which are watch only
     "lockUnspents"           (boolean, optional, default false) Lock selected unspent outputs
     "feeRate"                (numeric, optional, default not set: makes wallet determine the fee) Set a specific fee rate in BCD/kB
     "subtractFeeFromOutputs" (array, optional) A json array of integers.
                              The fee will be equally deducted from the amount of each specified output.
                              The outputs are specified by their zero-based index, before any change output is added.
                              Those recipients will receive less bitcoins than you enter in their corresponding amount field.
                              If no outputs are specified here, the sender pays the fee.
                                  [vout_index,...]
     "replaceable"            (boolean, optional) Marks this transaction as BIP125 replaceable.
                              Allows this transaction to be replaced by a transaction with higher fees
     "conf_target"            (numeric, optional) Confirmation target (in blocks)
     "estimate_mode"          (string, optional, default=UNSET) The fee estimate mode, must be one of:
         "UNSET"
         "ECONOMICAL"
         "CONSERVATIVE"
   }
5. bip32derivs                    (boolean, optional, default=false) If true, includes the BIP 32 derivation paths for public keys if we know them

Result:
{
  "psbt": "value",        (string)  The resulting raw transaction (base64-encoded string)
  "fee":       n,         (numeric) Fee in BCD the resulting transaction pays
  "changepos": n          (numeric) The position of the added change output, or -1
}

Examples:

Create a transaction with no inputs

> bitcoindiamond-cli walletcreatefundedpsbt "[{\"txid\":\"myid\",\"vout\":0}]" "[{\"data\":\"00010203\"}]"

#### walletlock

Removes the wallet encryption key from memory, locking the wallet.
After calling this method, you will need to call walletpassphrase again
before being able to call any methods which require the wallet to be unlocked.

Examples:

Set the passphrase for 2 minutes to perform a transaction
> bitcoindiamond-cli walletpassphrase "my pass phrase" 120

Perform a send (requires passphrase set)
> bitcoindiamond-cli sendtoaddress "1M72Sfpbz1BPpXFHz9m3CdqATR44Jvaydd" 1.0

Clear the passphrase since we are done before 2 minutes is up
> bitcoindiamond-cli walletlock

As json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "walletlock", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### walletpassphrase "passphrase" timeout

Stores the wallet decryption key in memory for 'timeout' seconds.
This is needed prior to performing transactions related to private keys such as sending bitcoins

Arguments:
1. "passphrase"     (string, required) The wallet passphrase
2. timeout            (numeric, required) The time to keep the decryption key in seconds; capped at 100000000 (~3 years).

Note:
Issuing the walletpassphrase command while the wallet is already unlocked will set a new unlock
time that overrides the old one.

Examples:

Unlock the wallet for 60 seconds
> bitcoindiamond-cli walletpassphrase "my pass phrase" 60

Lock the wallet again (before 60 seconds)
> bitcoindiamond-cli walletlock

As json rpc call

> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "walletpassphrase", "params": ["my pass phrase", 60] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### walletpassphrasechange "oldpassphrase" "newpassphrase"

Changes the wallet passphrase from 'oldpassphrase' to 'newpassphrase'.

Arguments:
1. "oldpassphrase"      (string) The current passphrase
2. "newpassphrase"      (string) The new passphrase

Examples:
> bitcoindiamond-cli walletpassphrasechange "old one" "new one"
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "walletpassphrasechange", "params": ["old one", "new one"] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/

#### walletprocesspsbt "psbt" ( sign "sighashtype" bip32derivs )

Update a PSBT with input information from our wallet and then sign inputs
that we can sign for.


Arguments:
1. "psbt"                      (string, required) The transaction base64 string
2. sign                          (boolean, optional, default=true) Also sign the transaction when updating
3. "sighashtype"            (string, optional, default=ALL) The signature hash type to sign with if not specified by the PSBT. Must be one of
       "ALL"
       "NONE"
       "SINGLE"
       "ALL|ANYONECANPAY"
       "NONE|ANYONECANPAY"
       "SINGLE|ANYONECANPAY"
4. bip32derivs                    (boolean, optional, default=false) If true, includes the BIP 32 derivation paths for public keys if we know them

Result:
{
  "psbt" : "value",          (string) The base64-encoded partially signed transaction
  "complete" : true|false,   (boolean) If the transaction has a complete set of signatures
  ]
}

Examples:

> bitcoindiamond-cli walletprocesspsbt "psbt"

### Zmq

#### getzmqnotifications

Returns information about the active ZeroMQ notifications.

Result:
[
  {                        (json object)
    "type": "pubhashtx",   (string) Type of notification
    "address": "..."       (string) Address of the publisher
  },
  ...
]

Examples:
> bitcoindiamond-cli getzmqnotifications
> curl --user myusername --data-binary '{"jsonrpc": "1.0", "id":"curltest", "method": "getzmqnotifications", "params": [] }' -H 'content-type: text/plain;' http://127.0.0.1:7116/



## REST Interface

### Transactions

```
GET /rest/tx/.
```

Given a transaction hash: returns a transaction in binary, hex-encoded binary, or JSON formats.

For full TX query capability, one must enable the transaction index via "txindex=1" command line / configuration option.

### Blocks

```
GET /rest/block/.` `GET /rest/block/notxdetails/.
```

Given a block hash: returns a block, in binary, hex-encoded binary or JSON formats.

The HTTP request and response are both handled entirely in-memory, thus making maximum memory usage at least 2.66MB (1 MB max block, plus hex encoding) per request.

With the /notxdetails/ option JSON response will only contain the transaction hash instead of the complete transaction details. The option only affects the JSON response.

### Blockheaders

```
GET /rest/headers//.
```

Given a block hash: returns amount of blockheaders in upward direction.

### Chaininfos

```
GET /rest/chaininfo.json
```

Returns various state info regarding block chain processing. Only supports JSON as output format.

- chain : (string) current network name as defined in BIP70 (main, test, regtest)
- blocks : (numeric) the current number of blocks processed in the server
- headers : (numeric) the current number of headers we have validated
- bestblockhash : (string) the hash of the currently best block
- difficulty : (numeric) the current difficulty
- mediantime : (numeric) the median time of the 11 blocks before the most recent block on the blockchain
- verificationprogress : (numeric) estimate of verification progress [0..1]
- chainwork : (string) total amount of work in active chain, in hexadecimal
- pruned : (boolean) if the blocks are subject to pruning
- pruneheight : (numeric) highest block available
- softforks : (array) status of softforks in progress
- bip9_softforks : (object) status of BIP9 softforks in progress

### Query UTXO set

```
GET /rest/getutxos//-/-/.../-.
```

The getutxo command allows querying of the UTXO set given a set of outpoints. See BIP64 for input and output serialisation: https://github.com/bitcoin/bips/blob/master/bip-0064.mediawiki

Example:

```
$ curl localhost:18332/rest/getutxos/checkmempool/b2cdfd7b89def827ff8af7cd9bff7627ff72e5e8b0f71210f92ea7a4000c5d75-0.json 2>/dev/null | json_pp
{
   "chainHeight" : 325347,
   "chaintipHash" : "00000000fb01a7f3745a717f8caebee056c484e6e0bfe4a9591c235bb70506fb",
   "bitmap": "1",
   "utxos" : [
      {
         "txvers" : 1
         "height" : 2147483647,
         "value" : 8.8687,		 
         "scriptPubKey" : {
            "asm" : "OP_DUP OP_HASH160 1c7cebb529b86a04c683dfa87be49de35bcf589e OP_EQUALVERIFY OP_CHECKSIG",
            "hex" : "76a9141c7cebb529b86a04c683dfa87be49de35bcf589e88ac",
            "reqSigs" : 1,
            "type" : "pubkeyhash",
            "addresses" : [
               "mi7as51dvLJsizWnTMurtRmrP8hG2m1XvD"
            ]
         }
      }
   ]
}
```

### Memory pool

```
GET /rest/mempool/info.json
```

Returns various information about the TX mempool. Only supports JSON as output format.

- size : (numeric) the number of transactions in the TX mempool
- bytes : (numeric) size of the TX mempool in bytes
- usage : (numeric) total TX mempool memory usage
- maxmempool : (numeric) maximum memory usage for the mempool in bytes
- mempoolminfee : (numeric) minimum feerate (BTC per KB) for tx to be accepted

```
GET /rest/mempool/contents.json
```

Returns transactions in the TX mempool. Only supports JSON as output format.

