package model;

public class PremiumUser extends User{

    public PremiumUser(int type, String id, String name) {
		super(type, id, name);
	}

    @Override
    public String toString() {
        String msg="\nID: "+this.getId()+"\nName: "+getName()+"\n";
        return msg;
    }
}
