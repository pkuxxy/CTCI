template<class T>
class SmartPointer
{
private:
	T* ref;
	unsigned* ref_count;
public:
	SmartPointer(T* ptr)
	{
		ref = ptr;
		ref_count = new unsigned;
		*ref_count = 1;
	}
	SmartPointer(SmartPointer<T> & sptr)
	{
		ref = sptr.ref;
		ref_count = sptr.ref_count;
		*ref_count++;
	}
	SmartPointer<T> & operator=(SmartPointer<T> & sptr)
	{
		if(this != &sptr)
		{
			ref = sptr.ref;
			ref_count = sptr.ref_count;
			*ref_count++;
		}
		return *this;
	}
	~SmartPointer()
	{
		*ref_count--;
		if(*ref_count == 0)
		{
			delete ref;
			delete ref_count;
			ref = NULL;
			ref_count = NULL;
		}
	}
	T get_value()
	{
		return *ref;
	}
};