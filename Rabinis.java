package mathforis;
import java.util.*;//�������п����õ��Ŀ�
public class Rabinis {
public static int isPrimeNumber(int number){ //�ж��Ƿ�Ϊ����
		double num=(double)number;
		int n=(int)Math.sqrt(num);
		int signal=2;
		for(int i=2;i<=n;i++){
		   if(number%i==0)
		   break;
		   signal++;
		}
		if(signal>=n)     //��Ϊ�����򷵻�1
		  return 1;
		else
		  return 0;
}
public static int isMode34(int number){    //�жϽ���Ƿ�ģ4��3
       if(number%4==3)
       return 1;
       else
       return 0;
}
public static int PrimeNumberCreate(int max,int min){   //��max��min��Χ�ڲ��������
       Random rand=new Random();
       int m=rand.nextInt(max)%(max-min+1)+min;
       int judge1=isPrimeNumber(m);  //�ж��Ƿ�������
       if(judge1==0){
       int z=max;
       int w=min;
       return PrimeNumberCreate(z,w);
       }//�����ص�ֱ�����������ٽ�����һ�����㡣
       int judge2=isMode34(m);//�ж��Ƿ�ģ4��3
       if(judge2==0){
       int z=max;
       int w=min;
       return PrimeNumberCreate(z,w);
      }//�����ص�ֱ�����������ٽ�����һ�����㡣
       return m;
}
public static int Opposite(int x1,int x2){     //x1,x2����Ĺ���
      int i=0;
      while(x1*(++i)%x2!=1);
      return i;
}
public static int Crt(int a,int b,int m1,int m2){  //�й�ʣ�ඨ���������ͬ��ʽ
		int m=m1*m2;
		int M1=m2;
		int M2=m1;
		int a1=Opposite(M1,m1);//��Ӧa����
		int b1=Opposite(M2,m2);//��Ӧb����
		int result=(a1*M1*a+b1*M2*b)%m;
		return result;
}

public static void main(String[] args) throws Exception{ 
	   
       System.out.println("������ɷ���Ҫ��Ĵ�����p��q");
       int min=100000000;
       int max=250000000;//����ģ��28���صĴ�������Χ
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
       System.out.println("��Ϣ���ֻ���Ľ��Ϊ��");
       System.out.println(aa.toString());
       System.out.println("����������Χ�����ηֶ����������Ի�ý����(ע����ǡ����28����ɶ����ֵ�����");//���ֹ�����Ҫ�����������
       int sum=28;
     while(sum!=0)
     {  sum--;
    	 int pubtext=input.nextInt();//����
       int encryptiontext=(pubtext*pubtext)%n;
       System.out.println("�����Ժ������Ϊ��");
       System.out.println(encryptiontext);

		System.out.println("���ܺ��������ڵļ���Ϊ��");//���н���
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
		c2=q-(int)Math.pow(encryptiontext, (q+1)/4)%q;//��������¿������ɼ���
		int case4=Crt(c1,c2,p,q);
		System.out.println(case4);
		//input.close();
     }
     input.close();
}
}
