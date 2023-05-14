package model;

public class RegularUser extends User{
    
    public RegularUser(int type, String id, String name) {
		super(type, id, name);
	}

	@Override
	public String toString() {
		String msg="\nID: "+this.getId()+"\nName: "+getName()+ "\n";
        return msg;
	}
}
