import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RubiksCube {
    static ArrayList<Array> Cube_Faces = new ArrayList<>();

    static String redFace[][]    = new String[][] {{"r","r","r"},{"r","r","r"},{"r","r","r"}};
    static String blueFace[][]   = new String[][] {{"b","b","b"},{"b","b","b"},{"b","b","b"}};;
    static String orangeFace[][] = new String[][] {{"o","o","o"},{"o","o","o"},{"o","o","o"}};;
    static String greenFace[][]  = new String[][] {{"g","g","g"},{"g","g","g"},{"g","g","g"}};;
    static String yellowFace[][] = new String[][] {{"y","y","y"},{"y","y","y"},{"y","y","y"}};;
    static String whiteFace[][]  = new String[][] {{"w","w","w"},{"w","w","w"},{"w","w","w"}};;
    static String nullFace[][]   = new String[][]  {{" "," "," "},{" "," "," "},{" "," "," "}};;

    public static ArrayList<String> solveArray = new ArrayList<String>();

    static Scanner scan = new Scanner(System.in);

    public static void CWRotate(String[][] side){
        String tempValue1 = side[0][0];
        String tempValue2 = side[1][0];
        side[0][0] = side[2][0];
        side[1][0] = side[2][1];
        side[2][0] = side[2][2];
        side[2][1] = side[1][2];
        side[2][2] = side[0][2];
        side[1][2] = side[0][1];
        side[0][2] = tempValue1;
        side[0][1] = tempValue2;
    }
    public static void CCWRotate(String[][] side){
        String tempValue1 = side[0][0];
        String tempValue2 = side[0][1];
        side[0][0] = side[0][2];
        side[0][1] = side[1][2];
        side[0][2] = side[2][2];
        side[1][2] = side[2][1];
        side[2][2] = side[2][0];
        side[2][1] = side[1][0];
        side[2][0] = tempValue1;
        side[1][0] = tempValue2;
    }
    public static void printCube(){
        for(int i = 0; i < 3; i++){
            System.out.println(nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2] + " | " + yellowFace[i][0] + " | " + yellowFace[i][1] + " | " + yellowFace[i][2] + " | " + nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2] + " | " + nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2]);
        }
        for(int i = 0; i < 3; i++){
            System.out.println(orangeFace[i][0] + " | " + orangeFace[i][1] + " | " + orangeFace[i][2] + " | " + blueFace[i][0] + " | " + blueFace[i][1] + " | " + blueFace[i][2] + " | " + redFace[i][0] + " | " + redFace[i][1] + " | " + redFace[i][2] + " | " + greenFace[i][0] + " | " + greenFace[i][1] + " | " + greenFace[i][2]);
        }
        for(int i = 0; i < 3; i++){
            System.out.println(nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2] + " | " + whiteFace[i][0] + " | " + whiteFace[i][1] + " | " + whiteFace[i][2] + " | " + nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2] + " | " + nullFace[i][0] + " | " + nullFace[i][1] + " | " + nullFace[i][2]);
        }
    }
    public static void takeInput(String move){
        String tempArray[] = new String[3];
        switch(move){
            case "U": 
                tempArray     = greenFace[0];
                greenFace[0]  = orangeFace[0];
                orangeFace[0] = blueFace[0];
                blueFace[0]   = redFace[0];
                redFace[0]    = tempArray;
                CWRotate(yellowFace);
                solveArray.add("U'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "U'": 
                tempArray     = orangeFace[0];
                orangeFace[0] = greenFace[0];
                greenFace[0]  = redFace[0];
                redFace[0]    = blueFace[0];
                blueFace[0]   = tempArray;
                CCWRotate(yellowFace);
                solveArray.add("U");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "D": 
                tempArray     = orangeFace[2];
                orangeFace[2] = greenFace[2];
                greenFace[2]  = redFace[2];
                redFace[2]    = blueFace[2];
                blueFace[2]   = tempArray;
                CWRotate(whiteFace);
                solveArray.add("D'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "D'": 
                tempArray     = greenFace[2];
                greenFace[2]  = orangeFace[2];
                orangeFace[2] = blueFace[2];
                blueFace[2]   = redFace[2];
                redFace[2]    = tempArray;
                CCWRotate(whiteFace);
                solveArray.add("D");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "R": 
                tempArray[0]     = blueFace[0][2];
                tempArray[1]     = blueFace[1][2];
                tempArray[2]     = blueFace[2][2];
                blueFace[0][2]   = whiteFace[0][2];
                blueFace[1][2]   = whiteFace[1][2];
                blueFace[2][2]   = whiteFace[2][2];
                whiteFace[0][2]  = greenFace[2][0];
                whiteFace[1][2]  = greenFace[1][0];
                whiteFace[2][2]  = greenFace[0][0];
                greenFace[0][0]  = yellowFace[2][2];
                greenFace[1][0]  = yellowFace[1][2];
                greenFace[2][0]  = yellowFace[0][2];
                yellowFace[2][2] = tempArray[2];
                yellowFace[1][2] = tempArray[1];
                yellowFace[0][2] = tempArray[0];
                CWRotate(redFace);
                solveArray.add("R'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "R'":
                tempArray[0]     = blueFace[0][2];
                tempArray[1]     = blueFace[1][2];
                tempArray[2]     = blueFace[2][2];
                blueFace[0][2]   = yellowFace[0][2];
                blueFace[1][2]   = yellowFace[1][2];
                blueFace[2][2]   = yellowFace[2][2];
                yellowFace[0][2] = greenFace[2][0];
                yellowFace[1][2] = greenFace[1][0];
                yellowFace[2][2] = greenFace[0][0];
                greenFace[0][0]  = whiteFace[2][2];
                greenFace[1][0]  = whiteFace[1][2];
                greenFace[2][0]  = whiteFace[0][2];
                whiteFace[0][2]  = tempArray[0];
                whiteFace[1][2]  = tempArray[1];
                whiteFace[2][2]  = tempArray[2];
                CCWRotate(redFace);
                solveArray.add("R");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "L":
                tempArray[0]     = blueFace[0][0];
                tempArray[1]     = blueFace[1][0];
                tempArray[2]     = blueFace[2][0];
                blueFace[0][0]   = yellowFace[0][0];
                blueFace[1][0]   = yellowFace[1][0];
                blueFace[2][0]   = yellowFace[2][0];
                yellowFace[0][0] = greenFace[2][2];
                yellowFace[1][0] = greenFace[1][2];
                yellowFace[2][0] = greenFace[0][2];
                greenFace[0][2]  = whiteFace[2][0];
                greenFace[1][2]  = whiteFace[1][0];
                greenFace[2][2]  = whiteFace[0][0];
                whiteFace[0][0]  = tempArray[0];
                whiteFace[1][0]  = tempArray[1];
                whiteFace[2][0]  = tempArray[2];
                CWRotate(orangeFace);
                solveArray.add("L'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "L'": 
                tempArray[0]     = blueFace[0][0];
                tempArray[1]     = blueFace[1][0];
                tempArray[2]     = blueFace[2][0];
                blueFace[0][0]   = whiteFace[0][0];
                blueFace[1][0]   = whiteFace[1][0];
                blueFace[2][0]   = whiteFace[2][0];
                whiteFace[0][0]  = greenFace[2][2];
                whiteFace[1][0]  = greenFace[1][2];
                whiteFace[2][0]  = greenFace[0][2];
                greenFace[0][2]  = yellowFace[2][0];
                greenFace[1][2]  = yellowFace[1][0];
                greenFace[2][2]  = yellowFace[0][0];
                yellowFace[2][0] = tempArray[2];
                yellowFace[1][0] = tempArray[1];
                yellowFace[0][0] = tempArray[0];
                CCWRotate(orangeFace);
                solveArray.add("L");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "F":
                tempArray[0]     = yellowFace[2][0];
                tempArray[1]     = yellowFace[2][1];
                tempArray[2]     = yellowFace[2][2];
                yellowFace[2][0] = orangeFace[2][2];
                yellowFace[2][1] = orangeFace[1][2];
                yellowFace[2][2] = orangeFace[0][2];
                orangeFace[2][2] = whiteFace[0][2];
                orangeFace[1][2] = whiteFace[0][1];
                orangeFace[0][2] = whiteFace[0][0];
                whiteFace[0][2]  = redFace[0][0];
                whiteFace[0][1]  = redFace[1][0];
                whiteFace[0][0]  = redFace[2][0];
                redFace[0][0]    = tempArray[0];
                redFace[1][0]    = tempArray[1];
                redFace[2][0]    = tempArray[2];
                CWRotate(blueFace);
                solveArray.add("F'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "F'":
                tempArray[0]     = yellowFace[2][0];
                tempArray[1]     = yellowFace[2][1];
                tempArray[2]     = yellowFace[2][2];
                yellowFace[2][0] = redFace[0][0];
                yellowFace[2][1] = redFace[1][0];
                yellowFace[2][2] = redFace[2][0];
                redFace[2][0]    = whiteFace[0][0];
                redFace[1][0]    = whiteFace[0][1];
                redFace[0][0]    = whiteFace[0][2];
                whiteFace[0][2]  = orangeFace[2][2];
                whiteFace[0][1]  = orangeFace[1][2];
                whiteFace[0][0]  = orangeFace[0][2];
                orangeFace[0][2] = tempArray[2];
                orangeFace[1][2] = tempArray[1];
                orangeFace[2][2] = tempArray[0];
                CCWRotate(blueFace);
                solveArray.add("F");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "B":
                tempArray[0]     = yellowFace[0][0];
                tempArray[1]     = yellowFace[0][1];
                tempArray[2]     = yellowFace[0][2];
                yellowFace[0][0] = redFace[0][2];
                yellowFace[0][1] = redFace[1][2];
                yellowFace[0][2] = redFace[2][2];
                redFace[2][2]    = whiteFace[2][0];
                redFace[1][2]    = whiteFace[2][1];
                redFace[0][2]    = whiteFace[2][2];
                whiteFace[2][2]  = orangeFace[2][0];
                whiteFace[2][1]  = orangeFace[1][0];
                whiteFace[2][0]  = orangeFace[0][0];
                orangeFace[0][0] = tempArray[2];
                orangeFace[1][0] = tempArray[1];
                orangeFace[2][0] = tempArray[0];
                CWRotate(greenFace);
                solveArray.add("B'");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "B'":
                tempArray[0]     = yellowFace[0][0];
                tempArray[1]     = yellowFace[0][1];
                tempArray[2]     = yellowFace[0][2];
                yellowFace[0][0] = orangeFace[2][0];
                yellowFace[0][1] = orangeFace[1][0];
                yellowFace[0][2] = orangeFace[0][0];
                orangeFace[2][0] = whiteFace[2][2];
                orangeFace[1][0] = whiteFace[2][1];
                orangeFace[0][0] = whiteFace[2][0];
                whiteFace[2][2]  = redFace[0][2];
                whiteFace[2][1]  = redFace[1][2];
                whiteFace[2][0]  = redFace[2][2];
                redFace[0][2]    = tempArray[0];
                redFace[1][2]    = tempArray[1];
                redFace[2][2]    = tempArray[2];
                CCWRotate(greenFace);
                solveArray.add("B");
                printCube();
                takeInput(scan.nextLine());
                break;
            case "Solve":
                System.out.println("To solve this cube, input the following moves in the given order");
                for(int i = 0; i < solveArray.size(); i++){
                    System.out.print((solveArray.get(solveArray.size()-(i+1)))+", ");
                }
        }
    }
    public static void main(String[] args){
        printCube();
        takeInput(scan.nextLine());
    }
}