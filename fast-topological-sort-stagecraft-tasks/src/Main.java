import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
  private static int i = 1;

  public static void main(String[] args) {
    // write your code here
    Scanner scanner = new Scanner((System.in));
    List<String> input = new ArrayList<String>();

    //    while ((scanner.hasNextLine())) {
    //      input.add(scanner.nextLine());
    //    }
    //    scanner.close();
    input.addAll(Arrays.asList("4", "2 4", "-1", "-1", "3", "10 11 8 5"));

    // Testcase 1 expected results
    //    10
    //    21
    //    23
    //    15
    Integer totalTasks = Integer.parseInt(input.get(0));

    // storing time requirement of each task in a List <Integer>
    List<Integer> tasksT =
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

  private static void fastTopologicalSort(Integer totalTasks, List<Integer[]> edges) {
    Queue<Integer> queue = new LinkedList<>();
    Integer inNeighbourCount[] = new Integer[totalTasks];
    for (int j = 0; j < totalTasks; j++) {
      inNeighbourCount[j] = 0;
    }
    for (int j = 0; j < totalTasks; j++) {
      Integer[] edge = edges.get(j);
      for (int k = 0; k < edge.length; k++) {
        if (edge[0] != -1) {
          inNeighbourCount[edge[k] - 1]++;
        }
      }
    }
    for (int j = 0; j < inNeighbourCount.length; j++) {
      if (inNeighbourCount[j] == 0) queue.add(inNeighbourCount[j]);
    }

    System.out.println("\nIn-Degree of each task:");
    Arrays.asList(inNeighbourCount).forEach(System.out::println);
    System.out.print("\nCurrent queue : ");
    queue.forEach(x -> System.out.print(x + " "));
    System.out.println("\n\nStarting fastTopologicalSort () --------------\n");
    System.out.println("\nCurrent taskID : " + i);


    while (!queue.isEmpty()) {
      int taskID = queue.poll();
      System.out.println("\n\nRecursive deleteTask()");
      deleteTask(queue, edges, taskID, inNeighbourCount);
    }
    System.out.println("\n\nEnding fastTopologicalSort () --------------");
  }

  private static void deleteTask(
      Queue<Integer> queue, List<Integer[]> edges, int taskID, Integer[] inNeighbourCount) {
    i++;
    System.out.println("\nCurrent taskID : " + i);
    if (edges[taskID] == 0) {return;}

    for (int j = 0; j < edges.get(taskID).length; j++) {
      Integer[] outNeigbours = edges.get(taskID);
      //      if (outNeigbours[0] == -1)
      //        continue;
      //      }
      for (int k = 0; k < outNeigbours.length; j++) {
        inNeighbourCount[outNeigbours[k]]--;
      }
      for (int k = 0; k < outNeigbours.length; j++) {
        if ( inNeighbourCount[outNeigbours[k]] > 0) {
          taskID = inNeighbourCount[outNeigbours[k]];
          deleteTask(queue, edges, taskID, inNeighbourCount);
        }
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
