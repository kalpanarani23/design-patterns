package adapter.example1;

public class XmlToJsonAdapter implements AnalyticToolAdapter {
    private JsonAnalyticTool analyticTool;

    public XmlToJsonAdapter(String data) {
        System.out.println("Converting data to json : " + data);
        String newData = data + "in json";
        analyticTool = new JsonAnalyticTool();
        analyticTool.setJsonData(newData);
    }

    @Override
    public void analyseData() {
        analyticTool.analyseData();
    }
}
