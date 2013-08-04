#include <iostream>
#include<math.h>
using namespace std;
class TreeNode
{
public:
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int data)
	{
		val = data;
		left = NULL;
		right = NULL;
	}
};
TreeNode* createTree(int a[], int l, int r)
{
	if(l > r)
		return NULL;
	int mid = (l + r) / 2;
	TreeNode* root = new TreeNode(a[mid]);
	root->left = createTree(a, l, mid-1);
	root->right = createTree(a, mid+1, r);
	return root;
}
TreeNode* createBinaryTree(int a[], int n)
{
	return createTree(a, 0, n-1);
}
int main()
{
	int a[] = {0,1,2,3,4,5,6,7,8,9};
	TreeNode* root = createBinaryTree(a, 10);
}