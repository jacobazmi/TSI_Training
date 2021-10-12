package com.assignment.paintingwalls;

import java.util.Scanner;

public class PaintingWalls {
    public static void main(String[] args) {
        //double paintPotVolume = 2.5; // litres
        //double paintPotCoverage = 12; // square metres
        //double paintPotCost = 5.6; // dollars
        //double roomHeight = 3.7; // metres
        //double roomWidth = 4.8; // metres
        //int walls = 2;

        Scanner scan = new Scanner(System.in);

        System.out.println("How many walls do you want to paint?");
        int walls = scan.nextInt();

        System.out.println("How tall is the room in metres?");
        double roomHeight = scan.nextDouble();

        System.out.println("How wide is the room in metres?"); // room assumed square
        double roomWidth = scan.nextDouble();

        System.out.println("What size paint pots will be used in litres?");
        double paintPotVolume = scan.nextDouble();

        double paintPotCost = 0;

        if (paintPotVolume == 2.5) {
            paintPotCost = 15;
        } else if (paintPotVolume == 5) {
            paintPotCost = 30;
        }

        //System.out.println("What is the cost of a pot of paint in dollars?");
        //double paintPotCost = scan.nextDouble();

    double paintPotCoverage = 4.8*paintPotVolume;
        double areaToPaint = roomHeight*roomWidth*walls;
        double potsRequired = Math.ceil(areaToPaint/paintPotCoverage);
        double paintUsed = areaToPaint/4.8;
        double remainingPaint = (potsRequired*paintPotVolume) - paintUsed;
        double totalCost = potsRequired*paintPotCost;

        System.out.println("To paint " + walls + " walls, the painter will need " + (int)potsRequired + " " + paintPotVolume + "L pot(s) of paint.");
        System.out.println("The total cost of the job will be " + "$" + String.format("%.2f",totalCost) + ".");
        System.out.println("There will be " + String.format("%.2f",remainingPaint) + " litres of paint leftover.");

    }
}
