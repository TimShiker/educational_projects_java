import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {

    List<Station> routeForCalculateDuration;
    List<Station> routeOnTheLine;
    List<Station> routeWithOneConnection;
    List<Station> routeWithTwoConnections;

    RouteCalculator routeCalculator;
    StationIndex stationIndexTest;

    /*
    my metro
    1   1    1
    2   2  - 2
    3 - 3    3
    4   4    4
        5
     */

    @Override
    protected void setUp() throws Exception {

        // create lines
        Line firstLine = new Line(1, "First line");
        Line secondLine = new Line(2, "Second line");
        Line thirdLine = new Line(3, "Third line");

        // create stations for first line
        Station a1 = new Station("First station on first line", firstLine);
        Station b1 = new Station("Second station on first line", firstLine);
        Station c1 = new Station("Third station on first line", firstLine);
        Station d1 = new Station("Fourth station on first line", firstLine);

        // create stations for second line
        Station a2 = new Station("First station on second line", secondLine);
        Station b2 = new Station("Second station on second line", secondLine);
        Station c2 = new Station("Third station on second line", secondLine);
        Station d2 = new Station("Fourth station on second line", secondLine);
        Station e2 = new Station("Fifth station on second line", secondLine);

        // create stations for third line
        Station a3 = new Station("First station on third line", thirdLine);
        Station b3 = new Station("Second station on third line", thirdLine);
        Station c3 = new Station("Third station on third line", thirdLine);
        Station d3 = new Station("Fourth station on third line", thirdLine);

        // added stations to lines
        Stream.of(a1, b1, c1, d1).forEach(firstLine::addStation);
        Stream.of(a2, b2, c2, d2, e2).forEach(secondLine::addStation);
        Stream.of(a3, b3, c3, d3).forEach(thirdLine::addStation);

        // create station index
        stationIndexTest = new StationIndex();

        //add lines
        Stream.of(firstLine, secondLine, thirdLine).forEach(stationIndexTest::addLine);

        //add stations
        firstLine.getStations().forEach(stationIndexTest::addStation);
        secondLine.getStations().forEach(stationIndexTest::addStation);
        thirdLine.getStations().forEach(stationIndexTest::addStation);

        //add connections
        List<Station> firstConnectionsStations = new ArrayList<>();
        Stream.of(c1, c2).forEach(firstConnectionsStations::add);

        List<Station> secondConnectionsStations = new ArrayList<>();
        Stream.of(b2, b3).forEach(secondConnectionsStations::add);

        Stream.of(firstConnectionsStations, secondConnectionsStations).
                forEach(stationIndexTest::addConnection);

        routeCalculator = new RouteCalculator(stationIndexTest);

        routeForCalculateDuration = new ArrayList<>();
        Stream.of(a1, b1, c1, c2, b2, b3, c3).forEach(routeForCalculateDuration::add);

        routeOnTheLine = new ArrayList<>();
        Stream.of(a2, b2, c2, d2, e2).forEach(routeOnTheLine::add);

        routeWithOneConnection = new ArrayList<>();
        Stream.of(a1, b1, c1, c2, d2, e2).forEach(routeWithOneConnection::add);

        routeWithTwoConnections = new ArrayList<>();
        Stream.of(a1, b1, c1, c2, b2, b3, a3).forEach(routeWithTwoConnections::add);

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(routeForCalculateDuration);
        double expected = 17.0;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndexTest.getStation("First station on second line"),
                stationIndexTest.getStation("Fifth station on second line"));
        List<Station> expected = new ArrayList<>(routeOnTheLine);

        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndexTest.getStation("First station on first line"),
                stationIndexTest.getStation("Fifth station on second line"));
        List<Station> expected = new ArrayList<>(routeWithOneConnection);

        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnection() {

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndexTest.getStation("First station on first line"),
                stationIndexTest.getStation("First station on third line"));
        List<Station> expected = new ArrayList<>();
        expected.addAll(routeWithTwoConnections);

        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
