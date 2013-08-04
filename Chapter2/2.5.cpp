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

Node *findLoopFirst1(Node *head)
{
	if(head == NULL || head->next == NULL || head->next->next == NULL)
		return NULL;
	Node *p1 = head->next;
	Node *p2 = p1->next;
	while(p1 != p2)
	{
		if(p1 == NULL || p2 == NULL)
			return NULL;
		p1 = p1->next;
		p2 = p2->next;
		if(p2 == NULL)
			return NULL;
		p2 = p2->next;
	}
	Node *head2 = p1->next;
	p1->next = NULL;
	int len1 = listLength(head);
	int len2 = listLength(head2);
	int diff = len1 - len2;
	Node *headLong = head;
	Node *headShort = head2;
	if(diff < 0)
	{
		headLong = head2;
		headShort = head;
		diff = -diff;
	}
	while(diff--)
	{
		headLong = headLong->next;
	}
	while(headLong != headShort)
	{
		headLong = headLong->next;
		headShort = headShort->next;
	}
	p1->next = head2;
	return headShort;
}

Node *findLoopFirst2(Node *head)
{
	if(head == NULL || head->next == NULL || head->next->next == NULL)
		return NULL;
	Node *p1 = head->next;
	Node *p2 = p1->next;
	while(p1 != p2)
	{
		if(p1 == NULL || p2 == NULL)
			return NULL;
		p1 = p1->next;
		p2 = p2->next;
		if(p2 == NULL)
			return NULL;
		p2 = p2->next;
	}
	while(p1 != head)
	{
		p1 = p1->next;
		head = head->next;
	}
	return p1;
}
int main()
{
	Node *n1 = new Node(1);
	Node *n2 = new Node(2);
	Node *n3 = new Node(3);
	Node *n4 = new Node(4);
	Node *n5 = new Node(5);
	n1->next = n2;
	n2->next = n3;
	n3->next = n4;
	n4->next = n5;
	n5->next = n3;
	cout<<findLoopFirst1(n1)->data<<endl;
	cout<<findLoopFirst2(n1)->data<<endl;
	system("pause");
	return 0;
}