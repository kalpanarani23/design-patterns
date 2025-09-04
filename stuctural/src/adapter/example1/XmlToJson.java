package adapter.example1;

public class XmlToJson {

    public static void main(String[] args) {
        //WITHOUT ADAPTER
        String xmlData = "Sample Data";
        JsonAnalyticTool tool1 = new JsonAnalyticTool();
        tool1.setJsonData(xmlData);
        tool1.analyseData();

        //WITH ADAPTER
        System.out.println("--------------------------------------");
        AnalyticToolAdapter toolAdapter = new XmlToJsonAdapter(xmlData);
        toolAdapter.analyseData();
    }
}
