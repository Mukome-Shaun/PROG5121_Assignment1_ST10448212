/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tvseries;

/**
 *
 * @author shaun
 */
import java.util.Scanner;
public class TvSeries {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();

        while (true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String choice = scanner.nextLine();

            if (!choice.equals("1")) {
                seriesManager.ExitSeriesApplication();
                break;
            }

            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025.");
            System.out.println("(6) Exit Application.");

            System.out.print("Enter your choice: ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1":
                    seriesManager.CaptureSeries();
                    break;
                case "2":
                    seriesManager.SearchSeries();
                    break;
                case "3":
                    seriesManager.UpdateSeries();
                    break;
                case "4":
                    seriesManager.DeleteSeries();
                    break;
                case "5":
                    seriesManager.SeriesReport();
                    break;
                case "6":
                    seriesManager.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Enter (1) to launch menu or any other key to exit");
        }
        
    }
    
}
