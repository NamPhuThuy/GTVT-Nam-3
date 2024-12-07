using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BFS
{
    internal class NhanhVaCan
    {
        //Contains information of every node in the graph
        public List<Node> _nodeList = new List<Node>();
        int _id = 0;

        int n; //number of vertices
        int k; //number of edges
        string _startP, _endP; //startPoint and endPoint

        //Store the: {vertex name - its index in _nodeList}
        Dictionary<string, int> mapVertices = new Dictionary<string, int>();
        Dictionary<string, int> _mapRankVertices = new Dictionary<string, int>();
        int _rankID = 0;

        //Stores the visited node 
        List<string> _visited = new List<string>();
        public string stringToExport;
        List<string> _path = new List<string>();

        
    }
}
