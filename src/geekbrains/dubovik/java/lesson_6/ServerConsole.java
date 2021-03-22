package geekbrains.dubovik.java.lesson_6;
// Сервер может работать как с консольным клиентом, так и с GUI-клиентом
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerConsole {
    private final int PORT = 8189;
    private DataInputStream in;
    private DataOutputStream out;
    private ServerSocket serverSocket;
    private Thread threadSendMsg;

    public static void main(String[] args) {
        new ServerConsole().serverWorking();
    }

    private void serverWorking() {
        try (ServerSocket newServerSocket = new ServerSocket(PORT)) {
            serverSocket = newServerSocket;
            serverStart();
            serverSendMsg();
            while (true) {
                String str = in.readUTF();
                if (str.contains("/end")) {
                    serverStop();
                    break;
                }
                else System.out.println("Сообщение " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serverStart() throws IOException {
        System.out.println("Сервер запущен, ожидаем подключения...");
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился, можно отпрвлять сообщения из консоли");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    private void serverStop() throws IOException {
        in.close();
        out.close();
        serverSocket.close();
        if (serverSocket.isClosed()) System.out.println("Сервер остановлен");
        else System.out.println("Сокет не закрылся");
        threadSendMsg.interrupt();
        if (threadSendMsg.isInterrupted()) System.out.println("Поток отправки со сканером закрыт");
        else System.out.println("Поток не закрылся");

    }

    private void serverSendMsg() {
        threadSendMsg = new Thread(new Runnable() {
            String msg;
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    try {
                        msg = scanner.nextLine();
                        if (!msg.isEmpty()) out.writeUTF("сервера: " + msg);
                        if (msg.contains("/end")) {
                            serverStop();
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