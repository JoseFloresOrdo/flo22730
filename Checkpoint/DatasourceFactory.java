public class DatasourceFactory {
    
    public static final int CSV_TYPE = 1;
    public static final int XML_TYPE = 3;
    public static final int JSON_TYPE = 2;
    public static final int TXT_TYPE = 40;

    public static IExport getDataSourceInstance(int fomarType){
        switch (fomarType) {
            case CSV_TYPE:
                return new CSVDataSource();    

            case XML_TYPE:
                return new XMLDataSource();

            case JSON_TYPE:
                return new JSONDataSource();
        
            default:
                return new CSVDataSource();
        }
    }

}