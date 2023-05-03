import java.util.Scanner;
class BankAccount 
{
  String name;
  String userName;
  String password;
  String accountNo;
  float balance = 100000f;
  int transaction = 0;
  String transactionHistory = "";
  public void register()
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Your Name:- ");
    this.name=sc.nextLine();
    System.out.println("Enter Your Username:- ");
    this.userName=sc.nextLine();
    System.out.println("Enter Your Password:- ");
    this.password=sc.nextLine();
    System.out.println("Enter Your Account Number:- ");
    this.accountNo=sc.nextLine();
    System.out.println("Registration Succussful...Kindly Loging with your credential. ");
  }
  public boolean login()
  {
    boolean isLogin=false;
    Scanner sc = new Scanner(System.in);
    while(!isLogin)
      {
        System.out.println("Enter Your Username:- ");
        String Username=sc.nextLine();
        if(Username.equals(userName))
        {
          while(!isLogin)
          {
            System.out.println("Enter Your Password:- ");
            String Password=sc.nextLine();
            if(Password.equals(password))
            {
              System.out.println("Login successful...");
              isLogin=true;
            }
            else
            {
              System.out.println("Invalid Password...");
            }
          }
        }
         else
            {
              System.out.println("Username not found...");
            }
      }
    return isLogin;
  }
  public void withdraw()
  {
    System.out.println("Enter amount to withdraw: ");
    Scanner sc=new Scanner(System.in);
    float amount=sc.nextFloat();
    try
      {
        if(balance>=amount)
        {
          transaction++;
          balance-=amount;
          System.out.println("Withdraw successful...");
          String str = amount + "Rs withdrawed\n";
          transactionHistory=transactionHistory.concat(str);
        }
        else
        {
          System.out.println("Insufficient Balance...");
        }
      }
    catch(Exception e)
      {
        
      }
  }
  public void deposit()
  {
    System.out.println("Enter amount to deposit:- ");
     Scanner sc=new Scanner(System.in);
    float amount=sc.nextFloat();

    try
      {
        if(amount<= 100000f)
        {
          transaction++;
          balance+=amount;
          System.out.println("Successfully Deposit... ");
          String str = amount+"Rs deposited\n";
          transactionHistory = transactionHistory.concat(str);
        }
        else{System.out.println("Sorry...Limit is 100000.00 ");}
      }
  catch(Exception e){}
  }
  public void transfer()
  {
   Scanner sc=new Scanner(System.in); 
   System.out.println("Enter Receipent's Name:- ");
    String receipent = sc.nextLine();
    System.out.println("Enter amount to transfer:- ");
    float amount =sc.nextFloat();
    try
      {
        if(balance >= amount)
        {
          transaction++;
          balance-=amount;
          System.out.println("Successfully Transfered to "+receipent);
          String str=amount+"Rs transfered to "+receipent +"\n";
          transactionHistory = transactionHistory.concat(str);
        }
        else{System.out.println("Insufficient Balance !! ");}
      }
    catch(Exception e){}
  }
  public void checkBalance()
  {
    System.out.println(" "+balance+" Rs");
  }
  public void transHistory()
  {
    if(transaction==0)
    {
      System.out.println("Empty...");
    }
    else{System.out.println(" "+transactionHistory);}
  }
}
public class Main
{
  public static int takeIntegerInput(int limit)
  {
    int input=0;
    boolean flag=false;
    while(!flag)
      {
        try
          {
            Scanner sc = new Scanner(System.in);
            input=sc.nextInt();
            flag=true;
            if(flag && input>limit || input< 1)
            {
              System.out.println("Choose the number between 1 to "+limit);
              flag=false;
            } 
          }
        catch(Exception e)
          {
            System.out.println("Enter only integer value ");
            flag=false;
          }
      }
    return input;
  }
  public static void main(String[] args) {
    System.out.println("*******WELCOME TO SBI ATM SYSTEM*******");
    System.out.println("1. Register");
    System.out.println("2. Exit");
     System.out.println("Enter Your Choice ");
    int choice=takeIntegerInput(2);

    if(choice==1)
    {
      BankAccount b= new BankAccount();
      b.register();;
      while(true)
        {
          System.out.println("1. Login");
          System.out.println("2. Exit");
          System.out.println("Enter Your Choice ");
          int ch=takeIntegerInput(2);
          if(ch==1)
          {
            if(b.login())
            {
              System.out.println("*******WELCOME Back"+b.name+"*******");
              boolean isFinished = false;
              while(!isFinished)
                {
                  System.out.println("1. Withdraw");
                  System.out.println("2. Deposit");
                  System.out.println("3. Transfer");
                  System.out.println("4. Check Balance");
                  System.out.println("5. Transaction History");
                  System.out.println("6. Exit");
                   System.out.println("Enter Your Choice ");
                  int c= takeIntegerInput(6);
                  switch(c)
                    {
                      case 1: b.withdraw(); break;
                      case 2: b.deposit();  break;
                      case 3: b.transfer(); break;
                      case 4: b.checkBalance(); break;
                      case 5: b.transHistory(); break;
                      case 6: isFinished= true; break;
                      default: System.out.println("Invalid Choice..."); break;
                    }
                }
            }
          }
          else{System.exit(0);}
        }
    }
    else{System.exit(0);}
  }
}