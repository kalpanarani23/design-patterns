package adapter.example1;

//Adaptee --- trying to adapt this behaviour
public class JsonAnalyticTool {
    String jsonData;

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public void analyseData() {
        if (jsonData.contains("json")){
            System.out.println("Analyse data : " + jsonData);
        } else {
            System.out.println("Not in correct format, cannot analyse data");
        }
    }

}
