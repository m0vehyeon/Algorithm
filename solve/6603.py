from itertools import combinations

bp = True
while (bp):
    line = list(map(str, input().strip().split()))
    n = int(line[0])
    if n == 0:
        bp = False
        break

    
    for i in list(combinations(line[1:], 6)):
        print(" ".join(list(map(str,i))))
    print(" ")
