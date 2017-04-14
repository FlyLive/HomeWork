package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
    private Socket socket = null;
    private Server server = null;
    // 接收用户输入流
    private BufferedReader buffer_reader = null;
    // 服务器输出流
    private PrintWriter writer = null;

    private static String request = "";

    public ServerThread(Socket socket, Server server) {
        // TODO Auto-generated constructor stub
        this.socket = socket;
        this.server = server;
        init();
    }

    private void init() {
        try {
            buffer_reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            server.apppendMsg(socket.getInetAddress() + "退出聊天");
        }
    }

    public void registe(){
        String name = "";
        for (int i = 0; i < request.length(); i++) {// 得到用户名
            if (request.charAt(i) == '”') {
                for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '”') {
                        i = j + 1;
                        break;
                    }
                    name = name + String.valueOf(request.charAt(j));
                }
                break;
            }
        }
        if (Server.clients.containsKey(name)) {
            writer.println("<result 失败>");
        } else {
            server.apppendMsg("用户:" + name + "注册成功!");
            Server.clients.put(name, null);// 存储写入图中
            writer.println("<result 注册成功！>");
        }
    }

    public void login(){
        String userName = "";
        for (int i = 0; i < request.length(); i++) {// 得到用户名
            if (request.charAt(i) == '”') {
                for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '”') {
                        i = j + 1;
                        break;
                    }
                    userName = userName
                            + String.valueOf(request
                            .charAt(j));
                }
                break;
            }
        }
        if (!Server.clients.containsKey(userName)) {
            writer.println("登录失败,用户不存在或输入错误");
        } else {
            writer.println("登录成功!" + userName + ",欢迎!");
            server.apppendMsg("用户:" + userName + "登录成功!");
            Server.clients.remove(userName);
            Server.clients.put(userName, socket);
        }
    }

    public void sendMsg(){
        int count = 0;// 计数器
        String userName = "";
        String toName = "";// 得到收件人的名字
        String message = "";// 得到发送的信息
        String send = null;

        for (int i = 0; i < request.length(); i++) {// 得到Message里面的内容
            if (request.charAt(i) == '”') {
                count++;
                if(count == 1){
                    for (int j = i + 1; j < request.length(); j++) {
                        if (request.charAt(j) == '”') {
                            count++;
                            i = j + 1;
                            break;
                        }
                        userName = userName + String.valueOf(request.charAt(j));
                    }
                }
                if (count == 3) {// 得到另一客户端的名字
                    for (int j = i + 1; j < request
                            .length(); j++) {
                        if (request.charAt(j) == '”') {
                            count++;
                            i = j + 1;
                            break;
                        }
                        toName = toName + String.valueOf(request
                                .charAt(j));// 收件人的名字
                    }
                }
                if (count == 5) {// 发送的信息
                    for (int j = i + 1; j < request
                            .length(); j++) {
                        if (request.charAt(j) == '”') {
                            count++;
                            i = j + 1;
                            break;
                        }
                        message = message +
                                String.valueOf(request.charAt(j));// 得到信息内容
                    }
                    send = "转发信息:(" + userName +
                            ")发送给(" + toName + ")的信息:" + message;
                    break;
                }
            }
        }
        PrintWriter toWriter;
        try {
            toWriter = new PrintWriter(Server.clients.get(toName).getOutputStream());
            if (toWriter != null) {
                toWriter.println(send);// 向另一客户端写入信息
                toWriter.flush();
            } else {
                writer.println("对不起！没有此用户！请检查......");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void logout(){
        String name = "";
        for (int i = 0; i < request.length(); i++) {// 得到用户名
            if (request.charAt(i) == '”') {
                for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '”') {
                        i = j + 1;
                        break;
                    }
                    name = name
                            + String.valueOf(request
                            .charAt(j));
                }
                break;
            }
        }
        Server.clients.remove(name);// 删除用户名

        writer.println("退出成功！>");
        server.apppendMsg("用户:" + name + "退出连接!");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("子线程开始工作");
        try {
            while (true) {
                if (socket.isClosed() == false) {
                    if (socket.isInputShutdown() == false) {
                        request = buffer_reader.readLine();

                        server.apppendMsg(request);

                        if (request.startsWith("<register "))// 注册
                        {
                            registe();
                        } else if (request.startsWith("<login "))// 登录
                        {
                            login();
                        } else if (request.startsWith("<message")) // 转发信息
                        {
                            sendMsg();
                        } else if (request.startsWith("<logout")) {// 退出登录
                            logout();
                            break;
                        } else {
                            writer.println("输入有误！请重新输入");
                        }
                        writer.flush();
                    }
                } else {
                    if (socket.getKeepAlive() == false) {
                        writer.close();
                        buffer_reader.close();
                        socket.close();
                        this.stop();
                    }
                }
            }
        } catch (Exception e) {
            server.apppendMsg(socket.getPort() + "退出聊天");
        }
    }
}