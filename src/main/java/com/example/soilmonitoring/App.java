package com.example.soilmonitoring;

import java.util.Scanner;

public class App {

    public enum SoilType {
        SANDY(10, 30, "Carrot, Potato, Groundnut"),
        LOAMY(40, 60, "Wheat, Maize, Sugarcane, Pulses"),
        CLAY(50, 70, "Rice, Jute, Sugarcane"),
        SILT(40, 60, "Tomato, Onion, Wheat, Corn");

        private final int minMoisture;
        private final int maxMoisture;
        private final String recommendedCrops;

        SoilType(int min, int max, String crops) {
            this.minMoisture = min;
            this.maxMoisture = max;
            this.recommendedCrops = crops;
        }

        public int getMinMoisture() { return minMoisture; }
        public int getMaxMoisture() { return maxMoisture; }
        public String getRecommendedCrops() { return recommendedCrops; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Soil Type (SANDY, LOAMY, CLAY, SILT): ");
        String soilInput = scanner.nextLine().trim().toUpperCase();

        try {
            SoilType selectedSoil = SoilType.valueOf(soilInput);

            System.out.print("Enter current soil moisture level (0 - 100): ");
            int moistureLevel = scanner.nextInt();

            if (moistureLevel < 0 || moistureLevel > 100) {
                System.out.println("Invalid moisture value. Please enter between 0 and 100.");
                return;
            }

            System.out.println("\n--- Soil Analysis Report ---");
            System.out.println("Soil Type: " + selectedSoil.name());
            System.out.println("Moisture Level: " + moistureLevel + "%");

            if (moistureLevel < selectedSoil.getMinMoisture()) {
                System.out.println("Status: Soil is too dry. Water is needed.");
            } else if (moistureLevel > selectedSoil.getMaxMoisture()) {
                System.out.println("Status: Soil is too wet. Stop irrigation.");
            } else {
                System.out.println("Status: Moisture is optimal for this soil.");
            }

            System.out.println("Recommended Crops: " + selectedSoil.getRecommendedCrops());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid soil type. Please enter: SANDY, LOAMY, CLAY, or SILT.");
        }
    }
}
