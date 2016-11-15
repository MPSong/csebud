package buddy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	String id;
	
	String pass;
	
	String name;
	
	String phone;
	
	String email;
	
	/**
	 * @return the id
	 */
	public String getId(){
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * @return the pass
	 */
	public String getPass(){
		return pass;
	}
	
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass){
		this.pass = pass;
	}
	
	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone(){
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
}