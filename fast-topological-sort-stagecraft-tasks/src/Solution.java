import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
  // Global variable i
  // Used in fastTopologicalSort (...) and deleteTask(...)
  private static int i = 0;

  /** @param args */
  public static void main(String[] args) {
    // write your code here
    Scanner scanner = new Scanner((System.in));
    List<String> input = new ArrayList<String>();

    //    while ((scanner.hasNextLine())) {
    //      input.add(scanner.nextLine());
    //    }
    //    scanner.close();

    // Edge case
    input.addAll(
        Arrays.asList("7", "2 3 4", "4 5", "6", "3 6", "4", "-1", "4 5 6", "10 15 20 31 5 14 2"));
    Integer totalTasks = Integer.parseInt(input.get(0));
    List<Integer> tasksT = parseTaskTimes(input);
    List<Integer[]> outNeighbours = parseEdges(input);
    fastTopologicalSort(totalTasks, tasksT, outNeighbours);
  }

  /**
   * This private method parses the raw input and returns a list integers that represents the times
   * to perform each task inidivually.
   *
   * @param input - Raw input provided by scanner().
   * @return - A list of integers that represents the times to perform each task individually.
   */
  private static List<Integer> parseTaskTimes(List<String> input) {
    return Arrays.stream(input.get(input.size() - 1).split(" "))
        .map(x -> Integer.parseInt(x.split(" ")[0]))
        .collect(Collectors.toList());

    //    System.out.println("\nTime it takes to complete each task:");
    //    tasksT.forEach(x -> System.out.println(x));

    
  }

  /**
   * Private method that parses the raw input and returns a list of integer arrays that represents
   * out neighbours of each task.
   *
   * @param input - Raw input provided by scanner().
   * @return - A list that integer arrays that represent out neighbours of each task, where the
   *     index of the list is a task.
   */
  private static List<Integer[]> parseEdges(List<String> input) {
    // copying outNeighbours from List<String []> to List<Integer []>
    input.remove(0);
    input.remove(input.size() - 1);
    List<Integer[]> outNeighbours = new ArrayList<Integer[]>();
    for (int j = 0; j < input.size(); j++) {
      Integer[] temp =
          (Integer[])
              Arrays.stream(input.get(j).split(" "))
                  .map(Integer::parseInt)
                  .collect(Collectors.toList())
                  .toArray(new Integer[input.get(j).split(" ").length]);
      outNeighbours.add(temp);
    }
    //    System.out.println("\nTotal Edges:");
    //    outNeighbours.forEach(
    //        x -> {
    //          Arrays.asList(x).forEach(y -> System.out.print(y + " "));
    //          System.out.println("");
    //        });
    return outNeighbours;
  }

  /**
   * This method sorts a DAG using fast topological sort Calls deleteTask() recursively
   *
   * @param totalTasks - Total number of tasks.
   * @param tasksT - Stores all tasks' independent time requirement.
   * @param outNeighbours - A list of integer arrays that stores all outNeighbours, where the index
   *     of the list represents a task and each integer array is the out neighbours. If the out
   *     neighbour at index 0 equals -1, then the indexed task does not have any out neighbours.
   */
  private static void fastTopologicalSort(
      Integer totalTasks, List<Integer> tasksT, List<Integer[]> outNeighbours) {
    // Init a queue
    Queue<Integer> queue = new LinkedList<>();

    // Uses outNeighbours list to create a in degree list and a in neighbour list
    Integer[] inDegree = new Integer[totalTasks];
    Map<Integer, List<Integer>> inNeighbours = new HashMap<Integer, List<Integer>>();
    storeIndegreesAndInNeighbours(totalTasks, inDegree, inNeighbours, outNeighbours);

    // Add all 0-In-Degree nodes to the queue
    for (int j = 0; j < inDegree.length; j++) {
      if (inDegree[j] == 0) queue.add(j);
    }

    // Init an empty topological order array
    // Call deleteTask recursively and populate topolgical order array with tasks
    Integer[] topOrder = new Integer[totalTasks];
    while (!queue.isEmpty()) {
      int taskID = queue.poll();
      queue.remove(taskID);
      deleteTask(outNeighbours, taskID, inDegree, inNeighbours, topOrder);
    }
    // Calculate completion times based on the topological order
    Integer[] competions = calcTaskCompetion(totalTasks, tasksT, topOrder, inNeighbours, inDegree);
    Arrays.asList(competions).forEach(System.out::println);
  }

  /**
   * Private method that use the outNeighbours list to iteratively populate a list of in degrees and
   * a list of in neighbours.
   *
   * @param totalTasks - Number of total tasks.
   * @param inDegree - An array that stores all InDegrees, where the index represents the task.
   * @param inNeighbours - A hashmap that stores all inNeighbours, where the keys represents the
   * @param outNeighbours - A list of integer arrays that stores all outNeighbours, where the index
   *     of the list represents a task and each integer array is the out neighbours. If the out
   *     neighbour at index 0 equals -1, then the indexed task does not have any out neighbours.
   */
  private static void storeIndegreesAndInNeighbours(
      Integer totalTasks,
      Integer[] inDegree,
      Map<Integer, List<Integer>> inNeighbours,
      List<Integer[]> outNeighbours) {
    for (int j = 0; j < totalTasks; j++) {
      inDegree[j] = 0;
    }
    for (int j = 0; j < totalTasks; j++) {
      Integer[] toNode = outNeighbours.get(j);
      for (int k = 0; k < toNode.length; k++) {
        if (toNode[0] != -1) {
          inDegree[toNode[k] - 1]++;
          List<Integer> list = inNeighbours.getOrDefault(toNode[k] - 1, new ArrayList<>());
          list.add(j);
          inNeighbours.put(toNode[k] - 1, list);
        }
      }
    }
  }

  /**
   * A private and recursive method used in topological sort to traverse the graph and mark node as
   * visted/ "deleted". Once all nodes are "deleted", the recursion will return from the recursion.
   *
   * @param edges -A list of all edges
   * @param taskID - An iterator used to keep track of the node to delete at each recursive
   *     iteration.
   * @param inDegree - An array that stores all InDegrees, where the index represents the task.
   * @param inNeighbours - A hashmap that stores all inNeighbours, where the keys represents the
   *     tasks, and each entry is a list of integers that each represents a in neighbour.
   * @param topOrder - An ordered array that stores all tasks in topolgical order. Initially
   *     topOrder[] is empty. With each recusive iteration, topOrder[] will be gradually populated
   *     with tasks, until all tasks are accounted for.
   */
  private static void deleteTask(
      List<Integer[]> edges,
      int taskID,
      Integer[] inDegree,
      Map<Integer, List<Integer>> inNeighbours,
      Integer[] topOrder) {

    // Stop Recursing once all nodes have been counted using iterator i
    if (i == inDegree.length) return;
    i++;
    //    System.out.println("\nCurrent taskID : " + (taskID + 1) + " in " + i + " place");
    Integer[] outNeigbours = new Integer[edges.get(taskID).length];
    if (i > 0) topOrder[i - 1] = taskID + 1;
    // Find all out-neighbours of current node
    outNeigbours = edges.get(taskID);
    if (outNeigbours[0] == -1) return;
    // Subtract 1 from all out-neighbours' in-degree
    for (int k = 0; k < outNeigbours.length; k++) {
      inDegree[outNeigbours[k] - 1]--;
    }
    for (int k = 0; k < outNeigbours.length; k++) {
      if (inDegree[outNeigbours[k] - 1] == 0) {
        taskID = outNeigbours[k] - 1;
        deleteTask(edges, taskID, inDegree, inNeighbours, topOrder);
      }
    }
  }

  /**
   * A private method used in the fastTopologicalSort(..) to calculate the actual completion times
   * for each task. In fastTopologicalSort(..), deleteTask(..) will be called first. Once A top
   *
   * @param totalTasks - Number of total tasks.
   * @param tasksT - Stores all tasks' independent time requirement.
   * @param topOrder - An ordered array that stores all tasks in topolgical order. topOrder[0] =
   *     earliest task executed whereas the topOrder[last] = latest task executed.
   * @param inNeighbours - A hashmap that stores all inNeighbours, where the key represents the
   *     task.
   * @param inDegree - An array that stores all InDegrees, where the index represents the task.
   * @return - Returns an integer array that stores the minimum time it takes to complete a task in
   *     topological order, where the index of the array represents the task.
   */
  private static Integer[] calcTaskCompetion(
      Integer totalTasks,
      List<Integer> tasksT,
      Integer[] topOrder,
      Map<Integer, List<Integer>> inNeighbours,
      Integer[] inDegree) {
    //    System.out.println("\n\nCompletions are:");
    Integer[] completions = new Integer[totalTasks];
    Arrays.fill(completions, 0);
    for (int j = 0; j < topOrder.length; j++) {
      Integer orderedTask = topOrder[j];
      if (inNeighbours.get(orderedTask - 1) == null) {
        completions[orderedTask - 1] = tasksT.get(orderedTask - 1);
      } else {
        Integer max = 0;
        List<Integer> inNodes = inNeighbours.get(orderedTask - 1);
        for (int k = 0; k < inNeighbours.get(orderedTask - 1).size(); k++) {
          if (completions[inNodes.get(k)] > max) {
            max = completions[inNodes.get(k)];
          }
        }
        completions[orderedTask - 1] = tasksT.get(topOrder[j] - 1) + max;
      }
      //      System.out.print(completions[topOrder[j]-1] + " ");
    }
    return completions;
  }
}
