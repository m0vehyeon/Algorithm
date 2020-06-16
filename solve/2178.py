N, M = map(int, input().split())
matrix = [[0] * M for _ in range(N)]
for _ in range(N):
    for i, v in enumerate(input()):
        matrix[_][i] = int(v)

cnt = 0
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
dist = [[0] * M for _ in range(N)]
check = [[False] * M for _ in range(N)]


def bfs(i, j):
    check[0][0] = True
    dist[0][0] = 1
    queue = []
    queue.append((i, j))
    while queue:
        i, j = queue.pop(0)
        for k in range(4):
            nx, ny = i + dx[k], j + dy[k]
            if 0 <= nx < N and 0 <= ny < M:
                if (matrix[nx][ny] == 1 and check[nx][ny] == False):
                    dist[nx][ny] = dist[i][j] + 1
                    check[nx][ny] = True
                    queue.append((nx, ny))

    return dist[N - 1][M - 1]


print(bfs(0, 0))

