#include<iostream>
#include<stack>
#include<vector>
#include<queue>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

bool match(TreeNode* t1, TreeNode* t2)
{
	if(t1 == NULL && t2 == NULL)
		return true;
	if(t1 == NULL || t2 == NULL)
		return false;
	if(t1->val != t2->val)
		return false;
	return match(t1->left, t2->left) && match(t1->right, t2->right);
}
bool isSubTree(TreeNode* t1, TreeNode* t2)
{
	if(t2 == NULL)
		return true;
	if(t1 == NULL)
		return false;
	if(t1->val == t2->val)
	{
		if(match(t1, t2))
			return true;
	}
	return isSubTree(t1->left, t2) || isSubTree(t1->right, t2);
}