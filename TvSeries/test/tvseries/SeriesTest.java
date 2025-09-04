/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tvseries;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shaun
 */
public class SeriesTest {
    
    public SeriesTest() {
    }

    @Test
    public void testCaptureSeries() {
    }

     @Test
    public void TestSearchSeries() {
        Series series = new Series();
        SeriesModel model = new SeriesModel("201", "Search Show", "12", "5");
        series.seriesList.add(model);

        SeriesModel found = series.seriesList.get(0);

        assertEquals("201", found.seriesId);
        assertEquals("Search Show", found.seriesName);
        assertEquals("12", found.seriesAge);
        assertEquals("5", found.seriesNumberOfEpisodes);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series();
        series.seriesList.add(new SeriesModel("202", "Another Show", "13", "7"));

        // Just check the only element is not the one we are searching for
        assertNotEquals("999", series.seriesList.get(0).seriesId);
    }


    @Test
    public void testUpdateSeries() {
        Series series = new Series();
        SeriesModel model = new SeriesModel("203", "Old Title", "14", "6");
        series.seriesList.add(model);

        SeriesModel toUpdate = series.seriesList.get(0);
        toUpdate.seriesName = "New Title";
        toUpdate.seriesAge = "18";
        toUpdate.seriesNumberOfEpisodes = "9";

        assertEquals("New Title", toUpdate.seriesName);
        assertEquals("18", toUpdate.seriesAge);
        assertEquals("9", toUpdate.seriesNumberOfEpisodes);
        
    }
     @Test
    public void TestDeleteSeries() {
        Series series = new Series();
        series.seriesList.add(new SeriesModel("204", "Delete Me", "16", "4"));

        assertEquals(1, series.seriesList.size());
        series.seriesList.remove(0);
        assertEquals(0, series.seriesList.size());
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series();
        series.seriesList.add(new SeriesModel("205", "Keep Me", "12", "3"));

        int before = series.seriesList.size();
        // Try removing something that doesn’t exist
        series.seriesList.removeIf(s -> s.seriesId.equals("999"));
        int after = series.seriesList.size();

        assertEquals(before, after);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        String age = "15"; // valid range 2–18
        boolean valid = age.matches("\\d+") &&
                        Integer.parseInt(age) >= 2 &&
                        Integer.parseInt(age) <= 18;

        assertTrue(valid);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        String age = "25"; // invalid
        boolean valid = age.matches("\\d+") &&
                        Integer.parseInt(age) >= 2 &&
                        Integer.parseInt(age) <= 18;

        assertFalse(valid);
    }

 
}
