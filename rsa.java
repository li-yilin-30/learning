package mathforis;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class rsa {
	private static char[] e;
	public static void main(String[] args) {
/*	try {  System.out.println("������Ҫ������ɵĴ������ı�����");
	   BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	   int num =Integer.parseInt(br.readLine());*/
		int num=14;
	  long thenum1,thenum2;
	    for (int i=0;;i++)
	    {     thenum1=ranlarprime(num);
	         if((isprime(thenum1))==1)
	        	 break;
	    }
	    for (int i=0;;i++)
	    {     thenum2=ranlarprime(num);
	         if((isprime(thenum2))==1)
	         { if(thenum2!=thenum1)
	        	 break;}
	    }
		System.out.println("�������"+num+"bit�������ֱ��ǣ�"+thenum1+"��"+thenum2);
		long n=thenum1*thenum2;
		long fai=(thenum1-1)*(thenum2-1);
		System.out.println("fai��ֵΪ��"+fai);
		Random random2 =new Random();
		long e;
		for(int k=0;;++k)
		{ e=random2.nextInt((int)fai)+1;
		  if(gcd(e,fai)==1)
			  break;
		}
		System.out.println("eΪ��"+e);
		//System.out.println(e);
		int d;
		for(d=2;;++d)
		{
			if(((e*d)%fai)==1)
			{   System.out.println("@");
				break;}
		}
		 System.out.println("dΪ��"+d);
		
	
    String str="MathematicalFundationofInformationsecurity201405001519030910274";//��������õ���Ϣ���ֻ��ķ���
    //����Ϣ���ֻ���������һ�飬��Сд��ĸ��ʮ�����ֹ�62����0~9Ϊ0~9��10~35ΪСд��ĸ36~61Ϊ��д��ĸ
    
    
   long [] list= {2986,1815,890,649,1128,641,2572,1439,649,1140,1450,974,1441,1515,1374,1816,1511,1750,774,1692,1832,124,66,5,0,67,71,3,9,62,131,4};
    //���������һ�����ַ�����
   
	long[] decoder=new long[32];
	for(int w=0;w<32;++w)
	{
		decoder[w]=remod(n,e,list[w]);
	}
	System.out.println("���ܹ��̣�");
	for(int j=0;j<32;++j)
		System.out.println(decoder[j]);
	
	System.out.println("���ܹ��̣�");
	for(int j=0;j<32;++j)
	System.out.println(remod(n,d,decoder[j]));
	System.out.println("������Ϣ���Ľ��Ϊ��"+"MathematicalFundationofInformationsecurity201405001519030910274");
	
}
	public static long ranlarprime(int n){
		long max=(long)Math.pow(2, n)-1;
		long min= (long)Math.pow(2, n-1);	
		//Random random=new Random();	
		long r1=(long)(min+Math.random()*(max-min+1));
		return r1;
	}
	
	public static int isprime(long num1){
		int s=1;
		if(num1%2==0){
			s=0;
		}
		for(int i=3;i<=Math.sqrt(num1);i=i+2){
			if(num1%i==0){
				s=0;
				break;
			}
		}
		return s;	
	}
	public static long gcd(long a,long b)
	{
	if(b>0)
	{
		return gcd(b,a%b);
	}
	return a;
	}
	 public static long remod(long m,long k,long b)
	{  long c;
	   int sum =0;
	   long []mylist=new long[1000];
	 while (k != 0)
	    {
	       c= k % 2;
	       k /= 2;
	       mylist[sum]=c;
	       sum++;
	       }
	long a=1;
	for (int i = 0; i<sum; ++i)
	   {                            //����ģ�ظ�ƽ������˼����ʵ��
	        if (mylist[i]==1)
	        {
	            a = a * b;
	            a = a % m;
	            b = b * b;
	            b = b % m;
	        }
	        if (mylist[i] == 0)
	        {
	            b = b * b;
	            b = b % m;
	        }
	    }
	   return (a % m);
	}
}
