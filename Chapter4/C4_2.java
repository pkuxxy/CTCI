import java.util.ArrayList;
import java.util.Stack;

enum State
{
	Unvisited,Visited;
}
class Node
{
	private ArrayList<Node> adjacent;
	
	public State state;
	
	public Node()
	{
		adjacent = new ArrayList<Node>();
	}

	public ArrayList<Node> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(ArrayList<Node> adjacent) {
		this.adjacent = adjacent;
	}
	
}
class Graph
{
	private ArrayList<Node> nodes;
	public Graph()
	{
		nodes = new ArrayList<Node>();
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
}
public class C4_2 {

	public static boolean findRoute(Graph g, Node start, Node end)
	{
		if(null == g || null == g.getNodes() || null == start || null == end)
			return false;
		Stack<Node> stack = new Stack<Node>();
		for(Node n : g.getNodes())
			n.state = State.Unvisited;
		stack.push(start);
		start.state = State.Visited;
		while(!stack.isEmpty())
		{
			Node cur = stack.pop();
			if(cur == end)
				return true;
			for(Node n : cur.getAdjacent())
			{
				if(n.state == State.Unvisited)
				{
					stack.push(n);
					n.state = State.Visited;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<Node>();
		Graph g = new Graph();
		
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		
		ArrayList<Node> adjacent = new ArrayList<Node>();
		adjacent.add(n2);
		n1.setAdjacent(adjacent);
		
		adjacent = new ArrayList<Node>();
		adjacent.add(n3);
		n2.setAdjacent(adjacent);
		
		list.add(n1);
		list.add(n2);
		list.add(n3);
		g.setNodes(list);
		
		System.out.println("FindRoute from n1 to n3: " + findRoute(g, n1, n3));
		System.out.println("FindRoute from n3 to n1: " + findRoute(g, n3, n1));
		
		adjacent = new ArrayList<Node>();
		adjacent.add(n1);
		n3.setAdjacent(adjacent);
		
		System.out.println("Adding a edge from n3 to n1, findRoute from n3 to n1: " + findRoute(g, n3, n1));

	}

}
