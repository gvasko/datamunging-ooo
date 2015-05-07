package hu.gvasko.codekata.datamunging;

import hu.gvasko.stringtable.StringTable;
import hu.gvasko.stringtable.StringTableFactory;
import hu.gvasko.stringtable.StringTableParser;
import hu.gvasko.stringtable.TrimToInteger;
import org.junit.Assert;
import org.junit.Test;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * Created by gvasko on 2015.05.06..
 */
public class DataMunging {

    // Columns
    final int WEATHER_DAY_LEN = 5;
    final int WEATHER_MAX_T_LEN = 6;
    final int WEATHER_MIN_T_LEN = 6;
    final String WEATHER_DAY_NAME = "Dy";
    final String WEATHER_MAX_T_NAME = "MxT";
    final String WEATHER_MIN_T_NAME = "MnT";

    @Test
    public void testDayOfSmallestTemperatureSpread() throws Exception {
        URL datFile = this.getClass().getResource("weather.dat");
        try (StringTableParser parser = StringTableFactory.getSoleInstance().getParser(datFile.toURI())) {
            // parser config: select the range to be parsed
            StringTable table = parser.firstRowIsHeader().excludeLastRow().excludeEmptyRows().parse(
                    WEATHER_DAY_LEN, WEATHER_MAX_T_LEN, WEATHER_MIN_T_LEN
            );

            // decoder: how to process each field in the selected range
            table.addStringDecoder(new TrimToInteger(), WEATHER_MAX_T_NAME, WEATHER_MIN_T_NAME);

            String dayOfSmallestTemperatureSpread = "14";
            String actualDay = DataMungingUtil.getFirstMinDiffRecord(table.getAllRecords(), WEATHER_MAX_T_NAME, WEATHER_MIN_T_NAME).get(WEATHER_DAY_NAME);
            Assert.assertEquals(dayOfSmallestTemperatureSpread, actualDay);
        }
    }
}