package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ServerThread extends Thread {
    private Socket socket = null;
    private Server server = null;

    private BufferedReader buffer_reader = null;

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
            server.apppendMsg(socket.getInetAddress() + "服务器已开启");
        }
    }

    public void registe(){
        String name = "";
        for (int i = 0; i < request.length(); i++) {
            if (request.charAt(i) == '“'){
                for (int j = i + 1; j < request.length(); j++) {
                    if(request.charAt(j) == '“'){
                        i = j + 1;
                        break;
                    }
                    name = name + String.valueOf(request.charAt(j));
                }
                break;
            }
        }
        if (Server.clients.containsKey(name)) {
            writer.println("<result ???>");
        } else {
            server.apppendMsg("???:" + name + "?????!");
            Server.clients.put(name, null);// ?洢д?????
            writer.println("<result ???????>");
        }
    }

    public void login(){
        String userName = "";
        for (int i = 0; i < request.length(); i++) {// 获取登录名字
            if (request.charAt(i) == '“') {
                for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '“') {
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
            writer.println("登录成功");
        } else {
            writer.println("欢迎!" + userName + ",???!");
            server.apppendMsg("用户：" + userName + "已上线");
            Server.clients.remove(userName);
            Server.clients.put(userName, socket);
        }
    }

    public void sendMsg(){
        int count = 0;
        String userName = "";
        String toName = "";// 接收信息方
        String message = "";// 发送信息内容
        String send = null;

        for (int i = 0; i < request.length(); i++) {// Message
            if (request.charAt(i) == '“') {
                count++;
                if(count == 1) for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '“') {
                        count++;
                        i = j + 1;
                        break;
                    }
                    userName = userName + String.valueOf(request.charAt(j));
                }
                if (count == 3) {
                    for (int j = i + 1; j < request
                            .length(); j++) {
                        if (request.charAt(j) == '“') {
                            count++;
                            i = j + 1;
                            break;
                        };
                        toName = toName + String.valueOf(request
                                .charAt(j));
                    }
                };
                if (count == 5) {
                    for (int j = i + 1; j < request.length(); j++) {
                        if (request.charAt(j) == '“') {
                            count++;
                            i = j + 1;
                            break;
                        }
                        message = message +
                                String.valueOf(request.charAt(j));
                    }
                    send = "??????:(" + userName +
                            ")?????(" + toName + ")?????:" + message;
                    break;
                }
            }
        }
        PrintWriter toWriter;
        try {
            toWriter = new PrintWriter(Server.clients.get(toName).getOutputStream());
            if (toWriter != null) {
                toWriter.println(send);
                toWriter.flush();
            } else {
                writer.println("???????д??????????......");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void logout(){
        String name = "";
        for (int i = 0; i < request.length(); i++) {
            if (request.charAt(i) == '“') {
                for (int j = i + 1; j < request.length(); j++) {
                    if (request.charAt(j) == '“') {
                        i = j + 1;
                        break;
                    };
                    name = name
                            + String.valueOf(request
                            .charAt(j));
                };
                break;
            }
        }
        Server.clients.remove(name);// ????????

        writer.println("????????>");
        server.apppendMsg("用户:" + name + "退出聊天");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("???????????");
        try {
            while (true) {
                if (socket.isClosed() == false) {
                    if (socket.isInputShutdown() == false) {
                        request = buffer_reader.readLine();

                        server.apppendMsg(request);

                        if (request.startsWith("<register "))// ???
                        {
                            registe();
                        } else if (request.startsWith("<login "))// ???
                        {
                            login();
                        } else if (request.startsWith("<message")) // ??????
                        {
                            sendMsg();
                        } else if (request.startsWith("<logout")) {// ??????
                            logout();
                            break;
                        } else {
                            writer.println("输入有误，请重试");
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