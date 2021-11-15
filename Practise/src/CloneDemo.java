class UserContact implements Cloneable
{
	int contactNo;
	public UserContact(int contactNo)
	{
		this.contactNo=contactNo;
	}
	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "UserContact [contactNo=" + contactNo + "]";
	}
	@Override
	protected UserContact clone() throws CloneNotSupportedException {
		UserContact uc= (UserContact) super.clone();
		return uc;
	}
	
}
class UserProfile implements Cloneable
{
	private int id;
	private String name;
	UserContact userContact;
	public UserProfile(int id, String name,UserContact userContact) {
		//super();
		this.id = id;
		this.name = name;
		this.userContact=userContact;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public UserContact getUserContact() {
		return userContact;
	}


	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}


	@Override
	protected UserProfile clone() throws CloneNotSupportedException {
		UserProfile up= (UserProfile) super.clone();
		up.setUserContact((UserContact)userContact.clone());
		return up;
	}


	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", name=" + name + ", userContact=" + userContact + "]";
	}

	
}
public class CloneDemo {
	public static void main(String args[]) throws CloneNotSupportedException
	{
		UserProfile demo=new UserProfile(1,"Naren", new UserContact(1234));
		System.out.println(demo.getId()+"-"+demo.getUserContact().getContactNo());
		UserProfile copyObj= demo.clone();
		copyObj.setId(2);
		copyObj.getUserContact().setContactNo(12);
		System.out.println(demo.getId()+"-"+demo.getUserContact().getContactNo());
	}
}	
