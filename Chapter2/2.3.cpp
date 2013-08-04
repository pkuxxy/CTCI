#include<iostream>
using namespace std;
class Node
{
public :
	int data;
	Node *next;
	Node(int data)
	{
		this->data = data;
		next = NULL;
	}
};
class List
{
public:
	Node *head;
	List()
	{
		head = NULL;
	}
	Node *append(int data)
	{
		if(!head)
			head = new Node(data);
		else
		{
			Node *cur = head;
			while(cur->next != NULL)
				cur = cur->next;
			cur->next = new Node(data);
		}
		return head;
	}
};
int listLength(Node *head)
{
	Node *cur = head;
	int len = 0;
	while(cur)
	{
		len++;
		cur = cur->next;
	}
	return len;
}
void deleteMid1(Node *head)	//delete middle element, given access to the head
{
	if(!head)
		return;
	int len = listLength(head);
	if(len < 2)
	{
		delete head;
		head = NULL;
		return;
	}

	int half = len/2;
	Node *pre = NULL;
	Node *cur = head;
	while(half--)
	{
		pre = cur;
		cur = cur->next;
	}
	pre->next = cur->next;
	delete cur;
}
bool deleteMid2(Node *mid)
{
	if(mid == NULL || mid->next == NULL)
		return false;
	Node *next = mid->next;
	mid->data = next->data;
	mid->next = next->next;
	delete next;
}
void printList(Node *head)
{
	Node *cur = head;
	while(cur)
	{
		cout<<cur->data<<" ";
		cur = cur->next;
	}
	cout<<endl<<endl;
}
int main()
{
	List list;
	list.append(1);
	list.append(2);
	list.append(3);
	list.append(4);
	list.append(5);
	printList(list.head);
	deleteMid1(list.head);
	printList(list.head);
	system("pause");
	return 0;
}