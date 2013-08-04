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

vector<vector<int>> ret;
void solve(TreeNode* root, int sum, vector<int>& list)
{
	if(root == NULL)
		return;
	list.push_back(root->val);
	int tmp = sum;
	for(vector<int>::size_type i = list.size()-1; i >= 0; i--)
	{
		tmp -= list[i];
		if(tmp == 0)
		{
			vector<int> cur;
			for(vector<int>::size_type j = i; j < list.size(); j++)
			{
				cur.push_back(list[j]);
			}
			ret.push_back(cur);
		}
	}
	solve(root->left, sum, list);
	solve(root->right, sum, list);
	list.pop_back();
}
vector<vector<int> > pathSum(TreeNode *root, int sum) 
{
	ret.clear();
	if(root == NULL)
		return ret;
	vector<int> list;
	solve(root, sum, list);
	return ret;
}