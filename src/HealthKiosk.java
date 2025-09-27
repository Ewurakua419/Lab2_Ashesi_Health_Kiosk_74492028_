import java.util.Scanner;
public class HealthKiosk {
    public static void main (String[] arg){
        System.out.println("Welcome to the health kiosk!");
        Scanner value= new Scanner(System.in);
        System.out.println("Enter service code (P/L/T/C)");
        String inputval=value.next();
        inputval=inputval.toUpperCase();
        char service=inputval.charAt(0);
        int healthMetric=0;
        double bMI=0;

        switch (service) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                break;
        }
        if (service=='T'){
            
            System.out.println("Please enter  health metric: 1 for BMI, 2 for Dosage round-up, 3 for simple trig helper ");
            healthMetric=value.nextInt();
            switch(healthMetric){
                case 1:
                    System.out.println("Please enter your weight in kg:");
                    double weight=value.nextDouble();
                
                    System.out.println("Please enter your height in cm:");
                    double height=value.nextDouble();

                    height=height/100;
                    bMI=weight/(Math.pow(height, 2));
                    bMI=Math.round(bMI*10.0)/10.0;

                    if (bMI<18.5){
                        System.out.println("BMI:"+bMI+" Category: Underweight");
                    }
                    else if (bMI>=18.5 && bMI<=24.9){
                        System.out.println("BMI:"+bMI+" Category: Normal");
                    }
                    else if (bMI>=25.0 && bMI<=29.9){
                        System.out.println("BMI:"+bMI+" Category: Overweight");
                    }
                    else{
                        System.out.println("BMI:"+bMI+" Category: Obese");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the required dosage in mg");
                    double dosage=value.nextDouble();
                    int numberOfTablets=(int) Math.ceil(dosage/250);
                    System.out.println("The number of tablets required are: "+numberOfTablets);
                    break;
                
                case 3:
                    System.out.println("Please enter an angle in degrees:");
                    double angle=value.nextDouble();
                    angle=angle*(Math.PI/180);//switch to radians
                    angle=(Math.round(angle * 1000) / 1000.0);
                    double sinOfAngle=Math.sin(angle);
                    sinOfAngle=(Math.round(sinOfAngle * 1000) / 1000.0);
                    double cosOfAngle=Math.cos(angle);
                    cosOfAngle=(Math.round(cosOfAngle * 1000) / 1000.0);
                    System.out.println("The sin of the angle "+angle+" is: "+ sinOfAngle+" and the cos of the angle is: "+cosOfAngle);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        //ID Sanity Check
        String setOfChar="ABCDEFGHIJKLMNOPQSTUVWXYZ";
        int location=(int) Math.random()*26;
        char beginChar=setOfChar.charAt(location);
        int num1=3+(int)(Math.random()*7);
        int num2=3+(int)(Math.random()*7);
        int num3=3+(int)(Math.random()*7);
        int num4=3+(int)(Math.random()*7);
        String iD=beginChar+String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3)+String.valueOf(num4);
        
        if (iD.length()==5 && Character.isLetter(beginChar)&& Character.isDigit(iD.charAt(1))&& Character.isDigit(iD.charAt(2))&& Character.isDigit(iD.charAt(3))&& Character.isDigit(iD.charAt(4))){
            System.out.println("ID OK");
        }
        else{
            if (iD.length()!=5){
                System.out.println("Invalid length");

            }
            if (!Character.isLetter(beginChar)){
                System.out.println("First char must be a letter");
            }
            if (Character.isDigit(iD.charAt(1))&& Character.isDigit(iD.charAt(2))&& Character.isDigit(iD.charAt(3))&& Character.isDigit(iD.charAt(4))){
                System.out.println("last 4 must be digits");
            }

        }
        //“Secure” Display Code
        System.out.println("Please enter your first name");
        String nameStudent=value.next();
        nameStudent=nameStudent.toUpperCase();
        char base=nameStudent.charAt(0);
        System.out.println(" Base code=" +base);
        char baseShift=(char)('A' +(base - 'A' + 2) % 26);
        System.out.println("Shifted letter of base code= "+baseShift );
        String lastTwoCharacters=iD.substring(3);
        System.out.println("Last two characters for ID: "+ lastTwoCharacters);
        String displayCode="";
        if (service=='T' && healthMetric==1){
            displayCode=baseShift+lastTwoCharacters+"-"+(int)(Math.round(bMI));
        }
        else{
            displayCode=baseShift+lastTwoCharacters+"-"+23;
        }
        System.out.println("Display code: "+displayCode);

        switch (service) {
            case 'P':
                System.out.println("PHARMACY | ID="+iD+" | "+displayCode);
                break;
            case 'L':
                System.out.println("LAB | ID="+iD+" | "+displayCode);
                break;
            case 'T':
                System.out.println("TRIAGE | ID= "+iD+" | "+displayCode);
                break;
            case 'C':
                System.out.println("COUNSELING | ID="+iD+" | "+displayCode);
                break;
            default:
                System.out.println("Please try again");
                break;
        }
        value.close();
    }
    
}
