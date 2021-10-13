package com.assignment.paintingwalls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PaintingWalls {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double roomHeight = 0;
        double roomWidth = 0;
        int walls = 0;
        String newWallAnswer = "yes";
        double areaToPaint = 0;
        double totalAreaToPaint = 0;


        do {
            System.out.println("How tall is the room in metres?");
            roomHeight = scan.nextDouble();

            System.out.println("How wide is the room in metres?"); // room assumed square
            roomWidth = scan.nextDouble();

            areaToPaint = roomHeight*roomWidth;
            totalAreaToPaint = totalAreaToPaint + areaToPaint;

            ++walls;

            System.out.println("Would you like to add another wall?");
            newWallAnswer = scan.next();

        } while(Objects.equals(newWallAnswer, "yes"));

        ArrayList<String> listOfPaintTypes = new ArrayList<String>();
        listOfPaintTypes.add("flat");
        listOfPaintTypes.add("eggshell");
        listOfPaintTypes.add("satin");
        listOfPaintTypes.add("gloss");

        System.out.println("What type of paint would you like to use? " + listOfPaintTypes.get(0) + "/" + listOfPaintTypes.get(1) + "/" + listOfPaintTypes.get(2)  + "/" + listOfPaintTypes.get(3));
        String paintType = scan.next();

        double costModifier = 0;
        double[] costModTable = {getNumberMod(costModifier),1.1,1.4,1.9};

        costModifier = switch (paintType) {
            case "flat" -> costModTable[0];
            case "eggshell" -> costModTable[1];
            case "satin" -> costModTable[2];
            case "gloss" -> costModTable[3];
            default -> costModTable[0];
        };

        double[] potCostTable = {8.99,15.50,27.99};

        System.out.println("What size paint pots will be used in litres?");
        double paintPotVolume = scan.nextDouble();

        double paintPotCost = 0;


        if (paintPotVolume == 1) {
            paintPotCost = potCostTable[0];
        } else if (paintPotVolume == 2.5) {
            paintPotCost = potCostTable[1];
        } else if (paintPotVolume == 5){
            paintPotCost = potCostTable[2];
        }


        double paintPotCoverage = 4.8*paintPotVolume;
        //double areaToPaint = roomHeight*roomWidth*walls;
        double potsRequired = Math.ceil(totalAreaToPaint/paintPotCoverage);
        double paintUsed = totalAreaToPaint/4.8;
        double remainingPaint = (potsRequired*paintPotVolume) - paintUsed;
        double totalCost = potsRequired*paintPotCost*costModifier;

        System.out.println("To paint " + walls + " wall(s), the painter will need " + (int)potsRequired + " " + paintPotVolume + "L pot(s) of paint.");
        System.out.println("The total cost of the job will be " + "$" + String.format("%.2f",totalCost) + ".");
        System.out.println("There will be " + String.format("%.2f",remainingPaint) + " litres of paint leftover.");

    }

    public static double getNumberMod(double x) {
        double y = x+1;
        return y;
    }
}
