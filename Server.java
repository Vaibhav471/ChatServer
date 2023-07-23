import java.net.*;
import java.io.*;


class Server
{
public static void main(String ar[])
{
try
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

ServerSocket ss=new ServerSocket(2003);
Socket s=ss.accept();
while(true)
{
ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
String str=(String)ois.readObject();
System.out.println(str);
str=br.readLine();
ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
oos.writeObject(str);
}
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}