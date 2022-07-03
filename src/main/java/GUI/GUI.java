package GUI;
import javax.swing.*;

import BussinessLayer.BillWriter;
import BussinessLayer.IdFinder;
import BussinessLayer.TableGenerator;
import Model.*;
import dao.*;
/**
 * generates the GUI
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener {
//TODO:...
	JFrame Frame=new JFrame("student management");
	int billindex=0;
	JPanel Panel=new JPanel();
	JPanel AddClient=new JPanel();
	JPanel AddProduct=new JPanel();
	JPanel AddOrder=new JPanel();
	JPanel UpdateClient=new JPanel();
	JPanel UpdateProduct=new JPanel();
	JPanel UpdateOrder=new JPanel();
	JPanel Delete=new JPanel();
	JButton CheckClient=new JButton();
	JButton CheckProduct=new JButton();
	JButton CheckOrder=new JButton();
	JButton AddClientInit=new JButton("Add Client");
	JButton AddProductInit=new JButton("Add Product");
	JButton UpdateC=new JButton("Update Client");
	JButton UpdateClientexe=new JButton("Update Client");
	JButton UpdateProductButton=new JButton("Update Product");
	JButton UpdateP=new JButton("Update Product");
	JButton UpdateO=new JButton("Update Order");
	JButton DeleteC=new JButton("Delete Client");
	JButton DeleteP=new JButton("Delete Product");
	JButton DeleteO=new JButton("Delete Order");
	JButton UpdateOrderButton=new JButton("Update order");
	JTextField UpdateClientid=new JTextField("id");
	JTextField UpdateProductid=new JTextField("id");
	JTextField AddClientName=new JTextField();
	JTextField AddClientAdress=new JTextField();
	JTextField AddClientEmail=new JTextField();
	JTextField AddClientAge=new JTextField();
	JTextField AddProductName=new JTextField();
	JTextField AddProductStock=new JTextField();
	JTextField AddClientName2=new JTextField();
	JTextField AddClientAdress2=new JTextField();
	JTextField AddClientEmail2=new JTextField();
	JTextField AddClientAge2=new JTextField();
	JTextField AddClientName3=new JTextField();
	JTextField AddClientAdress3=new JTextField();
	JTextField AddClientEmail3=new JTextField();
	JTextField AddClientAge3=new JTextField();
	JTextField AddProductName2=new JTextField();
	JTextField AddProductStock2=new JTextField();
	JTextField DeleteIndex=new JTextField();
	JLabel AddClientNameLabel=new JLabel("Nume:");
	JLabel AddClientAdressLabel=new JLabel("Adresa:");
	JLabel AddClientEmailLabel=new JLabel("Email:");
	JLabel AddClientAgeLabel=new JLabel("Varsta:");
	JLabel Updateid=new JLabel("id:");
	JLabel Updateidc=new JLabel("idc:");
	JLabel Updateidp=new JLabel("idp:");
	JLabel Updatenrel=new JLabel("nr elem:");
	JButton AddClientButton=new JButton("AddClient");
	JButton AddProductButton=new JButton("AddProduct");
	JLabel AddProductNameLabel=new JLabel("Nume:");
	JLabel AddProductStockLabel=new JLabel("Stock:");
	JButton TableSelecterClient=new JButton("Clients");
	JButton TableSelecterProduct=new JButton("Products");
	JButton TableSelecterOrder=new JButton("Orders");
	JButton AddOrderInit=new JButton("Add Order");
	JButton AddOrderButton=new JButton("Add Order");
	JTextField AddOrderCount=new JTextField();
	JTable OrderClient=new JTable();
	JTable OrderProduct=new JTable();
	JScrollPane j,t1,t2;
	JTable T=new JTable();
	public GUI() throws IllegalArgumentException, IllegalAccessException
	{
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(1100,850);
		Frame.setLocationRelativeTo(null);
		AddClientInit.setBounds(100,700,200,50);
		AddClientInit.addActionListener(this);
		//AddClient.setBackground(Color.red);
		
		AddClientNameLabel.setBounds(100,60,500,20);
		AddClientAdressLabel.setBounds(100,160,500,20);
		AddClientEmailLabel.setBounds(100,260,500,20);
		AddClientAgeLabel.setBounds(100,360,500,20);
		Updateid.setBounds(100,60,500,20);
		Updateidc.setBounds(100,160,500,20);
		Updateidp.setBounds(100,260,500,20);
		Updatenrel.setBounds(100,360,500,20);
		CheckClient.setBounds(600,100,200,20);
		CheckProduct.setBounds(600,100,200,20);
		CheckOrder.setBounds(600,100,200,20);
		AddClientName.setBounds(100,100,500,20);
		AddClientAdress.setBounds(100,200,500,20);
		AddClientEmail.setBounds(100,300,500,20);
		AddClientAge.setBounds(100,400,500,20);
		AddClientName2.setBounds(100,100,500,20);
		AddClientAdress2.setBounds(100,200,500,20);
		AddClientEmail2.setBounds(100,300,500,20);
		AddClientAge2.setBounds(100,400,500,20);
		AddClientName3.setBounds(100,100,500,20);
		AddClientAdress3.setBounds(100,200,500,20);
		AddClientEmail3.setBounds(100,300,500,20);
		AddClientAge3.setBounds(100,400,500,20);
		AddClientButton.setBounds(300,450,500,20);
		UpdateOrderButton.setBounds(300,450,500,20);
		TableSelecterClient.setBounds(50,25,300,25);
		TableSelecterProduct.setBounds(350,25,350,25);
		TableSelecterOrder.setBounds(700,25,300,25);
		AddOrderInit.setBounds(900,700,200,50);
		T.setBounds(50,50,950,550);
		AddClient.add(AddClientNameLabel);
		AddClient.add(AddClientAdressLabel);
		AddClient.add(AddClientEmailLabel);
		AddClient.add(AddClientAgeLabel);
		AddClient.add(AddClientName);
		AddClient.add(AddClientAdress);
		AddClient.add(AddClientEmail);
		AddClient.add(AddClientAge);
		UpdateClientid.setBounds(100,30,500,20);
		UpdateProductid.setBounds(100,30,500,20);
		UpdateClientexe.setBounds(300,450,500,20);
		UpdateProductButton.setBounds(300,450,500,20);
		UpdateClient.add(UpdateClientid);
		UpdateClient.add(AddClientNameLabel);
		UpdateClient.add(AddClientAdressLabel);
		UpdateClient.add(AddClientEmailLabel);
		UpdateClient.add(AddClientAgeLabel);
		UpdateClient.add(AddClientName2);
		UpdateClient.add(AddClientAdress2);
		UpdateClient.add(AddClientEmail2);
		UpdateClient.add(AddClientAge2);
		UpdateClient.add(UpdateClientexe);

		UpdateOrder.add(AddClientName3);
		UpdateOrder.add(AddClientAdress3);
		UpdateOrder.add(AddClientEmail3);
		UpdateOrder.add(AddClientAge3);
		UpdateOrder.add(UpdateOrderButton);
		UpdateOrder.add(Updateid);
		UpdateOrder.add(Updateidc);
		UpdateOrder.add(Updateidp);
		UpdateOrder.add(Updatenrel);
		AddProductInit.setBounds(500,700,200,50);
		AddProductNameLabel.setBounds(100,60,500,20);
		AddProductStockLabel.setBounds(100,160,500,20);
		AddProductName.setBounds(100,100,500,20);
		AddProductStock.setBounds(100,200,500,20);
		AddProductName2.setBounds(100,100,500,20);
		AddProductStock2.setBounds(100,200,500,20);
		AddProductButton.setBounds(300,450,500,20);
		UpdateOrder.setLayout(null);
		UpdateClientexe.addActionListener(this);
		UpdateC.addActionListener(this);
		UpdateP.addActionListener(this);
		UpdateO.addActionListener(this);
		AddProductInit.addActionListener(this);
		AddClientButton.addActionListener(this);
		AddProductButton.addActionListener(this);
		TableSelecterClient.addActionListener(this);
		TableSelecterProduct.addActionListener(this);
		UpdateProductButton.addActionListener(this);
		TableSelecterOrder.addActionListener(this);
		UpdateOrderButton.addActionListener(this);
		AddOrderInit.addActionListener(this);
		AddOrderButton.addActionListener(this);
		DeleteC.addActionListener(this);
		DeleteP.addActionListener(this);
		DeleteO.addActionListener(this);
		CheckClient.addActionListener(this);
		CheckProduct.addActionListener(this);
		CheckOrder.addActionListener(this);
		AddProduct.add(AddProductNameLabel);
		AddProduct.add(AddProductStockLabel);
		AddProduct.add(AddProductName);
		AddProduct.add(AddProductStock);
		AddProduct.add(AddProductButton);
		UpdateProduct.add(AddProductNameLabel);
		UpdateProduct.add(AddProductStockLabel);
		UpdateProduct.add(AddProductName2);
		UpdateProduct.add(AddProductStock2);
		UpdateProduct.add(UpdateProductButton);
		UpdateProduct.add(UpdateProductid);
		UpdateProduct.setLayout(null);
		OrderClient=TableGenerator.generateTable(new Client(0," "," "," ",0));
		OrderProduct=TableGenerator.generateTable(new Product(0,0,""));
		AddOrderCount.setPreferredSize(new Dimension(50,20));
		t1=new JScrollPane(OrderClient);
		t2=new JScrollPane(OrderProduct);
		AddOrder.add(t1);
		AddOrder.add(t2);
		AddOrder.add(AddOrderCount);
		AddOrder.add(AddOrderButton);
		UpdateClient.add(CheckClient);
		UpdateProduct.add(CheckProduct);
		UpdateOrder.add(CheckOrder);
		Panel.add(UpdateC);
		Panel.add(UpdateP);
		Panel.add(UpdateO);
		Panel.add(DeleteC);
		Panel.add(DeleteP);
		Panel.add(DeleteO);
		Panel.add(AddOrderInit);
		Panel.add(AddClientInit);
		Panel.add(AddProductInit);
		Panel.add(TableSelecterClient);
		Panel.add(TableSelecterProduct);
		Panel.add(TableSelecterOrder);
		
		T=TableGenerator.generateTable(new Client(0," "," "," ",0));
		j=new JScrollPane(T);
		Panel.add(j);
		DeleteIndex.setBounds(200,200,200,200);
		Delete.add(DeleteIndex);
		Delete.setLayout(null);
		//Panel.setLayout(null);
		//AddOrder.setLayout(new GridLayout(1,2));
		UpdateClient.setLayout(null);
		AddClient.setLayout(null);
		AddProduct.setLayout(null);
		Frame.setContentPane(Panel);
		Frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==UpdateP)
		{
			UpdateProduct.add(AddProductNameLabel);
			UpdateProduct.add(AddProductStockLabel);
			Frame.setContentPane(UpdateProduct);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==UpdateC)
		{
			UpdateClient.add(UpdateClientid);
			UpdateClient.add(AddClientNameLabel);
			UpdateClient.add(AddClientAdressLabel);
			UpdateClient.add(AddClientEmailLabel);
			UpdateClient.add(AddClientAgeLabel);
			UpdateClient.add(AddClientName2);
			UpdateClient.add(AddClientAdress2);
			UpdateClient.add(AddClientEmail2);
			UpdateClient.add(AddClientAge2);
			UpdateClient.add(UpdateClientexe);

			Frame.setContentPane(UpdateClient);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==UpdateO)
		{
			Frame.setContentPane(UpdateOrder);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==UpdateClientexe)
		{
			ClientDAO.updatename(Integer.parseInt(UpdateClientid.getText()),AddClientName2.getText() );
			ClientDAO.updateadress(Integer.parseInt(UpdateClientid.getText()),AddClientAdress2.getText() );
			ClientDAO.updateemail(Integer.parseInt(UpdateClientid.getText()),AddClientEmail2.getText() );
			ClientDAO.updateage(Integer.parseInt(UpdateClientid.getText()),Integer.parseInt(AddClientAge2.getText()) );
			Frame.setContentPane(Panel);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==UpdateOrderButton)
		{
			OrderDAO.updateidc(Integer.parseInt(AddClientName3.getText()),Integer.parseInt(AddClientAdress3.getText()));
			OrderDAO.updateidp(Integer.parseInt(AddClientName3.getText()),Integer.parseInt(AddClientEmail3.getText()));
			OrderDAO.updateel(Integer.parseInt(AddClientName3.getText()),Integer.parseInt(AddClientAge3.getText()));
			Frame.setContentPane(Panel);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==UpdateProductButton)
		{
			ProductDAO.updatename(Integer.parseInt(UpdateProductid.getText()),AddProductName2.getText() );
			ProductDAO.update(Integer.parseInt(UpdateProductid.getText()),Integer.parseInt(AddProductStock2.getText()) );
			Frame.setContentPane(Panel);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==AddClientInit)
		{
			AddClient.add(AddClientNameLabel);
			AddClient.add(AddClientAdressLabel);
			AddClient.add(AddClientEmailLabel);
			AddClient.add(AddClientAgeLabel);
			AddClient.add(AddClientName);
			AddClient.add(AddClientAdress);
			AddClient.add(AddClientEmail);
			AddClient.add(AddClientAge);
			AddClient.add(AddClientButton);
			Frame.setContentPane(AddClient);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
			
		}
		if(e.getSource()==AddClientButton)
		{
			Client temp=new Client(IdFinder.getNewClientId(),AddClientName.getText(),AddClientAdress.getText(),AddClientEmail.getText(),Integer.parseInt(AddClientAge.getText()));
			ClientDAO.insert(temp);
			Frame.setContentPane(Panel);
		}
		if(e.getSource()==AddProductButton)
		{
			Product temp=new Product(IdFinder.getNewProductId(),Integer.parseInt(AddProductStock.getText()),AddProductName.getText());
			ProductDAO.insert(temp);
			Frame.setContentPane(Panel);
		}
		if(e.getSource()==AddOrderInit)
		{
			try {
				OrderClient=TableGenerator.generateTable(new Client(0," "," "," ",0));
				OrderProduct=TableGenerator.generateTable(new Product(0,0,""));
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			t1.getViewport().add(OrderClient);
			t2.getViewport().add(OrderProduct);
			Frame.setContentPane(AddOrder);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==AddOrderButton)
		{
			int client=OrderClient.getSelectedRow();
			int product=OrderProduct.getSelectedRow();
			if(Integer.parseInt(OrderProduct.getValueAt(product,2).toString())<Integer.parseInt(AddOrderCount.getText()))
				System.out.println("produse insuficiente");
			else
			{
				OrderDAO.insert(new comanda(IdFinder.getNewOrderId(),Integer.parseInt(OrderClient.getValueAt(client, 0).toString()),Integer.parseInt(OrderProduct.getValueAt(product, 0).toString()),Integer.parseInt(AddOrderCount.getText())));
				ProductDAO.update(Integer.parseInt(OrderProduct.getValueAt(product, 0).toString()), Integer.parseInt(OrderProduct.getValueAt(product, 2).toString())-Integer.parseInt(AddOrderCount.getText()));
			}
			BillWriter.WriteBill(billindex,AddOrderCount.getText(),OrderProduct.getValueAt(client, 1).toString(),OrderClient.getValueAt(client, 1).toString());
			Frame.setContentPane(Panel);
		}
		if(e.getSource()==TableSelecterProduct)
		{
			
			try {
				T=TableGenerator.generateTable(new Product(0, 0, " "));
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			j.setViewportView(T);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==TableSelecterClient)
		{
			try {
				T=TableGenerator.generateTable(new Client(0,"","","",0));
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			j.setViewportView(T);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==TableSelecterOrder)
		{
			try {
				T=TableGenerator.generateTable(new comanda(0,0,0,0));
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			j.setViewportView(T);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==DeleteC)
		{
			ClientDAO.delete(Integer.parseInt(T.getValueAt(T.getSelectedRow(), 0).toString()));
			
		}
		if(e.getSource()==DeleteO)
		{
			OrderDAO.delete(Integer.parseInt(T.getValueAt(T.getSelectedRow(),0).toString()));
		}
		if(e.getSource()==DeleteP)
		{
			ProductDAO.delete(Integer.parseInt(T.getValueAt(T.getSelectedRow(),0).toString()));
		}
		if(e.getSource()==AddProductInit)
		{
			AddProduct.add(AddProductNameLabel);
			AddProduct.add(AddProductStockLabel);
			Frame.setContentPane(AddProduct);
			Frame.invalidate();
			Frame.repaint();
			Frame.validate();
		}
		if(e.getSource()==CheckClient)
		{
			Client c=ClientDAO.findById(Integer.parseInt(UpdateClientid.getText()));
			AddClientName2.setText(c.getNume());
			AddClientAdress2.setText(c.getAdresa());
			AddClientEmail2.setText(c.getEmail());
			AddClientAge2.setText(Integer.toString(c.getVarsta()));
			
			
		}
		if(e.getSource()==CheckProduct)
		{
			Product c=ProductDAO.findById(Integer.parseInt(UpdateProductid.getText()));
			AddProductName2.setText(c.getName());
			AddProductStock2.setText(Integer.toString(c.getStock()));
			
		}
		if(e.getSource()==CheckOrder)
		{
			comanda c=OrderDAO.findById(Integer.parseInt(AddClientName3.getText()));
			AddClientAdress3.setText(Integer.toString(c.getIDClient()));
			AddClientEmail3.setText(Integer.toString(c.getIDProduct()));
			AddClientAge3.setText(Integer.toString(c.getNumarElemente()));	
		}
	}
}
