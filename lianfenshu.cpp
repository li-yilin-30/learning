#include<iostream>
using namespace std;
#include<vector>
int main()
{   int tmp=1;
    vector<int> a;
    int p=210520;
    int q=191;
    int p_2=0;
    int p_1=1;
    int q_2=1;
    int q_1=0;
    vector<int>pp;
    vector<int>qq;
  
 while(tmp!=0)
    {
    
    int aa=p/q;
    a.push_back(aa);
    cout<<aa<<endl;
      tmp=p-aa*q;
      if(tmp==0)
       break;
     p=q;
     q=tmp;
    }
    vector<int>::iterator it;
    for(it=a.begin();it<a.end();++it)
    cout<<*it;
    
    int p_p,q_q;
    for(int i=0;i<a.size();++i)
    {
        p_p=a[i]*p_1+p_2;
        q_q=a[i]*q_1+q_2;
        p_2=p_1;
        p_1=p_p;
        q_2=q_1;
        q_1=q_q;
        qq.push_back(q_q);
        pp.push_back(p_p);
    }
    cout<<"p的值依次为，从0开始"<<endl;
    for(int i=0;i<pp.size();++i)
    cout<<pp[i]<<endl;
    cout<<"q的值依次为，从0开始"<<endl;
     for(int i=0;i<qq.size();++i)
    cout<<qq[i]<<endl;
return 0;
}