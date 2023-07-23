import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class GUIClient
{
Frame f;
TextField t;
Button b;
List l;
Socket s;
GUIClient()
{
f=new Frame("Client");
t=new TextField();
b=new Button("Send");
b.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
try
{
ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
oos.writeObject(t.getText());
l.add("Me:-"+t.getText());
}
catch(Exception e1)
{
System.out.println(e1.getMessage());
}

}
});
l=new List();
f.add(t,BorderLayout.NORTH);
f.add(b,BorderLayout.SOUTH);
f.add(l);
f.setSize(300,300);
f.setVisible(true);
try
{
s=new Socket("localhost",2003);

while(true)
{
ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
String str=(String)ois.readObject();
l.add("Friend:-"+str);
}

}
catch(Exception e)
{
System.out.println(e.getMessage());
}


}
public static void main(String ar[])
{
GUIClient gc=new GUIClient();
}
}