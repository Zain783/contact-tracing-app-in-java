import java.util.Scanner;
public class Main {

    static boolean setPosition(person obj, person[][] system, int position){
//here we are assuming that positionCounter variable which value initially 0 but soon when we iterate in loop then we will increament his value
//till we are not reached to insertion position which are choose by user
        int positionCounter=0;
        boolean isUserinsertedAtPostion=false;
        for (int i = 0; i < system.length; i++) {
            for (int j = 0; j < system.length; j++) {

                //when this condition is hited then we will store person position information at this specfic position at this index in our board
                if (positionCounter == position) {
                    system[i][j]=obj;
                    isUserinsertedAtPostion=true;
                    return isUserinsertedAtPostion;
                }
                positionCounter++;
            }

        }

    return isUserinsertedAtPostion;

    }
    //this function will identify the position of user with thus pername in all over thos board and if he got the position then it will return to us
static person querifyTheposition(String personName,person[][] system){
    person obj=null;

    for (int i = 0; i < system.length; i++) {
        for (int j = 0; j < system.length; j++) {
            if(personName.equals(system[i][j].name)){
                obj=system[i][j];
                return  obj;
            }
        }
    }
    return  obj;
}
//this function will check that the peron with its name is already exists to Varify that person is unique or not
static boolean isPersonAlreadyExists(person[][] system,String personName){

    for (int i = 0; i < system.length; i++) {
        for (int j = 0; j < system.length; j++) {
            if(personName.equals(system[i][j].name)){

                return  true;
            }
        }
    }
    return  false;
}
    static void displayUserdata(person[][] system){
        for (int i = 0; i < system.length; i++) {
            for (int j = 0; j < system.length; j++) {

                System.out.print(system[i][j].position+" "+system[i][j].name+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        The virtualsize of the board is 10 x 10, but should be configurable for up to 1,000 x 1,000.
        int size_of_the_board=10;
        System.out.print("Enter value to resize size of Board or put 0 if you not want to resize:");
        Scanner sc=new Scanner(System.in);
        int value=sc.nextInt();
        if(value!=0){
            size_of_the_board=value;
        }
        //should be configurable for up to 1,000 x 1,000 and 0 for dismiss or continue with default size
        if(size_of_the_board<=1000){
            person[][]  system= new person[size_of_the_board][size_of_the_board];
            for (int i = 0; i < size_of_the_board; i++) {
                for (int j = 0; j < size_of_the_board; j++) {
                    system[i][j]=new person(globalposition.globalPosition++);
                }
            }
            for (int i = 0; i < size_of_the_board; i++) {
                for (int j = 0; j < size_of_the_board; j++) {

                    System.out.print(system[i][j].position+"  ");
                }
                System.out.println();

            }

            while(true){

                System.out.println("1.for move one square:");
                System.out.println("2.for to querify the position:");
                System.out.println("3.for to print board :");
                System.out.println("3.for Exit() :");
                Scanner option=new Scanner(System.in);
                int opstionvalue=option.nextInt();
                if(opstionvalue==1){
                    System.out.println("Enter the person name:");
                    Scanner name=new Scanner(System.in);
                    String nameValue=name.next();
                    System.out.println("Enter the person Postion:");
                    Scanner position=new Scanner(System.in);
                    int indexPosition=position.nextInt();
                    boolean isExists=isPersonAlreadyExists(system,nameValue);
                    if(isExists==true){

                        System.out.println("The User is already exists with this name or id..");
                    }else{
                        boolean response=setPosition(new person(nameValue,indexPosition),system,indexPosition);
                        if(response==true){

                            System.out.println("user data is inserted at this "+indexPosition+"  position..");

                        }else {
                            System.out.println("You Choose wrong Postion");
                        }
                    }
                    //i have concatenate  person name and person current position to uniquely identify

                }else if(opstionvalue==3){

                    displayUserdata(system);
                }else if(opstionvalue==2){
                    System.out.println("Enter the person name:");
                    Scanner name=new Scanner(System.in);
                    String namevalue=name.next();
                    person isExists=querifyTheposition(namevalue.toString(),system);
                    if(isExists==null){

                        System.out.println("person at this position not exists");
                    }else{

                        System.out.println("Person Exists with name :"+isExists.name+" and postion is:"+isExists.position);

                    }
                }


            }

        }



    }


}