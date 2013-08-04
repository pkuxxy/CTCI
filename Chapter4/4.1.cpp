#include <iostream>
#include<math.h>
using namespace std;
class TreeNode
{
public:
	int val;
	TreeNode* left;
	TreeNode* right;
};
int maxDepth(TreeNode* root)
{
	if(root == NULL)
		return 0;
	return 1 + max(maxDepth(root->left), maxDepth(root->right));
}
int minDepth(TreeNode* root)
{
	if(root == NULL)
		return 0;
	return 1 + min(minDepth(root->left), minDepth(root->right));
}
bool isBalanced(TreeNode* root)
{
	return maxDepth(root) - minDepth(root) > 1;
}