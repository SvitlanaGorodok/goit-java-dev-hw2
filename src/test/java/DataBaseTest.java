import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    private static DataBase dataBase = new DataBase();

    @ParameterizedTest (name = "#{index} - Run test with arguments cart={0} expectedValue={1}")
    @MethodSource("predefinedDataTrue")
    void testCalculateCartCostShouldReturnTrue(String cart, float expectedValue){
        double actualValue = dataBase.calculateCartCost(cart);
        assertEquals(actualValue, expectedValue);
    }

    @ParameterizedTest (name = "#{index} - Run test with arguments cart={0} expectedValue={1}")
    @MethodSource("predefinedDataFalse")
    void testCalculateCartCostShouldReturnFalse(String cart, float expectedValue){
        double actualValue = dataBase.calculateCartCost(cart);
        assertNotEquals(actualValue, expectedValue);
    }

    @Test
    void testIfStorageNotEmpty() {
        HashMap<Character, Prices> actualValue = dataBase.getStorage();
        assertNotEquals(actualValue, null);
    }

    @Test
    void testIfStorageHasElements() {
        boolean actualValue = dataBase.getStorage().isEmpty();
        assertNotEquals(actualValue, true);
    }

    @Test
    void testIfStorageKeyIsOk() {
        Class<? extends Character> actualValue = dataBase.getStorage().keySet().iterator().next().getClass();
        assertEquals(actualValue, Character.class);
    }

    @Test
    void testIfStorageValueIsOk() {
        Class<? extends Prices> actualValue = dataBase.getStorage().values().iterator().next().getClass();
        assertEquals(actualValue, Prices.class);
    }

    static Stream<Arguments> predefinedDataTrue(){
        return Stream.of(Arguments.arguments("AAAAA", 5.5f), Arguments.arguments("BBB", 12.75f),
                Arguments.arguments("CCC", 3.0f), Arguments.arguments("DDD", 2.25f),
                Arguments.arguments("FFF", 0f), Arguments.arguments("ABCDABA", 13.25f),
                Arguments.arguments("", 0f)
        );
    }

    static Stream<Arguments> predefinedDataFalse(){
        return Stream.of(Arguments.arguments("AAA", 10.25f), Arguments.arguments("BBB", 10.25f),
                Arguments.arguments("CCC", 10.25f), Arguments.arguments("DDD", 10.25f),
                Arguments.arguments("FFF", 1f), Arguments.arguments("ABCDABA", 10.25f),
                Arguments.arguments("", 1f)
        );
    }

}