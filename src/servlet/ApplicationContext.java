package servlet;

import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
	private List<String> users;
	private List<City> cities;
	private static ApplicationContext instance=null;

	private ApplicationContext() {
		super();
		users=new ArrayList<String>();
		cities=new ArrayList<City>();
		users.add("admin:admin");
		cities.add(new City("Grad1","ptt1"));
		cities.add(new City("Grad2","ptt3"));
		cities.add(new City("Grad3","ptt12"));
		cities.add(new City("Grad4","ptter"));
		cities.add(new City("Grad5","ptt5"));
	}

	public List<String> getUsers() {
		return users;
	}
	
	public void addCity(String naziv, String pttBroj) {
		cities.add(new City(naziv,pttBroj));
	}
	
	public String listCities() {
		String html="";
		for(City c:cities) {
			html+="<tr>";
			html+="<td>"+c.getIme()+"</td>"+"<td>"+c.getPttBroj()+"</td>";
			html+="</tr>";
		}
		return html;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	public boolean deleteCity(String pttBroj) {
		City forDelete = null;
		for(City c:cities) {
			if(c.getPttBroj().equals(pttBroj)) forDelete=c;
		}
		cities.remove(forDelete);
		if(forDelete==null) return false;
		else return true;
	}
	
	public static ApplicationContext getInstance() {
		if(instance==null) {
			instance=new ApplicationContext();
		}
		return instance;
	}
	
	public boolean find(String usr,String pw) {
		String usrpw=usr+":"+pw;
		for(String s:users) {
			if(s.equals(usrpw)) return true;
		}
		return false;
	}
	
	public City findCity(String pttBroj) {
		for(City c:cities) {
			if(c.getPttBroj().equals(pttBroj)) return c;
		}
		return null;
	}
	
}
