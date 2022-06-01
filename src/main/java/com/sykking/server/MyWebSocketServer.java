package com.sykking.server;


import com.google.gson.Gson;
import com.sykking.conf.HttpSessionConfigurator;
import com.sykking.entity.Message;
import com.sykking.entity.User;
import com.sykking.utils.WebSocketMapUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/websocket" , configurator = HttpSessionConfigurator.class)
@Component
public class MyWebSocketServer {
    //声明Session对象 通过该对象可以发送消息给指定用户
    private Session session;
    //声明httpsession是为了获取用户名
    private HttpSession httpSession;

    /**
     * 连接建立后触发的方法
     */
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
        System.out.println("onOpen被访问");
        this.session = session;
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        User user = (User) httpSession.getAttribute("LoginUser");
        WebSocketMapUtil.put(user.getUsername(),this);//每获取一个Websocket连接都存入此Map中
    }

    /**
     * 连接关闭后触发的方法
     */
    @OnClose
    public void onClose(){
        User user = (User) httpSession.getAttribute("LoginUser");
        WebSocketMapUtil.remove((user.getUsername()));
        System.out.println("已删除username为"+user.getUsername()+"的用户");
    }

    /**
     * 接收到客户端消息时触发的方法
     */
    @OnMessage
    public void onMessage(String params,Session session) throws IOException {
        System.out.println("接收到客户端消息="+params);
        Gson gson = new Gson();
        Message message = gson.fromJson(params, Message.class);
        String toName = message.getToName();
        MyWebSocketServer server = WebSocketMapUtil.get(toName);
        if (server != null){
            server.sendMessage(message);
        }else {
            System.out.println(toName+"当前不在线无法发送！");
        }
    }

    /**
     * 发生错误时触发的方法
     */
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("用户"+session.getId()+"连接异常！");
        error.printStackTrace();
    }


    public void sendMessage(Message message) throws IOException {
        String s = new Gson().toJson(message);
        System.out.println("sendMessage中的数据为"+s);
        this.session.getBasicRemote().sendText(s);
    }


}
