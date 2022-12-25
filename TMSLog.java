import java.util.ArrayList;


public class TMSLog {
    private ArrayList<TMS> tmsLog;
         
    public TMSLog() {
        tmsLog = new ArrayList<TMS>();
    }

    public void archiveReport(TMS tms) {
        if (tmsLog.size() == 0) {
            tmsLog.add(tms);
        }
        else {
            for (TMS tms2 : tmsLog) {
                if (tms2.equals(tms)) {
                    tmsLog.add(tms2);
                    return;
                }
            }
            tmsLog.add(tms);
        }
        
    }

    public void showLog(String name) {
        System.out.println("TMS Archive:");
        Utils.logHeader();
        int tmsCount = 1;
        for (TMS tms : tmsLog) {
            int recordCount = 0;
            for (int i = 0; i < tmsLog.size(); i++) {
                if (tms.equals(tmsLog.get(i))) {
                    recordCount = i+1;
                }
            }
            while (tmsCount <= recordCount) {
                System.out.format(Utils.logFormat, "TMS " +(tmsCount), (name+recordCount));
                tmsCount++;
            }
            tmsCount = recordCount +1;
        }
        System.out.format("+--------------+----------------+%n");
    }

    public void retrieveReport(String name) {
        String recordID = Utils.string("RecordID");

        for (TMS tms : tmsLog) {
            int recordCount = 0;
            for (int i = 0; i < tmsLog.size(); i++) {
                if (tms.equals(tmsLog.get(i))) {
                    recordCount = i+1;
                }
            }
            if (recordID.equals(name+recordCount)) {
                tms.viewTMS();
                return;
            }
        }
        System.out.println("No TMS is recorded as: " + recordID);
    }
    
    public int getSize() {
        return tmsLog.size();
    }
    
}

