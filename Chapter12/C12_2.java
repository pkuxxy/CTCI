import java.util.ArrayList;

class Server {
	public ArrayList<Machine> machines = new ArrayList<Machine>();

	public Machine getMachineFromID(int id) {
		for (Machine m : machines) {
			if (m.machineID == id)
				return m;
		}
		return null;
	}
}

class Machine {
	public int machineID;
	public ArrayList<Person> persons = new ArrayList<Person>();

	public Person getPersonFromID(int id) {
		for (Person p : persons) {
			if (p.ID == id)
				return p;
		}
		return null;
	}
}

class Person {
	public int ID;
	public ArrayList<Integer> friends;
	public int machineID;
	public String info;
	public Server server;

	public Person(int machineID, int ID) {
		this.machineID = machineID;
		this.ID = ID;
		friends = new ArrayList<Integer>();
	}

	public void addFriend(int id) {
		friends.add(id);
	}

	public void removeFriend(int id) {
		friends.remove(id);
	}

	public Person loopupFriend(int machineID, int id) {
		for (Machine m : server.machines) {
			if (m.machineID == machineID) {
				for (Person p : m.persons) {
					if (p.ID == id) {
						return p;
					}
				}
			}
		}
		return null;
	}
}

public class C12_2 {

}
