package com.assignment.paintingwalls;

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


        System.out.println("What type of paint would you like to use? (flat/eggshell/satin/gloss");
        String paintType = scan.next();

        System.out.println("What size paint pots will be used in litres?");
        double paintPotVolume = scan.nextDouble();

        double costModifier = 0;

        costModifier = switch (paintType) {
            case "flat" -> 1;
            case "eggshell" -> 1.1;
            case "satin" -> 1.4;
            case "gloss" -> 1.9;
            default -> 1;
        };

        double paintPotCost = 0;

        if (paintPotVolume == 2.5) {
            paintPotCost = 15;
        } else if (paintPotVolume == 5) {
            paintPotCost = 30;
        }


        double paintPotCoverage = 4.8*paintPotVolume;
        //double areaToPaint = roomHeight*roomWidth*walls;
        double potsRequired = Math.ceil(totalAreaToPaint/paintPotCoverage);
        double paintUsed = areaToPaint/4.8;
        double remainingPaint = (potsRequired*paintPotVolume) - paintUsed;
        double totalCost = potsRequired*paintPotCost*costModifier;

        System.out.println("To paint " + walls + " wall(s), the painter will need " + (int)potsRequired + " " + paintPotVolume + "L pot(s) of paint.");
        System.out.println("The total cost of the job will be " + "$" + String.format("%.2f",totalCost) + ".");
        System.out.println("There will be " + String.format("%.2f",remainingPaint) + " litres of paint leftover.");

    }
}
