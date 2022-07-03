import GUI.GUI;
import dao.*;
import connection.connection;
import Model.*;
public class main {
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException {
	GUI G=new GUI();
	connection.getConnection();
	Client c=new Client(0,"mirel","Cluj","mirel@yahoo.com",12);
	comanda o=new comanda(0,0,0,12);
	//ClientDAO.insert(c);
	Client t1=ClientDAO.findById(0);
	System.out.print(t1.getNume());
	Product p=new Product(0,13,"mere");
	//ProductDAO.insert(p);
	Product t2=ProductDAO.findById(0);
	//OrderDAO.insert(o);
	comanda t=OrderDAO.findById(0);
	System.out.println(t.getNumarElemente());
	}
}
