package socketTest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileReceiverServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Use any available port

            System.out.println("Server waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            // Read file name and length
            String fileName = dataInputStream.readUTF();
            long fileLength = dataInputStream.readLong();

            // Create output stream to write the received file
            FileOutputStream fileOutputStream = new FileOutputStream("path/to/save/" + fileName);

            // Receive file data
            byte[] buffer = new byte[4096];
            int bytesRead;
            while (fileLength > 0 && (bytesRead = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, fileLength))) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
                fileLength -= bytesRead;
            }

            System.out.println("File received successfully");

            // Close streams and socket
            fileOutputStream.close();
            dataInputStream.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
