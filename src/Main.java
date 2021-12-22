import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args){
        
            new IITCarParkManager();
        

        //Car
        try{
            Car c1 =new Car();
            FileOutputStream fout=new FileOutputStream("File2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(c1);
            out.flush();
            out.close();
        }catch(Exception e){System.out.println(e);}
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("File2.txt"));
            Car c=(Car)in.readObject();
            in.close();
        }catch(Exception e){System.out.println(e);}

        //Van
        try{
            Van v1 =new Van();
            FileOutputStream fout=new FileOutputStream("File2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(v1);
            out.flush();
            out.close();
        }catch(Exception e){System.out.println(e);}
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("File2.txt"));
            Van v=(Van)in.readObject();
            in.close();
        }catch(Exception e){System.out.println(e);}

        //Mini Bus
        try{
            MiniBus b1 =new MiniBus();
            FileOutputStream fout=new FileOutputStream("File2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(b1);
            out.flush();
            out.close();
        }catch(Exception e){System.out.println(e);}
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("File2.txt"));
            MiniBus b=(MiniBus) in.readObject();
            in.close();
        }catch(Exception e){System.out.println(e);}

        //Mini Lorry
        try{
            MiniLorry l1 =new MiniLorry();
            FileOutputStream fout=new FileOutputStream("File2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(l1);
            out.flush();
            out.close();
        }catch(Exception e){System.out.println(e);}
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("File2.txt"));
            MiniLorry l=(MiniLorry) in.readObject();
            in.close();
        }catch(Exception e){System.out.println(e);}

        //Motor bike
        try{
            Bike m1 =new Bike();
            FileOutputStream fout=new FileOutputStream("File2.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(m1);
            out.flush();
            out.close();
        }catch(Exception e){System.out.println(e);}
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("File2.txt"));
            Bike m=(Bike) in.readObject();
            in.close();
        }catch(Exception e){System.out.println(e);}
    }
}



