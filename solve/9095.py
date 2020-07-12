n = int(input())
temp = [int(input()) for _ in range(n)]
arr=[1,2,4]
for j in range(3,12):
    arr.append(arr[j-1]+arr[j-2]+arr[j-3])
for v in temp:
    print(arr[v-1])
