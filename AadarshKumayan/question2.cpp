#include<iostream>
#include<istream>
using namespace std;
int main()
{
	long long int t[1000000],r[1000000],c[1000000],n=0,i,x=0,y,flag=0;
	char l='a';
	while(l!='\n')
	{
		cin>>t[n++];
		x+=t[n-1];
		cin.get(l);
	}
	n++;
	for(i=0;i<n;i++)
	cin>>r[i];
	for(i=0;i<n;i++)
	cin>>c[i];
	y=c[0];
	for(i=1;i<n;i++)
	{
	y+=t[i-1];
	if(y<r[i])
	{
		x+=r[i]-y;
		y=r[i];
	}
	else if(y>c[i])
	{
		cout<<-1<<endl;
		flag=1;
		break;
	}
	}
	if(flag==0)
	cout<<x<<endl;
	return 0;
}