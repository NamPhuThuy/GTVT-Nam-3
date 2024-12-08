using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Specialized;

namespace BFS
{
    class Graph
    {
        public List<Node> Nodes { get; set; } = new List<Node>();



        /*
         * public List<Node> FindMinimumSumPathFromHighestToLowestUsingBestFirstSearch()
        {
            Node highest = Nodes.OrderByDescending(n => n.Value).First();
            Node lowest = Nodes.OrderBy(n => n.Value).First();

            // Calculate heuristics for all nodes (distance to lowest weighted vertex)
            foreach (Node node in Nodes)
            {
                node.HeuristicDistanceToGoal = Math.Abs(node.Value - lowest.Value);
            }

            return BestFirstSearch(highest, lowest);
        }
         * 
         * private List<Node> BestFirstSearch(Node start, Node goal)
        {
            PriorityQueue<Node> openList = new PriorityQueue<Node>(); // Prioritize based on f(n) = g(n) + h(n)
            openList.Enqueue(start);

            while (openList.Count > 0)
            {
                Node current = openList.Dequeue();
                current.Visited = true;

                if (current == goal)
                {
                    // Path found! Reconstruct it using parent pointers
                    List<Node> path = new List<Node>();
                    Node currentNode = goal;
                    while (currentNode != null)
                    {
                        path.Add(currentNode);
                        currentNode = currentNode.Parent;
                    }
                    path.Reverse();
                    return path;
                }

                foreach (Edge neighbor in current.Neighbors)
                {
                    if (!neighbor.To.Visited)
                    {
                        int tentativeDistance = current.DistanceFromSource + neighbor.Weight;
                        if (tentativeDistance < neighbor.To.DistanceFromSource)
                        {
                            neighbor.To.Parent = current;
                            neighbor.To.DistanceFromSource = tentativeDistance;
                            // Calculate f(n) = g(n) + h(n) for best-first search
                            int f = tentativeDistance + neighbor.To.HeuristicDistanceToGoal;
                            openList.Enqueue(neighbor.To, -f); // Negative priority for descending order
                        }
                    }
                }
            }

            return null; // No path found
        }
         */
    }
}
