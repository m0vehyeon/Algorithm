N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

A.sort()

def binarySearch(data, target):

    start = 0
    end = len(A) - 1
    while (start <= end):
        mid = (start + end) // 2
        if (data[mid] == target):
            return 1
        elif (data[mid] > target):
            end = mid - 1
        else:
            start = mid + 1
    
    return 0

for i in B:
    if (binarySearch(A, i) == 1):
        print(1)
    else:
        print(0)
