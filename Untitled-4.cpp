#include<iostream>
using namespace std;
#include<cmath>
bool judgeSquareSum(int c)
{
    
    int k = 0;
    int j = sqrt(c);

    while (k <=j)
    {    if (k * k + j *j==c)
    {
        return true;
    }
        if ((k * k + j * j) < c)
         {
            
             k++;}
        else
           j--;
               
   }
   
 
   return false;
   
    
}
int main()
{
    cout << judgeSquareSum(13);
}
