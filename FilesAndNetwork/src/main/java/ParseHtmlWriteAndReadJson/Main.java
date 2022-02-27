package ParseHtmlWriteAndReadJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static final String PATH_TO_HTML_FILE = "data/moscow_metro.html";

    public static final String PATH_TO_MAP = "files/map.json";

    public static JSONObject map;

    public static void main(String[] args) throws IOException {

        File input = new File(PATH_TO_HTML_FILE);
        Document document = Jsoup.parse(input, "UTF-8");
        Elements metroData = document.select("#metrodata");
        map = new JSONObject();

        try {

            addConnectionsToJson(parseConnections(metroData));
            addLinesToJson(parseLines(metroData));
            addStationsToJson(parseStations(metroData));
            createJsonFile(map);

            calculatedStationsInLines();
            calculatedConnections();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static List<Station> parseStations(Elements metroData) {

        List<Station> stations = new ArrayList<>();
        Elements allStations = metroData.select("div[class*=js-metro-stations]");

        for (Element element : allStations) {

            List<String> namesStations = element.select("span.name").eachText();
            String numLine = element.attributes().get("data-line");

            namesStations.stream().forEach(name -> {
                stations.add(new Station(name, numLine));
            });
        }

        return stations;
    }

    private static List<Line> parseLines(Elements metroData) {

        List<Line> allLines = new ArrayList<>();
        Elements lines = metroData.select("span[class*=line]");

        for (Element element : lines) {

            String nameOfLine = element.text();
            String numberOfLine = element.attributes().get("data-line");

            Line lineForWrite = new Line(nameOfLine, numberOfLine);

            allLines.add(lineForWrite);
        }
        return allLines;
    }

    private static List<List<Connection>> parseConnections(Elements metroData) {

        List<List<Connection>> allConnections = new ArrayList<>();
        HashSet<Connection> connectionCheck = new HashSet<>();

        Elements allStations = metroData.select("div[class*=js-metro-stations]");

        for (Element linesAndStation : allStations) {

            String numberLine = linesAndStation.attributes().get("data-line");

            linesAndStation.select("p").stream().forEach(element1 -> {
                Elements connectionsElement = element1.select("span[title]");

                if (connectionsElement.size() > 0) {

                    String nameStation = element1.select("span.name").text();
                    Connection firstStationOfConnection = new Connection(numberLine, nameStation);

                    if (!connectionCheck.contains(firstStationOfConnection)) {

                        List<Connection> connections = new ArrayList<>();
                        connections.add(firstStationOfConnection);

                        connectionsElement.forEach(element2 -> {

                            String numLineConnection = numLineConnectionProcessing(element2.toString());
                            String nameStationConnection = nameStationConnectionProcessing(element2.toString());

                            Connection secondStationOfConnection =
                                    new Connection(numLineConnection, nameStationConnection);

                            if (!connectionCheck.contains(secondStationOfConnection) ||
                                    (connectionCheck.contains(secondStationOfConnection) &&
                                            !connectionCheck.contains(firstStationOfConnection))) {
                                connections.add(secondStationOfConnection);
                                connectionCheck.add(secondStationOfConnection);
                            }
                        });
                        if (connections.size() > 0) {
                            connectionCheck.add(firstStationOfConnection);
                            allConnections.add(connections);
                        }
                    }
                }
            });
        }

        return allConnections;
    }

    private static void addConnectionsToJson(List<List<Connection>> connections) {

        JSONArray arrayAllConnection = new JSONArray();

        connections.stream().forEach(connections1 -> {

            JSONArray arrayEachConnection = new JSONArray();

            connections1.stream().forEach(connection -> {
                JSONObject connectionForJson = new JSONObject();

                connectionForJson.put("line", connection.getLine());
                connectionForJson.put("station", connection.getStation());

                arrayEachConnection.add(connectionForJson);

            });
            arrayAllConnection.add(arrayEachConnection);
        });

        map.put("connections", arrayAllConnection);
    }

    private static String numLineConnectionProcessing(String line) {
        String hyphen = "ln-";
        String quoteRight = "\"";
        String substring = line.substring(line.indexOf(hyphen) + 3);

        return substring.substring(0, substring.indexOf(quoteRight));
    }

    private static String nameStationConnectionProcessing(String station) {
        String quoteLeft = "«";
        String quoteRight = "»";

        return station.substring(station.indexOf(quoteLeft) + 1, station.indexOf(quoteRight));
    }

    private static void addLinesToJson(List<Line> lines) {

        JSONArray arrayLines = new JSONArray();
        JSONObject lineForJson;

        for (Line line : lines) {

            lineForJson = new JSONObject();
            lineForJson.put("number", line.getNumber());
            lineForJson.put("name", line.getName());

            arrayLines.add(lineForJson);
        }

        map.put("lines", arrayLines);
    }

    private static void addStationsToJson(List<Station> stations) {

        JSONArray arrayStations = new JSONArray();
        JSONObject stationsForJson = new JSONObject();

        String startStation = stations.get(0).getNumberLine();

        for (Station station : stations) {

            if (station.getNumberLine().equals(startStation)) {
                arrayStations.add(station.getName());
                stationsForJson.put(station.getNumberLine(), arrayStations);
            } else {
                startStation = station.getNumberLine();
                arrayStations = new JSONArray();
                arrayStations.add(station.getName());
            }

        }

        map.put("stations", stationsForJson);
    }

    private static void createJsonFile(JSONObject jsonObject) {

        try {
            FileWriter file = new FileWriter(PATH_TO_MAP);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created");
    }

    public static void calculatedStationsInLines() {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");

            stationsObject.keySet().forEach(lineNumberObject ->
            {
                String lineNumber = (String) lineNumberObject;
                JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);

                linesArray.forEach(linesForOut -> {
                    JSONObject lineObject = (JSONObject) linesForOut;

                    if (lineNumber.equals(lineObject.get("number"))) {
                        System.out.println("Line " + "\"" + lineObject.get("name") + "\": ");
                    }
                });

                System.out.println("\tnumber: " + "\"" + lineNumber + "\"; number of stations: " +
                        stationsArray.size() + ".");
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void calculatedConnections() {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");

            System.out.println("Total number of crossing = " +  connectionsArray.size());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATH_TO_MAP));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
