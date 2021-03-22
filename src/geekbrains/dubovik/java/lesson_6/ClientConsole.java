package geekbrains.dubovik.java.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientConsole {
    private final int PORT = 8189;
    private final String HOST = "localhost";
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Thread threadSendMsg;

    public static void main(String[] args) {
        new ClientConsole().clientWorking();
    }

    private void clientWorking() {
        try (Socket newSocket = new Socket(HOST, PORT)) {
            socket = newSocket;
            if (socket.isConnected()) System.out.println("Соединение установлено, можно отправлять сообщения");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            clientSendMsg();
            while (true) {
                String str = in.readUTF();
                if (str.contains("/end")) {
                    connectionStop();
                    break;
                }
                else System.out.println("Сообщение " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connectionStop() throws IOException {
        in.close();
        out.close();
        socket.close();
        if (socket.isClosed()) System.out.println("Связь с сервером разорвана");
        else System.out.println("Сокет не закрылся");
        threadSendMsg.interrupt();
        if (threadSendMsg.isInterrupted()) System.out.println("Поток отправки со сканером закрыт");
        else System.out.println("Поток не закрылся");
    }

    private void clientSendMsg() {
        threadSendMsg = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        msg = scanner.nextLine();
                        if (!msg.isEmpty()) out.writeUTF("клиента: " + msg);
                        if (msg.contains("/end")) {
                            connectionStop();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadSendMsg.setDaemon(true);
        threadSendMsg.start();
    }
}