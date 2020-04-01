# Bitcoindiamond 节点搭建

## 服务器推荐配置

- CPU **4** 核以上
- 硬盘 **500G** 以上
- 内存 **16G** 
- 系统推荐 Ubuntu 18.04.4 LTS 64-bit 或 Debian 10 (buster) 64-bit

## 安装节点程序

### 下载官方发布版本

在 [发布版本](https://github.com/eveybcd/BitcoinDiamond/releases) 页面下载对应系统的最新版本，解压文件夹里面的 bin 目录中即包含可运行的节点程序。

### 源码编译

也可从源码直接按需编译，以 Debian 系统为例，编译步骤如下：（其他系统请见 [Building](https://github.com/eveybcd/BitcoinDiamond/tree/master/doc#building)）

```bash
# 下载源码
wget https://github.com/eveybcd/BitcoinDiamond/archive/v1.3.0.tar.gz
# 解压缩
tar -zxvf v1.3.0.tar.gz
cd BitcoinDiamond-1.3.0/
# 安装依赖
sudo apt-get update
sudo apt-get install build-essential libtool autotools-dev automake pkg-config libssl-dev libevent-dev bsdmainutils python3 libboost-system-dev libboost-filesystem-dev libboost-chrono-dev libboost-test-dev libboost-thread-dev
sudo apt-get install libminiupnpc-dev libzmq3-dev

# 安装 BerkeleyDB （可选，钱包功能需要）
sudo apt-get install software-properties-common
sudo add-apt-repository ppa:bitcoin/bitcoin
sudo apt-get update
sudo apt-get install libdb4.8-dev libdb4.8++-dev

# 安装 GUI 依赖 （可选）
sudo apt-get install libqt5gui5 libqt5core5a libqt5dbus5 qttools5-dev qttools5-dev-tools libprotobuf-dev protobuf-compiler
sudo apt-get install libqrencode-dev

# 生成 configure 脚本
./autogen.sh
# 运行 configure 脚本 （完整编译，--disable-wallet 禁用钱包功能；--without-gui 禁用 GUI）
./configure
# 编译
make
# 安装 （可选）
make install
```

## 运行节点

在 ~/.bitcoindiamond目录下创建 bitcoin.conf 配置文件，常用内容如下：

```bash
# daemon 模式运行
daemon=1

# 索引全部交易，可使用 getrawtransaction 接口
txindex=1

# P2P 端口
port=7117

# 启用 RPC 服务
server=1
# 启用 REST 请求服务
rest=1
# 允许进行 RPC 的 IP （可设置多次）
rpcallowip=127.0.0.1/24
# RPC 端口
rpcport=7116
# RPC 用户名
rpcuser=bcd
# RPC 密码
rpcpassword=123456

# 启用 ZMQ 
zmqpubhashblock=tcp://127.0.0.1:58333
zmqpubhashtx=tcp://127.0.0.1:58333
zmqpubrawblock=tcp://127.0.0.1:58333
zmqpubrawtx=tcp://127.0.0.1:58333
```

运行安装完之后的运行程序 bitcoindiamondd 或者 bitcoindiamond-qt（GUI程序），运行之后可以查看运行日志 ~/.bitcoindiamond/debug.log，等所有区块同步完成之后节点即可使用（视网络情况耗时1-3天不等）。