/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class RealEstate {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    static ArrayList<Property> inputList = new ArrayList();
    static ArrayList<Double> abc = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException {
        inputList = readDataLineByLine("resources/data.csv");

        System.out.println(inputList.get(5).price);
        System.out.println(inputList.get(5).address);
        System.out.println(inputList.get(5).landsize);
        sum();
        
        double a = abc.get(0);
        double b = abc.get(1);
        double c = abc.get(2);
        
       Scanner sc = new Scanner(System.in);
       System.out.println("Please enter the post code : ");

       int X = sc.nextInt();
       System.out.println("Please enter the land size : ");

        int Z = sc.nextInt();

        double y = (a * X) + (b * Z) + c;
           System.out.println("The price : " + y);

    }

    static void sum() {
        double sumx = 0;//sum address 
        double sumy = 0;// sum price 
        double sumz = 0;// sum land size
        int i;
        for (i = 0; i < inputList.size(); i++) {
            sumx = sumx + inputList.get(i).address;
            sumy = sumy + inputList.get(i).price;
            sumz = sumz + inputList.get(i).landsize;

        }
        System.out.println("Sum of price = " + sumy);
        System.out.println("Sum of Post code  = " + sumx);
        System.out.println("Sum of land size  = " + sumz);

        double meanx = sumx / i;
        double meany = sumy / i;
        double meanz = sumz / i;
        System.out.println("mean of price = " + meany);
        System.out.println("mean of Post code  = " + meanx);
        System.out.println("mean of land size  = " + meanz);
        double sumxm = 0;
        double sumym = 0;
        double sumzm = 0;
        double sumxmp2 = 0;
        double sumzmp2 = 0;
        double sumxmym = 0;
        double sumymzm = 0;
        double sumxmzm = 0;

        for (int q = 0; q < inputList.size(); q++) {
            double xm = inputList.get(q).address - meanx;
            double ym = inputList.get(q).price - meany;
            double zm = inputList.get(q).landsize - meanz;
            double xmp2 = Math.pow(2, xm);
            double zmp2 = Math.pow(2, zm);

            sumxm = sumxm + xm;
            sumym = sumym + ym;
            sumzm = sumzm + zm;
            sumxmp2 = sumxmp2 + xmp2;
            sumzmp2 = sumzmp2 + zmp2;
            sumxmym = sumxmym + (xm * ym);
            sumymzm = sumymzm + (ym * zm);
            sumxmzm = sumxmzm + (xm * zm);
        }

        System.out.println("Sumxm = " + sumxm);
        System.out.println("Sumym = " + sumym);
        System.out.println("Sumzm = " + sumzm);
        System.out.println("Sumxmp2 = " + sumxmp2);
        System.out.println("Sumzmp2 = " + sumzmp2);
        System.out.println("sumxmym = " + sumxmym);
        System.out.println("sumymzm = " + sumymzm);
        System.out.println("sumxmzm = " + sumxmzm);

        double a = ((sumxmym * sumzmp2) - (sumymzm * sumxmzm)) / ((sumxmp2 * sumzmp2) - Math.pow(2, (sumxmzm)));
        double b = ((sumymzm * sumxmp2) - (sumxmym * sumxmzm)) / ((sumxmp2 * sumzmp2) - Math.pow(2, sumxmzm));
        double c = meany - (a * meanx) - (b * meanz);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        
        abc.add(a);
        abc.add(b);
        abc.add(c);
    }

    static ArrayList<Property> readDataLineByLine(String file) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new BufferedReader(new FileReader(file)));
        ArrayList<Property> mydata = new ArrayList();
        while (fileinput.hasNextLine()) {
            Property toAdd = new Property();

            String newline = fileinput.nextLine();

            String[] line = newline.trim().split(",");

            toAdd.setPrice(Double.parseDouble(line[4]));
            toAdd.setAddress(Double.parseDouble(line[9]));
            toAdd.setLandsize(Double.parseDouble(line[13]));
//            System.out.println(line[4]);
//            System.out.println(line[9]);
//            System.out.println(line[13]);
            mydata.add(toAdd);

//            
        }

        return mydata;

    }

}
