class Lock
{
public:
	Lock(){}
	~Lock(){}
	void acquire(){}
	void release(){}
};
template<class T>
class Singleton
{
private:
	static T* ins;
	static Lock lock;
	Singleton(){};
public:
	static T* instance()
	{
		if(ins == NULL)
		{
			lock.acquire();
			if(ins == NULL)
				ins = new T;
			lock.release();
		}
		return ins;
	}
};
template<class T>
Lock Singleton<T>::lock;

int main()
{
	int* p = Singleton<int>::instance();
	return 0;
}