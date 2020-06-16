N=int(input())
K=int(input())
matrix=[[0]*(N+1) for _ in range(N+1)]
for _ in range(K):
    a,b=map(int,input().split())
    matrix[a][b]=1
    matrix[b][a]=1

def bfs(current_node):
    foot_prints=[]
    queue=[]
    queue.append(current_node)
    foot_prints.append(1)
    while queue:
        current_node=queue.pop(0)
        for search_node in range(len(matrix[current_node])):
            if(matrix[search_node][current_node]==1 and search_node not in foot_prints):
                foot_prints.append(search_node)
                matrix[search_node][current_node]=0
                queue.append(search_node)
    return foot_prints

print(len(bfs(1))-1)
