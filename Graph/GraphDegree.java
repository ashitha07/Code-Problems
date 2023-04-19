/******************************************************************************
This program implements graph as list of vertices and edges and find the 
maxDegree and if the graph is euler walkable
*******************************************************************************/
#include <iostream>
#include<vector>
#include<set>

using namespace std;
class Graph{
    private:
        vector<int> V;
        vector<pair<int,int>> E;
        vector<int>degree;
    public:
        Graph(vector<int>v,vector<pair<int,int>>e):V(v),E(e){
           
        }
        void printGraph();
        bool isEulerWalkable();
        void populateDegree();
        int maxDegree();
};
/* Function to check eulerian path or cycle */
bool Graph::isEulerWalkable(){
    int countOdd = 0;
    for(auto i: degree){
        if(i%2==1){
            countOdd++;
        }
    }
    return (countOdd==0||countOdd==2);
    
}
/* Function to find the max degree in a graph */
int Graph::maxDegree(){
    int max = 0;
     for(auto i: degree){
        if(i>max){
            max=i;
        }
    }
    return max;
}
/*This is to find degree of each vertex*/
void Graph::populateDegree(){
     degree.resize(V.size(),0);
     for(auto i: E){
         degree[i.first]++;
         degree[i.second]++;
     }
}
int main()
{
    vector<int> vertices = {0,1,2,3};
    vector<pair<int,int>> edges = {{1, 3}, {3, 0},
                                        {0, 2}, {2, 1}, {2, 3}} ;
    Graph g(vertices,edges);
    g.populateDegree();
    cout<<g.isEulerWalkable()<<endl;
    cout<<g.maxDegree();
    
    return 0;
}
