N = int(input())
num_card = set(map(int, input().split()))
M = int(input())
comp = list(map(int, input().split()))

for i in comp:
    if (i in num_card):
        print(1, end = ' ')
    else:
        print(0, end = ' ')