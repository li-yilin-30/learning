package mathforis;
import java.util.*;//引入所有可能用到的库
public class Rabinis {
public static int isPrimeNumber(int number){ //判断是否为素数
		double num=(double)number;
		int n=(int)Math.sqrt(num);
		int signal=2;
		for(int i=2;i<=n;i++){
		   if(number%i==0)
		   break;
		   signal++;
		}
		if(signal>=n)     //若为素数则返回1
		  return 1;
		else
		  return 0;
}
public static int isMode34(int number){    //判断结果是否模4余3
       if(number%4==3)
       return 1;
       else
       return 0;
}
public static int PrimeNumberCreate(int max,int min){   //在max与min范围内产生随机数
       Random rand=new Random();
       int m=rand.nextInt(max)%(max-min+1)+min;
       int judge1=isPrimeNumber(m);  //判断是否是素数
       if(judge1==0){
       int z=max;
       int w=min;
       return PrimeNumberCreate(z,w);
       }//反复回调直至满足条件再进行下一步运算。
       int judge2=isMode34(m);//判断是否模4余3
       if(judge2==0){
       int z=max;
       int w=min;
       return PrimeNumberCreate(z,w);
      }//反复回调直至满足条件再进行下一步运算。
       return m;
}
public static int Opposite(int x1,int x2){     //x1,x2求逆的过程
      int i=0;
      while(x1*(++i)%x2!=1);
      return i;
}
public static int Crt(int a,int b,int m1,int m2){  //中国剩余定理求解两个同余式
		int m=m1*m2;
		int M1=m2;
		int M2=m1;
		int a1=Opposite(M1,m1);//对应a的逆
		int b1=Opposite(M2,m2);//对应b的逆
		int result=(a1*M1*a+b1*M2*b)%m;
		return result;
}

public static void main(String[] args) throws Exception{ 
	   
       System.out.println("随机生成符合要求的大素数p，q");
       int min=100000000;
       int max=250000000;//近似模拟28比特的大素数范围
       int p=PrimeNumberCreate(max,min);
       int q=PrimeNumberCreate(max,min);
       System.out.println(q);
       System.out.println(p);
       int n=p*q;
       Scanner input=new Scanner(System.in);
      
       String a=new String("CommunicationskillMathematicalFundationofInformationsecurity201202001519030910274000001");
      StringBuffer aa =new StringBuffer(100);
       for(int f=0;f<a.length();++f)
       {    int tmp=a.charAt(f);
            aa.append(tmp);
       } 
       System.out.println("信息数字化后的结果为：");
       System.out.println(aa.toString());
       System.out.println("请在整数范围内依次分段输入明文以获得结果：(注意请恰好用28次完成对数字的输入");//数字过大需要多次依次输入
       int sum=28;
     while(sum!=0)
     {  sum--;
    	 int pubtext=input.nextInt();//明文
       int encryptiontext=(pubtext*pubtext)%n;
       System.out.println("加密以后的密文为：");
       System.out.println(encryptiontext);

		System.out.println("解密后明文所在的集合为：");//进行解密
		int c1=0,c2=0;
		c1=(int)Math.pow(encryptiontext, (p+1)/4)%p;
		c2=(int)Math.pow(encryptiontext, (q+1)/4)%q;
		int case1=Crt(c1,c2,p,q);
		System.out.println(case1);
		c1=p-(int)Math.pow(encryptiontext, (p+1)/4)%p;
		c2=(int)Math.pow(encryptiontext, (q+1)/4)%q;
		int case2=Crt(c1,c2,p,q);
		System.out.println(case2);
		c1=(int)Math.pow(encryptiontext, (p+1)/4)%p;
		c2=q-(int)Math.pow(encryptiontext, (q+1)/4)%q;
		int case3=Crt(c1,c2,p,q);
		System.out.println(case3);
		c1=p-(int)Math.pow(encryptiontext, (p+1)/4)%p;
		c2=q-(int)Math.pow(encryptiontext, (q+1)/4)%q;//四种情况下可以生成集合
		int case4=Crt(c1,c2,p,q);
		System.out.println(case4);
		//input.close();
     }
     input.close();
}
}
