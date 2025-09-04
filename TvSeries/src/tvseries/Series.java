/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseries;

/**
 *
 * @author shaun
 */
import java.util.Scanner;
import java.util.ArrayList;


public class Series {
    ArrayList<SeriesModel> seriesList = new ArrayList<>(); // Stores all series
    private Scanner scanner = new Scanner(System.in);             // Input scanner

    /**
     * Captures a new series with user input and validates age restriction.
     */
    public void CaptureSeries() {
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        String age;
        do {
            System.out.print("Enter the series age restriction (2-18): ");
            age = scanner.nextLine();
            if (!age.matches("\\d+") || Integer.parseInt(age) < 2 || Integer.parseInt(age) > 18) {
                System.out.println("Invalid age restriction! Please enter a number between 2 and 18.");
                age = scanner.nextLine(); // Prompt for re-entry
            }
        } while (!age.matches("\\d+") || Integer.parseInt(age) < 2 || Integer.parseInt(age) > 18);

        System.out.print("Enter the number of episodes: ");
        String episodes = scanner.nextLine();
        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series processed successfully!!! Details have been saved.");
    }

    /**
     * Searches for a series by ID and displays its details.
     */
    public void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id)) {
                System.out.println("SERIES ID: " + series.seriesId);
                System.out.println("SERIES NAME: " + series.seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
                System.out.println("SERIES NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
                System.out.println("Enter (1) to launch menu or any other key to exit");
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!!");
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }

    /**
     * Updates an existing series' details based on its ID.
     */
    public void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(id)) {
                System.out.print("Enter the new series name: ");
                series.seriesName = scanner.nextLine();

                String age;
                do {
                    System.out.print("Enter the new age restriction (2-18): ");
                    age = scanner.nextLine();
                    if (!age.matches("\\d+") || Integer.parseInt(age) < 2 || Integer.parseInt(age) > 18) {
                        System.out.println("Invalid age restriction! Please enter a number between 2 and 18.");
                        age = scanner.nextLine();
                    }
                } while (!age.matches("\\d+") || Integer.parseInt(age) < 2 || Integer.parseInt(age) > 18);

                series.seriesAge = age;
                System.out.print("Enter the new number of episodes: ");
                series.seriesNumberOfEpisodes = scanner.nextLine();
                System.out.println("Series updated successfully!!!");
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!!");
    }

    /**
     * Deletes a series after user confirmation.
     */
    public void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).seriesId.equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + "? Yes (y) to delete... ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(i);
                    System.out.println("Series with Series Id: " + id + " WAS deleted!!");
                    return;
                }
                return; // Exit if user declines
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!!");
    }

    /**
     * Displays a report of all series in memory.
     */
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series data available.");
            return;
        }
        System.out.println("SERIES REPORT - 2025");
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("SERIES " + (i + 1));
            System.out.println("SERIES ID: " + series.seriesId);
            System.out.println("SERIES NAME: " + series.seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + series.seriesAge);
            System.out.println("NUMBER OF EPISODES: " + series.seriesNumberOfEpisodes);
            if (i < seriesList.size() - 1) {
                System.out.println("-------------------");
            }
        }
    }

    /**
     * Exits the application.
     */
    public void ExitSeriesApplication() {
        System.out.println("Exiting application...");
        scanner.close();
        System.exit(0);
    }
    
}