import java.util.*;

class Bank {
    public String accno;
    public String name;
    public long balance;
    public long loanamount;
    public String password;
    Scanner KB = new Scanner(System.in);

    //method to get a loan
    void loan()
    {
        System.out.println("Minimum  bank balance for loan eligibility is Rs.80000\n");
        System.out.println("Your bank balance is "+balance);
        if(balance>=80000)
        {System.out.println("You are eligible for a loan\n");
            System.out.println("You may now pick an option for the type of loan\n");
            System.out.println("1. Home Loan\n");
            System.out.println("2. Personal Loan\n");
            System.out.println("3. Car Loan\n");
            int choice=KB.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the amount you want for Home Loan\n");
                    loanamount=KB.nextLong();
                    System.out.println("You have taken "+loanamount+"Rupees loan\n"+"and your interest rate is 7.25% per annum");
                    break;
                case 2:
                    System.out.println("Enter the amount you want for Personal Loan\n");
                    loanamount=KB.nextLong();
                    System.out.println("You have taken "+loanamount+"Rupees loan\n"+"and your interest rate is 9.85% per annum");
                    break;
                case 3:
                    System.out.println("Enter the amount you want for Car Loan\n");
                    loanamount=KB.nextLong();
                    System.out.println("You have taken "+loanamount+"Rupees loan\n"+"and your interest rate is 8.00% per annum");
                    break;
                default:
                    System.out.println("Incorrect Choice\n");
            }


        }
        else
            System.out.println("You arent eligible for loan");
    }

    // method to check fixed deposits
    void fd(){
        System.out.println("Enter the amount you want to keep as fixed deposit:\n");
        long f=KB.nextLong();
        System.out.println("Your annual fixed deposit is "+0.13*f);
        System.out.println();
    }

    //method to have and choose between 3 credit cards
    void payment()
    {
        if(balance>100000){
            System.out.println("You are a platinum member. The following things are in access to you\n");
            System.out.println("1. You get double points for every purchase you do\n2.Customized credit health report\n3. Low onterest loans and lifetime free credit cards\n4. More discount vouchers on movie tickets\n5. Available offers on Airline Tickets");
        }
        else if(balance>50000&&balance<100000){
            System.out.println("You are a gold member. The following things are in access to you\n");
            System.out.println("1. You get 50% more points for every purchase you do\n2. Customized credit health report\n3. Low onterest loans and free credit cards upto a period of 6 years\n4. More discount vouchers on movie tickets");
            System.out.println("For becoming a platinum member, you need to have more than Rs.100000 in your account.\n");
        }
        else{
            System.out.println("You are a silver member. The following things are in access to you\n");
            System.out.println("1. You get points for every purchase you do\n2. Customized credit health report\n3. Low interest loans");
            System.out.println("For becoming a gold member, you need to have more than Rs.50000 in your account.\n");
        }
        System.out.println();

    }


    //method to open an account
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = KB.next();
        System.out.print("Enter Your Password: ");
        password = KB.next();
        System.out.print("Enter Name: ");
        name = KB.next();
        System.out.print("Enter Balance: ");
        balance = KB.nextLong();

    }

    //method to display account details
    void showAccount() {
        System.out.println("Account No:- "+accno + "\n" +"Name:- "+ name + "\n" +"Balance:- "+ balance+"\n"+"Loan Taken:- "+loanamount+"\n");
    }

    //method to deposit money
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = KB.nextLong();
        if (balance -500>= amt) {
            balance = balance - amt;
            System.out.println("You have succesfully withrawn Rs."+amt);
            System.out.println("Your current balance is Rs."+balance);
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acn, String pass) {
        if (accno.equals(acn) && password.equals(pass)) {
            //showAccount();
            return (true);
        }
        return (false);
    }

}


class AccountHolder extends Bank{
    int cheque(Vector<Bank> V,int a){
        System.out.println("Enter name of bearer: ");
        name= KB.next();
        System.out.println("Enter amount: ");
        int amnt=KB.nextInt();
        if(V.get(a).balance-500>=amnt) {

            V.get(a).balance = V.get(a).balance - amnt;
            System.out.println("Amount" + " " + amnt + " is deducted from your account\nCurrent Balance is "
                    +V.get(a).balance);
        }
        else
            System.out.println("Balance not enough\n");
        return a;
    }

    int card(Vector<Bank> V,int a){
        System.out.println("Enter card no.: ");
        int card_no = KB.nextInt();
        System.out.println("Enter pin: ");
        int pin = KB.nextInt();
        System.out.println("Enter amount: ");
        int amnt= KB.nextInt();
        if(V.get(a).balance-500>=amnt) {
            V.get(a).balance = V.get(a).balance - amnt;
            System.out.println("Amount" + " " + amnt + " is deducted from your account\nCurrent Balance is "
                    +V.get(a).balance);
        }
        else
            System.out.println("Balance not enough\n");
        return a;
    }


}


class Manager extends Bank {
    public String managerPass="admin";

    //method to check the password of manager
    boolean checkPass(String pass) {
        if (managerPass.equals(pass)) {
            return (true);
        }
        return (false);
    }

    //method to search for a particular account
    boolean search1(String acn,Vector<Bank> V,int a) {
        if(acn.equals(V.get(a).accno)) {
            //showAccount();
            return(true);
        }
        return(false);
    }

    //method to display account details
    void showAccount1(Vector<Bank> V,int a) {
        System.out.println("Account No:- "+V.get(a).accno + "\n" +"Name:- "+ V.get(a).name + "\n"
                +"Balance:- "+ V.get(a).balance+"\n"+"Loan Taken:- "+V.get(a).loanamount+"\n");

    }

}

public class ABC {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);
        Vector<Bank> C= new Vector<Bank>();
        int x;

        do{
            System.out.println("[1] Open New Account");
            System.out.println("[2] Customer Login");
            System.out.println("[3] Admin Section");
            System.out.println("[0] To Exit");
            System.out.println("Enter your choice: ");
            x=KB.nextInt();
            switch(x)
            {
                case 1:
                    Bank obj = new Bank();
                    C.addElement(obj);
                    obj.openAccount();
                    break;

                case 2:
                    int ch;
                    System.out.println("Enter account no.: ");
                    String acn=KB.next();
                    System.out.println("Enter Password: ");
                    String pass = KB.next();
                    boolean found = false;
                    for (int i = 0; i < C.size(); i++) {
                        found = C.get(i).search(acn,pass);
                        if (found) {

                            System.out.print("\t1. View account details \n\t2. Deposit \n\t3. Withdraw \n\t4. Loan \n\t"
                                    + "5. Fixed Deposit \n\t6. Credit Card info \n\t7. Payment options\n\t8. Exit");
                            do {

                                System.out.println("\nEnter your Choice :");
                                ch = KB.nextInt();
                                switch (ch) {
                                    case 1:

                                        C.get(i).showAccount();
                                        break;


                                    case 2:

                                        C.get(i).deposit();
                                        break;

                                    case 3:

                                        C.get(i).withdrawal();
                                        break;

                                    case 4:

                                        C.get(i).loan();
                                        break;

                                    case 5:

                                        C.get(i).fd();
                                        break;

                                    case 6:

                                        C.get(i).payment();
                                        break;

                                    case 7:
                                        System.out.println("Enter your choice for payment\n");
                                        System.out.println("1. By cheque\n");
                                        System.out.println("2. By card\n");
                                        System.out.println("3. Back\n");
                                        AccountHolder a=new AccountHolder();
                                        int option=KB.nextInt();
                                        if(option==1) {
                                            a.cheque(C,i);
                                            break;
                                        }
                                        else if(option==2) {
                                            a.card(C,i);
                                            break;
                                        }
                                        else if(option==3) {
                                            break;
                                        }
                                        else {
                                            System.out.println("Invalid Choice!");
                                        }
                                        break;

                                    case 8:
                                        System.out.println("Good Bye..");
                                        break;

                                    default:
                                        System.out.println("Enter a valid choice!");
                                }
                            }
                            while (ch != 8);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }

                    break;

                case 3:
                    System.out.println("Enter Password: ");
                    String managerPassword=KB.next();
                    int choice;
                    Manager m=new Manager();
                    boolean check=false;
                    check=m.checkPass(managerPassword);
                    if(check) {
                        do {
                            System.out.println("\n\t1. Display all accounts\n\t2. Search for an account\n\t3. Exit");
                            System.out.println("Enter your choice: ");
                            choice=KB.nextInt();
                            switch(choice) {
                                case 1:
                                    for(int i=0;i<C.size();i++) {
                                        m.showAccount1(C,i);
                                    }

                                    break;

                                case 2:
                                    System.out.println("Enter account no.: ");
                                    String AcNo=KB.next();
                                    boolean found1=false;
                                    for(int i=0;i<C.size();i++) {
                                        found1=m.search1(AcNo,C,i);
                                        if(found1) {
                                            C.get(i).showAccount();
                                        }
                                    }
                                    if(!found1) {
                                        System.out.println("This account does not exists.");
                                    }

                                    break;

                                case 3:
                                    break;

                                default:
                                    System.out.println("Enter a valid choice!");

                            }
                        }while(choice!=3);
                    }
                    if(!check) {
                        System.out.println("Incorrect Password!");
                    }

                    break;

                case 0:
                    break;
            }
        } while(x!=0);
        KB.close();

    }
}
