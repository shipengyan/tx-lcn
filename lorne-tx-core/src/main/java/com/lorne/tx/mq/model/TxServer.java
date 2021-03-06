package com.lorne.tx.mq.model;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by lorne on 2017/6/30.
 */
public class TxServer {

    private int port;
    private String host;


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


    @Override
    public String toString() {
        return "host:" + host + ",port:" + port;
    }

    public static TxServer parser(String json) {
        try {
            JSONObject jsonObject = JSONObject.parseObject(json);
            TxServer txServer = new TxServer();
            txServer.setPort(jsonObject.getInteger("port"));
            txServer.setHost(jsonObject.getString("ip"));
            return txServer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
