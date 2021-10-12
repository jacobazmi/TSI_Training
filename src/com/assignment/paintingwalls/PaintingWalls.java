package com.assignment.paintingwalls;

import java.util.Scanner;

public class PaintingWalls {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many walls do you want to paint?");
        int walls = scan.nextInt();

        System.out.println("How tall is the room in metres?");
        double roomHeight = scan.nextDouble();

        System.out.println("How wide is the room in metres?"); // room assumed square
        double roomWidth = scan.nextDouble();

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
        double areaToPaint = roomHeight*roomWidth*walls;
        double potsRequired = Math.ceil(areaToPaint/paintPotCoverage);
        double paintUsed = areaToPaint/4.8;
        double remainingPaint = (potsRequired*paintPotVolume) - paintUsed;
        double totalCost = potsRequired*paintPotCost*costModifier;

        System.out.println("To paint " + walls + " walls, the painter will need " + (int)potsRequired + " " + paintPotVolume + "L pot(s) of paint.");
        System.out.println("The total cost of the job will be " + "$" + String.format("%.2f",totalCost) + ".");
        System.out.println("There will be " + String.format("%.2f",remainingPaint) + " litres of paint leftover.");

    }
}
