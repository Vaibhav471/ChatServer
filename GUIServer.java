import java.awt.*;
import java.awt.event.*;
import java.net.*; 
import java.io.*;

class GUIServer implements WindowListener
{
Frame f;
TextField t;
Button b;
List l;
Socket s;
GUIServer()
{
f=new Frame("Server");
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
f.addWindowListener(this);


try
{
ServerSocket ss=new ServerSocket(2003);
s=ss.accept();

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
public void windowClosing(WindowEvent e)
{
f.dispose();
}
public void windowClosed(WindowEvent e)
{
}
public void windowIconified(WindowEvent e)
{
}
public void windowDeiconified(WindowEvent e)
{
}
public void windowActivated(WindowEvent e)
{
}
public void windowDeactivated(WindowEvent e)
{
}
public void windowOpened(WindowEvent e)
{
}

public static void main(String ar[])
{
GUIServer gc=new GUIServer();
}
}