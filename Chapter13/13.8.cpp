#include<map>
using namespace std;

class Node
{
public:
	Node* left;
	Node* right;
};
Node* copy_node(Node* cur, map<Node*, Node*> visited)
{
	if(NULL == cur)
		return NULL;
	map<Node*, Node*>::iterator i = visited.find(cur);
	if(i != visited.end())
	{
		return i->second;
	}
	Node* node = new Node;
	visited[cur] = node;
	node->left = copy_node(cur->left, visited);
	node->right = copy_node(cur->right, visited);
	return node;
}

Node* copy_structure(Node* root)
{
	 map<Node*, Node*> visited;
	 return copy_node(root, visited);
}