#include <iostream>
#include<math.h>
#include<set>
#include<queue>
using namespace std;
class GraphNode
{
public:
	int val;
	set<GraphNode*> adjacent;
};
bool hasPath(GraphNode* n1, GraphNode* n2)
{
	if(n1 == NULL || n2 == NULL)
		return false;
	queue<GraphNode*> q;
	set<GraphNode*> visited;
	q.push(n1);
	visited.insert(n1);
	while(!q.empty())
	{
		GraphNode* cur = q.front();
		q.pop();
		if(cur == n2)
			return true;
		set<GraphNode*> adj = cur->adjacent;
		for(set<GraphNode*>::iterator i = adj.begin(); i != adj.end(); i++)
		{
			if(visited.find(*i) == visited.end())
				continue;
			visited.insert(*i);
			q.push(*i);
		}
	}
	return false;
}