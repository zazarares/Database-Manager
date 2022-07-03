package Model;
/**
 * datatype for storing clients
 * @author Hotupan Rares
 * @version 1.0
 * @since 2022-05-16
 */
public class Client {
	private int id;
	private String nume;
	private String adresa;
	private String email;
	private int varsta;
	public Client(int id,String nume,String adresa,String email,int varsta)
	{
		this.id=id;
		this.nume=nume;
		this.adresa=adresa;
		this.email=email;
		this.varsta=varsta;
	}
	public int getID() {
	return id;}
	public String getNume()
	{
		return nume;
	}
	public String getAdresa()
	{
		return adresa;
	}
	public String getEmail()
	{
		return email;
	}
	public int getVarsta()
	{
		return varsta;
	}
	public void setNume(String nume)
	{
		this.nume=nume;
	}
	public void setAdresa(String adresa)
	{
		this.adresa=adresa;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setVarsta(int varsta)
	{
		this.varsta=varsta;
	}
}
