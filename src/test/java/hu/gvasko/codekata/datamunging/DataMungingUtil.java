package hu.gvasko.codekata.datamunging;

import hu.gvasko.stringtable.StringRecord;

import java.util.List;

/**
 * Utility functions to delay design decisions
 * Created by gvasko on 2015.05.06..
 */
public class DataMungingUtil {

    public static StringRecord getFirstMinDiffRecord(List<StringRecord> records, String f1, String f2) {
        return records.stream().min( (rec1, rec2) -> Integer.compare(getDiff(rec1, f1, f2), getDiff(rec2, f1, f2)) ).get();
    }

    private static int getDiff(StringRecord rec, String f1, String f2) {
        return Math.abs(Integer.parseInt(rec.get(f1)) - Integer.parseInt(rec.get(f2)));
    }

}