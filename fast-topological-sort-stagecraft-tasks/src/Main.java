import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
  private static int i = 0;
  private static List<Integer> tasksT;

  /** @param args */
  public static void main(String[] args) {
    // write your code here
    Scanner scanner = new Scanner((System.in));
    List<String> input = new ArrayList<String>();

    //    while ((scanner.hasNextLine())) {
    //      input.add(scanner.nextLine());
    //    }
    //    scanner.close();
    //    input.addAll(Arrays.asList("4", "2 4", "-1", "-1", "3", "10 11 8 5"));
    input.addAll(
        Arrays.asList("7", "2 3 4", "4 5", "6", "3 6", "4", "-1", "4 5 6", "10 15 20 31 5 14 2"));
    // Testcase 1 expected results
    //    10
    //    21
    //    23
    //    15
    Integer totalTasks = Integer.parseInt(input.get(0));

    // storing time requirement of each task in a List <Integer>
    tasksT =
        Arrays.stream(input.get(input.size() - 1).split(" "))
            .map(x -> Integer.parseInt(x.split(" ")[0]))
            .collect(Collectors.toList());
    System.out.println("\nTime it takes to complete each task:");
    tasksT.forEach(x -> System.out.println(x));

    // copying edges from List<String []> to Lis<Integer []>
    input.remove(0);
    input.remove(input.size() - 1);
    List<Integer[]> edges = new ArrayList<>();
    for (int j = 0; j < input.size(); j++) {
      String[] temp = input.get(j).split(" ");
      Integer[] edge = new Integer[temp.length];
      for (int k = 0; k < temp.length; k++) {
        edge[k] = Integer.parseInt(temp[k]);
      }
      edges.add(edge);
    }

    System.out.println("\nTotal Edges:");
    edges.forEach(
        x -> {
          Arrays.asList(x).forEach(y -> System.out.print(y + " "));
          System.out.println("");
        });

    fastTopologicalSort(totalTasks, edges);
  }

  /**
   * This method sorts a DAG using fast topological sort
   * Calls deleteTask() recursively
   * @param totalTasks
   * @param edges
   */
  private static void fastTopologicalSort(Integer totalTasks, List<Integer[]> edges) {

    // Mark each node with In-Degree
    Queue<Integer> queue = new LinkedList<>();
    Integer[] inDegree = new Integer[totalTasks];
    Map<Integer, List<Integer>> inNeighbours = new HashMap<Integer, List<Integer>>();
    for (int j = 0; j < totalTasks; j++) {
      inDegree[j] = 0;
    }
    for (int j = 0; j < totalTasks; j++) {
      Integer[] otherNode = edges.get(j);
      for (int k = 0; k < otherNode.length; k++) {
        if (otherNode[0] != -1) {
          inDegree[otherNode[k] - 1]++;
          List<Integer> list = inNeighbours.getOrDefault(otherNode[k] - 1, new ArrayList<>());
          list.add(j);
          inNeighbours.put(otherNode[k] - 1, list);
        }
      }
    }

    // Add all 0-In-Degree nodes to the queue
    for (int j = 0; j < inDegree.length; j++) {
      if (inDegree[j] == 0) queue.add(j);
    }

    System.out.println("\nIn-Degree of each task:");
    Arrays.asList(inDegree).forEach(System.out::println);
    System.out.println("\nIn-Neighbours of each task:");
    for (int j = 0; j < totalTasks; j++) {
      System.out.println(inNeighbours.getOrDefault(j, Arrays.asList(new Integer[1])));
    }
    System.out.print("\nCurrent queue : ");
    queue.forEach(x -> System.out.print(x + " "));


    // While Queue is not empty, recursively delete nodes
    Integer[] topOrder = new Integer[totalTasks];
    while (!queue.isEmpty()) {
      System.out.println("\n\nStarting fastTopologicalSort () --------------\n");
      int taskID = queue.poll();
      queue.remove(taskID);
      System.out.println("\n\nRecursive deleteTask()");
      deleteTask(edges, taskID, inDegree, inNeighbours,topOrder);
    }
    System.out.println("\n\nEnding fastTopologicalSort () --------------");




    Arrays.asList(topOrder).stream().forEach(x->System.out.println(x));
  }

  public void calcTaskTimings (Integer totalTasks, Integer [] topOrder) {


    Integer[] totalTimes = new Integer[totalTasks];
    Arrays.fill(totalTimes, 42);
    for (int j =0; j<topOrder.length; j++){
      Integer task = topOrder[j];

    }

  }

  /**
   * This is a private and recursive method used in topological sort.
   * @param edges
   * @param taskID
   * @param inDegree
   */
  private static void deleteTask(
      List<Integer[]> edges,
      int taskID,
      Integer[] inDegree,
      Map<Integer, List<Integer>> inNeighbours,
      Integer[] topOrder
  ) {

    // Stop Recursing once all nodes have been counted using iterator i
    if (i == inDegree.length) {
      return;
    }

    i++;
    System.out.println("\nCurrent taskID : " + (taskID + 1) + " in " + i + " place");
    Integer[] outNeigbours = new Integer[edges.get(taskID).length];
    if (i>0)topOrder[i-1] = taskID + 1;

    // Find all out-neighbours of current node
    outNeigbours = edges.get(taskID);
    if (outNeigbours[0] == -1) {
      System.out.println("In-Degree of each task:");
      Arrays.asList(inDegree).forEach(System.out::println);
      return;
    }

    // Subtract 1 from all out-neighbours' in-degree
    for (int k = 0; k < outNeigbours.length; k++) {
      inDegree[outNeigbours[k] - 1]--;
    }
    System.out.println("In-Degree of each task:");
    Arrays.asList(inDegree).forEach(System.out::println);

    for (int k = 0; k < outNeigbours.length; k++) {
      if (inDegree[outNeigbours[k] - 1] == 0) {
        taskID = outNeigbours[k] - 1;
        deleteTask(edges, taskID, inDegree, inNeighbours, topOrder);
      }
    }
  }

  //  private static List<Integer[]> deleteTask(
  //      Queue<Integer> queue, List<Integer[]> edges, int taskID, Integer[] inNeighbourCount) {
  //    i++;
  //
  //
  //
  //    System.out.println("\nCurrent count : " + i);
  //    System.out.print("Current queue : ");
  //    queue.forEach(x -> System.out.print(x + " "));
  //
  //    for (int j = 0; j < edges.get(taskID).length; j++) {
  //      Integer[] outNeigbours = edges.get(taskID);
  //      if (outNeigbours[0] == -1) {
  //        continue;
  //      }
  //      for (int k = 0; k < outNeigbours.length; j++) {
  //        Integer[] oldInEdges = edges.get(outNeigbours[k]);
  //        Integer[] newInEdges = null;
  //        try {
  //          newInEdges =
  //              (Integer[])
  //                  Arrays.stream(oldInEdges)
  //                      .map(
  //                          x -> {
  //                            if (x == taskID) {
  //                              return null;
  //                            } else return x;
  //                          })
  //                      .toArray();
  //        } catch (ClassCastException emptyArray) {
  //          newInEdges = new Integer[] {0};
  //        }
  //        edges.remove(oldInEdges);
  //        edges.add(outNeigbours[k], newInEdges);
  //      }
  //    }
  //    for (int j = 0; j < queue.size(); j++) {
  //      if (edges.get(j).length == 0) {
  //        queue.remove(j);
  //      }
  //    }
  //    return deleteTask(queue, edges, taskID, inNeighbourCount);
  //  }
}
