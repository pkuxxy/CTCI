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

vector<vector<int> > levelOrder(TreeNode *root) 
{
	vector<vector<int>> ret;
	if(root == NULL)
		return ret;
	queue<TreeNode*> q;
	q.push(root);
	int curLevel = 1;
	int nextLevel = 0;
	vector<int> curList;
	while(!q.empty())
	{
		TreeNode* cur = q.front();
		q.pop();
		curLevel--;
		curList.push_back(cur->val);
		if(cur->left != NULL)
		{
			q.push(cur->left);
			nextLevel++;
		}
		if(cur->right != NULL)
		{
			q.push(cur->right);
			nextLevel++;
		}
		if(curLevel == 0)
		{
			curLevel = nextLevel;
			nextLevel = 0;
			ret.push_back(vector<int>(curList));
			curList.clear();
		}
	}
	return ret;
}