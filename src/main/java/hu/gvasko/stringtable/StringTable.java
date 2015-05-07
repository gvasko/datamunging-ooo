package hu.gvasko.stringtable;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by gvasko on 2015.05.06..
 */
public interface StringTable {
    List<StringRecord> getAllRecords();
    void addStringDecoder(UnaryOperator<String> decoder, String... fields);
}