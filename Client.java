import java.net.*;
import java.io.*;


class Client
{
public static void main(String ar[])
{
try
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

Socket s=new Socket("localhost",2003);

while(true)
{
String str=br.readLine();
ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
oos.writeObject(str);
ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
str=(String)ois.readObject();
System.out.println(str);
}

}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}