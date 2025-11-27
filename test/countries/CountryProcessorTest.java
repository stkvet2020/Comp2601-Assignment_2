package countries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CountryProcessorTest {

    private CountryProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new CountryProcessor();
    }

    @Test
    @DisplayName("Should run printNumberOfCountries without errors.")
    void printNumberOfCountries() {
        assertDoesNotThrow(() -> processor.printNumberOfCountries());
    }

    @Test
    @DisplayName("Should run printLongestCapitalCity without errors.")
    void printLongestCapitalCity() {
        assertDoesNotThrow(() -> processor.printLongestCapitalCity());
    }

    @Test
    @DisplayName("Should run printShortestCountryName without errors.")
    void printShortestCountryName() {
        assertDoesNotThrow(() -> processor.printShortestCountryName());
    }

    @Test
    @DisplayName("Should run printAllCountriesThatStartWith without errors.")
    void printAllCountriesThatStartWith() {
        assertDoesNotThrow(() -> processor.printAllCountriesThatStartWith("A"));
    }
}