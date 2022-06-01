package com.sykking.utils;

import com.sykking.server.MyWebSocketServer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 存储<用户名,websocket对象>的
 */
public class WebSocketMapUtil {

    public static ConcurrentMap<String, MyWebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    public static void put(String key, MyWebSocketServer myWebSocketServer){
        webSocketMap.put(key, myWebSocketServer);
    }

    public static MyWebSocketServer get(String key){
        return webSocketMap.get(key);
    }

    public static void remove(String key){
        webSocketMap.remove(key);
    }

    public static Collection<MyWebSocketServer> getValues(){
        return webSocketMap.values();
    }

    public static Collection<MyWebSocketServer> getOtherValues(String username){
        List<String> stringList = new ArrayList<>();
        Collection<MyWebSocketServer> myWebSocketServers = new ArrayList<>();
        Set<String> strings = webSocketMap.keySet();
        for (String s:strings) {
            if (s.equals(username)){//遇到自己的key就跳过不保存
                continue;
            }
            stringList.add(s);
        }
        for (String key:stringList) {
            myWebSocketServers.add(WebSocketMapUtil.get(key));
        }
        return myWebSocketServers;
    }

    public static List<String> getOtherKey(String username){
        List<String> stringList = new ArrayList<>();
        Set<String> keySet = webSocketMap.keySet();
        for (String s:keySet) {
            if (s.equals(username)){//遇到自己的key就跳过不保存
                continue;
            }
            stringList.add(s);
        }
        return stringList;
    }

}