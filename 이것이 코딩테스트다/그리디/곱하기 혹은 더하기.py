import sys

n = sys.stdin.readline().rstrip()

result = int(n[0])

for i in range(0, len(n) - 1):
    if (int(n[i]) <= 1 or int(n[i+1]) <= 1):
        result += int(n[i+1])
    else:
        result *= int(n[i+1])

print(result)