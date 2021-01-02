import sys
from itertools import permutations as p

def compare(num_arr, comp):
    for v in num_arr:
        bp = 1
        for i in range(len(comp)):
            if comp[i] == '<' and v[i] < v[i+1]:
                continue
            elif comp[i] == '>' and v[i] > v[i+1]:
                continue
            else:
                bp = 0
                break
        if bp == 1:
            return v
    
    return 1


k = int(sys.stdin.readline())
comp = sys.stdin.readline().split()
num = [i for i in range(0, 10)]
result = ''

list_max = list(p(num[-(k+1):]))
list_max.reverse()

print(''.join(list(map(str,compare(list_max,comp)))))
print(''.join(list(map(str,compare(list(p(num[:k+1])),comp)))))