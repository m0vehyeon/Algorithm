N, K = map(int, input().split())

arr = [str(i) for i in range(1,N+1)]

check = 0

result = []

while len(arr):
    check += K - 1
    if check >= len(arr):
        check %= len(arr)
    result.append(arr.pop(check))

print('<',', '.join(result), '>', sep = '')