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
bool find(TreeNode* root, TreeNode* node)
{
	if(root == node)
		return true;
	if(root == NULL)
		return false;
	return find(root->left, node) || find(root->right, node);
}
TreeNode* firstCommonAncestor(TreeNode* root, TreeNode* n1, TreeNode* n2)
{
	if(root == NULL)
		return NULL;
	if(root == n1 || root == n2)
		return root;
	if(find(root->left, n1) && find(root->left, n2))
		return firstCommonAncestor(root->left, n1, n2);
	else if(find(root->right, n1) && find(root->right, n2))
		return firstCommonAncestor(root->right, n1, n2);
	else
		return root;
}