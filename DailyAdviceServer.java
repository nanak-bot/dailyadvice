import java.io.*;
import java.net.*;
public class DailyAdviceServer {
    String[] adviceList = {"Take long walk.","Call an old Friend.","Play with your kids.","Help a needy person.","Feed a hungry animal.","Work out in gym."};
    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4242);
            while(true){
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
        private String getAdvice(){
            int random = (int)(Math.random()*adviceList.length);
            return adviceList[random];
        }
        public static void main(String[] args){
            DailyAdviceServer server = new DailyAdviceServer();
            server.go();
        }
    }

