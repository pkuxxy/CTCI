import java.util.ArrayList;

class CallCenter
{
	public static final int LEVEL = 3;
	ArrayList<Employee>[] employees = new ArrayList[LEVEL];
	ArrayList<Call>[] calls = new ArrayList[LEVEL];
	public Employee getCallHandler(Call c)
	{
		for(int i = c.getLevel(); i < LEVEL; i++)
		{
			ArrayList<Employee> emlist = employees[i];
			for(Employee e : emlist)
			{
				if(e.isFree())
					return e;
			}
		}
		return null;
	}
	public void dispatchCall(Call c)
	{
		Employee e = getCallHandler(c);
		if(null != e)
			e.handleCall(c);
		else
			calls[c.getLevel()].add(c);
	}
}
class Call
{
	private int level;
	private String message;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
class Employee
{
	private int level;
	private boolean free;
	public Employee(int level)
	{
		this.level = level;
	}
	public boolean isFree() {
		return free;
	}

	public void handleCall(Call c) {
		//deal with the call c
	}
}
class Fresher extends Employee
{
	public Fresher() {
		super(0);
	}
}
class TL extends Employee
{
	public TL() {
		super(1);
	}
}
class PM extends Employee
{
	public PM() {
		super(2);
	}
}
public class C7_2 {

}
