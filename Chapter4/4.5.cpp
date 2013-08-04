#include<iostream>
#include<stack>
#include<vector>
#include<queue>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode *parent;
	TreeNode(int x) : val(x), left(NULL), right(NULL),parent(NULL) {}
};

TreeNode* nextNodeInOrder(TreeNode* node)
{
	if(node == NULL)
		return NULL;
	if(node->right)
	{
		TreeNode* cur = node->right;
		while(cur->left)
			cur = cur->left;
		return cur;
	}
	else
	{
		return nextNodeInOrder(node->parent);
	}
}