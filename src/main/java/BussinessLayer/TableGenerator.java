package BussinessLayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import javax.swing.*;
import dao.*;
import Model.*;
import connection.*;
/**
 * generates table for all ids in use
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class TableGenerator {
public static JTable generateTable(Object type) throws IllegalArgumentException, IllegalAccessException{
	JTable T=new JTable();
	if(type.getClass().isInstance(new Client(0, "0", "0", "null", 0)))
	{
		int index=0;
		String[][] S=new String[100][5];
		String[] Col;
		Field[] F;
		F=type.getClass().getDeclaredFields();
		Col=new String[F.length];
		for(int i=0;i<F.length;i++)
			Col[i]=F[i].getName().toString();
		Client c=ClientDAO.findById(index);
		int i=0;
		while(index<25)
		{
			if(c!=null) {
			S[i][1]=c.getNume();
			S[i][2]=c.getAdresa();
			S[i][3]=c.getEmail();
			S[i][4]=Integer.toString(c.getVarsta());
			S[i][0]=Integer.toString(c.getID());
			i++;
			}index++;c=ClientDAO.findById(index);
			
		}
		T=new JTable(S,Col);
	}
	if(type.getClass().isInstance(new Product(0, 0, "0")))
	{
		int index=0;
		String[][] S=new String[100][3];
		String[] Col=new String[3];
		Field[] F;
		F=type.getClass().getDeclaredFields();
		Col=new String[F.length];
		for(int i=0;i<F.length;i++)
			Col[i]=F[i].getName().toString();
		Product c=ProductDAO.findById(index);
		int i=0;
		while(index<25)
		{
			if(c!=null) {
			S[i][1]=c.getName();
			S[i][2]=Integer.toString(c.getStock());
			S[i][0]=Integer.toString(c.getID());
			i++;
			}
			index++;
			c=ProductDAO.findById(index);
			
		}
		T=new JTable(S,Col);
	}
	if(type.getClass().isInstance(new comanda(0,0, 0, 0)))
	{
		int index=0;
		String[][] S=new String[100][4];
		String[] Col=new String[4];
		Field[] F;
		F=type.getClass().getDeclaredFields();
		Col=new String[F.length];
		for(int i=0;i<F.length;i++)
			Col[i]=F[i].getName().toString();
		comanda c=OrderDAO.findById(index);
		int i=0;
		while(index<25)
		{
			if(c!=null) {
			S[i][1]=Integer.toString(c.getIDClient());
			S[i][2]=Integer.toString(c.getIDProduct());
			S[i][0]=Integer.toString(c.getID());
			S[i][3]=Integer.toString(c.getNumarElemente());
			i++;
			}
			index++;
			c=OrderDAO.findById(index);
			
		}
		T=new JTable(S,Col);
	}
	return T;
}
}
